package lt.mpk.mpk.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import lt.mpk.mpk.NavDrawer;
import lt.mpk.mpk.R;
import lt.mpk.mpk.app;

public class activity1_4 extends NavDrawer {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_activity1_4);

        //region PopulateView
        app a = ((app)getApplicationContext());

        int emo1 = a.getEmotional1();
        int emo2 = a.getEmotional2();
        int emo3 = a.getEmotional3();
        int phys = a.getPhysical();

        LinearLayout lay = findViewById(R.id.selectspace);

        if(emo1 == 1 || emo1 == 7 || emo2 == 2 || emo2 == 8 || emo3 == 3 || emo3 == 9 || phys == 4){
            createView(lay,R.string.meditation_title1,R.string.meditation_description1, 1);
            View div = getLayoutInflater().inflate(R.layout.divider, lay, false);
            lay.addView(div);
        }
        if(emo1 == 1 || emo1 == 4 || emo2 == 2 || emo2 == 5 || emo3 == 3 || emo3 == 6){
            createView(lay,R.string.meditation_title2,R.string.meditation_description2, 2);
            View div = getLayoutInflater().inflate(R.layout.divider, lay, false);
            lay.addView(div);
        }
        if(emo1 == 4 || emo1 == 7 || emo2 == 5 || emo2 == 8 || emo3 == 6 || emo3 == 9 || phys == 3){
            createView(lay,R.string.meditation_title3,R.string.meditation_description3, 3);
            View div = getLayoutInflater().inflate(R.layout.divider, lay, false);
            lay.addView(div);
        }
        if(emo1 == 10 || emo1 == 13 || emo2 == 11 || emo2 == 14 || emo3 == 12 || emo3 == 15 || phys == 4 || phys == 5){
            createView(lay,R.string.meditation_title4,R.string.meditation_description4, 4);
            View div = getLayoutInflater().inflate(R.layout.divider, lay, false);
            lay.addView(div);
        }
        if(emo1 == 10 || emo2 == 11 || emo3 == 12 || phys == 2){
            createView(lay,R.string.meditation_title5,R.string.meditation_description5, 5);
            View div = getLayoutInflater().inflate(R.layout.divider, lay, false);
            lay.addView(div);
        }
        if(emo1 == 13 || emo2 == 14 || emo3 == 15 || phys == 1){
            createView(lay,R.string.meditation_title6,R.string.meditation_description6, 6);
            View div = getLayoutInflater().inflate(R.layout.divider, lay, false);
            lay.addView(div);
        }
        createView(lay,R.string.meditation_title7,R.string.meditation_description7, 7);
        //endregion

        //region RememberState
        SharedPreferences settings = getSharedPreferences("Stickers", 0);
        SharedPreferences.Editor editor = settings.edit();
        if (emo1 == 1)
            editor.putInt("emotion1", settings.getInt("emotion1",0) + 1);
        else if (emo2 == 2)
            editor.putInt("emotion2", settings.getInt("emotion2",0) + 1);
        else if (emo3 == 3)
            editor.putInt("emotion3", settings.getInt("emotion3",0) + 1);
        else if (emo1 == 4)
            editor.putInt("emotion4", settings.getInt("emotion4",0) + 1);
        else if (emo2 == 5)
            editor.putInt("emotion5", settings.getInt("emotion5",0) + 1);
        else if (emo2 == 6)
            editor.putInt("emotion6", settings.getInt("emotion6",0) + 1);
        else if (emo1 == 7)
            editor.putInt("emotion7", settings.getInt("emotion7",0) + 1);
        else if (emo2 == 8)
            editor.putInt("emotion8", settings.getInt("emotion8",0) + 1);
        else if (emo3 == 9)
            editor.putInt("emotion9", settings.getInt("emotion9",0) + 1);
        else if (emo1 == 10)
            editor.putInt("emotion10", settings.getInt("emotion10",0) + 1);
        else if (emo2 == 11)
            editor.putInt("emotion11", settings.getInt("emotion11",0) + 1);
        else if (emo3 == 12)
            editor.putInt("emotion12", settings.getInt("emotion12",0) + 1);
        else if (emo1 == 13)
            editor.putInt("emotion13", settings.getInt("emotion13",0) + 1);
        else if (emo2 == 14)
            editor.putInt("emotion14", settings.getInt("emotion14",0) + 1);
        else if (emo3 == 15)
            editor.putInt("emotion15", settings.getInt("emotion15",0) + 1);

        if(phys == 1)
            editor.putInt("phys1", settings.getInt("phys1",0) + 1);
        else if(phys == 2)
            editor.putInt("phys2", settings.getInt("phys2",0) + 1);
        else if(phys == 3)
            editor.putInt("phys3", settings.getInt("phys3",0) + 1);
        else if(phys == 4)
            editor.putInt("phys4", settings.getInt("phys4",0) + 1);
        else if(phys == 5)
            editor.putInt("phys5", settings.getInt("phys5",0) + 1);

        editor.apply();
        //endregion

        super.onCreate(savedInstanceState);
    }

    private void createView(LinearLayout main, int titleRes, int descRes,final int num){
        View debugLayout = getLayoutInflater().inflate(R.layout.meditation_item, main, false);
        TextView t1 = debugLayout.findViewById(R.id.itemTitle);
        t1.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.primaryText));
        t1.setText(titleRes);
        TextView t2 = debugLayout.findViewById(R.id.itemDescription);
        t2.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.primaryText));
        t2.setText(descRes);

        Button b = debugLayout.findViewById(R.id.itemButton1);
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