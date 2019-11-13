package myapp.Akka.akkacircle.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import myapp.Akka.akkacircle.R;

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

startActivity(new Intent(SplashScreen.this, FrontPage.class));



            }
        }, DELAY);

    }
}
