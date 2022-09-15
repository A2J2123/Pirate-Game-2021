import java.util.Random;

/**
 * File Name: Jeganathan_Aundre_Treasure
 * Name: Aundre Jeganathan
 * Description: creating a treasure class that extends the location class, that has row and column and randomized number of gold.
 */
public class Jeganathan_Aundre_Treasure extends Jeganathan_Aundre_Location {
    Random r = new Random();

    private int ranNum=0;
    private int gold=0;
    private boolean empty = false;

    public Jeganathan_Aundre_Treasure () {

        ranNum = r.nextInt(4);

        switch (this.ranNum) {
            case 0:
                gold = 100;
                break;
            case 1:
                gold = 250;
                break;
            case 2:
                gold = 500;
                break;
            case 3:
                gold = 1000;
                break;
        }
    }

    //accessor method
    public int getGold () {
        return gold;
    }
    public boolean getEmpty () {
        return empty;
    }

    //mutator method
    public void setEmpty (boolean e) {
        empty = e;
    }
}
