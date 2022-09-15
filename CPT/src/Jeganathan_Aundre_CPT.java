import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * Name: Aundre Jeganathan
 * File: Jeganathan_Aundre_CPT
 * Date: June 18, 2021
 * Description: A game where the player plays as a scalawag moves around a 10 by 10 grid to find and escape with gold doubloons
 * Along the the way, there will be obstacles like pirates that move randomly and will steal half your treasure if you land in the same place
 * Another obstacle is the ambush site where your gold doubloons are completely taken away from you and ends the game.
 * 10 treasure chests, marked with T, are randomly assigned a number of gold and are scattered on the grid
 * A hidden escape site, marked with X is revealed when landed on, and the player can exit the game when they want.
 * Lastly, the player is marked with an S and can move in any direction by one space.
 */

public class Jeganathan_Aundre_CPT {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Random r = new Random();
        Jeganathan_Aundre_Scalawag S = new Jeganathan_Aundre_Scalawag();
        Jeganathan_Aundre_Location A = new Jeganathan_Aundre_Location();
        Jeganathan_Aundre_Location X = new Jeganathan_Aundre_Location();
        Jeganathan_Aundre_Pirate P[] = new Jeganathan_Aundre_Pirate[4];
        Jeganathan_Aundre_Treasure T[] = new Jeganathan_Aundre_Treasure[10];

        String secretBoard[][] = new String[10][10];
        String playerBoard[][] = new String[10][10];
        int menu = 0;
        int treasure = 0;
        int escape = 0;
        int move = 0;
        boolean ambush = false;

        System.out.println("");
        System.out.println("");
        System.out.println(" .S_sSSs     .S   .S_sSSs     .S_SSSs    sdSS_SSSSSSbs    sSSs          sSSSSs   .S_SSSs     .S_SsS_S.     sSSs  ");
        System.out.println(".SS~YS%%b   .SS  .SS~YS%%b   .SS~SSSSS   YSSS~S%SSSSSP   d%%SP         d%%%%SP  .SS~SSSSS   .SS~S*S~SS.   d%%SP  ");
        System.out.println("S%S   `S%b  S%S  S%S   `S%b  S%S   SSSS       S%S       d%S'          d%S'      S%S   SSSS  S%S `Y' S%S  d%S'    ");
        System.out.println("S%S    S%S  S%S  S%S    S%S  S%S    S%S       S%S       S%S           S%S       S%S    S%S  S%S     S%S  S%S     ");
        System.out.println("S%S    d*S  S&S  S%S    d*S  S%S SSSS%S       S&S       S&S           S&S       S%S SSSS%S  S%S     S%S  S&S     ");
        System.out.println("S&S   .S*S  S&S  S&S   .S*S  S&S  SSS%S       S&S       S&S_Ss        S&S       S&S  SSS%S  S&S     S&S  S&S_Ss  ");
        System.out.println("S&S_sdSSS   S&S  S&S_sdSSS   S&S    S&S       S&S       S&S~SP        S&S       S&S    S&S  S&S     S&S  S&S~SP ");
        System.out.println("S&S~YSSY    S&S  S&S~YSY%b   S&S    S&S       S&S       S&S           S&S sSSs  S&S    S&S  S&S     S&S  S&S    ");
        System.out.println("S*S         S*S  S*S   `S%b  S*S    S&S       S*S       S*b           S*b `S%%  S*S    S&S  S*S     S*S  S*b     ");
        System.out.println("S*S         S*S  S*S    S%S  S*S    S*S       S*S       S*S.          S*S   S%  S*S    S*S  S*S     S*S  S*S.    ");
        System.out.println("S*S         S*S  S*S    S&S  S*S    S*S       S*S        SSSbs         SS_sSSS  S*S    S*S  S*S     S*S   SSSbs  ");
        System.out.println("S*S         S*S  S*S    SSS  SSS    S*S       S*S         YSSP          Y~YSSY  SSS    S*S  SSS     S*S    YSSP  ");
        System.out.println("SP          SP   SP                 SP        SP                                       SP           SP           ");
        System.out.println("Y           Y    Y                  Y         Y                                        Y            Y            ");
        System.out.println("");
        System.out.println("");
        System.out.println("");

        while (menu != 4) {

            for(int x = 0; x<4; x++){
                P[x] = new Jeganathan_Aundre_Pirate();
            }
            for(int x = 0; x<10; x++){
                T[x] = new Jeganathan_Aundre_Treasure();
            }
            secretBoard = null;
            secretBoard = new String[10][10];
            playerBoard = null;
            playerBoard = new String[10][10];


            S.setName("Scalawag");
            A.setName("Ambush Site");
            X.setName("Escape Site");
            for(int x = 0; x<4; x++){
                P[x].setName("Pirate"+(x+1));
            }
            for(int x = 0; x<10; x++){
                T[x].setName("Treasure"+(x+1));
            }

            System.out.println("1. Play game");
            System.out.println("2. How to play");
            System.out.println("3. Legend");
            System.out.println("4. Exit");

            try{
                menu = s.nextInt();
            } catch (InputMismatchException e){
                System.out.println("Invalid input.");
            }
            s.nextLine();



            System.out.println("");

            switch (menu) {
                case 1:

                    for (int x = 0; x < 10; x++) { //Populates the board with treasure chests
                        do {
                            T[x].setRow(r.nextInt(10));
                            T[x].setColumn(r.nextInt(10));
                        } while (!isVacant(T[x].getRow(),T[x].getColumn(),secretBoard,playerBoard));
                        secretBoard[T[x].getRow()][T[x].getColumn()] = "T ";
                        playerBoard[T[x].getRow()][T[x].getColumn()] = "T ";
                    }
                    for (int x = 0; x < 4; x++) { //Populates the board with pirates
                        do {
                            P[x].setRow(r.nextInt(10));
                            P[x].setColumn(r.nextInt(10));
                        } while (!isVacant(P[x].getRow(),P[x].getColumn(),secretBoard,playerBoard));
                        playerBoard[P[x].getRow()][P[x].getColumn()] = "P ";
                    }

                    do { //Populates the board with an ambush site
                        A.setRow(r.nextInt(10));
                        A.setColumn(r.nextInt(10));
                    } while (!isVacant(A.getRow(),A.getColumn(),secretBoard,playerBoard));
                    secretBoard[A.getRow()][A.getColumn()] = "A ";

                    do { //Populates the board with an escape site
                        X.setRow(r.nextInt(10));
                        X.setColumn(r.nextInt(10));
                    } while (!isVacant(X.getRow(),X.getColumn(),secretBoard,playerBoard));
                    secretBoard[X.getRow()][X.getColumn()] = "X ";

                    do { //Populates the board with the scalawag
                        S.setRow(r.nextInt(10));
                        S.setColumn(r.nextInt(10));
                    } while (!isVacant(S.getRow(),S.getColumn(),secretBoard,playerBoard));
                    playerBoard[S.getRow()][S.getColumn()] = "S ";



                    for (int x = 0; x < secretBoard.length; x++) { //Just sets every null space in the array to a "_ " so that it prints clean grid.
                        for (int y = 0; y < secretBoard[x].length; y++) {
                            if (secretBoard[x][y] == null) {
                                secretBoard[x][y] = "_ ";
                            }
                        }
                    }

                    for (int x = 0; x < playerBoard.length; x++) {
                        for (int y = 0; y < playerBoard.length; y++) {
                            if (playerBoard[x][y] == null) {
                                playerBoard[x][y] = "_ ";
                            }
                        }
                    }

                    do{
                        printBoard(playerBoard); //prints board and amount of treasure
                        System.out.println("");
                        System.out.println("Gold Doubloons: "+treasure);
                        System.out.println("");


                        for(int x = 0; x<4; x++){ //randomly moves each pirate
                            playerBoard[P[x].getRow()][P[x].getColumn()]="_ ";
                            do{
                                move = P[x].randomMove(P[x].getRow(), P[x].getColumn());
                            }while(!isVacant((move-(move%10))/10,move%10,secretBoard,playerBoard));

                            /**
                             * This takes the integer move, which is a number from 0 to 99 that
                             * references a certain location on the double array so 0 is the
                             * top left spot on the gird while 99 is the bottom right spot,
                             * and converts it into a proper row and column for the grid
                             */
                            P[x].setColumn(move%10);
                            P[x].setRow((move-(move%10))/10);
                        }

                        playerBoard[S.getRow()][S.getColumn()]="_ "; //lets the player move
                        move = S.moves(S.getRow(), S.getColumn());
                        /**
                         * This takes the integer move, which is a number from 0 to 99 that
                         * references a certain location on the double array so 0 is the
                         * top left spot on the gird while 99 is the bottom right spot,
                         * and converts it into a proper row and column for the grid
                         */
                        S.setColumn(move%10);
                        S.setRow((move-(move%10))/10);

                        if(secretBoard[S.getRow()][S.getColumn()]=="X " || secretBoard[S.getRow()][S.getColumn()]=="x "){
                            do{
                                System.out.println("");
                                System.out.println("");
                                System.out.println(" ██████████                                                  █████ █████ █████ █████ █████ █████");
                                System.out.println("░░███░░░░░█                                                 ░░███ ░░███ ░░███ ░░███ ░░███ ░░███ ");
                                System.out.println(" ░███  █ ░   █████   ██████   ██████   ████████   ██████     ░░███ ███   ░░███ ███   ░░███ ███  ");
                                System.out.println(" ░██████    ███░░   ███░░███ ░░░░░███ ░░███░░███ ███░░███     ░░█████     ░░█████     ░░█████   ");
                                System.out.println(" ░███░░█   ░░█████ ░███ ░░░   ███████  ░███ ░███░███████       ███░███     ███░███     ███░███  ");
                                System.out.println(" ░███ ░   █ ░░░░███░███  ███ ███░░███  ░███ ░███░███░░░       ███ ░░███   ███ ░░███   ███ ░░███ ");
                                System.out.println(" ██████████ ██████ ░░██████ ░░████████ ░███████ ░░██████     █████ █████ █████ █████ █████ █████");
                                System.out.println("░░░░░░░░░░ ░░░░░░   ░░░░░░   ░░░░░░░░  ░███░░░   ░░░░░░     ░░░░░ ░░░░░ ░░░░░ ░░░░░ ░░░░░ ░░░░░ ");
                                System.out.println("                                       ░███                                                     ");
                                System.out.println("                                       █████                                                    ");
                                System.out.println("                                      ░░░░░                                                     ");
                                System.out.println("");
                                System.out.println("");
                                System.out.println("Press 1 to escape now, press 0 to continue your adventure:");
                                escape = s.nextInt();
                            }while(escape!=1 && escape!=0);

                            secretBoard[S.getRow()][S.getColumn()] = "x ";
                        }

                        if(secretBoard[S.getRow()][S.getColumn()]=="A "){
                            treasure=0;
                            System.out.println("");
                            System.out.println("");
                            System.out.println(".=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-.");
                            System.out.println("|                     ______                     |");
                            System.out.println("|                  .-\"      \"-.                  |");
                            System.out.println("|                 /            \\                 |");
                            System.out.println("|     _          |              |          _     |");
                            System.out.println("|    ( \\         |,  .-.  .-.  ,|         / )    |");
                            System.out.println("|     > \"=._     | )(__/  \\__)( |     _.=\" <     |");
                            System.out.println("|    (_/\"=._\"=._ |/     /\\     \\| _.=\"_.=\"\\_)    |");
                            System.out.println("|           \"=._\"(_     ^^     _)\"_.=\"           |");
                            System.out.println("|               \"=\\__|IIIIII|__/=\"               |");
                            System.out.println("|              _.=\"| \\IIIIII/ |\"=._              |");
                            System.out.println("|    _     _.=\"_.=\"\\          /\"=._\"=._     _    |");
                            System.out.println("|   ( \\_.=\"_.=\"     `--------`     \"=._\"=._/ )   |");
                            System.out.println("|    > _.=\"                            \"=._ <    |");
                            System.out.println("|   (_/                                    \\_)   |");
                            System.out.println("|                                                |");
                            System.out.println("'-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-='");
                            System.out.println("");
                            System.out.println("");
                            System.out.println(" .d888888  8888ba.88ba   888888ba  dP     dP .d88888b  dP     dP   88888888b 888888ba  ");
                            System.out.println("d8'    88  88  `8b  `8b  88    `8b 88     88 88.    \"' 88     88   88        88    `8b ");
                            System.out.println("88aaaaa88a 88   88   88 a88aaaa8P' 88     88 `Y88888b. 88aaaaa88a a88aaaa    88     88 ");
                            System.out.println("88     88  88   88   88  88   `8b. 88     88       `8b 88     88   88        88     88 ");
                            System.out.println("88     88  88   88   88  88    .88 Y8.   .8P d8'   .8P 88     88   88        88    .8P ");
                            System.out.println("88     88  dP   dP   dP  88888888P `Y88888P'  Y88888P  dP     dP   88888888P 8888888P  ");
                            System.out.println("");
                            System.out.println("");
                            System.out.println("You just got ambushed and all your loot was taken!!");
                            System.out.println("");
                            escape=1;
                            ambush=true;
                        }

                        for(int x = 0; x<10; x++){
                            if(S.getRow()==T[x].getRow() && S.getColumn()==T[x].getColumn() && T[x].getEmpty()==false){

                                System.out.println("");
                                System.out.println("");
                                System.out.println(" _________  ________  _______   ________  ________  ___  ___  ________  _______ ");
                                System.out.println("|\\___   ___\\\\   __  \\|\\  ___ \\ |\\   __  \\|\\   ____\\|\\  \\|\\  \\|\\   __  \\|\\  ___ \\  ");
                                System.out.println("\\|___ \\  \\_\\ \\  \\|\\  \\ \\   __/|\\ \\  \\|\\  \\ \\  \\___|\\ \\  \\\\\\  \\ \\  \\|\\  \\ \\   __/| ");
                                System.out.println("     \\ \\  \\ \\ \\   _  _\\ \\  \\_|/_\\ \\   __  \\ \\_____  \\ \\  \\\\\\  \\ \\   _  _\\ \\  \\_|/__  ");
                                System.out.println("      \\ \\  \\ \\ \\  \\\\  \\\\ \\  \\_|\\ \\ \\  \\ \\  \\|____|\\  \\ \\  \\\\\\  \\ \\  \\\\  \\\\ \\  \\_|\\ \\ ");
                                System.out.println("       \\ \\__\\ \\ \\__\\\\ _\\\\ \\_______\\ \\__\\ \\__\\____\\_\\  \\ \\_______\\ \\__\\\\ _\\\\ \\_______\\");
                                System.out.println("        \\|__|  \\|__|\\|__|\\|_______|\\|__|\\|__|\\_________\\|_______|\\|__|\\|__|\\|_______|");
                                System.out.println("                                            \\|_________|                             ");
                                System.out.println("");
                                System.out.println("*******************************************************************************");
                                System.out.println("          |                   |                  |                     |");
                                System.out.println(" _________|________________.=\"\"_;=.______________|_____________________|_______");
                                System.out.println("|                   |  ,-\"_,=\"\"     `\"=.|                  |");
                                System.out.println("|___________________|__\"=._o`\"-._        `\"=.______________|___________________");
                                System.out.println("          |                `\"=._o`\"=._      _`\"=._                     |");
                                System.out.println(" _________|_____________________:=._o \"=._.\"_.-=\"'\"=.__________________|_______");
                                System.out.println("|                   |    __.--\" , ; `\"=._o.\" ,-\"\"\"-._ \".   |");
                                System.out.println("|___________________|_._\"  ,. .` ` `` ,  `\"-._\"-._   \". '__|___________________");
                                System.out.println("          |           |o`\"=._` , \"` `; .\". ,  \"-._\"-._; ;              |");
                                System.out.println(" _________|___________| ;`-.o`\"=._; .\" ` '`.\"\\` . \"-._ /_______________|_______");
                                System.out.println("|                   | |o;    `\"-.o`\"=._``  '` \" ,__.--o;   |");
                                System.out.println("|___________________|_| ;     (#) `-.o `\"=.`_.--\"_o.-; ;___|___________________");
                                System.out.println("____/______/______/___|o;._    \"      `\".o|o_.--\"    ;o;____/______/______/____");
                                System.out.println("/______/______/______/_\"=._o--._        ; | ;        ; ;/______/______/______/_");
                                System.out.println("____/______/______/______/__\"=._o--._   ;o|o;     _._;o;____/______/______/____");
                                System.out.println("/______/______/______/______/____\"=._o._; | ;_.--\"o.--\"_/______/______/______/_");
                                System.out.println("____/______/______/______/______/_____\"=.o|o_.--\"\"___/______/______/______/____");
                                System.out.println("/______/______/______/______/______/______/______/______/______/______/________");
                                System.out.println("*******************************************************************************");

                                treasure+=T[x].getGold();
                                System.out.println("You found a chest and gained "+T[x].getGold()+" gold!");
                                secretBoard[S.getRow()][S.getColumn()]="t ";
                                T[x].setEmpty(true);
                            }
                        }

                        for(int x = 0; x<4; x++){
                            if(S.getRow()==P[x].getRow() && S.getColumn()==P[x].getColumn()){

                                System.out.println("");
                                System.out.println("");
                                System.out.println("         _,-._");
                                System.out.println("        ; ___ :           ,------------------------------. a");
                                System.out.println("    ,--' (. .) '--.__    |  Argh, I am mean pirate and I  |");
                                System.out.println("  _;      |||        \\   |     want to steal half of      |");
                                System.out.println(" '._,-----''';=.____,\"   |        your GOLD!! Also        |");
                                System.out.println("   /// < o>   |##|       |  I am lonely and misunderstood |");
                                System.out.println("   (o        \\`--'       //`-----------------------------'");
                                System.out.println("  ///\\ >>>>  _\\ <<<<    //");
                                System.out.println(" --._>>>>>>>><<<<<<<<  / ");
                                System.out.println(" ___() >>>[||||]<<<<");
                                System.out.println(" `--'>>>>>>>><<<<<<<");
                                System.out.println("      >>>>>>><<<<<<");
                                System.out.println("        >>>>><<<<<");
                                System.out.println("         >>ctr<<");
                                System.out.println("");
                                System.out.println("");

                                System.out.println("You got caught by a Pirate lost half of your gold!!");
                                treasure/=2;

                                playerBoard[P[x].getRow()][P[x].getColumn()]="_ ";
                                do {
                                    P[x].setRow(r.nextInt(10));
                                    P[x].setColumn(r.nextInt(10));
                                } while (!isVacant(P[x].getRow(),P[x].getColumn(),secretBoard,playerBoard));
                                playerBoard[P[x].getRow()][P[x].getColumn()] = "P ";
                            }
                        }

                        for(int x = 0; x<4; x++){
                            playerBoard[P[x].getRow()][P[x].getColumn()]="P ";
                        }
                        playerBoard[S.getRow()][S.getColumn()]="S ";


                        for(int x = 0; x<10; x++){
                            for(int y = 0; y<10; y++){
                                if(secretBoard[x][y]=="t "&& playerBoard[x][y]!="S "){
                                    playerBoard[x][y]="t ";
                                }
                                if (secretBoard[x][y]=="x "&& playerBoard[x][y]!="S "){
                                    playerBoard[x][y]="X ";
                                }
                            }
                        }

                    } while(escape==0);

                    if(!ambush){
                        if(treasure==0){
                            System.out.println("WHY WOULD YOU LEAVE THE ISLAND WITH NO PROFIT!!!");
                        } else if (treasure>0){
                            System.out.println("Congratulations! You escape the island with "+treasure+" gold doubloons.");
                        }
                    } else{
                        System.out.println("Looks like you got ambushed and kicked off the island with no gold!");
                    }
                    System.out.println("");

                    break;

                case 2: //How to play
                    System.out.println("Welcome to the pirate game!!");
                    System.out.println("You are a scalawag pirate, marked with an S, who is trying to escape this island, while collecting as much treasure as you can.");
                    System.out.println("You can move by typing the space number out of the given options.");
                    System.out.println("There are also enemy pirates, marked with P, who are constantly trying to attack you and steal half of your loot.");
                    System.out.println("There is randomly placed treasure that you can collect with 100, 250, 500 or 1000 gold doubloons.");
                    System.out.println("There is a secret escape spot where you escape with your current amount of loot, or come back later with more.");
                    System.out.println("Lastly, beware of an ambush sight where all your enemies are trying to attack you and end the game.");
                    System.out.println("HAVE FUN!!!");
                    System.out.println("");
                    break;

                case 3: //prints legend
                    S.legend();
                    break;
                case 4:
                    System.out.println("Good bye!");
                    break;
            }


        }

    }

    /** A program that prints the double array, that is put into the method, as a grid.
     * Precondition: board cannot be null
     * Postcondition: The double array is printed in the form of a grid.
     * @param board - the double array that is inputted into the method
     */

    public static void printBoard (String board[][]){
        for (int x = 0; x < board.length; x++) {
            if (x == 0)
                System.out.print("[00-09]  ");
            else
                System.out.print("[" + (x * 10) + "-" + (x * 10 + 9) + "]  ");
            for (int y = 0; y < board.length; y++) {
                System.out.print(board[x][y]);
            }
            System.out.println("");
        }
    }

    /** A program that checks whether a coordinate on the two double arrays, are occupied by any important element.
     * Precondition: row>=0
     * Precondition: column>=0
     * Precondition: secretBoard cannot be null
     * Precondition: playerBoard cannot be null
     * Postcondition: A true boolean if the location in both arrays are not occupied by an important element, and false otherwise.
     * @param row - the row of a chosen coordinate in the double array
     * @param column - the column of a chosen coordinate in the double array
     * @param secretBoard - a 10x10 double array that contains elements hidden from the player
     * @param playerBoard - a 10x10 double array that can be observed by the player
     * @return result - a boolean value
     */

    public static boolean isVacant(int row, int column, String [][] secretBoard, String [][] playerBoard){
        if(playerBoard[row][column] == "T " || playerBoard[row][column] == "t " || playerBoard[row][column] == "P " || secretBoard[row][column] == "A " || secretBoard[row][column] == "X " || secretBoard[row][column] == "x "){
            return false;
        } else{
            return true;
        }
    }
}

