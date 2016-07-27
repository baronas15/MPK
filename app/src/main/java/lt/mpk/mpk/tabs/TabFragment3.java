package lt.mpk.mpk.tabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import lt.mpk.mpk.R;
import lt.mpk.mpk.app;

public class TabFragment3 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.tabs3, container, false);

        Helper h = new Helper();
        h.checkBoxChangeListener(rootView,R.id.checkBox7,1,7,getActivity());
        h.checkBoxChangeListener(rootView,R.id.checkBox8,2,8,getActivity());
        h.checkBoxChangeListener(rootView,R.id.checkBox9,3,9,getActivity());

        app a = (app)getActivity().getApplicationContext();

        CheckBox c1 = (CheckBox)rootView.findViewById(R.id.checkBox7);
        CheckBox c2 = (CheckBox)rootView.findViewById(R.id.checkBox8);
        CheckBox c3 = (CheckBox)rootView.findViewById(R.id.checkBox9);

        if(a.getEmotional1() == 7)
            c1.setChecked(true);
        if(a.getEmotional2() == 8)
            c2.setChecked(true);
        if(a.getEmotional3() == 9)
            c3.setChecked(true);

        return rootView;
    }
}