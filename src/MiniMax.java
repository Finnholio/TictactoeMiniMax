import java.util.*;
impoty Move;

public class MiniMax {
    public static void main(String args[]){
        int[][] game = {{0, 0, 0}, {-1, -1, 0}, {0, 0, 0}};
        System.out.println(Arrays.toString(startMinimax(game)));
    }

    public static Move startMinimax(int[][] game){
        //find all options
        List<Move> allMoves = findAllMoves(game);

        //run miniMax on all options
        List<Integer> scores = new ArrayList<>();
        int bestScore = -2;
        int[] bestMove = new int[2];


        for(move : allMoves) {
            /* newboard = changeBoard(board, move);
               score = scoreboard(newboard);
               if (score == 0 )
                  score = minimax(newboard, other_player);

               if score == win
                  return move;

               if score > bestScore {
                  bestScore = score;
                  bestMove = move;
               }
               */
        }


        for (int i = 0; i < options.size(); i++){
            int[][] tempGame = new int[3][3];
            for (int j = 0; j < game.length; j++){
                for (int k = 0; k < game[j].length; k++){
                    tempGame[j][k] = game[j][k];
                }
            }
            tempGame[options.get(i)[0]][options.get(i)[1]] = 1;
            scores.add(miniMax(tempGame, 1));
        }
        //return best option
        for (int i = 0; i < scores.size(); i++){
            if (scores.get(i) > bestScore){
                bestScore = scores.get(i);
                bestOption = options.get(i);
            }
        }
        return bestOption;
    }

    public static int miniMax(int[][] game, int whosTurn){
        //find all options
        List<Move> options = findAllOptions(game);
        List<Integer> optionsScores = new ArrayList<>();

        //check for winners
        for (int i = 0; i < options.size(); i++){
            int[][] tempGame = game;
            tempGame[options.get(i)[0]][options.get(i)[1]] = whosTurn;
            int winner = Tictactoe.check_winner(tempGame);

            if (winner != 0){
                optionsScores.add(winner);
            }

            //run miniMax on losers
            else {
                optionsScores.add(miniMax(tempGame, whosTurn * -1));
            }
        }
        //return score for option
        for (int i = 0; i < optionsScores.size(); i++){
            System.out.println(Arrays.toString(options.get(i)));
            System.out.println(optionsScores.get(i));
        }


        for (int i = 0; i < optionsScores.size(); i++){
            if (optionsScores.get(i) == whosTurn){
                System.out.println(whosTurn + "\n\n");
                return whosTurn;
            }
            else if (optionsScores.get(i) == 0){
                System.out.println(0 + "\n\n");
                return 0;
            }
        }
        System.out.println((whosTurn*-1) + "\n\n");
        return whosTurn * -1;
    }

    public static List<Move> findAllMoves(int[][] game){
        List<Move> allMoves = new ArrayList<Move>();
        for (int i = 0; i < game.length; i++){
            for (int j = 0; j < game[i].length; j++){
                if (game[i][j] == 0)
                    allOptions.add( new Move{i,j} );
            }
        }
        return allMoves;
    }
}
