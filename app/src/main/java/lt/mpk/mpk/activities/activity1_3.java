package lt.mpk.mpk.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import lt.mpk.mpk.R;
import lt.mpk.mpk.app;

public class activity1_3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity1_3);
    }

    public void activity13button1_Click(View v){
        startActivity(new Intent(activity1_3.this, activity1_4.class));
    }

    public void activity13button2_Click(View v){
        app a = ((app)getApplicationContext());

        if(a.getEmotional1() == -1 && a.getEmotional2() == -1 && a.getEmotional3() == -1){

        }else{
            startActivity(new Intent(activity1_3.this, activity1_5.class));
            overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    /*
    Log.d("m",a.getMental()+"");
    Log.d("p",a.getPhysical()+"");
    Log.d("e1",a.getEmotional1()+"");
    Log.d("e2",a.getEmotional2()+"");
    Log.d("e3",a.getEmotional3()+"");
    */

    /*
    Intent intent = new Intent(getApplicationContext(), main.class);
    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    intent.putExtra("EXIT", true);
    startActivity(intent);
    */

}
