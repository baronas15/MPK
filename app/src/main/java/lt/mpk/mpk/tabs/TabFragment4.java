package lt.mpk.mpk.tabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import lt.mpk.mpk.R;
import lt.mpk.mpk.app;

public class TabFragment4 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.tabs4, container, false);

        Helper h = new Helper();
        h.checkBoxChangeListener(rootView,R.id.checkBox10,1,10,getActivity());
        h.checkBoxChangeListener(rootView,R.id.checkBox11,2,11,getActivity());
        h.checkBoxChangeListener(rootView,R.id.checkBox12,3,12,getActivity());

        app a = (app)getActivity().getApplicationContext();

        CheckBox c1 = (CheckBox)rootView.findViewById(R.id.checkBox10);
        CheckBox c2 = (CheckBox)rootView.findViewById(R.id.checkBox11);
        CheckBox c3 = (CheckBox)rootView.findViewById(R.id.checkBox12);

        if(a.getEmotional1() == 10)
            c1.setChecked(true);
        if(a.getEmotional2() == 11)
            c2.setChecked(true);
        if(a.getEmotional3() == 12)
            c3.setChecked(true);

        return rootView;
    }
}