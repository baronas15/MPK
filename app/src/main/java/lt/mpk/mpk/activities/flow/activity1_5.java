package lt.mpk.mpk.activities.flow;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Calendar;

import lt.mpk.mpk.R;
import lt.mpk.mpk.activities.activity_sticker;
import lt.mpk.mpk.activities.main;

import static android.media.MediaPlayer.create;

public class activity1_5 extends AppCompatActivity {
    private SharedPreferences settings;
    private SharedPreferences.Editor editor;

    private SeekBar seekbar;
    private MediaPlayer mediaPlayer;
    private TextView tx1;
    private TextView tx2;

    private final Handler mHandler = new Handler();

    private int meditationNumber = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity1_5);

        settings = getSharedPreferences("Stickers", 0);
        editor = settings.edit();

        int audioToPlay = R.raw.septintas;
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int value = extras.getInt("playAudioNumber");
            switch (value){
                case 1:meditationNumber = 1; audioToPlay = R.raw.pirmas;break;
                case 2:meditationNumber = 2; audioToPlay = R.raw.antras;break;
                case 3:meditationNumber = 3; audioToPlay = R.raw.trecias;break;
                case 4:meditationNumber = 4; audioToPlay = R.raw.ketvirtas;break;
                case 5:meditationNumber = 5; audioToPlay = R.raw.penktas;break;
                case 6:meditationNumber = 6; audioToPlay = R.raw.sestas;break;
                case 7:meditationNumber = 7; audioToPlay = R.raw.septintas;break;
            }
        }

        mediaPlayer = create(this, audioToPlay);
        seekbar = this.findViewById(R.id.seekBar);
        tx1 = this.findViewById(R.id.activity1_5_text1);
        tx2 = this.findViewById(R.id.activity1_5_text2);

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {}

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                mHandler.removeCallbacks(mUpdateTimeTask);
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mHandler.removeCallbacks(mUpdateTimeTask);
                int totalDuration = mediaPlayer.getDuration();
                int currentPosition = progressToTimer(seekBar.getProgress(), totalDuration);

                // forward or backward to certain seconds
                mediaPlayer.seekTo(currentPosition);

                // update timer progress again
                updateProgressBar();
            }
        });

        tx1.setText(String.format("%s", milliSecondsToTimer(mediaPlayer.getCurrentPosition())));
        tx2.setText(String.format("%s", milliSecondsToTimer(mediaPlayer.getDuration())));

        final Button play_button = this.findViewById(R.id.activity1_5_button1);
        play_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                seekbar.setProgress(0);
                seekbar.setMax(100);
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                    play_button.setBackgroundResource(R.drawable.play_button);
                }else{
                    mediaPlayer.start();
                    play_button.setBackgroundResource(R.drawable.pause_button);
                    updateProgressBar();
                }
            }
        });

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mHandler.removeCallbacksAndMessages(null);
                play_button.setBackgroundResource(R.drawable.play_button);

                //region Activity4_update
                Calendar c = Calendar.getInstance();
                int hour = c.get(Calendar.HOUR_OF_DAY);
                int minute = c.get(Calendar.MINUTE);
                int time = hour * 60 + minute;

                Calendar last = Calendar.getInstance();
                Calendar today = Calendar.getInstance();

                int y = settings.getInt("lastMeditationYear",1970);
                int m = settings.getInt("lastMeditationMonth",0);
                int d = settings.getInt("lastMeditationDay",1);

                // Set the date for both of the calendar instance
                last.set(y, m, d);
                today.set(today.get(Calendar.YEAR), today.get(Calendar.MONTH), today.get(Calendar.DAY_OF_MONTH));

                // Calculate difference in milliseconds
                long diff = today.getTimeInMillis() - last.getTimeInMillis();
                long diffDays = diff / (24 * 60 * 60 * 1000);

                editor.putInt("lastMeditationYear", today.get(Calendar.YEAR));
                editor.putInt("lastMeditationMonth", today.get(Calendar.MONTH));
                editor.putInt("lastMeditationDay", today.get(Calendar.DAY_OF_MONTH));

                if(diffDays > 1) editor.putInt("daysInARow", 1);
                else if(diffDays == 1) editor.putInt("daysInARow", settings.getInt("daysInARow",0) + 1);
                else if(diffDays < 0) editor.putInt("daysInARow", 1);

                editor.putInt("meditationCount", settings.getInt("meditationCount",0) + 1);
                editor.putInt("meditationsInOneGo", settings.getInt("meditationsInOneGo",0) + 1);
                editor.apply();

                if(settings.getInt("meditationCount",0) == 1 && !settings.getBoolean("sticker1", false))
                    createSticker(1);
                if(settings.getInt("meditationCount",0) == 10 && !settings.getBoolean("sticker2", false))
                    createSticker(2);
                if(settings.getInt("meditationCount",0) == 25 && !settings.getBoolean("sticker3", false))
                    createSticker(3);
                if(settings.getInt("meditationsInOneGo",0) == 2 && !settings.getBoolean("sticker4", false))
                    createSticker(4);
                if(settings.getInt("meditationsInOneGo",0) == 3 && !settings.getBoolean("sticker5", false))
                    createSticker(5);

                if(settings.getInt("daysInARow",0) == 5 && !settings.getBoolean("sticker6", false))
                    createSticker(6);
                if(settings.getInt("daysInARow",0) == 10 && !settings.getBoolean("sticker7", false))
                    createSticker(7);
                if(settings.getInt("daysInARow",0) == 20 && !settings.getBoolean("sticker8", false))
                    createSticker(8);
                if(settings.getInt("daysInARow",0) == 31 && !settings.getBoolean("sticker9", false))
                    createSticker(9);
                if(settings.getInt("daysInARow",0) == 50 && !settings.getBoolean("sticker10", false))
                    createSticker(10);
                if(settings.getInt("daysInARow",0) == 70 && !settings.getBoolean("sticker11", false))
                    createSticker(11);
                if(settings.getInt("daysInARow",0) == 100 && !settings.getBoolean("sticker12", false))
                    createSticker(12);
                if(settings.getInt("daysInARow",0) == 150 && !settings.getBoolean("sticker13", false))
                    createSticker(13);
                if(settings.getInt("daysInARow",0) == 365 && !settings.getBoolean("sticker14", false))
                    createSticker(14);

                if(time >= 240 && time <= 450 && !settings.getBoolean("sticker15", false))
                    createSticker(15);
                if(time >= 720 && time <= 840 && !settings.getBoolean("sticker16", false))
                    createSticker(16);

                if(settings.getInt("totalTime",0) >= 180000 && !settings.getBoolean("sticker17", false))
                    createSticker(17);
                if(settings.getInt("totalTime",0) >= 1800000 && !settings.getBoolean("sticker18", false))
                    createSticker(18);
                if(settings.getInt("totalTime",0) >= 3600000 && !settings.getBoolean("sticker19", false))
                    createSticker(19);

                editor.putInt("playTime" + meditationNumber, settings.getInt("playTime" + meditationNumber,0) + 1);

                editor.apply();
                //endregion
            }
        });

    }

    private void createSticker(int num){
        editor.putBoolean("sticker"+num,true);
        editor.putInt("lastSticker",num);

        Intent i = new Intent(getApplicationContext(), activity_sticker.class);
        i.putExtra("sticker", num+"");
        startActivity(i);
        editor.apply();
    }

    private void updateProgressBar() {
        mHandler.postDelayed(mUpdateTimeTask, 100);
    }
    /**
     * Background Runnable thread
     * */
    private final Runnable mUpdateTimeTask = new Runnable()
    {
        public void run()
        {
            long totalDuration = mediaPlayer.getDuration();
            long currentDuration = mediaPlayer.getCurrentPosition();

            // Displaying Total Duration time
            tx1.setText(String.format("%s", milliSecondsToTimer(currentDuration)));
            // Displaying time completed playing
            tx2.setText(String.format("%s", milliSecondsToTimer(totalDuration)));

            // Updating progress bar
            int progress = getProgressPercentage(currentDuration, totalDuration);
            //Log.d("Progress", ""+progress);
            seekbar.setProgress(progress);

            if(mediaPlayer.isPlaying()) {
                SharedPreferences settings = getSharedPreferences("Stickers", 0);
                SharedPreferences.Editor editor = settings.edit();
                editor.putInt("totalTime", settings.getInt("totalTime", 0) + 1);
                editor.apply();
            }
            // Running this thread after 100 milliseconds
            mHandler.postDelayed(this, 100);
        }
    };

    /**
     * Function to convert milliseconds time to
     * Timer Format
     * Hours:Minutes:Seconds
     * */
    private String milliSecondsToTimer(long milliseconds){
        String finalTimerString = "";
        String secondsString;

        // Convert total duration into time
        int hours = (int)( milliseconds / (1000*60*60));
        int minutes = (int)(milliseconds % (1000*60*60)) / (1000*60);
        int seconds = (int) ((milliseconds % (1000*60*60)) % (1000*60) / 1000);
        // Add hours if there
        if(hours > 0){
            finalTimerString = hours + ":";
        }

        // Prepending 0 to seconds if it is one digit
        if(seconds < 10) secondsString = "0" + seconds;
        else secondsString = "" + seconds;

        finalTimerString = finalTimerString + minutes + ":" + secondsString;

        // return timer string
        return finalTimerString;
    }

    /**
     * Function to get Progress percentage
     * */
    private int getProgressPercentage(long currentDuration, long totalDuration){
        Double percentage;

        long currentSeconds = (int) (currentDuration / 1000);
        long totalSeconds = (int) (totalDuration / 1000);

        // calculating percentage
        percentage =(((double)currentSeconds)/totalSeconds)*100;

        // return percentage
        return percentage.intValue();
    }

    /**
     * Function to change progress to timer
     * returns current duration in milliseconds
     * */
    private int progressToTimer(int progress, int totalDuration) {
        int currentDuration;
        totalDuration = totalDuration / 1000;
        currentDuration = (int) ((((double)progress) / 100) * totalDuration);

        return currentDuration * 1000;
    }

    //region Exit
    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
        Exit();
    }

    public void activity15button2_Click(View v)
    {
        Intent intent = new Intent(getApplicationContext(), main.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("EXIT", true);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
        Exit();
    }

    private void Exit()
    {
        mediaPlayer.stop();
        mediaPlayer.release();
        mHandler.removeCallbacksAndMessages(null);
    }
    //endregion
}
