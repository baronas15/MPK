package lt.mpk.mpk.activities.achivements;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;

import lt.mpk.mpk.NavDrawer;
import lt.mpk.mpk.R;

public class activity4_1_2 extends NavDrawer {
    private final int[] imageFields = { R.id.activity4_1_2_image1, R.id.activity4_1_2_image2,
            R.id.activity4_1_2_image3, R.id.activity4_1_2_image4,
            R.id.activity4_1_2_image5, R.id.activity4_1_2_image6,
            R.id.activity4_1_2_image7, R.id.activity4_1_2_image8,
            R.id.activity4_1_2_image9, R.id.activity4_1_2_image10,
            R.id.activity4_1_2_image11, R.id.activity4_1_2_image12,
            R.id.activity4_1_2_image13, R.id.activity4_1_2_image14,
            R.id.activity4_1_2_image15, R.id.activity4_1_2_image16,
            R.id.activity4_1_2_image17, R.id.activity4_1_2_image18,
            R.id.activity4_1_2_image19};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_activity4_1_2);

        SharedPreferences settings = getSharedPreferences("Stickers", 0);

        for (int i = 1; i <= 19; i++){
            if (!settings.getBoolean("sticker" + i, false)){
                ImageView im = findViewById(imageFields[i-1]);

                im.setImageDrawable(getResources().getDrawable(R.drawable.locked));
            }
        }

        super.onCreate(savedInstanceState);
    }
}
