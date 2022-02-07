
The Project is written in Java using OOPS.

About the Game:
-> Basically, when you enter the game Tic-Tac-Toe, it will welcome you with a initial screen.
-> Then it will ask you to select if you want to play against computer or against another player.
-> If you select to play against the computer, it will ask which turn you want to play.
-> Then you enter in the game loop and play the game. Depending on the game state, it will tell if
the game ends in a tie, win or loss
-> At last, it will ask if you want to continue playing it or exit the game.

Instructions about the game:
->It will ask you to select if you want to play against computer or against another player.
   -> 0 for computer
   -> 1 for another player
-> Then if you select to play against the computer, it will ask you which turn to play
   -> 0 for first turn
   -> 1 for second turn
-> At last, it will ask you to continue the game or exit it
   -> 0 to continue the game
   -> -1 to exit the game
-> In the game loop, you will asked to enter a position from 1-9
   -> The game will check if it is valid position.
   -> If it is invalid, it will display and ask for input again from the user
   -> If it is valid, the game will update that position with player symbol

About the computer algorithm:
-> To find the next position for the computer, it goes through the following step
-> First, it check if there is a winning position for the computer, it return that position
-> Second, it check if there is a winning position for the opponent, we need to block that, we return that position
-> If the middle position is empty, we return that position
-> Then we check if there is no such position, we check for a position that have maximum surrounding cells having opponent symbol. If the number of block cell are more than 0, we return that position.
-> Third, if no such position is there, we return a random position.

->There are two modes of the game:-
  -> Player vs Player
  -> Player vs Computer