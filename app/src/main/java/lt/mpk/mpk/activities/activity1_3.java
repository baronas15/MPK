package lt.mpk.mpk.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import lt.mpk.mpk.R;
import lt.mpk.mpk.app;

public class activity1_3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity1_3);

        disableButton();
    }

    protected void onResume()
    {
        super.onResume();
        disableButton();
    }

    public void activity13button1_Click(View v){
        startActivity(new Intent(activity1_3.this, activity1_4.class));
        overridePendingTransition(R.anim.slide_in_down,R.anim.slide_out_down);
    }

    public void activity13button2_Click(View v){
        app a = ((app)getApplicationContext());

        if(a.getEmotional1() == -1 && a.getEmotional2() == -1 && a.getEmotional3() == -1){

        }else{
            startActivity(new Intent(activity1_3.this, activity1_5.class));
            overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

    private void disableButton()
    {
        app a = ((app)getApplicationContext());
        Button b = (Button) findViewById(R.id.activity1_3_button2);

        Log.d("d",a.getEmotional1()+"|"+a.getEmotional2()+"|"+a.getEmotional3());
        if(a.getEmotional1() == -1 && a.getEmotional2() == -1 && a.getEmotional3() == -1)
            b.setEnabled(false);
        else
            b.setEnabled(true);
    }
    /*
    Log.d("m",a.getMental()+"");
    Log.d("p",a.getPhysical()+"");
    Log.d("e1",a.getEmotional1()+"");
    Log.d("e2",a.getEmotional2()+"");
    Log.d("e3",a.getEmotional3()+"");
    */

    /*

    */

}
