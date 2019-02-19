package lt.mpk.mpk.tabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import lt.mpk.mpk.R;
import lt.mpk.mpk.app;

public class TabFragment1 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.tabs1, container, false);

        Helper h = new Helper();
        h.checkBoxChangeListener(rootView,R.id.checkBox1,1,1,getActivity());
        h.checkBoxChangeListener(rootView,R.id.checkBox2,2,2,getActivity());
        h.checkBoxChangeListener(rootView,R.id.checkBox3,3,3,getActivity());

        app a = (app)getActivity().getApplicationContext();

        CheckBox c1 = rootView.findViewById(R.id.checkBox1);
        CheckBox c2 = rootView.findViewById(R.id.checkBox2);
        CheckBox c3 = rootView.findViewById(R.id.checkBox3);

        if(a.getEmotional1() == 1)
            c1.setChecked(true);
        if(a.getEmotional2() == 2)
            c2.setChecked(true);
        if(a.getEmotional3() == 3)
            c3.setChecked(true);

        return rootView;
    }
}