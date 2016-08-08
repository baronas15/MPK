package lt.mpk.mpk.activities;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import lt.mpk.mpk.R;

public class activity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity4);
        SharedPreferences settings = getSharedPreferences("Stickers", 0);

        //region Area 1
        TextView text1 = (TextView) findViewById(R.id.lastSticker);
        String lastSticker = "";

        switch (settings.getInt("lastSticker",-1)){
            case -1: lastSticker = getString(R.string.stickerName0); break;
            case 1: lastSticker = getString(R.string.stickerName1); break;
            case 2: lastSticker = getString(R.string.stickerName2); break;
            case 3: lastSticker = getString(R.string.stickerName3); break;
            case 4: lastSticker = getString(R.string.stickerName4); break;
            case 5: lastSticker = getString(R.string.stickerName5); break;
            case 6: lastSticker = getString(R.string.stickerName6); break;
        }

        text1.setText(lastSticker);
        //endregion
        //region Area 2
        TextView text2 = (TextView) findViewById(R.id.stickerCount);
        int stickerCount = 0;

        for (int i = 1; i <= 23; i++){
            if(settings.getBoolean("sticker"+i,true))
                stickerCount++;
            if(settings.getBoolean("sticker"+i,false))
                Log.d("sticker"+i,"true");
        }
        text2.setText(stickerCount+"/23");
        //endregion
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }
}
