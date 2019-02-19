package lt.mpk.mpk.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import lt.mpk.mpk.R;

public class activity_sticker extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_sticker);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("sticker");

            TextView tx = this.findViewById(R.id.activity_sticker_text1);
            ImageView im = this.findViewById(R.id.activity_sticker_image1);

            switch(value){
                case "1": tx.setText(R.string.stickerAward1); im.setImageDrawable(getResources().getDrawable(R.drawable.start));break;
                case "2": tx.setText(R.string.stickerAward2); im.setImageDrawable(getResources().getDrawable(R.drawable.meditation_count10));break;
                case "3": tx.setText(R.string.stickerAward3); im.setImageDrawable(getResources().getDrawable(R.drawable.meditation_count25));break;
                case "4": tx.setText(R.string.stickerAward4); im.setImageDrawable(getResources().getDrawable(R.drawable.in_a_row2));break;
                case "5": tx.setText(R.string.stickerAward5); im.setImageDrawable(getResources().getDrawable(R.drawable.in_a_row3));break;
                case "6": tx.setText(R.string.stickerAward6); im.setImageDrawable(getResources().getDrawable(R.drawable.days_in_a_row5));break;
                case "7": tx.setText(R.string.stickerAward7); im.setImageDrawable(getResources().getDrawable(R.drawable.days_in_a_row10));break;
                case "8": tx.setText(R.string.stickerAward8); im.setImageDrawable(getResources().getDrawable(R.drawable.days_in_a_row20));break;
                case "9": tx.setText(R.string.stickerAward9); im.setImageDrawable(getResources().getDrawable(R.drawable.days_in_a_row31));break;
                case "10": tx.setText(R.string.stickerAward10); im.setImageDrawable(getResources().getDrawable(R.drawable.days_in_a_row50));break;
                case "11": tx.setText(R.string.stickerAward11); im.setImageDrawable(getResources().getDrawable(R.drawable.days_in_a_row70));break;
                case "12": tx.setText(R.string.stickerAward12); im.setImageDrawable(getResources().getDrawable(R.drawable.days_in_a_row100));break;
                case "13": tx.setText(R.string.stickerAward13); im.setImageDrawable(getResources().getDrawable(R.drawable.days_in_a_row150));break;
                case "14": tx.setText(R.string.stickerAward14); im.setImageDrawable(getResources().getDrawable(R.drawable.days_in_a_row365));break;
                case "15": tx.setText(R.string.stickerAward15); im.setImageDrawable(getResources().getDrawable(R.drawable.sun));break;
                case "16": tx.setText(R.string.stickerAward16); im.setImageDrawable(getResources().getDrawable(R.drawable.night));break;
                case "17": tx.setText(R.string.stickerAward17); im.setImageDrawable(getResources().getDrawable(R.drawable.total_count5h));break;
                case "18": tx.setText(R.string.stickerAward18); im.setImageDrawable(getResources().getDrawable(R.drawable.total_count50h));break;
                case "19": tx.setText(R.string.stickerAward19); im.setImageDrawable(getResources().getDrawable(R.drawable.total_count100h));break;
            }
        }
        Button b = this.findViewById(R.id.activity_sticker_button_1);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
