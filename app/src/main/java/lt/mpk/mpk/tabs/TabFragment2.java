package lt.mpk.mpk.tabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import lt.mpk.mpk.R;
import lt.mpk.mpk.app;

public class TabFragment2 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.tabs2, container, false);

        Helper h = new Helper();
        h.checkBoxChangeListener(rootView,R.id.checkBox4,1,4,getActivity());
        h.checkBoxChangeListener(rootView,R.id.checkBox5,2,5,getActivity());
        h.checkBoxChangeListener(rootView,R.id.checkBox6,3,6,getActivity());

        app a = (app)getActivity().getApplicationContext();

        CheckBox c1 = (CheckBox)rootView.findViewById(R.id.checkBox4);
        CheckBox c2 = (CheckBox)rootView.findViewById(R.id.checkBox5);
        CheckBox c3 = (CheckBox)rootView.findViewById(R.id.checkBox6);

        if(a.getEmotional1() == 4)
            c1.setChecked(true);
        if(a.getEmotional2() == 5)
            c2.setChecked(true);
        if(a.getEmotional3() == 6)
            c3.setChecked(true);

        return rootView;
    }
}