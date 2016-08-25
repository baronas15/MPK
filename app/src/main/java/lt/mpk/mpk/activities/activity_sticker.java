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
            }
        }
    }
}
