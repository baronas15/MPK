package lt.mpk.mpk.activities.flow;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import lt.mpk.mpk.NavDrawer;
import lt.mpk.mpk.R;
import lt.mpk.mpk.app;

public class activity1_2 extends NavDrawer {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_activity1_2);

        disableButton();

        super.onCreate(savedInstanceState);
    }

    protected void onResume() {
        super.onResume();
        disableButton();
    }

    public void activity13button1_Click(View v){
        startActivity(new Intent(activity1_2.this, activity1_3.class));
        overridePendingTransition(R.anim.slide_in_down,R.anim.slide_out_down);
    }

    public void activity13button2_Click(View v){
        app a = ((app)getApplicationContext());

        if(a.getEmotional1() == -1 && a.getEmotional2() == -1 && a.getEmotional3() == -1){

        }else{
            startActivity(new Intent(activity1_2.this, activity1_4.class));
            overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

    private void disableButton() {
        app a = ((app)getApplicationContext());
        Button b = findViewById(R.id.activity1_3_button2);

        if(a.getEmotional1() == -1 && a.getEmotional2() == -1 && a.getEmotional3() == -1)
            b.setEnabled(false);
        else
            b.setEnabled(true);
    }
}
