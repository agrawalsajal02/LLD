package lld.snakesandladder;

import org.springframework.security.core.parameters.P;

import java.util.Deque;

public class Game {
    Board board;
    Deque<Player>players;
    Dice dice;
    Player winner;

    public Game(){
        initialise(10,2);
    }
    public void initialise(int n, int player) {
        board = new Board(n, 5,4);

        for(int i=0;i<player;i++){
            players.add(new Player("Sajal",1));
        }

        dice= new Dice(1);
        winner=null;
    }


    public void startGame() {

      while(winner==null) {
          // get which player turn
          Player player = players.removeFirst();

          // play the game
          // roll a dice
          Integer diceValue = dice.rollDice();
          // Update the position
          if(player.currentPosition!=0 || (diceValue==6 || diceValue==1)) {
              updateNextPosition(player, diceValue);

              // check the winner
              if (player.currentPosition >= board.cells.length * board.cells.length) {
                  winner = player;
              }
          }

          players.add(player);
      }
    }

    private void updateNextPosition(Player player, Integer nextPosition) {
        int nextPlayerPosition = player.currentPosition + nextPosition;
        if(nextPlayerPosition ==board.cells.length * board.cells.length - 1){
            player.currentPosition= board.cells.length * board.cells.length;
            return;
        }

        if(nextPlayerPosition >board.cells.length * board.cells.length -1 ){
            return;
        }

        int length = board.cells.length;

        int row=nextPlayerPosition/length;
        int col=nextPlayerPosition%length;

        player.currentPosition = nextPlayerPosition;
        if (board.cells[row][col].jump!=null && board.cells[row][col].jump.start ==player.currentPosition) {
            if (board.cells[row][col].jump.start >= board.cells[row][col].jump.end) {
                //snake
                Integer snakePosition = board.cells[row][col].jump.end;
                player.currentPosition = snakePosition;
            } else {
                // ladder
                Integer ladderPosition = board.cells[row][col].jump.end;
                player.currentPosition = ladderPosition;
            }
        }

        return;
    }
}
