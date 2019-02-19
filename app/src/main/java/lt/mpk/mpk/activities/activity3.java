package lt.mpk.mpk.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import lt.mpk.mpk.NavDrawer;
import lt.mpk.mpk.R;

public class activity3 extends NavDrawer {
    private String INTENT_EXTRAS = "playAudioNumber";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_activity3);

        CreateListener(1,R.id.itemButton1);
        CreateListener(2,R.id.itemButton2);
        CreateListener(3,R.id.itemButton3);
        CreateListener(4,R.id.itemButton4);
        CreateListener(5,R.id.itemButton5);
        CreateListener(6,R.id.itemButton6);
        CreateListener(7,R.id.itemButton7);

        super.onCreate(savedInstanceState);
    }

    private void CreateListener(final int num, int ResId){
        Button b = findViewById(ResId);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), activity1_5.class);
                i.putExtra(INTENT_EXTRAS,num);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }
}