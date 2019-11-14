package myapp.Akka.akkacircle.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import myapp.Akka.akkacircle.home.Homepage;
import myapp.Akka.akkacircle.R;
import myapp.Akka.akkacircle.Util.Api;
import myapp.Akka.akkacircle.Util.SharedPrefManager;
import myapp.Akka.akkacircle.auth.model.Pojo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {
    private TextView textview,_skip;
    private EditText _paas,_number;
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        _skip=findViewById(R.id.skip);
        textview = findViewById(R.id.reg);
        _number=findViewById(R.id.phnnumber);
        _paas=findViewById(R.id.password);
        textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                LoginActivity.this.finish();
            }
        });
        btn=findViewById(R.id.logindata);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userSignin();
                //startActivity(new Intent(LoginActivity.this, Homepage.class));

            }
        });
    }

    private void userSignin() {
        final ProgressDialog mprogressDialog=new ProgressDialog(this);
        mprogressDialog.setMessage("Signing Up...");
        mprogressDialog.setCanceledOnTouchOutside(false);
        mprogressDialog.show();


        String number=_number.getText().toString().trim();
        String pass=_paas.getText().toString().trim();

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(Api.Url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api service=retrofit.create(Api.class);

        Call<Pojo> call=service.userLogin(number,pass);
        call.enqueue(new Callback<Pojo>() {
            @Override
            public void onResponse(Call<Pojo> call, Response<Pojo> response) {
                mprogressDialog.dismiss();
                if(!response.body().getError()){
                    finish();
                    SharedPrefManager.getInstance(getApplicationContext()).userLogin(response.body().getUser());
                    startActivity(new Intent(LoginActivity.this,Homepage.class));
                }else{
                    Toast.makeText(getApplicationContext(),"Invalid mobile or password",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Pojo> call, Throwable t) {
                mprogressDialog.dismiss();
                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_LONG).show();

            }
        });

    }


}
