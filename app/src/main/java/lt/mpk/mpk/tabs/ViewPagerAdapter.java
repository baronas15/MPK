package lt.mpk.mpk.tabs;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new TabFragment1();
            case 1:
                return new TabFragment2();
            case 2:
                return new TabFragment3();
            case 3:
                return new TabFragment4();
            case 4:
                return new TabFragment5();
            default:
                return new TabFragment1();
        }

        //return new TabFragment1();    // Which Fragment should be dislpayed by the viewpager for the given position
        // In my case we are showing up only one fragment in all the three tabs1 so we are
        // not worrying about the position and just returning the TabFragment
    }

    @Override
    public int getCount() {
        return 5;
    }

}