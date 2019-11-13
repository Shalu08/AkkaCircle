package myapp.Akka.akkacircle.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import myapp.Akka.akkacircle.R;

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
                startActivity(new Intent(LoginActivity.this, SignUp.class));
                LoginActivity.this.finish();
            }
        });
        btn=findViewById(R.id.logindata);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, Homepage.class));

            }
        });
    }
}
