import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * File Name: Jeganathan_Aundre_Scalawag
 * Name: Aundre Jeganathan
 * Description: creating a treasure class that extends the location class, that has row and column and a method for moving
 */

public class Jeganathan_Aundre_Scalawag extends Jeganathan_Aundre_Location {

    /** The program that gives the user options to move and returns the chosen location to move.
     * Precondition: row>=0
     * Precondition: column>=0
     * Postcondition: Returns a number from 0-99 that references the coordinate on the 10x10 grid that the player moves to.
     * @param row - the current row of the player in the double array
     * @param column - the current column of the player in the double array
     * @param position - A number from 0-99 that references a coordinate on the 10x10 grid.
     * @param move - A number from 0-99 that references the coordinate on the 10x10 grid that the player moves to.
     * @return move - an integer value
     */

    public int moves(int row, int column){
        Scanner s =  new Scanner(System.in);

        int position = (row*10)+column;
        int move = 0;

        System.out.println("Possible moves:");
        System.out.println("");

        /**
         * These if statements check if the player is on the far left or right, far up or down side
         * or just in the centre, and prints the available moves accordingly.
         * For example, if the player is at the top left space, it can only move down, right, or
         * down-right.
         * It also accepts the required move and checks if it is valid.
         */

        if((row-1)<0 && (column-1)<0){
            System.out.printf("%3s%3d%n", "S",(position+1));
            System.out.printf("%3d%3d%n", (position+10),(position+11));
            System.out.println("");

            do{
                System.out.println("Type the space number to move, or -1 for the legend:");

                try{
                    move = s.nextInt();
                } catch (InputMismatchException e){
                    System.out.println("Invalid input.");
                }
                s.nextLine();

                if(move==-1){
                    legend();
                    move=-2;
                }
            }while(move!=position+1&& move!=position+10&& move!=position+11);

        } else if ((row+1)>9 && (column+1)>9){
            System.out.printf("%1d%3d%n", (position-11),(position-10));
            System.out.printf("%1d%3s%n", (position-1),"S");
            System.out.println("");

            do{
                System.out.println("Type the space number to move, or -1 for the legend:");

                try{
                    move = s.nextInt();
                } catch (InputMismatchException e){
                    System.out.println("Invalid input.");
                }
                s.nextLine();

                if(move==-1){
                    legend();
                    move=-2;
                }
            }while(move!=position-11&& move!=position-10&& move!=position-1);

        } else if ((row-1)<0 && (column+1)>9){
            System.out.printf("%1d%3s%n", (position-1),"S");
            System.out.printf("%1d%3d%n", (position+9),(position+10));
            System.out.println("");

            do{
                System.out.println("Type the space number to move, or -1 for the legend:");

                try{
                    move = s.nextInt();
                } catch (InputMismatchException e){
                    System.out.println("Invalid input.");
                }
                s.nextLine();

                if(move==-1){
                    legend();
                    move=-2;
                }
            }while(move!=position-1&& move!=position+9&& move!=position+10);

        } else if ((row+1)>9 && (column-1)<0) {
            System.out.printf("%3d%3d%n", (position-10),(position-9));
            System.out.printf("%3s%3d%n", "S",(position+1));
            System.out.println("");

            do{
                System.out.println("Type the space number to move, or -1 for the legend:");

                try{
                    move = s.nextInt();
                } catch (InputMismatchException e){
                    System.out.println("Invalid input.");
                }
                s.nextLine();

                if(move==-1){
                    legend();
                    move=-2;
                }
            }while(move!=position-10&& move!=position-9&& move!=position+1);

        } else if ((row-1)<0){
            System.out.printf("%1d%3s%3d%n", (position-1),"S",(position+1));
            System.out.printf("%1d%3d%3d%n", (position+9),(position+10),(position+11));
            System.out.println("");

            do{
                System.out.println("Type the space number to move, or -1 for the legend:");

                try{
                    move = s.nextInt();
                } catch (InputMismatchException e){
                    System.out.println("Invalid input.");
                }
                s.nextLine();

                if(move==-1){
                    legend();
                    move=-2;
                }
            }while(move!=position-1&& move!=position+1&& move!=position+9&& move!=position+10&& move!=position+11);

        } else if ((row+1)>9){
            System.out.printf("%1d%3d%3d%n", (position-11),(position-10),(position-9));
            System.out.printf("%1d%3s%3d%n", (position-1),"S",(position+1));
            System.out.println("");

            do{
                System.out.println("Type the space number to move, or -1 for the legend:");

                try{
                    move = s.nextInt();
                } catch (InputMismatchException e){
                    System.out.println("Invalid input.");
                }
                s.nextLine();

                if(move==-1){
                    legend();
                    move=-2;
                }
            }while(move!=position-11&& move!=position-10&& move!=position-9&& move!=position-1&& move!=position+1);

        } else if ((column-1)<0){
            System.out.printf("%3d%3d%n", (position-10),(position-9));
            System.out.printf("%3s%3d%n", "S",(position+1));
            System.out.printf("%3d%3d%n", (position+10),(position+11));
            System.out.println("");

            do{
                System.out.println("Type the space number to move, or -1 for the legend:");

                try{
                    move = s.nextInt();
                } catch (InputMismatchException e){
                    System.out.println("Invalid input.");
                }
                s.nextLine();

                if(move==-1){
                    legend();
                    move=-2;
                }
            }while(move!=position-10&& move!=position-9&& move!=position+1&& move!=position+10&& move!=position+11);

        } else if ((column+1)>9){
            System.out.printf("%1d%3d%n", (position-11),(position-10));
            System.out.printf("%1d%3s%n", (position-1),"S");
            System.out.printf("%1d%3d%n", (position+9),(position+10));
            System.out.println("");

            do{
                System.out.println("Type the space number to move, or -1 for the legend:");

                try{
                    move = s.nextInt();
                } catch (InputMismatchException e){
                    System.out.println("Invalid input.");
                }
                s.nextLine();

                if(move==-1){
                    legend();
                    move=-2;
                }
            }while(move!=position-11&& move!=position-10&& move!=position-1&& move!=position+9&& move!=position+10);

        } else{

            System.out.printf("%1d%3d%3d%n", (position-11),(position-10),(position-9));
            System.out.printf("%1d%3s%3d%n", (position-1),"S",(position+1));
            System.out.printf("%1d%3d%3d%n", (position+9),(position+10),(position+11));
            System.out.println("");


            do{
                System.out.println("Type the space number to move, or -1 for the legend:");

                try{
                    move = s.nextInt();
                } catch (InputMismatchException e){
                    System.out.println("Invalid input.");
                }
                s.nextLine();

                if(move==-1){
                    legend();
                    move=-2;
                }
            }while(move!=position-11&& move!=position-10&& move!=position-9&& move!=position-1&& move!=position+1&& move!=position+9&& move!=position+10&& move!=position+11);
        }

        return move;
    }

    /** The program that prints the legend of what all the symbols on the board mean.
     * Postcondition: the legend is printed
     */

    public static void legend (){
        System.out.println("");
        System.out.println("Here is the game legend, but if you want the actual legend, look in the mirror! :)");
        System.out.println("T - full treasure");
        System.out.println("t - empty treasure");
        System.out.println("P - pirate, YIKES!");
        System.out.println("X - escape the island");
        System.out.println("S - the scalawag … YOU!");
        System.out.println("");
    }
}
