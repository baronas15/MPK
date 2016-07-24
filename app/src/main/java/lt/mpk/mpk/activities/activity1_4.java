package lt.mpk.mpk.activities;

import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import lt.mpk.mpk.R;
import lt.mpk.mpk.tabs.ViewPagerAdapter;
import lt.mpk.mpk.app;

public class activity1_4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity1_4);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        if (viewPager != null) {
            viewPager.setAdapter(viewPagerAdapter);
        }

        final TabLayout.Tab emo1 = tabLayout != null ? tabLayout.newTab() : null;
        final TabLayout.Tab emo2 = tabLayout != null ? tabLayout.newTab() : null;
        final TabLayout.Tab emo3 = tabLayout != null ? tabLayout.newTab() : null;
        final TabLayout.Tab emo4 = tabLayout != null ? tabLayout.newTab() : null;
        final TabLayout.Tab emo5 = tabLayout != null ? tabLayout.newTab() : null;

        assert emo1 != null;
        emo1.setIcon(R.drawable.emo1);
        emo2.setIcon(R.drawable.emo2);
        emo3.setIcon(R.drawable.emo3);
        emo4.setIcon(R.drawable.emo4);
        emo5.setIcon(R.drawable.emo5);

        tabLayout.addTab(emo1, 0);
        tabLayout.addTab(emo2, 1);
        tabLayout.addTab(emo3, 2);
        tabLayout.addTab(emo4, 3);
        tabLayout.addTab(emo5, 4);

        tabLayout.setTabTextColors(ContextCompat.getColorStateList(this, R.color.colorAccent));
        tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.indicator));

        if (viewPager != null) {
            viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        }
    }

    public void activity14button1_Click(View v){
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        int i = 0;
        if (tabLayout != null) {
            i = tabLayout.getSelectedTabPosition();
        }

        app a = ((app)getApplicationContext());

        if(a.getEmotional1() != 3*i + 1)
            a.setEmotional1(-1);
        if(a.getEmotional2() != 3*i + 2)
            a.setEmotional2(-1);
        if(a.getEmotional3() != 3*i + 3)
            a.setEmotional3(-1);

        finish();
        overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);
    }
}
