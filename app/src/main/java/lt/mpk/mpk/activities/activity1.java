package lt.mpk.mpk.activities;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

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

       /* Animation anim = new ScaleAnimation(
                1f, .1f, // Start and end values for the X axis scaling
                1f, .1f, // Start and end values for the Y axis scaling
                Animation.RELATIVE_TO_SELF, .5f, // Pivot point of X scaling
                Animation.RELATIVE_TO_SELF, .5f); // Pivot point of Y scaling
        anim.setFillAfter(true); // Needed to keep the result of the animation*/

        Animation anim = AnimationUtils.loadAnimation(this, R.anim.scale_down);
        ImageView i = (ImageView) findViewById(R.id.activity1_image);
        i.startAnimation(anim);
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