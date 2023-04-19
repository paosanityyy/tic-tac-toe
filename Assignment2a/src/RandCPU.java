import java.util.Random;

public class RandCPU extends Player {

    public RandCPU(String name, char symbol) {
        super(name, symbol);
    }

    @Override
    public int makeMove(Board gameBoard) {
        boolean goodChoice = false;
        System.out.println(this.name + " is selecting... ");
        int pos = -1;
        while (!goodChoice) {
            pos = new Random().nextInt(gameBoard.ticTacToe.length);
            if (gameBoard.ticTacToe[pos] == 0) {
                goodChoice = true;
            }
        }
        return pos;
    }
}
