package group14.cs2110.virginia.edu.cs2110annihilators;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by Cassie on 4/11/2015.
 */
public class Ghosts {

    private Bitmap bitmap;	// the actual bitmap
    private int x;			// the X coordinate
    private int y;			// the Y coordinate
    private Movement movement;	// the speed with its directions
    protected int maxHealth, currentHealth, centerX, centerY;

    public Ghosts() {}

    public Ghosts(Bitmap bitmap, int x, int y) {
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
     * Method which updates the Ghost's internal state every tick
     */
    public void update() {
        x += (movement.getXv() * movement.getxDirection());
        y += (movement.getYv() * movement.getyDirection());
    }

    public void die() {
    }

    public void attack() {
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public int getCenterX() {
        return centerX;
    }

    public int getCenterY() {
        return centerY;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public void setCenterX(int centerX) {
        this.centerX = centerX;
    }

    public void setCenterY(int centerY) {
        this.centerY = centerY;
    }

}
