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
import android.widget.LinearLayout;
import android.widget.TextView;

import lt.mpk.mpk.R;
import lt.mpk.mpk.app;

public class activity1_4 extends AppCompatActivity {
    private DrawerLayout mDrawer;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity1_4);

        //region PopulateView
        app a = ((app)getApplicationContext());

        int emo1 = a.getEmotional1();
        int emo2 = a.getEmotional2();
        int emo3 = a.getEmotional3();
        int phys = a.getPhysical();

        LinearLayout lay = (LinearLayout) findViewById(R.id.selectspace);

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

        //region Toolbar_NavDrawer
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
        ab.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("MPK");

        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        FrameLayout f1 = (FrameLayout) findViewById(R.id.drawer_item_1);
        f1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.mpk.lt"));
                startActivity(browserIntent);
                mDrawer.closeDrawers();
            }
        });
        FrameLayout f2 = (FrameLayout) findViewById(R.id.drawer_item_2);
        f2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), main.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("EXIT", true);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
                mDrawer.closeDrawers();
            }
        });
        FrameLayout f3 = (FrameLayout) findViewById(R.id.drawer_item_3);
        f3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), activity2.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("EXIT", true);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
                mDrawer.closeDrawers();
            }
        });
        FrameLayout f4 = (FrameLayout) findViewById(R.id.drawer_item_4);
        f4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), activity3.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("EXIT", true);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
                mDrawer.closeDrawers();
            }
        });
        FrameLayout f5 = (FrameLayout) findViewById(R.id.drawer_item_5);
        f5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), activity4.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("EXIT", true);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
                mDrawer.closeDrawers();
            }
        });
        FrameLayout f7 = (FrameLayout) findViewById(R.id.drawer_item_7);
        f7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.kaunas.lt/"));
                startActivity(browserIntent);
                mDrawer.closeDrawers();
            }
        });
        FrameLayout f8 = (FrameLayout) findViewById(R.id.drawer_item_8);
        f8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.kaunovsb.lt/"));
                startActivity(browserIntent);
                mDrawer.closeDrawers();
            }
        });
        //endregion
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawer.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void createView(LinearLayout main, int titleRes, int descRes,final int num){
        View debugLayout = getLayoutInflater().inflate(R.layout.meditation_item, main, false);
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