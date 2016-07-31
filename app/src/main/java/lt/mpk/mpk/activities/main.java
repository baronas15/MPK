package lt.mpk.mpk.activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import lt.mpk.mpk.R;

public class main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        //getSupportActionBar().setDisplayShowTitleEnabled(false);
        //myToolbar.setNavigationIcon(R.drawable.back);

        //region ChangeFonts
        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/Fondamento.ttf");
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

        //region StartButton_Listener
        Button startButton = (Button)findViewById(R.id.activity_main_button1);
        if (startButton != null) {
            startButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        ButtonClick1();
                    }
                }
            );
        }
        //endregion

        //region LayoutButton_Listener1
        LinearLayout lout1 = (LinearLayout)findViewById(R.id.activity_main_item1);
        if (lout1 != null) {
            lout1.setOnClickListener(
                new LinearLayout.OnClickListener(){ public void onClick(View v){
                        PanelClick1();
        } } ); }
        TextView tx1 = (TextView)findViewById(R.id.activity_main_text1);
        if (tx1 != null) {
            tx1.setOnClickListener(
                new TextView.OnClickListener(){ public void onClick(View v){
                        PanelClick1();
        } } ); }
        ImageView im1 = (ImageView)findViewById(R.id.activity_main_image1);
        if (im1 != null) {
            im1.setOnClickListener(
                new ImageView.OnClickListener(){ public void onClick(View v){
                        PanelClick1();
        } } ); }
        //endregion

        //region LayoutButton_Listener2
        LinearLayout lout2 = (LinearLayout)findViewById(R.id.activity_main_item2);
        if (lout2 != null) {
            lout2.setOnClickListener(
                    new LinearLayout.OnClickListener(){ public void onClick(View v){
                        PanelClick2();
        } } ); }
        TextView tx2 = (TextView)findViewById(R.id.activity_main_text2);
        if (tx2 != null) {
            tx2.setOnClickListener(
                    new TextView.OnClickListener(){ public void onClick(View v){
                        PanelClick2();
        } } ); }
        ImageView im2 = (ImageView)findViewById(R.id.activity_main_image2);
        if (im2 != null) {
            im2.setOnClickListener(
                    new ImageView.OnClickListener(){ public void onClick(View v){
                        PanelClick2();
        } } ); }
        //endregion

        //region LayoutButton_Listener3
        LinearLayout lout3 = (LinearLayout)findViewById(R.id.activity_main_item3);
        if (lout3 != null) {
            lout3.setOnClickListener(
                    new LinearLayout.OnClickListener(){ public void onClick(View v){
                        PanelClick3();
                    } } ); }
        TextView tx3 = (TextView)findViewById(R.id.activity_main_text3);
        if (tx3 != null) {
            tx3.setOnClickListener(
                    new TextView.OnClickListener(){ public void onClick(View v){
                        PanelClick3();
                    } } ); }
        ImageView im3 = (ImageView)findViewById(R.id.activity_main_image3);
        if (im3 != null) {
            im3.setOnClickListener(
                    new ImageView.OnClickListener(){ public void onClick(View v){
                        PanelClick3();
                    } } ); }
        //endregion
    }


    @Override
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
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }


    //region Redirecting
    public void ButtonClick1(){
        startActivity(new Intent(main.this, activity1.class));
        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);
    }
    public void PanelClick1(){
        startActivity(new Intent(main.this, activity2.class));
        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);
    }
    public void PanelClick2(){
        startActivity(new Intent(main.this, activity3.class));
        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);
    }
    public void PanelClick3(){
        startActivity(new Intent(main.this, activity4.class));
        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);
    }
    //endregion
}
