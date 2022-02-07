import java.util.*;

// Creating the class Computer
// This is the blueprint for the Computer
public class Computer{

    // Instance variables
    private char symbol;
    private char enemySymbol;
    
    // Method to set the symbol and the enemy symbol based on the turn
    private void setSymbol(int turn){
        if(turn==0){
        this.symbol='X';
        this.enemySymbol='O';
        }
        else{
        this.symbol='O';
        this.enemySymbol='X';
        }
    }
    
    // Method to calculate the no of blocking-Cell and return it
    // Blocking cell is the no of cells having enemy symbol around the target cell
    private int blockingCell(Board board,int position){
        position--;
        int blockCell=0;
        int i=position/3;
        int j=position%3;

        // Checking the cells around the target cell
        if(i>0)
           if(board.board[i-1][j]==this.enemySymbol) blockCell++;
        if(i<2)
           if(board.board[i+1][j]==this.enemySymbol) blockCell++;
        if(j>0)
           if(board.board[i][j-1]==this.enemySymbol) blockCell++;
        if(j<2)
           if(board.board[i][j+1]==this.enemySymbol) blockCell++;
        
        return blockCell;
    }
    
    // Method to determine if there is a winning situation for the computer by placing its symbol
    private int winningTurn(Board board){
        Board clone = board;
        int position=0;

        // Checking if for any position, there is a chance to win for computer an returning that
        for(int i=1;i<=9;i++){
            if(clone.validMove(i)==true){
                clone.update(i,this.symbol);
                // If by updating a certain position, the computer can win the game, we return that position
                if(clone.gameWinner()==true)   
                    return i;
                else{
                    // else we reverse that position to its orginial state
                    clone.update(i,'-');
                }
            }
        }
        return position;
    }
    
    // Method to determine if there is a winning situation for the opponent and blocking it
    private int blockingTurn(Board board){
        Board clone = board;
        int position=0;

        // Checking if for any position, there is a chance to win for opponent an returning that
        for(int i=1;i<=9;i++){
            if(clone.validMove(i)==true){
                clone.update(i,this.enemySymbol);
                // If by updating a certain position, the opponent can win the game, we return that position
                if(clone.gameWinner()==true)
                    return i;
                else{
                    // else we reverse that position to its orginial state
                    clone.update(i,'-');
                }
            }
        }
        if(position!=0) return position;
        
        // If the middle position is empty, we fill that
        if(clone.validMove(5)==true) return 5;
        
        // If there is still no position, we block a cell that has maximum no of neighbouring cells having enemy symbol
        int blockCell=0;
        for(int i=1;i<=9;i++){
            if(clone.validMove(i)==true){
                if(blockingCell(clone,i)>blockCell){
                    position=i;
                    blockCell=blockingCell(clone,i);
                }
            }
        }
        return position;
    }
    
    // Method to calculate the random position
    private int randomTurn(Board board){
        Random rand= new Random();
        int position=rand.nextInt(9)+1;
        // This loop will give the valid random position
        while(board.validMove(position)!=true){
            position=rand.nextInt(9)+1;
        }
        return position;
    }
    
    // Method to decide the accurate position for the computer
    private int decider(Board board){
        // For deciding position:
        // First check if there is a winning position for the computer
        int position=winningTurn(board);

        // Second check if there is a winning position for the enemy player and block that
        if(position==0)
        position = blockingTurn(board);

        // If there is no position for above two conditions, then a random position
        if(position==0)
        position = randomTurn(board);

        return position;
    }
    
    // Method to decide the computer turn
    public void computerTurn(Board board,int turn){
        // This sets the symbol for the computer and the opponent
        setSymbol(turn);

        // This selects the valid position for the board
        int position = decider(board);

        // This displays the position selected by the computer and update it in the board
        System.out.println("Computer chooses the position "+position);
        System.out.println("");
        board.update(position,symbol);
    }
}


