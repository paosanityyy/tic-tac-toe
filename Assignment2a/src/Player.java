
import java.util.Scanner;
public class Player {
    protected String name;
    private char symbol;

    public Player(String name, char symbol){
        this.name = name;
        this.symbol = symbol;
    }

    public int makeMove(Board gameBoard){
        boolean goodChoice = false;
        Scanner typed = new Scanner(System.in);
        int pos = -1;
        while(!goodChoice) {
            System.out.println("Where do you want to go?: ");
            String userP = typed.nextLine();
            try {
                pos = Integer.parseInt(userP);
            } catch (Exception notInt){
                pos = -1;
            }
            if(pos <= 0 || pos > gameBoard.ticTacToe.length){
                System.out.println("Selection must be an available number on the board!");
            }
            else if(gameBoard.ticTacToe[pos - 1] == 0){
                goodChoice = true;
            } else{
                System.out.println("That position is not available!");
            }
        }

        return pos - 1;
    }

    public String getName(){
        return this.name;
    }

    public char getSymbol(){
        return this.symbol;
    }
}
