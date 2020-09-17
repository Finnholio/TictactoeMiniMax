import java.util.Scanner;

public class Tictactoe {
    public static void main(String args[]){
        //rules
        System.out.println("How to play tic tac toe in this program : X's are represented by -1 and O's are represented by 1.\nX's go first and to input which square you want to place your piece on you first input your row then your column.");

        Scanner myObj = new Scanner(System.in);
        boolean playingGame = true;
        int whosTurn = -1;
        int[][] game = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};

        //main game loop
        while(playingGame){
            if(check_winner(game) == -1){
                System.out.println("Player 1 Wins!!");
                playingGame = false;
            }
            else if(check_winner(game) == 1){
                System.out.println("Player 2 Wins!!");
                playingGame = false;
            }
            else {
                printGameState(game);

                //get input
                System.out.println("Row : ");
                String row = myObj.next();
                System.out.println("Column : ");
                String column = myObj.next();

                int row_int = Integer.parseInt(row);
                int column_int = Integer.parseInt(column);

                game[row_int][column_int] = whosTurn;

                if (whosTurn == -1){
                    whosTurn = 1;
                }
                else {
                    whosTurn = -1;
                }
            }
        }

    }

    public static void printGameState(int[][] game){
        System.out.println(game[0][0] + "|" + game[1][0] + "|" + game[2][0]);
        System.out.println(game[0][1] + "|" + game[1][1] + "|" + game[1][2]);
        System.out.println(game[2][0] + "|" + game[2][1] + "|" + game[2][2]);
    }

    public static int check_winner(int[][] game){
        //diagonal player 1 wins
        if(game[0][0] == -1 && game[1][1] == -1 && game[2][2] == -1){
            return -1;
        }
        else if(game[0][2] == -1 && game[1][1] == -1 && game[2][0] == -1){
            return -1;
        }

        //horizontal player 1 wins
        else if(game[0][0] == -1 && game[1][0] == -1 && game[2][0] == -1){
            return -1;
        }
        else if(game[0][1] == -1 && game[1][1] == -1 && game[2][1] == -1){
            return -1;
        }
        else if(game[0][2] == -1 && game[1][2] == -1 && game[2][2] == -1){
            return -1;
        }

        //verticle player 1 wins
        else if(game[0][0] == -1 && game[0][1] == -1 && game[0][2] == -1){
            return -1;
        }
        else if(game[1][0] == -1 && game[1][1] == -1 && game[1][2] == -1){
            return -1;
        }
        else if(game[2][0] == -1 && game[2][1] == -1 && game[2][2] == -1){
            return -1;
        }

        //diagonal player 2 wins
        if(game[0][0] == 1 && game[1][1] == 1 && game[2][2] == 1){
            return 1;
        }
        else if(game[0][2] == 1 && game[1][1] == 1 && game[2][0] == 1){
            return 1;
        }

        //horizontal player 2 wins
        else if(game[0][0] == 1 && game[1][0] == 1 && game[2][0] == 1){
            return 1;
        }
        else if(game[0][1] == 1 && game[1][1] == 1 && game[2][1] == 1){
            return 1;
        }
        else if(game[0][2] == 1 && game[1][2] == 1 && game[2][2] == 1){
            return 1;
        }

        //verticle player 2 wins
        else if(game[0][0] == 1 && game[0][1] == 1 && game[0][2] == 1){
            return -1;
        }
        else if(game[1][0] == 1 && game[1][1] == 1 && game[1][2] == 1){
            return -1;
        }
        else if(game[2][0] == 1 && game[2][1] == 1 && game[2][2] == 1){
            return -1;
        }
        else{
            return 0;
        }
    }
}
