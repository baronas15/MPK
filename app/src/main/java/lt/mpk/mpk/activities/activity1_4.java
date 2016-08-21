package lt.mpk.mpk.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import lt.mpk.mpk.R;
import lt.mpk.mpk.app;

public class activity1_4 extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity1_4);

        app a = ((app)getApplicationContext());

        int emo1 = a.getEmotional1();
        int emo2 = a.getEmotional2();
        int emo3 = a.getEmotional3();
        int phys = a.getPhysical();

        LinearLayout lay = (LinearLayout) findViewById(R.id.selectspace);

        if(emo1 == 1 || emo1 == 7 || emo2 == 2 || emo2 == 8 || emo3 == 3 || emo3 == 9 || phys == 4)
            createView(lay,R.string.meditation_title1,R.string.meditation_description1, 1);
        if(emo1 == 1 || emo1 == 4 || emo2 == 2 || emo2 == 5 || emo3 == 3 || emo3 == 6)
            createView(lay,R.string.meditation_title2,R.string.meditation_description2, 2);
        if(emo1 == 4 || emo1 == 7 || emo2 == 5 || emo2 == 8 || emo3 == 6 || emo3 == 9 || phys == 3)
            createView(lay,R.string.meditation_title3,R.string.meditation_description3, 3);
        if(emo1 == 10 || emo1 == 13 || emo2 == 11 || emo2 == 14 || emo3 == 12 || emo3 == 15 || phys == 4 || phys == 5)
            createView(lay,R.string.meditation_title4,R.string.meditation_description4, 4);
        if(emo1 == 10 || emo2 == 11 || emo3 == 12 || phys == 2)
            createView(lay,R.string.meditation_title5,R.string.meditation_description5, 5);
        if(emo1 == 13 || emo2 == 14 || emo3 == 15 || phys == 1)
            createView(lay,R.string.meditation_title6,R.string.meditation_description6, 6);
        createView(lay,R.string.meditation_title7,R.string.meditation_description7, 7);
    }

    private void createView(LinearLayout main, int titleRes, int descRes,final int num){
        View debugLayout = getLayoutInflater().inflate(R.layout.item, main, false);
        TextView t1 = (TextView) debugLayout.findViewById(R.id.itemTitle);
        t1.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.primaryText));
        t1.setText(titleRes);
        TextView t2 = (TextView) debugLayout.findViewById(R.id.itemDescription);
        t2.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.primaryText));
        t2.setText(descRes);

        Button b = (Button) debugLayout.findViewById(R.id.itemButton1);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), activity1_5.class);

                i.putExtra("playAudioNumber",num);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
            }
        });
        main.addView(debugLayout);
    }
}