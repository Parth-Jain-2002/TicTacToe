import java.util.*;

// Creating the TIC-TAC-TOE class
public class TicTacToe{
    
    // Function to manage the player turn
    public static void playerGameTurn(Board board, int turn,Scanner sc){
        int position;
        System.out.println("Enter your desired location [1-9]:");
        if(turn==0)
           System.out.println("PLAYER X's TURN:");
        else
           System.out.println("PLAYER O's TURN:");
        
        // Taking position input from the user till it is a valid position
        position= sc.nextInt();
        if(board.validMove(position)==false){
           System.out.println("That's not a valid move");
           System.out.println("");
           playerGameTurn(board, turn,sc);
        }
        else{
        // If it is a valid position, updating that position with player symbol
        if(turn==0)
           board.update(position,'X');
        else
           board.update(position,'O');
        }
    }
    
    public static void main(String[] args){
        
        // Creating the object board
        Board board = new Board();
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Welcome to the Game Mania!!");
        boolean gameContinue=true;
        
        // The game loops continue till the player enters -1 to exit
        while(gameContinue==true){

            boolean againstComp = false;
            int computerTurn = -1;
            // Creating the object computer
            Computer computer = new Computer();
            
            // Taking input regarding if the player wants to play against computer or another player
            System.out.println("Do you want to play against computer or another player? [0 for computer | 1 for another player]");
            int against=sc.nextInt();
            while(against!=1&&against!=0){
                System.out.println("You have entered invalid number. Enter again");
                against= sc.nextInt();
            }

            // If the player chooses to play against computer, then taking the input regarding which turn to take
            if(against==0){
                againstComp=true;
                System.out.println("Which turn do you want? [0 for first | 1 for second]");
                computerTurn=sc.nextInt();
                while(computerTurn!=1&&computerTurn!=0){
                    System.out.println("You have entered invalid number. Enter again");
                    computerTurn= sc.nextInt();
                }
                computerTurn^=1;
            }

            // Game Loop
            board.initialScreen();
            System.out.println();
            int turn=0;
            // The loop continues till the game ends in a tie or win or loss
            while(board.gameOn()!=false){
                if(turn!=computerTurn || againstComp==false)
                    playerGameTurn(board,turn,sc);
                else
                    computer.computerTurn(board,turn);
                turn=turn^1;
                board.display();
            }
            // This declares the winner
            board.declareWinner(turn);
            
            // Taking the input from the user if they want to play another game or want to exit
            System.out.println("Do you want to play another game? [-1 to exit | 0 to continue] ");
            int in= sc.nextInt();
            while(in!=-1&&in!=0){
                System.out.println("You have entered invalid number. Enter again");
                in= sc.nextInt();
            }
            if(in==-1)
                gameContinue=false;
            else board.clearBoard();
        }
    }
}