package lt.mpk.mpk.activities;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import lt.mpk.mpk.R;
import lt.mpk.mpk.app;

public class activity1_2 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity1_2);

        RadioGroup radGrp = (RadioGroup) findViewById(R.id.physicalgroup);
        final ImageView img = (ImageView) findViewById(R.id.physicalimage);

        //region SetDefaultRadioButton
        /* Set starting value */
        RadioButton rB3 = (RadioButton) findViewById(R.id.physicalgroup_3);
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
    }

    public void activity12button1_Click(View v){
        RadioGroup radGrp = (RadioGroup) findViewById(R.id.physicalgroup);
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

        startActivity(new Intent(activity1_2.this, activity1_3.class));
        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    //region ChangeColors
    private void changeBackgrounds(int selected)
    {
        RadioButton rB1 = (RadioButton) findViewById(R.id.physicalgroup_1);
        RadioButton rB2 = (RadioButton) findViewById(R.id.physicalgroup_2);
        RadioButton rB3 = (RadioButton) findViewById(R.id.physicalgroup_3);
        RadioButton rB4 = (RadioButton) findViewById(R.id.physicalgroup_4);
        RadioButton rB5 = (RadioButton) findViewById(R.id.physicalgroup_5);


        rB1.setBackgroundResource(R.color.radioButtonBackgroundDefault);
        rB2.setBackgroundResource(R.color.radioButtonBackgroundDefault);
        rB3.setBackgroundResource(R.color.radioButtonBackgroundDefault);
        rB4.setBackgroundResource(R.color.radioButtonBackgroundDefault);
        rB5.setBackgroundResource(R.color.radioButtonBackgroundDefault);

        rB1.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.primaryText));
        rB2.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.primaryText));
        rB3.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.primaryText));
        rB4.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.primaryText));
        rB5.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.primaryText));

        switch (selected) {
            case R.id.physicalgroup_1:
                rB1.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.radioButtonBackgroundSelect));
                rB1.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.primaryTextInverted));
                break;
            case R.id.physicalgroup_2:
                rB2.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.radioButtonBackgroundSelect));
                rB2.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.primaryTextInverted));
                break;
            case R.id.physicalgroup_3:
                rB3.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.radioButtonBackgroundSelect));
                rB3.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.primaryTextInverted));
                break;
            case R.id.physicalgroup_4:
                rB4.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.radioButtonBackgroundSelect));
                rB4.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.primaryTextInverted));
                break;
            case R.id.physicalgroup_5:
                rB5.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.radioButtonBackgroundSelect));
                rB5.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.primaryTextInverted));
                break;
        }
    }
    //endregion
}


/*

        SharedPreferences settings = getSharedPreferences("Preferences", 0);

        switch (settings.getInt("mental",3)) {
            case R.id.mindgroup_1:
                //Mind was selected 1
                break;
            case R.id.mindgroup_2:
                //Mind was selected 2
                break;
            case R.id.mindgroup_3:
                //Mind was selected 3
                break;
            case R.id.mindgroup_4:
                //Mind was selected 4
                break;
            case R.id.mindgroup_5:
                //Mind was selected 5
                break;
        }

*/