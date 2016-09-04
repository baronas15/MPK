package lt.mpk.mpk.activities;

import android.app.Activity;
import android.os.Bundle;
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

            TextView tx = (TextView)this.findViewById(R.id.activity_sticker_text1);

            switch(value){
                case "1": tx.setText(R.string.stickerName1);break;
                case "2": tx.setText(R.string.stickerName2);break;
                case "3": tx.setText(R.string.stickerName3);break;
                case "4": tx.setText(R.string.stickerName4);break;
                case "5": tx.setText(R.string.stickerName5);break;
                case "6": tx.setText(R.string.stickerName6);break;
                case "7": tx.setText(R.string.stickerName7);break;
                case "8": tx.setText(R.string.stickerName8);break;
                case "9": tx.setText(R.string.stickerName9);break;
                case "10": tx.setText(R.string.stickerName10);break;
                case "11": tx.setText(R.string.stickerName11);break;
                case "12": tx.setText(R.string.stickerName12);break;
                case "13": tx.setText(R.string.stickerName13);break;
                case "14": tx.setText(R.string.stickerName14);break;
                case "15": tx.setText(R.string.stickerName15);break;
                case "16": tx.setText(R.string.stickerName16);break;
                case "17": tx.setText(R.string.stickerName17);break;
                case "18": tx.setText(R.string.stickerName18);break;
                case "19": tx.setText(R.string.stickerName19);break;
            }
        }
    }
}
