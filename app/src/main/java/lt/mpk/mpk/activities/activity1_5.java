package lt.mpk.mpk.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Calendar;

import lt.mpk.mpk.R;

import static android.media.MediaPlayer.create;

public class activity1_5 extends AppCompatActivity {
    private SharedPreferences settings;
    private SharedPreferences.Editor editor;

    private DrawerLayout mDrawer;
    private Toolbar toolbar;

    private SeekBar seekbar;
    private MediaPlayer mediaPlayer;
    private TextView tx1;
    private TextView tx2;

    private Handler mHandler = new Handler();

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
                case 1:audioToPlay = R.raw.pirmas;break;
                case 2:audioToPlay = R.raw.antras;break;
                case 3:audioToPlay = R.raw.trecias;break;
                case 4:audioToPlay = R.raw.ketvirtas;break;
                case 5:audioToPlay = R.raw.penktas;break;
                case 6:audioToPlay = R.raw.sestas;break;
                case 7:audioToPlay = R.raw.septintas;break;
            }
        }

        mediaPlayer = create(this, audioToPlay);
        seekbar = (SeekBar)this.findViewById(R.id.seekBar);
        tx1 = (TextView)this.findViewById(R.id.activity1_5_text1);
        tx2 = (TextView)this.findViewById(R.id.activity1_5_text2);

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

        final Button play_button = (Button)this.findViewById(R.id.activity1_5_button1);
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

                Calendar c = Calendar.getInstance();
                int hour = c.get(Calendar.HOUR_OF_DAY);
                int minute = c.get(Calendar.MINUTE);
                int time = hour * 60 + minute;

                editor.putInt("meditationCount", settings.getInt("meditationCount",0) + 1);
                editor.putInt("meditationsInOneGo", settings.getInt("meditationsInOneGo",0) + 1);
                editor.apply();

                if(settings.getInt("meditationCount",0) == 1 && !settings.getBoolean("sticker1", false))
                    createSticker(1);
                if(settings.getInt("meditationCount",0) == 2 && !settings.getBoolean("sticker2", false))
                    createSticker(2);
                if(settings.getInt("meditationCount",0) == 10 && !settings.getBoolean("sticker3", false))
                    createSticker(3);
                if(settings.getInt("meditationCount",0) == 25 && !settings.getBoolean("sticker4", false))
                    createSticker(4);
                if(settings.getInt("meditationsInOneGo",0) == 2 && !settings.getBoolean("sticker5", false))
                    createSticker(5);
                if(settings.getInt("meditationsInOneGo",0) == 3 && !settings.getBoolean("sticker6", false))
                    createSticker(6);

                if(time >= 240 && time <= 450 && !settings.getBoolean("sticker16", false))
                    createSticker(16);
                if(time >= 720 && time <= 840 && !settings.getBoolean("sticker17", false))
                    createSticker(17);
                if(settings.getInt("totalTime",0) >= 36000 && !settings.getBoolean("sticker18", false))
                    createSticker(18);
                if(settings.getInt("totalTime",0) >= 180000 && !settings.getBoolean("sticker19", false))
                    createSticker(19);
                if(settings.getInt("totalTime",0) >= 360000 && !settings.getBoolean("sticker20", false))
                    createSticker(20);
                if(settings.getInt("totalTime",0) >= 900000 && !settings.getBoolean("sticker21", false))
                    createSticker(21);
                if(settings.getInt("totalTime",0) >= 1800000 && !settings.getBoolean("sticker22", false))
                    createSticker(22);
                if(settings.getInt("totalTime",0) >= 3600000 && !settings.getBoolean("sticker23", false))
                    createSticker(23);

                editor.apply();
            }
        });

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
                Exit();
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
                Exit();
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
                Exit();
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
                Exit();
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
                Exit();
            }
        });
        FrameLayout f7 = (FrameLayout) findViewById(R.id.drawer_item_7);
        f7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.kaunas.lt/"));
                startActivity(browserIntent);
                mDrawer.closeDrawers();
                Exit();
            }
        });
        FrameLayout f8 = (FrameLayout) findViewById(R.id.drawer_item_8);
        f8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.kaunovsb.lt/"));
                startActivity(browserIntent);
                mDrawer.closeDrawers();
                Exit();
            }
        });
        //endregion
    }

    private void createSticker(int num){
        editor.putBoolean("sticker"+num,true);
        editor.putInt("lastSticker",num);

        Intent i = new Intent(getApplicationContext(), activity_sticker.class);
        i.putExtra("sticker", num+"");
        startActivity(i);
        editor.apply();
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

    public void updateProgressBar() {
        mHandler.postDelayed(mUpdateTimeTask, 100);
    }
    /**
     * Background Runnable thread
     * */
    private Runnable mUpdateTimeTask = new Runnable() {
        public void run() {
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

                //Log.d("totTime", settings.getInt("totalTime", 0) + "");
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
    public String milliSecondsToTimer(long milliseconds){
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
    public int getProgressPercentage(long currentDuration, long totalDuration){
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
    public int progressToTimer(int progress, int totalDuration) {
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
