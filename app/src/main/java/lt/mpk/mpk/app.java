package lt.mpk.mpk;

import android.app.Application;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class app extends Application {
    public int getMental() {
        return mental;
    }
    public int getPhysical() {
        return physical;
    }
    public int getEmotional1() {
        return emotional1;
    }
    public int getEmotional2() {
        return emotional2;
    }
    public int getEmotional3() {
        return emotional3;
    }
    public int getCurrentTab() { return currentTab; }

    public void setMental(int mental) {
        this.mental = mental;
    }
    public void setPhysical(int physical) {
        this.physical = physical;
    }
    public void setEmotional1(int emotional1) {
        this.emotional1 = emotional1;
    }
    public void setEmotional2(int emotional2) {
        this.emotional2 = emotional2;
    }
    public void setEmotional3(int emotional3) {
        this.emotional3 = emotional3;
    }
    public void setCurrentTab(int currentTab) { this.currentTab = currentTab; }

    private int mental;
    private int physical;
    private int emotional1;
    private int emotional2;
    private int emotional3;
    private int currentTab;
}

/*
* Example usage:
*
* app a = ((app)getApplicationContext());
* int mental = a.getMental();
* a.setMental(1);
* */
