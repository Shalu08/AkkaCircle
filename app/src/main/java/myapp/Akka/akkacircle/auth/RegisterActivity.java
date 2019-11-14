package myapp.Akka.akkacircle.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import myapp.Akka.akkacircle.home.Homepage;
import myapp.Akka.akkacircle.R;
import myapp.Akka.akkacircle.Util.Api;
import myapp.Akka.akkacircle.Util.SharedPrefManager;
import myapp.Akka.akkacircle.auth.model.Pojo;
import myapp.Akka.akkacircle.auth.model.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegisterActivity extends AppCompatActivity {
    private Button _loginbtn;
    private EditText _name,_email,_phone,_password;
    private TextView _loginnow;
    private CheckBox checkBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        _loginbtn=findViewById(R.id.loginbtn);
        _loginnow=findViewById(R.id.logdata);
        _loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(_name.getText().toString().isEmpty()||_email.getText().toString().isEmpty()||_password.getText().toString().isEmpty()||_phone.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Enter all fields",Toast.LENGTH_LONG).show();
                }else {
                    userSignUp();
                }
            }
        });

        _loginnow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });
        _name=findViewById(R.id.name);
        _email=findViewById(R.id.email);
        _phone=findViewById(R.id.phn);
        _password=findViewById(R.id.password);
        checkBox=findViewById(R.id.check);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox.isChecked()){
                    _loginbtn.setEnabled(true);
                }
                else {
                     Toast.makeText(getApplicationContext(),"Firstly Check Terms and Condition",Toast.LENGTH_LONG).show();
                    _loginbtn.setEnabled(false);
                }
            }
        });
    }
    private void userSignUp() {

        //defining a progress dialog to show while signing up
        final ProgressDialog progressDialog = new ProgressDialog(RegisterActivity.this);
        progressDialog.setMessage("Signing Up...");
        progressDialog.show();

        String name =_name.getText().toString().trim();
        String email =_email.getText().toString().trim();
        String password = _password.getText().toString().trim();
        String phoneno = _phone.getText().toString();


        //building retrofit object
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.Url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //Defining retrofit api service
        Api service = retrofit.create(Api.class);

        //Defining the user object as we need to pass it with the call
        User user = new User(name, email, password, phoneno);

        //defining the call
        Call<Pojo> call = service.createUser(
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                user.getPhoneno()
        );

        //calling the api
        call.enqueue(new Callback<Pojo>() {
            @Override
            public void onResponse(Call<Pojo> call, Response<Pojo> response) {
                //hiding progress dialog
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(), response.body().getMessage(), Toast.LENGTH_LONG).show();

                if (!response.body().getError()) {
                    //starting profile activity
                    finish();
                    SharedPrefManager.getInstance(getApplicationContext()).userLogin(response.body().getUser());
                    startActivity(new Intent(getApplicationContext(), Homepage.class));
                }

            }

            @Override
            public void onFailure(Call<Pojo> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

}
