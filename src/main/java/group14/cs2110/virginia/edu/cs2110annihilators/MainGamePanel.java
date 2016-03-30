package group14.cs2110.virginia.edu.cs2110annihilators;

import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by Cassie on 4/11/2015.
 */
public class MainGamePanel extends SurfaceView implements
        SurfaceHolder.Callback {

    private static final String TAG = MainGamePanel.class.getSimpleName();

    private MainThread thread;
    private Hero hero;

    public MainGamePanel(Context context) {
        super(context);
        // adding the callback (this) to the surface holder to intercept events
        getHolder().addCallback(this);

        // create droid and load bitmap
        hero = new Hero(BitmapFactory.decodeResource(getResources(), R.drawable.hero), 50, 50);

        // create the game loop thread
        thread = new MainThread(getHolder(), this);

        // make the GamePanel focusable so it can handle events
        setFocusable(true);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width,
                               int height) {
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        // at this point the surface is created and
        // we can safely start the game loop
        thread.setRunning(true);
        thread.start();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        Log.d(TAG, "Surface is being destroyed");
        // tell the thread to shut down and wait for it to finish
        // this is a clean shutdown
        boolean retry = true;
        while (retry) {
            try {
                thread.join();
                retry = false;
            } catch (InterruptedException e) {
                // try again shutting down the thread
            }
        }
        Log.d(TAG, "Thread was shut down cleanly");
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            // delegating event handling to the droid
            hero.handleActionDown((int)event.getX(), (int)event.getY());

            // check if in the lower part of the screen we exit
            if (event.getY() > getHeight() - 50) {
                thread.setRunning(false);
                ((Activity)getContext()).finish();
            } else {
                Log.d(TAG, "Coords: x=" + event.getX() + ",y=" + event.getY());
            }
        } if (event.getAction() == MotionEvent.ACTION_MOVE) {
            // the gestures
            if (hero.isTouched()) {
                // the droid was picked up and is being dragged
                hero.setX((int)event.getX());
                hero.setY((int)event.getY());
            }
        } if (event.getAction() == MotionEvent.ACTION_UP) {
            // touch was released
            if (hero.isTouched()) {
                hero.setTouched(false);
            }
        }
        return true;
    }

    public void render(Canvas canvas) {
        canvas.drawColor(Color.BLACK);
        hero.draw(canvas);
    }

    /**
     * This is the game update method. It iterates through all the objects
     * and calls their update method if they have one or calls specific
     * engine's update method.
     */
    public void update() {
        // check collision with right wall if heading right
        if (hero.getMovement().getxDirection() == Movement.DIRECTION_RIGHT
                && hero.getX() + hero.getBitmap().getWidth() / 2 >= getWidth()) {
            hero.getMovement().toggleXDirection();
        }
        // check collision with left wall if heading left
        if (hero.getMovement().getxDirection() == Movement.DIRECTION_LEFT
                && hero.getX() - hero.getBitmap().getWidth() / 2 <= 0) {
            hero.getMovement().toggleXDirection();
        }
        // check collision with bottom wall if heading down
        if (hero.getMovement().getyDirection() == Movement.DIRECTION_DOWN
                && hero.getY() + hero.getBitmap().getHeight() / 2 >= getHeight()) {
            hero.getMovement().toggleYDirection();
        }
        // check collision with top wall if heading up
        if (hero.getMovement().getyDirection() == Movement.DIRECTION_UP
                && hero.getY() - hero.getBitmap().getHeight() / 2 <= 0) {
            hero.getMovement().toggleYDirection();
        }
        // Update the lone droid
        hero.update();
    }

}

