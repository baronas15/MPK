package lt.mpk.mpk.activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import lt.mpk.mpk.R;

public class activity4_1_2 extends Activity {
    int textFields[] = { R.id.activity4_1_2_text1,
            R.id.activity4_1_2_text2,
            R.id.activity4_1_2_text3,
            R.id.activity4_1_2_text4,
            R.id.activity4_1_2_text5,
            R.id.activity4_1_2_text6,
            R.id.activity4_1_2_text7,
            R.id.activity4_1_2_text8,
            R.id.activity4_1_2_text9,
            R.id.activity4_1_2_text10,
            R.id.activity4_1_2_text11,
            R.id.activity4_1_2_text12,
            R.id.activity4_1_2_text13,
            R.id.activity4_1_2_text14,
            R.id.activity4_1_2_text15,
            R.id.activity4_1_2_text16,
            R.id.activity4_1_2_text17,
            R.id.activity4_1_2_text18,
            R.id.activity4_1_2_text19,
            R.id.activity4_1_2_text20,
            R.id.activity4_1_2_text21,
            R.id.activity4_1_2_text22,
            R.id.activity4_1_2_text23};
    int imageFields[] = { R.id.activity4_1_2_image1,
            R.id.activity4_1_2_image2,
            R.id.activity4_1_2_image3,
            R.id.activity4_1_2_image4,
            R.id.activity4_1_2_image5,
            R.id.activity4_1_2_image6,
            R.id.activity4_1_2_image7,
            R.id.activity4_1_2_image8,
            R.id.activity4_1_2_image9,
            R.id.activity4_1_2_image10,
            R.id.activity4_1_2_image11,
            R.id.activity4_1_2_image12,
            R.id.activity4_1_2_image13,
            R.id.activity4_1_2_image14,
            R.id.activity4_1_2_image15,
            R.id.activity4_1_2_image16,
            R.id.activity4_1_2_image17,
            R.id.activity4_1_2_image18,
            R.id.activity4_1_2_image19,
            R.id.activity4_1_2_image20,
            R.id.activity4_1_2_image21,
            R.id.activity4_1_2_image22,
            R.id.activity4_1_2_image23};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity4_1_2);

        SharedPreferences settings = getSharedPreferences("Stickers", 0);
        SharedPreferences.Editor editor = settings.edit();

        for (int i = 1; i <= 23; i++){
            if (settings.getBoolean("sticker"+i,false)== false){
                Log.d("sticker"+i,"true");
                TextView tx = (TextView) findViewById(textFields[i-1]);
                ImageView im = (ImageView) findViewById(imageFields[i-1]);

                im.setImageDrawable(getResources().getDrawable(R.drawable.locked));
            }
        }
    }

}
