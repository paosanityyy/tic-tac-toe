public class MinMaxCPU extends Player{
    public MinMaxCPU(String name, char symbol) {
        super(name, symbol);
    }

    @Override
    public int makeMove(Board gameBoard){
        System.out.println(this.name + " is selecting... ");
        int ai;
        if(gameBoard.p1 == this){
            ai = 1;
        } else{ai = 2;}
        int bestScore = -9999;
        int bestMove = 0;
        for(int i = 0; i < gameBoard.ticTacToe.length; i++){
            if(gameBoard.ticTacToe[i] == 0){
                gameBoard.ticTacToe[i] = ai;
                int score = minMax(gameBoard, 0, false, ai);
                gameBoard.ticTacToe[i] = 0;
                if (score > bestScore){
                    bestScore = score;
                    bestMove = i;
                }
            }
        }
        return bestMove;
    }

    public int minMax(Board gameBoard, int depth, boolean maximizing, int pNum){
        int oNum;
        if(pNum == 1){
            oNum = 2;
        } else{oNum = 1;}

        int result = gameBoard.checkWin();
        if(result != 0){
            if (result == pNum){
                return 10 - depth;
            }
            if (result == -1){
                return 0;
            }
            return -10 + depth;
        }
        if(maximizing){
            int bestScore = -9999;
            for(int i = 0; i < gameBoard.ticTacToe.length; i++){
                if(gameBoard.ticTacToe[i] == 0){
                    gameBoard.ticTacToe[i] = pNum;
                    int score = minMax(gameBoard, depth++, false, pNum);
                    gameBoard.ticTacToe[i] = 0;
                    if(score > bestScore){
                        bestScore = score;
                    }
                }
            }
            return bestScore;
        }

        if(!maximizing){
            int bestScore = 9999;
            for(int i = 0; i < gameBoard.ticTacToe.length; i++){
                if(gameBoard.ticTacToe[i] == 0){
                    gameBoard.ticTacToe[i] = oNum;
                    int score = minMax(gameBoard, depth++, true, pNum);
                    gameBoard.ticTacToe[i] = 0;
                    if(score < bestScore){
                        bestScore = score;
                    }
                }
            }
            return bestScore;
        }
        return 0;
    }
}

