package lt.mpk.mpk.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import lt.mpk.mpk.R;

public class main extends AppCompatActivity {
    private int enterAnim = R.anim.slide_in_right;
    private int exitAnim = R.anim.slide_out_right;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Create toolbar */
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        //region Stickers
        SharedPreferences settings = getSharedPreferences("Stickers", 0);
        SharedPreferences.Editor editor = settings.edit();

        if(!settings.contains("meditationCount"))
            editor.putInt("meditationCount",0);

        if(!settings.contains("daysInARow"))
            editor.putInt("daysInARow",0);

        if(!settings.contains("meditationsInOneGo"))
            editor.putInt("meditationsInOneGo",0);

        if(!settings.contains("totalTime"))
            editor.putInt("totalTime",0);

        if(!settings.contains("lastSticker"))
            editor.putInt("lastSticker",-1);

        for (int i = 1; i <= 23; i++){
            if(!settings.contains("sticker"+i))
                editor.putBoolean("sticker"+i,false);
            if (settings.getBoolean("sticker"+i,false))
                Log.d("sticker"+i,"true");
        }

        editor.apply();
        //endregion

        //region Buttons
        Button b = (Button) findViewById(R.id.activity_main_button1);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(main.this, activity1.class));
                overridePendingTransition(enterAnim,exitAnim);
            }
        });
        LinearLayout l1 = (LinearLayout) findViewById(R.id.activity_main_item1);
        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(main.this, activity2.class));
                overridePendingTransition(enterAnim,exitAnim);
            }
        });
        LinearLayout l2 = (LinearLayout) findViewById(R.id.activity_main_item2);
        l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(main.this, activity3.class));
                overridePendingTransition(enterAnim,exitAnim);
            }
        });
        LinearLayout l3 = (LinearLayout) findViewById(R.id.activity_main_item3);
        l3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(main.this, activity4.class));
                overridePendingTransition(enterAnim,exitAnim);
            }
        });
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
}
