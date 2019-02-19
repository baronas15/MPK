package lt.mpk.mpk.activities;

import android.os.Bundle;

import lt.mpk.mpk.NavDrawer;
import lt.mpk.mpk.R;

public class activity2_2 extends NavDrawer {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_activity2_2);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }
}
