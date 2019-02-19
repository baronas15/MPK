package lt.mpk.mpk.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import lt.mpk.mpk.NavDrawer;
import lt.mpk.mpk.R;

public class activity4 extends NavDrawer {
    private int enterAnim = R.anim.slide_in_down;
    private int exitAnim = R.anim.slide_out_down;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_activity4);
        SharedPreferences settings = getSharedPreferences("Stickers", 0);

        //region Area 1
        switch (settings.getInt("lastSticker",-1)){
            case -1:
                TextView tx = new TextView(this);
                tx.setText(getString(R.string.activity4_error1));
                tx.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.material_text_title));
                tx.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.primaryText));

                FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);
                params.gravity = Gravity.CENTER;
                tx.setLayoutParams(params);

                FrameLayout frame = findViewById(R.id.activity4_lastSticker);
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
        TextView text2 = findViewById(R.id.activity4_stickerCount);
        int stickerCount = 0;

        for (int i = 1; i <= 19; i++){
            if(settings.getBoolean("sticker"+i,true))
                stickerCount++;
        }
        text2.setText(stickerCount+"/19");

        LinearLayout l2 = findViewById(R.id.activity4_layout2);
        l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(activity4.this, activity4_1_2.class));
                overridePendingTransition(enterAnim,exitAnim);
            }
        });
        //endregion
        //region Area 3
        TextView textItem5 = findViewById(R.id.activity4_timer);
        long time = settings.getInt("totalTime",0) * 100;
        textItem5.setText(milliSecondsToTimer(time));
        //endregion
        //region Area 4
        TextView topEmo = findViewById(R.id.activity4_topEmotion);
        int[] emoCount = new int[15];
        for (int i = 1; i <= 15; i++){
            emoCount[i-1] = settings.getInt("emotion"+i,0);
        }

        int max=-1;
        int maxIndex = -1;
        for (int i = 0; i < emoCount.length; i++) {
            if (emoCount[i] > max && emoCount[i] != 0) {
                max = emoCount[i];
                maxIndex = i;
            }
        }

        switch (maxIndex){
            case 0:topEmo.setText(R.string.activity1_3_emot1);break;
            case 1:topEmo.setText(R.string.activity1_3_emot2);break;
            case 2:topEmo.setText(R.string.activity1_3_emot3);break;
            case 3:topEmo.setText(R.string.activity1_3_emot4);break;
            case 4:topEmo.setText(R.string.activity1_3_emot5);break;
            case 5:topEmo.setText(R.string.activity1_3_emot6);break;
            case 6:topEmo.setText(R.string.activity1_3_emot7);break;
            case 7:topEmo.setText(R.string.activity1_3_emot8);break;
            case 8:topEmo.setText(R.string.activity1_3_emot9);break;
            case 9:topEmo.setText(R.string.activity1_3_emot10);break;
            case 10:topEmo.setText(R.string.activity1_3_emot11);break;
            case 11:topEmo.setText(R.string.activity1_3_emot12);break;
            case 12:topEmo.setText(R.string.activity1_3_emot13);break;
            case 13:topEmo.setText(R.string.activity1_3_emot14);break;
            case 14:topEmo.setText(R.string.activity1_3_emot15);break;
            case -1:topEmo.setText(R.string.activity4_error4);break;
        }

        //endregion
        //region Area 5
        int[] playTime = new int[7];
        for (int i = 1; i <= 7; i++){
            playTime[i-1] = settings.getInt("playTime"+i,0);
        }

        max=-1;
        maxIndex = -1;

        for (int i = 0; i < playTime.length; i++) {
            if (playTime[i] > max && playTime[i] != 0) {
                max = playTime[i];
                maxIndex = i;
            }
        }

        TextView textItem4 = findViewById(R.id.activity4_topMeditation);
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

        super.onCreate(savedInstanceState);
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

        FrameLayout frame = findViewById(R.id.activity4_lastSticker);
        frame.addView(iv);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }
}
