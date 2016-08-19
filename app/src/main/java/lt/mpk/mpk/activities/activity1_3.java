package lt.mpk.mpk.activities;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import lt.mpk.mpk.R;
import lt.mpk.mpk.tabs.TabFragment1;
import lt.mpk.mpk.tabs.TabFragment2;
import lt.mpk.mpk.tabs.TabFragment3;
import lt.mpk.mpk.tabs.TabFragment4;
import lt.mpk.mpk.tabs.TabFragment5;
import lt.mpk.mpk.app;

public class activity1_3 extends AppCompatActivity {
    private int[] tabIcons = {
            R.drawable.ic_mood_white_36dp,
            R.drawable.ic_sentiment_satisfied_white_36dp,
            R.drawable.ic_sentiment_neutral_white_36dp,
            R.drawable.ic_sentiment_dissatisfied_white_36dp,
            R.drawable.ic_mood_bad_white_36dp
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity1_3);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
        tabLayout.getTabAt(3).setIcon(tabIcons[3]);
        tabLayout.getTabAt(4).setIcon(tabIcons[4]);

        app a = ((app)getApplicationContext());

        if(a.getCurrentTab() != -1)
            viewPager.setCurrentItem(a.getCurrentTab());
        else
            viewPager.setCurrentItem(2);
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

        a.setCurrentTab(tabLayout.getSelectedTabPosition());
        finish();
        overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        app a = ((app)getApplicationContext());
        a.setCurrentTab(tabLayout.getSelectedTabPosition());

        overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new TabFragment1());
        adapter.addFrag(new TabFragment2());
        adapter.addFrag(new TabFragment3());
        adapter.addFrag(new TabFragment4());
        adapter.addFrag(new TabFragment5());
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment) {
            mFragmentList.add(fragment);
        }
    }
}
