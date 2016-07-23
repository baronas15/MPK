package lt.mpk.mpk.tabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import lt.mpk.mpk.R;

public class TabFragment5 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.tabs5, container, false);

        Helper h = new Helper();
        h.checkBoxChangeListener(rootView,R.id.checkBox13,1,13,getActivity());
        h.checkBoxChangeListener(rootView,R.id.checkBox14,2,14,getActivity());
        h.checkBoxChangeListener(rootView,R.id.checkBox15,3,15,getActivity());

        return rootView;
    }
}