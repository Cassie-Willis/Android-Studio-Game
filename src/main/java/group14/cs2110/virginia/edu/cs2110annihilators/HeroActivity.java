package group14.cs2110.virginia.edu.cs2110annihilators;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by Cassie on 4/11/2015.
 */
public class HeroActivity extends Activity {
    /** Called when the activity is first created. */

    private static final String TAG = HeroActivity.class.getSimpleName();
    MediaPlayer mySoundMain;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // requesting to turn the title OFF
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // making it full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // set our MainGamePanel as the View
        setContentView(new MainGamePanel(this));
        Log.d(TAG, "View added");
        mySoundMain = MediaPlayer.create(this, R.raw.mainsong);
        mySoundMain.setLooping(true);
        mySoundMain.start();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "Destroying...");
        super.onDestroy();
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "Stopping...");
        super.onStop();
    }

    public void goToMenu(View view) {
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
        mySoundMain.pause();
        //pause();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void playMusic(View view) {
        if (mySoundMain.isPlaying()) {
            mySoundMain.pause();
        } else {
            mySoundMain.start();
        }
    }


}
