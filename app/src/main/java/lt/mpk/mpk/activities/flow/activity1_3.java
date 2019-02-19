package lt.mpk.mpk.activities.flow;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import lt.mpk.mpk.NavDrawer;
import lt.mpk.mpk.R;
import lt.mpk.mpk.app;
import lt.mpk.mpk.tabs.TabFragment1;
import lt.mpk.mpk.tabs.TabFragment2;
import lt.mpk.mpk.tabs.TabFragment3;
import lt.mpk.mpk.tabs.TabFragment4;
import lt.mpk.mpk.tabs.TabFragment5;

public class activity1_3 extends NavDrawer {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_activity1_3);

        TabLayout tabLayout = findViewById(R.id.tabs);
        ViewPager viewPager = findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.getTabAt(0).setIcon(R.drawable.emo1);
        tabLayout.getTabAt(1).setIcon(R.drawable.emo2);
        tabLayout.getTabAt(2).setIcon(R.drawable.emo3);
        tabLayout.getTabAt(3).setIcon(R.drawable.emo4);
        tabLayout.getTabAt(4).setIcon(R.drawable.emo5);

        app a = ((app)getApplicationContext());

        if(a.getCurrentTab() != -1)
            viewPager.setCurrentItem(a.getCurrentTab());
        else
            viewPager.setCurrentItem(2);

        super.onCreate(savedInstanceState);
    }

    public void activity14button1_Click(View v){
        exit();
        finish();
        overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();

        exit();
        overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);
    }

    private void exit(){
        TabLayout tabLayout = findViewById(R.id.tabs);
        int i = tabLayout.getSelectedTabPosition();

        app a = ((app)getApplicationContext());

        if(a.getEmotional1() != 3*i + 1)
            a.setEmotional1(-1);
        if(a.getEmotional2() != 3*i + 2)
            a.setEmotional2(-1);
        if(a.getEmotional3() != 3*i + 3)
            a.setEmotional3(-1);

        a.setCurrentTab(tabLayout.getSelectedTabPosition());
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

        ViewPagerAdapter(FragmentManager manager) {
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

        void addFrag(Fragment fragment) {
            mFragmentList.add(fragment);
        }
    }
}
