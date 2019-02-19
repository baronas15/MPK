package lt.mpk.mpk.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import lt.mpk.mpk.NavDrawer;
import lt.mpk.mpk.R;
import lt.mpk.mpk.activities.achivements.activity4;
import lt.mpk.mpk.activities.flow.activity1;
import lt.mpk.mpk.activities.meditationList.activity3;
import lt.mpk.mpk.activities.theory.activity2;

public class main extends NavDrawer {
    private final int enterAnim = R.anim.slide_in_right;
    private final int exitAnim = R.anim.slide_out_right;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);

        //region Buttons
        Button b = findViewById(R.id.activity_main_button1);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(main.this, activity1.class));
                overridePendingTransition(enterAnim,exitAnim);
            }
        });
        LinearLayout l1 = findViewById(R.id.activity_main_item1);
        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(main.this, activity2.class));
                overridePendingTransition(enterAnim,exitAnim);
            }
        });
        LinearLayout l2 = findViewById(R.id.activity_main_item2);
        l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(main.this, activity3.class));
                overridePendingTransition(enterAnim,exitAnim);
            }
        });
        LinearLayout l3 = findViewById(R.id.activity_main_item3);
        l3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(main.this, activity4.class));
                overridePendingTransition(enterAnim,exitAnim);
            }
        });
        //endregion

        super.onCreate(savedInstanceState);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }
}
