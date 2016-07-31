package lt.mpk.mpk.activities;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;


import lt.mpk.mpk.R;

import static android.media.MediaPlayer.create;

public class activity1_5 extends AppCompatActivity {
    //private List<Card> cards;
    private SeekBar seekbar;
    private MediaPlayer mediaPlayer;
    private TextView tx1;
    private TextView tx2;

    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity1_5);

        mediaPlayer = create(this, R.raw.antras);
        seekbar = (SeekBar)this.findViewById(R.id.seekBar);
        tx1 = (TextView)this.findViewById(R.id.activity1_5_text1);
        tx2 = (TextView)this.findViewById(R.id.activity1_5_text2);

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

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
        if(seconds < 10){
            secondsString = "0" + seconds;
        }else{
            secondsString = "" + seconds;}

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

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

    public void activity15button2_Click(View v)
    {
        Intent intent = new Intent(getApplicationContext(), main.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("EXIT", true);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }
}

/*
        RecyclerView rv = (RecyclerView)findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(llm);

        createData();
        RVAdapter adapter = new RVAdapter(cards);
        rv.setAdapter(adapter);
    }

    public static class RVAdapter extends RecyclerView.Adapter<RVAdapter.RecyclerViewHolder>{
        List<Card> cards;

        RVAdapter(List<Card> cards){
            this.cards = cards;
        }
        public static class RecyclerViewHolder extends RecyclerView.ViewHolder{
            RecyclerView rv;
            TextView cardTitle;
            TextView cardText;

            public RecyclerViewHolder(View itemView) {
                super(itemView);
                rv = (RecyclerView)itemView.findViewById(R.id.rv);
                cardTitle = (TextView)itemView.findViewById(R.id.cardTitle);
                cardText = (TextView)itemView.findViewById(R.id.cardText);
            }
        }
        @Override
        public int getItemCount() {
            return cards.size();
        }
        @Override
        public RecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_item, viewGroup, false);
            RecyclerViewHolder cvh = new RecyclerViewHolder(v);
            return cvh;
        }
        @Override
        public void onBindViewHolder(RecyclerViewHolder cardViewHolder, int i) {
            cardViewHolder.cardTitle.setText(cards.get(i).title);
            cardViewHolder.cardText.setText(cards.get(i).text);
        }
        @Override
        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
            super.onAttachedToRecyclerView(recyclerView);
        }
    }

    private void createData(){
        cards = new ArrayList<>();

        cards.add(new Card("Meditacija1","Meditacijos aprasymas Meditacijos aprasymas Meditacijos aprasymas Meditacijos aprasymas",1));
        cards.add(new Card("Meditacija2","Meditacijos aprasymas Meditacijos aprasymas Meditacijos aprasymas Meditacijos aprasymas",2));
    }

    class Card {
        String title;
        String text;
        int id;

        Card(String title, String text, int id){
            this.title = title;
            this.text = text;
            this.id = id;
        }
    }*/
