package lt.mpk.mpk;

import android.app.Application;
import android.content.SharedPreferences;

/* Example usage:
*
* app a = ((app)getApplicationContext());
* int physical = a.getPhysical();
* a.setPhysical(1);
* */
public class app extends Application {
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

    private int physical;
    private int emotional1;
    private int emotional2;
    private int emotional3;
    private int currentTab;

    @Override
    public void onCreate() {
        super.onCreate();

        //region Stickers
        SharedPreferences settings = getSharedPreferences("Stickers", 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("meditationsInOneGo", 0);

        if(!settings.contains("lastMeditationYear"))
            editor.putInt("lastMeditationYear",1970);
        if(!settings.contains("lastMeditationMonth"))
            editor.putInt("lastMeditationMonth",0);
        if(!settings.contains("lastMeditationDay"))
            editor.putInt("lastMeditationDay",1);

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

        for (int i = 1; i <= 19; i++)
            if(!settings.contains("sticker"+i))
                editor.putBoolean("sticker"+i,false);

        for (int i = 1; i <= 7; i++)
            if(!settings.contains("playTime"+i))
                editor.putInt("playTime"+i,0);

        //FOR DEVELOPEMENT PURPOSES
        if(false){
            for (int i = 1; i <= 19; i++)
                editor.putBoolean("sticker"+i,true);
            editor.putInt("lastSticker",19);
            editor.putInt("totalTime",3600000);
            for (int i = 1; i <= 7; i++)
                editor.putInt("playTime"+i,10);
        }
        else if(false){
            for (int i = 1; i <= 19; i++)
                editor.putBoolean("sticker"+i,false);
            editor.putInt("lastSticker",-1);
            editor.putInt("totalTime",0);
            for (int i = 1; i <= 7; i++)
                editor.putInt("playTime"+i,0);
        }


        editor.apply();
        //endregion
    }
}