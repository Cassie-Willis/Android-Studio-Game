package group14.cs2110.virginia.edu.cs2110annihilators;

import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by Cassie on 4/11/2015.
 */
public class DrawGhosts extends Ghosts{
    final Random rnd = new Random();
    ArrayList baddies = new ArrayList();

    private void populateList() {
        baddies.add(R.drawable.red_ghost);
        baddies.add(R.drawable.orange_ghost);
        baddies.add(R.drawable.yellow_ghost);
        baddies.add(R.drawable.green_ghost);
    }

    public void addNewImageToScreen() {
        Random rand = new Random();
        int i = rand.nextInt(baddies.size());
        baddies.get(i);
    }

   public DrawGhosts(int centerX, int centerY) {
       setCenterX(centerX);
       setCenterY(centerY);
   }






}
