package lt.mpk.mpk.tabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import lt.mpk.mpk.R;

public class TabFragment4 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.tabs4, container, false);

        Helper h = new Helper();
        h.checkBoxChangeListener(rootView,R.id.checkBox10,1,10,getActivity());
        h.checkBoxChangeListener(rootView,R.id.checkBox11,2,11,getActivity());
        h.checkBoxChangeListener(rootView,R.id.checkBox12,3,12,getActivity());

        return rootView;
    }
}