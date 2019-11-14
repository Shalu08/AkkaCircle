package myapp.Akka.akkacircle.intro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import myapp.Akka.akkacircle.home.Homepage;
import myapp.Akka.akkacircle.R;
import myapp.Akka.akkacircle.Util.SharedPrefManager;

public class SplashScreen extends AppCompatActivity {
private ImageView imageView;
private Animation animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);
        imageView= findViewById(R.id. imglogo);
        animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);

        imageView.startAnimation(animation);

        int DELAY = 4000;


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (SharedPrefManager.getInstance(SplashScreen.this).isLoggedIn()) {
                    finish();
                    startActivity(new Intent(SplashScreen.this, Homepage.class));
                }else {
                    startActivity(new Intent(SplashScreen.this, FrontPage.class));
                }


            }
        }, DELAY);

    }
}
