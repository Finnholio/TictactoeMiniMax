import java.util.*;

public class MiniMax {
    public static void main(String args[]){
        int[][] game = {{0, 0, 0}, {-1, -1, 0}, {0, 0, 0}};
        System.out.println(Arrays.toString(startMinimax(game)));
    }


    public static int[] startMinimax(int[][] game){
        //find all options
        List<int[]> options = findAllOptions(game);
        //run miniMax on all options
        List<Integer> scores = new ArrayList<>();
        int bestScore = -2;
        int[] bestOption = new int[2];

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
        List<int[]> options = findAllOptions(game);
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
            if (optionsScores.get(i) == whosTurn){
                return whosTurn;
            }
        }
        for (int i = 0; i < optionsScores.size(); i++){
            if (optionsScores.get(i) == 0){
                return 0;
            }
        }

        return whosTurn * -1;
    }

    public static List<int[]> findAllOptions(int[][] game){
        List<int[]> allOptions = new ArrayList<int[]>();
        for (int i = 0; i < game.length; i++){
            for (int j = 0; j < game[i].length; j++){
                if (game[i][j] == 0){
                    int[] option = {i, j};
                    allOptions.add(option);
                }
            }
        }
        return allOptions;
    }
}
