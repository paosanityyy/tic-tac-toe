public class Board {
    public int[] ticTacToe;
    public Player p1;
    public Player p2;

    Board(Player p1, Player p2){
        ticTacToe = new int[9];
        this.p1 = p1;
        this.p2 = p2;
        for (int i = 0; i < ticTacToe.length; i++) {
            ticTacToe[i] = 0;
        }
    }

    public void playerTurn(Player activePlayer){
        Player inactivePlayer;
        int playerNum;
        if(activePlayer == p1){
            inactivePlayer = p2;
            playerNum = 1;
        } else{ inactivePlayer = p1; playerNum = 2;}
        System.out.printf("It is %s's turn: %n", activePlayer.getName());

        int selected = activePlayer.makeMove(this);
        ticTacToe[selected] = playerNum;

        System.out.println(showBoard());
        int winner = checkWin();
        if(winner == 1){
            System.out.println("Congratulations " + p1.getName());
        } else if (winner == 2) {
            System.out.println("Congratulations " + p2.getName());
        } else if (winner == -1) {
            System.out.println("No more moves left. This is a draw");
        } else{
            playerTurn(inactivePlayer);
        }
    }

    public char[] symbolsBoard(){
        char[] symbols = new char[9];
        for(int i = 0; i < ticTacToe.length; i++){
            if(ticTacToe[i] == 0){
                symbols[i] = (char)(i+1+'0');
            } else if (ticTacToe[i] == 1) {
                symbols[i] = p1.getSymbol();
            } else if (ticTacToe[i] == 2){
                symbols[i] = p2.getSymbol();
            }
        }
        return symbols;
    }

    public int checkWin(){
        int winCon = 0;
        if(ticTacToe[0] == ticTacToe[1] && ticTacToe[0] == ticTacToe[2] && ticTacToe[0] != 0){
            winCon = 1;
        }
        else if(ticTacToe[3] == ticTacToe[4] && ticTacToe[3] == ticTacToe[5] && ticTacToe[3] != 0){
            winCon = 2;
        }
        else if(ticTacToe[6] == ticTacToe[7] && ticTacToe[6] == ticTacToe[8] && ticTacToe[6] != 0){
            winCon = 3;
        }
        else if(ticTacToe[0] == ticTacToe[3] && ticTacToe[0] == ticTacToe[6] && ticTacToe[0] != 0){
            winCon = 1;
        }
        else if(ticTacToe[1] == ticTacToe[4] && ticTacToe[1] == ticTacToe[7] && ticTacToe[1] != 0){
            winCon = 2;
        }
        else if(ticTacToe[2] == ticTacToe[5] && ticTacToe[2] == ticTacToe[8] && ticTacToe[2] != 0){
            winCon = 3;
        }
        else if(ticTacToe[0] == ticTacToe[4] && ticTacToe[0] == ticTacToe[8] && ticTacToe[0] != 0){
            winCon =2;
        }
        else if(ticTacToe[6] == ticTacToe[4] && ticTacToe[6] == ticTacToe[2] && ticTacToe[6] != 0){
            winCon = 2;
        }

        switch (winCon){
            case 1:
                return ticTacToe[0];
            case 2:
                return ticTacToe[4];
            case 3:
                return ticTacToe[8];
            default:
                for(int i = 0; i < ticTacToe.length; i++){
                    if(ticTacToe[i] == 0){
                        return 0;
                    }
                }
                return -1;
        }
    }

    public String showBoard(){
        char[] visualBoard = symbolsBoard();
        return String.format("%c | %c | %c\n--+---+--\n%c | %c | %c\n--+---+--\n%c | %c | %c",visualBoard[0],visualBoard[1],visualBoard[2],visualBoard[3],visualBoard[4],visualBoard[5],visualBoard[6],visualBoard[7],visualBoard[8]);
    }
}

