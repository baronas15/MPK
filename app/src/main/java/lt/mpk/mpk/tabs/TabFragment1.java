package lt.mpk.mpk.tabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import lt.mpk.mpk.R;

public class TabFragment1 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.tabs1, container, false);

        Helper h = new Helper();
        h.checkBoxChangeListener(rootView,R.id.checkBox1,1,1,getActivity());
        h.checkBoxChangeListener(rootView,R.id.checkBox2,2,2,getActivity());
        h.checkBoxChangeListener(rootView,R.id.checkBox3,3,3,getActivity());

        return rootView;
    }
}