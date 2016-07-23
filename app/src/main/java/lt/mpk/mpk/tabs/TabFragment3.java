package lt.mpk.mpk.tabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import lt.mpk.mpk.R;

public class TabFragment3 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.tabs3, container, false);

        Helper h = new Helper();
        h.checkBoxChangeListener(rootView,R.id.checkBox7,1,7,getActivity());
        h.checkBoxChangeListener(rootView,R.id.checkBox8,2,8,getActivity());
        h.checkBoxChangeListener(rootView,R.id.checkBox9,3,9,getActivity());

        return rootView;
    }
}