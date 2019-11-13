package myapp.Akka.akkacircle.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import myapp.Akka.akkacircle.R;

public class SignUp extends AppCompatActivity {
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
        _loginnow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUp.this, LoginActivity.class));
                SignUp.this.finish();
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
                    _loginbtn.setVisibility(View.VISIBLE);
                }
                else {
                    _loginbtn.setVisibility(View.GONE);
                }
            }
        });
    }
}
