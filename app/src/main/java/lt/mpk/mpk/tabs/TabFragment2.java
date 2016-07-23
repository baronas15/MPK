package lt.mpk.mpk.tabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import lt.mpk.mpk.R;

public class TabFragment2 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.tabs2, container, false);

        Helper h = new Helper();
        h.checkBoxChangeListener(rootView,R.id.checkBox4,1,4,getActivity());
        h.checkBoxChangeListener(rootView,R.id.checkBox5,2,5,getActivity());
        h.checkBoxChangeListener(rootView,R.id.checkBox6,3,6,getActivity());

        return rootView;
    }
}