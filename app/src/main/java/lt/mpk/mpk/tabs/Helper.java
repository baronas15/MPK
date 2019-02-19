package lt.mpk.mpk.tabs;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import lt.mpk.mpk.R;
import lt.mpk.mpk.app;

class Helper {
    public void checkBoxChangeListener(final View r, final int i, final int x, final int y, final Context context){
        CheckBox cBox = r.findViewById( i );
        if (cBox != null) {
            cBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    app a = ((app)context.getApplicationContext());

                    CheckBox cBox = r.findViewById( i );
                    if(isChecked){
                        cBox.setBackgroundColor(ContextCompat.getColor(context.getApplicationContext(), R.color.checkboxBackgroundSelected));
                        cBox.setTextColor(ContextCompat.getColor(context.getApplicationContext(), R.color.checkboxTextSelected));
                        if (x == 1)
                            a.setEmotional1(y);
                        else if (x == 2)
                            a.setEmotional2(y);
                        else
                            a.setEmotional3(y);
                    }
                    else{
                        cBox.setBackgroundColor(ContextCompat.getColor(context.getApplicationContext(), R.color.checkboxBackgroundDefault));
                        cBox.setTextColor(ContextCompat.getColor(context.getApplicationContext(), R.color.checkboxTextDefault));
                        if (x == 1)
                            a.setEmotional1(-1);
                        else if (x == 2)
                            a.setEmotional2(-1);
                        else
                            a.setEmotional3(-1);
                    }
                }
            });
        }
    }
}
