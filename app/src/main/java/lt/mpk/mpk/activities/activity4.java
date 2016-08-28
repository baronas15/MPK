package lt.mpk.mpk.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import lt.mpk.mpk.R;

public class activity4 extends AppCompatActivity {
    private int enterAnim = R.anim.slide_in_down;
    private int exitAnim = R.anim.slide_out_down;

    private DrawerLayout mDrawer;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity4);
        SharedPreferences settings = getSharedPreferences("Stickers", 0);

        //region Area 1

        switch (settings.getInt("lastSticker",-1)){
            case -1:
                TextView tx = new TextView(this);
                tx.setText(getString(R.string.activity4_error1));
                tx.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.primaryText));
                FrameLayout.LayoutParams params = new FrameLayout.LayoutParams((int) FrameLayout.LayoutParams.WRAP_CONTENT,(int) FrameLayout.LayoutParams.WRAP_CONTENT);
                params.gravity = Gravity.CENTER;
                tx.setLayoutParams(params);
                if (Build.VERSION.SDK_INT < 23) tx.setTextAppearance(getApplicationContext(), android.R.style.TextAppearance_Large);
                else tx.setTextAppearance(android.R.style.TextAppearance_Large);

                FrameLayout frame = (FrameLayout) findViewById(R.id.activity4_item1);
                frame.addView(tx);
                break;
            case 1: addImageView(R.drawable.start); break;
            case 2: addImageView(R.drawable.meditation_count2); break;
            case 3: addImageView(R.drawable.meditation_count10); break;
            case 4: addImageView(R.drawable.meditation_count25); break;
            case 5: addImageView(R.drawable.in_a_row2); break;
            case 6: addImageView(R.drawable.in_a_row3); break;

            case 18: addImageView(R.drawable.total_count1h); break;
            case 19: addImageView(R.drawable.total_count5h); break;
            case 20: addImageView(R.drawable.total_count10h); break;
            case 21: addImageView(R.drawable.total_count25h); break;
            case 22: addImageView(R.drawable.total_count50h); break;
            case 23: addImageView(R.drawable.total_count100h); break;
        }

        //endregion
        //region Area 2
        TextView text2 = (TextView) findViewById(R.id.stickerCount);
        int stickerCount = 0;

        for (int i = 1; i <= 23; i++){
            if(settings.getBoolean("sticker"+i,true))
                stickerCount++;
            if(settings.getBoolean("sticker"+i,false))
                Log.d("sticker"+i,"true");
        }
        text2.setText(stickerCount+"/23");

        LinearLayout l2 = (LinearLayout) findViewById(R.id.activity4_layout2);
        l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(activity4.this, activity4_1_2.class));
                overridePendingTransition(enterAnim,exitAnim);
            }
        });
        //endregion

        //region Toolbar_NavDrawer
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
        ab.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("MPK");

        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        FrameLayout f1 = (FrameLayout) findViewById(R.id.drawer_item_1);
        f1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.mpk.lt"));
                startActivity(browserIntent);
                mDrawer.closeDrawers();
            }
        });
        FrameLayout f2 = (FrameLayout) findViewById(R.id.drawer_item_2);
        f2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), main.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("EXIT", true);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
                mDrawer.closeDrawers();
            }
        });
        FrameLayout f3 = (FrameLayout) findViewById(R.id.drawer_item_3);
        f3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), activity2.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("EXIT", true);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
                mDrawer.closeDrawers();
            }
        });
        FrameLayout f4 = (FrameLayout) findViewById(R.id.drawer_item_4);
        f4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), activity3.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("EXIT", true);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
                mDrawer.closeDrawers();
            }
        });
        FrameLayout f5 = (FrameLayout) findViewById(R.id.drawer_item_5);
        f5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), activity4.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("EXIT", true);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
                mDrawer.closeDrawers();
            }
        });
        FrameLayout f7 = (FrameLayout) findViewById(R.id.drawer_item_7);
        f7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.kaunas.lt/"));
                startActivity(browserIntent);
                mDrawer.closeDrawers();
            }
        });
        FrameLayout f8 = (FrameLayout) findViewById(R.id.drawer_item_8);
        f8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.kaunovsb.lt/"));
                startActivity(browserIntent);
                mDrawer.closeDrawers();
            }
        });
        //endregion
    }

    private void addImageView(int ResId) {
        ImageView iv = new ImageView(this);

        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams((int) FrameLayout.LayoutParams.WRAP_CONTENT,(int) FrameLayout.LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.CENTER;
        iv.setLayoutParams(params);

        iv.setImageDrawable(getResources().getDrawable(ResId));

        FrameLayout frame = (FrameLayout) findViewById(R.id.activity4_item1);
        frame.addView(iv);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawer.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }
}
