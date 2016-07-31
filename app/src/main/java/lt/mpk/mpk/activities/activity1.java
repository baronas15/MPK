package lt.mpk.mpk.activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import lt.mpk.mpk.R;
import lt.mpk.mpk.app;

public class activity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity1);

        //region ChangeFont
        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/goodfish.ttf");
        TextView tv = (TextView) findViewById(R.id.activity1_title);
        if (tv != null) {
            tv.setTypeface(tf);
        }
        //endregion

        app a = ((app)getApplicationContext());
        a.setEmotional1(-1);
        a.setEmotional2(-1);
        a.setEmotional3(-1);
        a.setCurrentTab(-1);
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