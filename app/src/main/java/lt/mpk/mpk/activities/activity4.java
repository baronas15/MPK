package lt.mpk.mpk.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import lt.mpk.mpk.R;

public class activity4 extends AppCompatActivity {
    private int enterAnim = R.anim.slide_in_down;
    private int exitAnim = R.anim.slide_out_down;

    private DrawerLayout mDrawer;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity4);
        SharedPreferences settings = getSharedPreferences("Stickers", 0);

        //region Area 1

        switch (settings.getInt("lastSticker",-1)){
            case -1:
                TextView tx = new TextView(this);
                tx.setText(getString(R.string.activity4_error1));
                tx.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.material_text_subhead));
                tx.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.primaryText));

                FrameLayout.LayoutParams params = new FrameLayout.LayoutParams((int) FrameLayout.LayoutParams.WRAP_CONTENT,(int) FrameLayout.LayoutParams.WRAP_CONTENT);
                params.gravity = Gravity.CENTER;
                tx.setLayoutParams(params);

                FrameLayout frame = (FrameLayout) findViewById(R.id.activity4_item1);
                frame.addView(tx);
                break;
            case 1: addImageView(R.drawable.start); break;
            case 2: addImageView(R.drawable.meditation_count10); break;
            case 3: addImageView(R.drawable.meditation_count25); break;
            case 4: addImageView(R.drawable.in_a_row2); break;
            case 5: addImageView(R.drawable.in_a_row3); break;
            case 6: addImageView(R.drawable.days_in_a_row5); break;
            case 7: addImageView(R.drawable.days_in_a_row10); break;
            case 8: addImageView(R.drawable.days_in_a_row20); break;
            case 9: addImageView(R.drawable.days_in_a_row31); break;
            case 10: addImageView(R.drawable.days_in_a_row50); break;
            case 11: addImageView(R.drawable.days_in_a_row70); break;
            case 12: addImageView(R.drawable.days_in_a_row100); break;
            case 13: addImageView(R.drawable.days_in_a_row150); break;
            case 14: addImageView(R.drawable.days_in_a_row365); break;
            case 15: addImageView(R.drawable.night); break;
            case 16: addImageView(R.drawable.sun); break;
            case 17: addImageView(R.drawable.total_count5h); break;
            case 18: addImageView(R.drawable.total_count50h); break;
            case 19: addImageView(R.drawable.total_count100h); break;
        }

        //endregion
        //region Area 2
        TextView text2 = (TextView) findViewById(R.id.stickerCount);
        int stickerCount = 0;

        for (int i = 1; i <= 19; i++){
            if(settings.getBoolean("sticker"+i,true))
                stickerCount++;
        }
        text2.setText(stickerCount+"/19");

        LinearLayout l2 = (LinearLayout) findViewById(R.id.activity4_layout2);
        l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(activity4.this, activity4_1_2.class));
                overridePendingTransition(enterAnim,exitAnim);
            }
        });
        //endregion

        //region Area3
        //endregion

        //region Area4
        TextView textItem5 = (TextView) findViewById(R.id.activity4_item5);
        long time = settings.getInt("totalTime",0) * 100;
        textItem5.setText(milliSecondsToTimer(time));
        //endregion

        //region Area5
        int[] playTime = new int[7];
        for (int i = 1; i <= 7; i++){
            playTime[i-1] = settings.getInt("playTime"+i,0);
        }

        int max=-1;
        int maxIndex = -1;

        for (int i = 0; i < playTime.length; i++) {
            if (playTime[i] > max && playTime[i] != 0) {
                max = playTime[i];
                maxIndex = i;
            }
        }

        TextView textItem4 = (TextView) findViewById(R.id.activity4_item4);
        switch (maxIndex){
            case 0: textItem4.setText(R.string.meditation_title1); break;
            case 1: textItem4.setText(R.string.meditation_title2); break;
            case 2: textItem4.setText(R.string.meditation_title3); break;
            case 3: textItem4.setText(R.string.meditation_title4); break;
            case 4: textItem4.setText(R.string.meditation_title5); break;
            case 5: textItem4.setText(R.string.meditation_title6); break;
            case 6: textItem4.setText(R.string.meditation_title7); break;
        }
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

    public String milliSecondsToTimer(long milliseconds){
        String finalTimerString = "";
        String secondsString;

        // Convert total duration into time
        int hours = (int)( milliseconds / (1000*60*60));
        int minutes = (int)(milliseconds % (1000*60*60)) / (1000*60);
        int seconds = (int) ((milliseconds % (1000*60*60)) % (1000*60) / 1000);

        // Add hours if there
        if(hours > 0 && minutes >= 10){
            finalTimerString = hours + ":";
        }else if(hours > 0 && minutes >= 0 && minutes < 10){
            finalTimerString = hours + ":0";
        }

        // Prepending 0 to seconds if it is one digit
        if(seconds < 10) secondsString = "0" + seconds;
        else secondsString = "" + seconds;

        finalTimerString = finalTimerString + minutes + ":" + secondsString;

        // return timer string
        return finalTimerString;
    }

    private void addImageView(int ResId) {
        ImageView iv = new ImageView(this);

        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.CENTER;
        iv.setLayoutParams(params);

        iv.setImageDrawable(getResources().getDrawable(ResId));

        FrameLayout frame = (FrameLayout) findViewById(R.id.activity4_item1);
        frame.addView(iv);
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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }
}
