package group14.cs2110.virginia.edu.cs2110annihilators;

/**
 * Created by Cassie on 4/7/2015.
 */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Layout;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.Random;

public class MainActivity extends ActionBarActivity implements View.OnTouchListener {

    MediaPlayer mySoundMain;
    MediaPlayer flash;
    Bitmap b = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888);
    Canvas c = new Canvas(b);
    //Ourview v;
    int x, y;
    int max = 800;
    Ghosts redghost;
    final Random rnd = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mySoundMain = MediaPlayer.create(this, R.raw.mainsong);
        flash = MediaPlayer.create(this, R.raw.camera);
        x = y = 0;
        mySoundMain.setLooping(true);
        mySoundMain.start();
        ImageView j = (ImageView)findViewById(R.id.hero);
        j.setOnTouchListener(this);
        redghost = new Ghosts(BitmapFactory.decodeResource(getResources(), R.drawable.red_ghost), 200, 200);
        ImageView baddie = new ImageView(getApplicationContext());
    }

    public boolean onTouch(View view, MotionEvent event) {
        final int X = (int) event.getRawX();
        final int Y = (int) event.getRawY();
        ImageView j = (ImageView)findViewById(R.id.hero);
        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:
                RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
                x = (int) (X - j.getTranslationX());
                y = (int) (Y - j.getTranslationY());
                break;
            case MotionEvent.ACTION_UP:
                break;
            case MotionEvent.ACTION_POINTER_DOWN:
                break;
            case MotionEvent.ACTION_POINTER_UP:
                break;
            case MotionEvent.ACTION_MOVE:
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();

                j.setTranslationX(X - x);
                j.setTranslationY(Y - y);
                break;
        }

        return true;
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    public void playMusic(View view) {
        if (mySoundMain.isPlaying()) {
            mySoundMain.pause();
        } else {
            mySoundMain.start();
        }
    }

    public void pause(View view) {
        super.onPause();
    }

    public void talk(View view) {
        //method to talk to green ghosts
    }

    public void pickUp(View view) {
//        if (coins.getX() == hero.getX() && coins.getY() == hero.getY()) {
//            coins.destroy();
//            money += 5;
//        }

//        else if (health.getX() == hero.getX() && health.getY() == hero.getY()) {
//            coins.destroy();
//            heroHealth += 5;
//        }

//        else if (film.getX() == hero.getX() && film.getY() == hero.getY()) {
//            coins.destroy();
//            ammo += 5;
//        }

    }

    public void toUp(View view) {
        RelativeLayout main = (RelativeLayout) MainActivity.this.findViewById(R.id.mainActivity);
        flash.start();
        flash.setLooping(false);
        ImageView coins = new ImageView(this);
        coins.setImageResource(R.drawable.coin);
        ImageView film = new ImageView(this);
        film.setImageResource(R.drawable.film);
        ImageView health = new ImageView(this);
        health.setImageResource(R.drawable.health);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT);
        RelativeLayout.LayoutParams params2 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT);
        RelativeLayout.LayoutParams params3 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT);
        params.leftMargin = rnd.nextInt(max);
        params.topMargin = rnd.nextInt(max);
        params2.leftMargin = rnd.nextInt(max);
        params2.topMargin = rnd.nextInt(max);
        params3.leftMargin = rnd.nextInt(max);
        params3.topMargin = rnd.nextInt(max);
//        if (ghosts.getX() == hero.getX() && ghosts.getY <= hero.getY()) {
//            main.removeView(ghosts);
        main.addView(coins, params);
        main.addView(health, params2);
        main.addView(film, params3);
       // }
    }

    public void toDown(View view) {
        RelativeLayout main = (RelativeLayout) MainActivity.this.findViewById(R.id.mainActivity);
        flash.start();
        flash.setLooping(false);
        ImageView coins = new ImageView(this);
        coins.setImageResource(R.drawable.coin);
        ImageView film = new ImageView(this);
        film.setImageResource(R.drawable.film);
        ImageView health = new ImageView(this);
        health.setImageResource(R.drawable.health);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT);
        RelativeLayout.LayoutParams params2 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT);
        RelativeLayout.LayoutParams params3 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT);
        params.leftMargin = rnd.nextInt(max);
        params.topMargin = rnd.nextInt(max);
        params2.leftMargin = rnd.nextInt(max);
        params2.topMargin = rnd.nextInt(max);
        params3.leftMargin = rnd.nextInt(max);
        params3.topMargin = rnd.nextInt(max);
//        if (ghosts.getX() == hero.getX() && ghosts.getY >= hero.getY()) {
//            main.removeView(ghosts);
            main.addView(coins, params);
            main.addView(health, params2);
            main.addView(film, params3);
        //}
    }

    public void toRight(View view) {
        RelativeLayout main = (RelativeLayout) MainActivity.this.findViewById(R.id.mainActivity);
        flash.start();
        flash.setLooping(false);
        ImageView coins = new ImageView(this);
        coins.setImageResource(R.drawable.coin);
        ImageView film = new ImageView(this);
        film.setImageResource(R.drawable.film);
        ImageView health = new ImageView(this);
        health.setImageResource(R.drawable.health);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT);
        RelativeLayout.LayoutParams params2 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT);
        RelativeLayout.LayoutParams params3 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT);
        params.leftMargin = rnd.nextInt(max);
        params.topMargin = rnd.nextInt(max);
        params2.leftMargin = rnd.nextInt(max);
        params2.topMargin = rnd.nextInt(max);
        params3.leftMargin = rnd.nextInt(max);
        params3.topMargin = rnd.nextInt(max);
//        if (ghosts.getX() >= hero.getX() && ghosts.getY == hero.getY()) {
//            main.removeView(ghosts);
        main.addView(coins, params);
        main.addView(health, params2);
        main.addView(film, params3);
        // }
    }

    public void toLeft(View view) {
        RelativeLayout main = (RelativeLayout) MainActivity.this.findViewById(R.id.mainActivity);
        flash.start();
        flash.setLooping(false);
        ImageView coins = new ImageView(this);
        coins.setImageResource(R.drawable.coin);
        ImageView film = new ImageView(this);
        film.setImageResource(R.drawable.film);
        ImageView health = new ImageView(this);
        health.setImageResource(R.drawable.health);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT);
        RelativeLayout.LayoutParams params2 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT);
        RelativeLayout.LayoutParams params3 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT);
        params.leftMargin = rnd.nextInt(max);
        params.topMargin = rnd.nextInt(max);
        params2.leftMargin = rnd.nextInt(max);
        params2.topMargin = rnd.nextInt(max);
        params3.leftMargin = rnd.nextInt(max);
        params3.topMargin = rnd.nextInt(max);
//        if (ghosts.getX() <= hero.getX() && ghosts.getY == hero.getY()) {
//            main.removeView(ghosts);
        main.addView(coins, params);
        main.addView(health, params2);
        main.addView(film, params3);
        // }
    }

    public void goToMenu(View view) {
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
        mySoundMain.pause();
        //pause();
    }
}


//    public class Ourview extends SurfaceView implements Runnable{
//
//        Thread t = null;
//        SurfaceHolder holder;
//        boolean isItOK = false;
//
//        public Ourview(Context context) {
//            super(context);
//            holder = getHolder();
//        }
//
//        public void run() {
//            while(isItOK)
//                if(!holder.getSurface().isValid()){
//                    continue;
//                }
//
//            Canvas c = holder.lockCanvas();
//            c.drawARGB(225, 150, 150, 10);
//            c.drawBitmap(b, x, y, null);
//            holder.unlockCanvasAndPost(c);
//
//        }
//
//        public void pause(){
//            isItOK = false;
//            while(true){
//                try{
//                    t.join();
//                }
//                catch (InterruptedException e){
//                    System.out.println("What happened lol");
//                }
//            }
//
//            //There may be more code that I'm missing lol
//            //I'm not sure though
//        }
//    }
//}
//
////    @Override
////    public boolean onCreateOptionsMenu(Menu menu) {
////        // Inflate the menu; this adds items to the action bar if it is present.
////        getMenuInflater().inflate(R.menu.menu_display_message, menu);
////        return true;
////    }

