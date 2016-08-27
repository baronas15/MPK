package lt.mpk.mpk.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import lt.mpk.mpk.R;

public class activity4_1_2 extends AppCompatActivity {
    int textFields[] = { R.id.activity4_1_2_text1, R.id.activity4_1_2_text2,
            R.id.activity4_1_2_text3, R.id.activity4_1_2_text4,
            R.id.activity4_1_2_text5, R.id.activity4_1_2_text6,
            R.id.activity4_1_2_text7, R.id.activity4_1_2_text8,
            R.id.activity4_1_2_text9, R.id.activity4_1_2_text10,
            R.id.activity4_1_2_text11, R.id.activity4_1_2_text12,
            R.id.activity4_1_2_text13, R.id.activity4_1_2_text14,
            R.id.activity4_1_2_text15, R.id.activity4_1_2_text16,
            R.id.activity4_1_2_text17, R.id.activity4_1_2_text18,
            R.id.activity4_1_2_text19, R.id.activity4_1_2_text20,
            R.id.activity4_1_2_text21, R.id.activity4_1_2_text22,
            R.id.activity4_1_2_text23};
    int imageFields[] = { R.id.activity4_1_2_image1, R.id.activity4_1_2_image2,
            R.id.activity4_1_2_image3, R.id.activity4_1_2_image4,
            R.id.activity4_1_2_image5, R.id.activity4_1_2_image6,
            R.id.activity4_1_2_image7, R.id.activity4_1_2_image8,
            R.id.activity4_1_2_image9, R.id.activity4_1_2_image10,
            R.id.activity4_1_2_image11, R.id.activity4_1_2_image12,
            R.id.activity4_1_2_image13, R.id.activity4_1_2_image14,
            R.id.activity4_1_2_image15, R.id.activity4_1_2_image16,
            R.id.activity4_1_2_image17, R.id.activity4_1_2_image18,
            R.id.activity4_1_2_image19, R.id.activity4_1_2_image20,
            R.id.activity4_1_2_image21, R.id.activity4_1_2_image22,
            R.id.activity4_1_2_image23};

    private DrawerLayout mDrawer;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity4_1_2);

        SharedPreferences settings = getSharedPreferences("Stickers", 0);
        SharedPreferences.Editor editor = settings.edit();

        for (int i = 1; i <= 23; i++){
            if (settings.getBoolean("sticker"+i,false)== false){
                Log.d("sticker"+i,"true");
                TextView tx = (TextView) findViewById(textFields[i-1]);
                ImageView im = (ImageView) findViewById(imageFields[i-1]);

                im.setImageDrawable(getResources().getDrawable(R.drawable.locked));
            }
        }

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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawer.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
