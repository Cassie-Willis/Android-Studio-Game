package group14.cs2110.virginia.edu.cs2110annihilators;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by Cassie on 4/11/2015.
 */
public class Hero {

        private Bitmap bitmap;	// the actual bitmap
        private int x;			// the X coordinate
        private int y;			// the Y coordinate
        private boolean touched;	// if Hero is touched/picked up
        private Movement movement;	// the speed with its directions

        public Hero(Bitmap bitmap, int x, int y) {
            this.bitmap = bitmap;
            this.x = x;
            this.y = y;
            this.movement = new Movement();
        }

        public Bitmap getBitmap() {
            return bitmap;
        }
        public void setBitmap(Bitmap bitmap) {
            this.bitmap = bitmap;
        }
        public int getX() {
            return x;
        }
        public void setX(int x) {
            this.x = x;
        }
        public int getY() {
            return y;
        }
        public void setY(int y) {
            this.y = y;
        }

        public boolean isTouched() {
            return touched;
        }

        public void setTouched(boolean touched) {
            this.touched = touched;
        }

        public Movement getMovement() {
            return movement;
        }

        public void setMovement(Movement movement) {
            this.movement = movement;
        }

        public void draw(Canvas canvas) {
            canvas.drawBitmap(bitmap, x - (bitmap.getWidth() / 2), y - (bitmap.getHeight() / 2), null);
        }

        /**
         * Method which updates the Hero's internal state every tick
         */
        public void update() {
            if (!touched) {
//                x += (movement.getXv() * movement.getxDirection());
//                y += (movement.getYv() * movement.getyDirection());
            }
        }


        /**
         * Handles the {@link MotionEvent.ACTION_DOWN} event. If the event happens on the
         * bitmap surface then the touched state is set to <code>true</code> otherwise to <code>false</code>
         * @param eventX - the event's X coordinate
         * @param eventY - the event's Y coordinate
         */
        public void handleActionDown(int eventX, int eventY) {
            if (eventX >= (x - bitmap.getWidth() / 2) && (eventX <= (x + bitmap.getWidth()/2))) {
                if (eventY >= (y - bitmap.getHeight() / 2) && (y <= (y + bitmap.getHeight() / 2))) {
                    // hero touched
                    setTouched(true);
                } else {
                    setTouched(false);
                }
            } else {
                setTouched(false);
            }

        }
    }


