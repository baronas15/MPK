package lt.mpk.mpk.activities;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import lt.mpk.mpk.R;
import lt.mpk.mpk.app;

public class activity1 extends AppCompatActivity {
    private DrawerLayout mDrawer;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity1);

        //region Activity1
        app a = ((app)getApplicationContext());
        a.setEmotional1(-1);
        a.setEmotional2(-1);
        a.setEmotional3(-1);
        a.setCurrentTab(-1);


        final ImageView i = (ImageView) findViewById(R.id.activity1_image);
        final ImageView bg = (ImageView) findViewById(R.id.activity1_image_background);
        final TextView txt = (TextView) findViewById(R.id.activity1_switchText);

        final Animation down = AnimationUtils.loadAnimation(this, R.anim.scale_down);
        final Animation up = AnimationUtils.loadAnimation(this, R.anim.scale_up);

        final Animation downSmall = AnimationUtils.loadAnimation(this, R.anim.scale_down_small);
        final Animation upSmall = AnimationUtils.loadAnimation(this, R.anim.scale_up_small);

        final Animation textDown = AnimationUtils.loadAnimation(this, R.anim.alpha_down);
        final Animation textUp = AnimationUtils.loadAnimation(this, R.anim.alpha_up);

        i.startAnimation(down);
        bg.startAnimation(downSmall);
        txt.startAnimation(textDown);
        down.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                txt.setText(R.string.animation_out);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                i.startAnimation(up);
                bg.startAnimation(upSmall);
                txt.startAnimation(textUp);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {}
        });

        up.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                txt.setText(R.string.animation_in);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                i.startAnimation(down);
                bg.startAnimation(downSmall);
                txt.startAnimation(textDown);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {}
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

        ImageView f1 = (ImageView) findViewById(R.id.drawer_item_1);
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
        FrameLayout f9 = (FrameLayout) findViewById(R.id.drawer_item_9);
        f8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.avmi.lt/"));
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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

    public void activity1button1_Click(View v){
        startActivity(new Intent(activity1.this, activity1_1.class));
        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);
    }
}