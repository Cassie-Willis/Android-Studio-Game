package group14.cs2110.virginia.edu.cs2110annihilators;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

/**
 * Created by Cassie on 4/7/2015.
 */
public class MenuActivity extends ActionBarActivity {

    MediaPlayer mySound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        mySound = MediaPlayer.create(this, R.raw.menusong);
        mySound.setLooping(true);
        mySound.start();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void newGame(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        mySound.pause();
    }

    public void playMusic(View view) {
        if (mySound.isPlaying()) {
            mySound.pause();
        }
        else {
            mySound.start();
        }
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
}
