package lt.mpk.mpk.tabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import lt.mpk.mpk.R;
import lt.mpk.mpk.app;

public class TabFragment5 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.tabs5, container, false);

        Helper h = new Helper();
        h.checkBoxChangeListener(rootView,R.id.checkBox13,1,13,getActivity());
        h.checkBoxChangeListener(rootView,R.id.checkBox14,2,14,getActivity());
        h.checkBoxChangeListener(rootView,R.id.checkBox15,3,15,getActivity());

        app a = (app)getActivity().getApplicationContext();

        CheckBox c1 = (CheckBox)rootView.findViewById(R.id.checkBox13);
        CheckBox c2 = (CheckBox)rootView.findViewById(R.id.checkBox14);
        CheckBox c3 = (CheckBox)rootView.findViewById(R.id.checkBox15);

        if(a.getEmotional1() == 13)
            c1.setChecked(true);
        if(a.getEmotional2() == 14)
            c2.setChecked(true);
        if(a.getEmotional3() == 15)
            c3.setChecked(true);

        return rootView;
    }
}