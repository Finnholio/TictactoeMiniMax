import java.util.Scanner;

public class Tictactoe {
    public static void main(String args[]){
        //rules
        System.out.println("");

        int whosTurn = -1;
        int[][] game = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};

        //main game loop
        while(true){
            if(check_winner(game) == -1){
                System.out.println("Player 1 Wins!!");
                break;
            }

            if(check_winner(game) == 1){
                System.out.println("Player 2 Wins!!");
                break;
            }

            printGameState(game);

            //place new piece
            boolean no_piece_placed = true;
            while(no_piece_placed){
                int[] newPiecePosition = getInput();
                if(game[newPiecePosition[0]][newPiecePosition[1]] == 0){
                    game[newPiecePosition[0]][newPiecePosition[1]] = whosTurn;
                    no_piece_placed = false;
                }
                else {
                    System.out.println("ERROR : PIECE PLACEMENT  INVALID");
                    System.out.println("\n\n");
                }

            }

            //switch turn
            whosTurn *= -1;

            //space between lines
            System.out.println("\n\n");
        }

    }

    public static void playingWithAI(){
        //rules
        System.out.println("");

        boolean playingGame = true;
        int whosTurn = -1;
        int[][] game = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};

        //main game loop
        while(playingGame){
            if (whosTurn == -1){
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
                    if(check_winner(game) == -1){
                        System.out.println("Player 1's Turn : ");
                    }
                    else if(check_winner(game) == 1) {
                        System.out.println("Player 2's Turn : ");
                    }

                    //place new piece
                    boolean no_piece_placed = true;
                    while(no_piece_placed){
                        int[] newPiecePosition = getInput();
                        if(game[newPiecePosition[0]][newPiecePosition[1]] == 0){
                            game[newPiecePosition[0]][newPiecePosition[1]] = whosTurn;
                            no_piece_placed = false;
                        }
                        else {
                            System.out.println("ERROR : PIECE PLACEMENT  INVALID");
                            System.out.println("\n\n");
                        }

                    }

                    //switch turn
                    if (whosTurn == -1){
                        whosTurn = 1;
                    }
                    else {
                        whosTurn = -1;
                    }

                    //space between lines
                    System.out.println("\n\n");
                }
            }
        }
    }

    private static int[] getInput(){
        Scanner inputScanner = new Scanner(System.in);
        char inputText[] = inputScanner.next().toCharArray();

        int outputPosition[] = {0, 0};

        //define row
        outputPosition[0] = (inputText[1] - 49);

        //define column
        if(inputText[0] == 't'){
            outputPosition[1] = 0;
        }
        else if(inputText[0] == 'm'){
            outputPosition[1] = 1;
        }
        else if(inputText[0] == 'b'){
            outputPosition[1] = 2;
        }
        else {
            System.out.println("ERROR : CHARACTER NOT RECOGNIZED");
        }

        return outputPosition;
    }

    public static void printGameState(int[][] game){
        //make game readable
        String[][] gameRead = {{"", "", ""}, {"", "", ""}, {"", "", ""}};
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(game[i][j] == -1){
                    gameRead[i][j] = "X";
                }
                else if(game[i][j] == 1){
                    gameRead[i][j] = "O";
                }
                else {
                    if (j == 0){
                        gameRead[i][j] = "t" + (i+1);
                    }
                    else if (j == 1){
                        gameRead[i][j] = "m" + (i+1);
                    }
                    else if (j == 2){
                        gameRead[i][j] = "b" + (i+1);
                    }
                    else {
                        System.out.println("ERROR : GAME HAS GONE OUT OF BOUNDS");
                    }
                }
            }
        }

        System.out.println(gameRead[0][0] + "|" + gameRead[1][0] + "|" + gameRead[2][0]);
        System.out.println(gameRead[0][1] + "|" + gameRead[1][1] + "|" + gameRead[2][1]);
        System.out.println(gameRead[0][2] + "|" + gameRead[1][2] + "|" + gameRead[2][2]);
    }

    private static int check_winner(int[][] game){
      for (int i = 0; i < 3; i++){
        // check a row
        if (game[i][0] == game[i][1] && game[i][1] == game[i][2] && game[i][0] != 0)
          return game[i][0]

        // check a column
        if (game[0][i] == game[1][i] && game[1][i] == game[2][i] && game[0][i] != 0){
          return game[0][i];
        }
      }

      // check diagonal 1
      if (game[0][0] == game[1][1] && game[1][1] == game[2][2] && game[0][0] != 0)
        return game[0][0];

      // check diagonal 2
      if (game[0][2] == game[1][1] && game[1][1] == game[2][0] && game[0][2] != 0)
        return game[0][2];

      // no winner
      return 0;
    }
 }
