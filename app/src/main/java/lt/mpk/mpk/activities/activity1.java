package lt.mpk.mpk.activities;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import lt.mpk.mpk.R;
import lt.mpk.mpk.app;

public class activity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity1);

        app a = ((app)getApplicationContext());
        a.setEmotional1(-1);
        a.setEmotional2(-1);
        a.setEmotional3(-1);
        a.setCurrentTab(-1);


        final ImageView i = (ImageView) findViewById(R.id.activity1_image);
        final ImageView bg = (ImageView) findViewById(R.id.activity1_image_background);
        final TextView txt = (TextView) findViewById(R.id.activity1_switchText);

        final Animation down = AnimationUtils.loadAnimation(this, R.anim.scale_down);
        final Animation up = AnimationUtils.loadAnimation(this, R.anim.scale_up);

        final Animation downSmall = AnimationUtils.loadAnimation(this, R.anim.scale_down_small);
        final Animation upSmall = AnimationUtils.loadAnimation(this, R.anim.scale_up_small);

        i.startAnimation(down);
        bg.startAnimation(downSmall);
        txt.startAnimation(downSmall);
        down.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                txt.setText("Iškvėpk");
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                i.startAnimation(up);
                bg.startAnimation(upSmall);
                txt.startAnimation(upSmall);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        up.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                txt.setText("Įkvėpk");
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                i.startAnimation(down);
                bg.startAnimation(downSmall);
                txt.startAnimation(downSmall);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    public void activity1button1_Click(View v){
        startActivity(new Intent(activity1.this, activity1_1.class));
        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }
}