package lt.mpk.mpk.activities.theory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import lt.mpk.mpk.NavDrawer;
import lt.mpk.mpk.R;

public class activity2 extends NavDrawer {
    private final int enterAnim = R.anim.slide_in_right;
    private final int exitAnim = R.anim.slide_out_right;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_activity2);

        LinearLayout l1 = findViewById(R.id.activity2_item1);
        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(activity2.this, activity2_1.class));
                overridePendingTransition(enterAnim,exitAnim);
            }
        });
        LinearLayout l2 = findViewById(R.id.activity2_item2);
        l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(activity2.this, activity2_2.class));
                overridePendingTransition(enterAnim,exitAnim);
            }
        });
        LinearLayout l3 = findViewById(R.id.activity2_item3);
        l3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(activity2.this, activity2_3.class));
                overridePendingTransition(enterAnim,exitAnim);
            }
        });
        LinearLayout l4 = findViewById(R.id.activity2_item4);
        l4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(activity2.this, activity2_4.class));
                overridePendingTransition(enterAnim,exitAnim);
            }
        });
        LinearLayout l5 = findViewById(R.id.activity2_item5);
        l5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(activity2.this, activity2_5.class));
                overridePendingTransition(enterAnim,exitAnim);
            }
        });

        super.onCreate(savedInstanceState);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }
}
