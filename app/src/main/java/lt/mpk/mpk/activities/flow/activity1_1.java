package lt.mpk.mpk.activities.flow;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import lt.mpk.mpk.NavDrawer;
import lt.mpk.mpk.R;
import lt.mpk.mpk.app;

public class activity1_1 extends NavDrawer {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_activity1_1);

        RadioGroup radGrp = findViewById(R.id.physicalgroup);
        final ImageView img = findViewById(R.id.physicalimage);

        //region SetDefaultRadioButton
        /* Set starting value */
        RadioButton rB3 = findViewById(R.id.physicalgroup_3);
        rB3.setSelected(true);
        int checkedRadioButtonID = radGrp.getCheckedRadioButtonId();
        changeBackgrounds(checkedRadioButtonID);
        //endregion

        //region MindGroup_ChangeListener
        radGrp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup arg0, int id) {
            switch (id) {
                case R.id.physicalgroup_1:
                    img.setImageResource(R.drawable.emo1);
                    changeBackgrounds(id);
                    break;
                case R.id.physicalgroup_2:
                    img.setImageResource(R.drawable.emo2);
                    changeBackgrounds(id);
                    break;
                case R.id.physicalgroup_3:
                    img.setImageResource(R.drawable.emo3);
                    changeBackgrounds(id);
                    break;
                case R.id.physicalgroup_4:
                    img.setImageResource(R.drawable.emo4);
                    changeBackgrounds(id);
                    break;
                case R.id.physicalgroup_5:
                    img.setImageResource(R.drawable.emo5);
                    changeBackgrounds(id);
                    break;
            }
            }
        });
        //endregion

        super.onCreate(savedInstanceState);
    }

    public void activity12button1_Click(View v){
        RadioGroup radGrp = findViewById(R.id.physicalgroup);
        int checkedRadioButtonID = radGrp.getCheckedRadioButtonId();

        app a = ((app)getApplicationContext());
        switch (checkedRadioButtonID) {
            case R.id.physicalgroup_1:
                a.setPhysical(1);
                break;
            case R.id.physicalgroup_2:
                a.setPhysical(2);
                break;
            case R.id.physicalgroup_3:
                a.setPhysical(3);
                break;
            case R.id.physicalgroup_4:
                a.setPhysical(4);
                break;
            case R.id.physicalgroup_5:
                a.setPhysical(5);
                break;
        }

        startActivity(new Intent(activity1_1.this, activity1_2.class));
        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

    //region ChangeColors
    private void changeBackgrounds(int selected)
    {
        RadioButton rB1 = findViewById(R.id.physicalgroup_1);
        RadioButton rB2 = findViewById(R.id.physicalgroup_2);
        RadioButton rB3 = findViewById(R.id.physicalgroup_3);
        RadioButton rB4 = findViewById(R.id.physicalgroup_4);
        RadioButton rB5 = findViewById(R.id.physicalgroup_5);
        View s1 = findViewById(R.id.pSpace1);
        View s2 = findViewById(R.id.pSpace2);
        View s3 = findViewById(R.id.pSpace3);
        View s4 = findViewById(R.id.pSpace4);

        rB1.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.radioButtonBackgroundDefault));
        rB2.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.radioButtonBackgroundDefault));
        rB3.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.radioButtonBackgroundDefault));
        rB4.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.radioButtonBackgroundDefault));
        rB5.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.radioButtonBackgroundDefault));

        rB1.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.primaryText));
        rB2.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.primaryText));
        rB3.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.primaryText));
        rB4.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.primaryText));
        rB5.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.primaryText));

        s1.setVisibility(View.VISIBLE);
        s2.setVisibility(View.VISIBLE);
        s3.setVisibility(View.VISIBLE);
        s4.setVisibility(View.VISIBLE);

        switch (selected) {
            case R.id.physicalgroup_1:
                rB1.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.radioButtonBackgroundSelect));
                rB1.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.primaryTextInverted));
                s1.setVisibility(View.INVISIBLE);
                break;
            case R.id.physicalgroup_2:
                rB2.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.radioButtonBackgroundSelect));
                rB2.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.primaryTextInverted));
                s1.setVisibility(View.INVISIBLE);
                s2.setVisibility(View.INVISIBLE);
                break;
            case R.id.physicalgroup_3:
                rB3.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.radioButtonBackgroundSelect));
                rB3.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.primaryTextInverted));
                s2.setVisibility(View.INVISIBLE);
                s3.setVisibility(View.INVISIBLE);
                break;
            case R.id.physicalgroup_4:
                rB4.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.radioButtonBackgroundSelect));
                rB4.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.primaryTextInverted));
                s3.setVisibility(View.INVISIBLE);
                s4.setVisibility(View.INVISIBLE);
                break;
            case R.id.physicalgroup_5:
                rB5.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.radioButtonBackgroundSelect));
                rB5.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.primaryTextInverted));
                s4.setVisibility(View.INVISIBLE);
                break;
        }
    }
    //endregion
}