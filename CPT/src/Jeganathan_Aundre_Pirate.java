import java.util.Random;

/**
 * File Name: Jeganathan_Aundre_Pirate
 * Name: Aundre Jeganathan
 * Description: creating a treasure class that extends the location class, that has row and column and a method for random moving
 */

public class Jeganathan_Aundre_Pirate extends Jeganathan_Aundre_Location {

    /** A program that randomly generates a number from 0-99 that is 1 space, in any direction, away from an object.
     * Precondition: row>=0
     * Precondition: column>=0
     * Postcondition: a randomly generated number is returned.
     * @param row - the current row of the pirate in the double array
     * @param column - the current column of the pirate in the double array
     * @param ranNum - a randomly generated number that represents any coordinate on a 10x10 grid
     * @param position - the current coordinate of the object in the 10x10 grid
     * @param move - the chosen coordinate of 10x10 grid, for the object to move to
     * @return move - a integer value
     */

    public int randomMove(int row, int column){
        Random r =  new Random();
        int ranNum = 0;
        int move = 0;
        int position = (row*10)+column;

        /**
         * This checks the position of each pirate and sees where they can move, then a random number
         * is generated for the position, if it is one space away and not off the board then it
         * returns that number for the pirate to move there
         */

        if((row-1)<0 && (column-1)<0){
            do{
                ranNum=r.nextInt(100);
            }while(ranNum!=position+1&& ranNum!=position+10&& ranNum!=position+11&& ranNum!=position);

        } else if ((row+1)>9 && (column+1)>9){
            do{
                ranNum=r.nextInt(100);
            }while(ranNum!=position-11&& ranNum!=position-10&& ranNum!=position-1&& ranNum!=position);

        } else if ((row-1)<0 && (column+1)>9){
            do{
                ranNum=r.nextInt(100);
            }while(ranNum!=position-1&& ranNum!=position+9&& ranNum!=position+10&& ranNum!=position);

        } else if ((row+1)>9 && (column-1)<0) {
            do{
                ranNum=r.nextInt(100);
            }while(ranNum!=position-10&& ranNum!=position-9&& ranNum!=position+1&& ranNum!=position);

        } else if ((row-1)<0){
            do{
                ranNum=r.nextInt(100);
            }while(ranNum!=position-1&& ranNum!=position+1&& ranNum!=position+9&& ranNum!=position+10&& ranNum!=position+11&& ranNum!=position);

        } else if ((row+1)>9){
            do{
                ranNum=r.nextInt(100);
            }while(ranNum!=position-11&& ranNum!=position-10&& ranNum!=position-9&& ranNum!=position-1&& ranNum!=position+1&& ranNum!=position);

        } else if ((column-1)<0){
            do{
                ranNum=r.nextInt(100);
            }while(ranNum!=position-10&& ranNum!=position-9&& ranNum!=position+1&& ranNum!=position+10&& ranNum!=position+11&& ranNum!=position);

        } else if ((column+1)>9){
            do{
                ranNum=r.nextInt(100);
            }while(ranNum!=position-11&& ranNum!=position-10&& ranNum!=position-1&& ranNum!=position+9&& ranNum!=position+10&& ranNum!=position);

        } else{
            do{
                ranNum=r.nextInt(100);
            }while(ranNum!=position-11&& ranNum!=position-10&& ranNum!=position-9&& ranNum!=position-1&& ranNum!=position+1&& ranNum!=position+9&& ranNum!=position+10&& ranNum!=position+11&& ranNum!=position);
        }

        move = ranNum;
        return move;
    }
}
