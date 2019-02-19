package lt.mpk.mpk.activities.flow;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import lt.mpk.mpk.NavDrawer;
import lt.mpk.mpk.R;
import lt.mpk.mpk.app;

public class activity1 extends NavDrawer {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_activity1);

        startBubbleAnimation();

        super.onCreate(savedInstanceState);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

    public void activity1button1_Click(View v){
        startActivity(new Intent(activity1.this, activity1_1.class));
        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);
    }

    private void startBubbleAnimation() {
        app a = ((app)getApplicationContext());
        a.setEmotional1(-1);
        a.setEmotional2(-1);
        a.setEmotional3(-1);
        a.setCurrentTab(-1);

        final ImageView i = findViewById(R.id.activity1_image);
        final ImageView bg = findViewById(R.id.activity1_image_background);
        final TextView txt = findViewById(R.id.activity1_switchText);

        final Animation down = AnimationUtils.loadAnimation(this, R.anim.scale_down);
        final Animation up = AnimationUtils.loadAnimation(this, R.anim.scale_up);

        final Animation downSmall = AnimationUtils.loadAnimation(this, R.anim.scale_down_small);
        final Animation upSmall = AnimationUtils.loadAnimation(this, R.anim.scale_up_small);

        final Animation textDown = AnimationUtils.loadAnimation(this, R.anim.alpha_down);
        final Animation textUp = AnimationUtils.loadAnimation(this, R.anim.alpha_up);

        i.startAnimation(down);
        bg.startAnimation(downSmall);
        txt.startAnimation(textDown);
        down.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                txt.setText(R.string.animation_out);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                i.startAnimation(up);
                bg.startAnimation(upSmall);
                txt.startAnimation(textUp);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {}
        });

        up.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                txt.setText(R.string.animation_in);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                i.startAnimation(down);
                bg.startAnimation(downSmall);
                txt.startAnimation(textDown);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {}
        });
    }
}