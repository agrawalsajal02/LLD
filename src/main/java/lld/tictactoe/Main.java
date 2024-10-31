package lld.tictactoe;

public class Main {
    public static void main(String[] args) {
        LLDTicTacToe.TicTacToeGame game=new LLDTicTacToe.TicTacToeGame();
        System.out.println("Game winner is : "+game.startGame());
    }
}
