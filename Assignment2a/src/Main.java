import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("*--------------------------------*");
        System.out.println("| WELCOME TO OUR TIC-TAC-TOE JAVA |");
        System.out.println("*--------------------------------*");
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        char symbol;
        int whoMakesFirstMove = 0;
        do{
            System.out.print("Choose your symbol (X or O): ");
            symbol = Character.toUpperCase(sc.next().charAt(0));
            if (symbol != 'X' && symbol != 'O'){
                System.out.println("You must input either X or O.");
            }
            sc.nextLine();
        } while (symbol != 'X' && symbol != 'O');
        char oppSymbol;
        if(symbol == 'X'){
            oppSymbol = 'O';
        } else{
            oppSymbol = 'X';
        }

        do{
            System.out.print("Choose who will go first, Press 1 for " + name +" to go first or 2 for Opponent:");
            try {
                whoMakesFirstMove = sc.nextInt();
            } catch (NumberFormatException e) {
                System.out.println("Error! Input must be an integer.");
            }
        } while (whoMakesFirstMove != 1 && whoMakesFirstMove != 2);

        boolean activeGame = true;
        while(activeGame) {
            System.out.println("Please select an option from the menu\n1.Two Player\n2.Random Computer\n3.Smart CPU\n4.Exit");
            int userChoice = sc.nextInt();
            Board game = null;
            if (userChoice == 1) {
                game = new Board(new Player(name, symbol), new Player("Player Two", oppSymbol));
            } else if (userChoice == 2) {
                game = new Board(new Player(name, symbol), new RandCPU("CPU", oppSymbol));
            } else if (userChoice == 3) {
                game = new Board(new Player(name, symbol), new MinMaxCPU("DeepBlue", oppSymbol));
            } else if (userChoice == 4){
                System.out.println("Goodbye!");
                exit(0);
            }
            System.out.println(game.showBoard());

            if (whoMakesFirstMove == 1){
                game.playerTurn(game.p1);
            } else {
                game.playerTurn(game.p2);
            }
            System.out.println("The game is completed!");
        }
    }
}