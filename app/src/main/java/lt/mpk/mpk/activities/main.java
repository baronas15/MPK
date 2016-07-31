package lt.mpk.mpk.activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import lt.mpk.mpk.R;

public class main extends AppCompatActivity {
    private Typeface tf;
    private Toolbar myToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Initialize variables */
        myToolbar = (Toolbar) findViewById(R.id.toolbar);
        tf = Typeface.createFromAsset(getAssets(), "fonts/express.ttf");

        setSupportActionBar(myToolbar);

        //region ChangeFonts
        TextView tv = (TextView) findViewById(R.id.activity_main_title);
        if (tv != null) {
            tv.setTypeface(tf);
        }
        TextView tv1 = (TextView) findViewById(R.id.activity_main_text1);
        if (tv1 != null) {
            tv1.setTypeface(tf);
        }
        TextView tv2 = (TextView) findViewById(R.id.activity_main_text2);
        if (tv2 != null) {
            tv2.setTypeface(tf);
        }
        TextView tv3 = (TextView) findViewById(R.id.activity_main_text3);
        if (tv3 != null) {
            tv3.setTypeface(tf);
        }

        TextView tv4 = (TextView) findViewById(R.id.activity_main_titleText);
        if (tv4 != null) {
            tv4.setTypeface(tf);
        }
        TextView tv5 = (TextView) findViewById(R.id.activity_main_button1);
        if (tv5 != null) {
            tv5.setTypeface(tf);
        }
        //endregion
    }


    /*@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_back:
                //If pressed back button
                return true;

            case R.id.action_next:
                //If pressed forward button
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);
        }
    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }


    //region Redirecting
    public void ButtonClick1(View v){
        startActivity(new Intent(main.this, activity1.class));
        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);
    }
    public void PanelClick1(View v){
        startActivity(new Intent(main.this, activity2.class));
        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);
    }
    public void PanelClick2(View v){
        startActivity(new Intent(main.this, activity3.class));
        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);
    }
    public void PanelClick3(View v){
        startActivity(new Intent(main.this, activity4.class));
        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);
    }
    //endregion
}
