// Creating the class Board
// This is the blueprint for the board
class Board{
    // Instance variable
    public char[][] board = new char[3][3];
    
    // Constructor for the board
    Board(){
        // This initializes all the position with '-'
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                board[i][j]='-';
            }
        }
    }
    
    // Method to display the first screen and the rules to the player
    public void initialScreen(){
        System.out.println("");
        System.out.println("Welcome to Tic Tac Toe. This is a new game.");
        System.out.println("Board numbers are as follows:-");
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(i*3+j+1);
                System.out.print(" | ");
            }
            System.out.println(" ");
        }
        System.out.println("");
    }
    
    // Method to display the current state of the board after any updation
    public void display(){
        System.out.println("");
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(board[i][j]);
                System.out.print(" | ");
            }
            System.out.println(" ");
        }
        System.out.println("");
    }
    
    // Method to update the position using the symbol passed in it
    public void update(int position, char symbol){
         position=position-1;
         board[position/3][position%3]=symbol;
    }
    
    // Method to check if the game is still on
    // For this, we check if there is a winner on the current board state or if all
    // the positions are filled up
    public boolean gameOn(){
        if(gameWinner()==true) return false;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[i][j]=='-'){
                    return true;
                }
            }
        }
        return false;
    }
    
    // Method to check if there is a winner based on the current board state
    public boolean gameWinner(){
        // This checks for the rows
        for(int i=0;i<3;i++){
            if(board[i][0]==board[i][1] && board[i][0]==board[i][2] && board[i][0]!='-') return true;
        }
        // This checks for the columns
        for(int i=0;i<3;i++){
            if(board[0][i]==board[1][i] && board[0][i]==board[2][i] && board[0][i]!='-') return true;
        }
        // These two conditions check for the diagonals of the board
        if(board[0][0]==board[1][1] && board[0][0]==board[2][2] && board[2][2]!='-') return true;
        if(board[0][2]==board[1][1] && board[1][1]==board[2][0] && board[0][2]!='-') return true;

        return false;
    }
    
    // Method to determine if the position is a valid move
    public boolean validMove(int position){
        // If the position is not within [1-9] range. it return false
        if(position<=0 || position>9) 
            return false;
        position=position-1;
        // Checking if the board position is empty or not
        if(board[position/3][position%3]=='-'){
           return true;
        }
        return false;
    }
    
    // Method to clean up the board after the game ends
    public void clearBoard(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                board[i][j]='-';
            }
        }
    }
    
    // Method to declare the winner based on the current game state
    public void declareWinner(int turn){
        // If there is no game winner, the game is a tie
        if(gameWinner()==false){
            System.out.println("The game ends in a tie!!");
            System.out.println("");
        }
        else{
            if(turn==0)
            System.out.println("Player O wins!!");
            else
            System.out.println("Player X wins!!");
            System.out.println("");
        }
    }
}

