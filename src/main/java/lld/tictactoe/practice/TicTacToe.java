package lld.tictactoe.practice;

import lld.tictactoe.practice.model.*;

import java.util.Deque;
import java.util.concurrent.ThreadLocalRandom;

public class TicTacToe {
    Deque<Player>players;
    Board board;
    Player winner = null;

    public TicTacToe(){
        PieceO pieceO= new PieceO();
        players.add(new Player(pieceO));

        PieceX pieceX= new PieceX();
        players.add(new Player(pieceX));

        int n=3;
        board=new Board(3);
    }
    public void startGame() {

        while(winner==null){
            // get the player
            Player player = players.removeFirst();
            players.addLast(player);

            PlayingPiece playingPiece = player.playingPiece;
            getRandomNonSelectedLocation(board,playingPiece,board.getPlayingPieces().length);

            // check if the user is winning
            Boolean isWinning = checkIfWinning(board, playingPiece);
            if(isWinning){
                winner=player;
            }

        }
    }

    private Boolean checkIfWinning(Board board, PlayingPiece playingPiece) {
        for(int i=0;i<3;i++){
            Boolean colIsFine= true;
            for(int j=0;j<3;j++){
                if(board.getPlayingPieces()[i][j]!=playingPiece){
                    colIsFine= false;
                }
            }
            if(colIsFine)return true;
        }

        for(int i=0;i<3;i++){
            Boolean colIsFine= true;
            for(int j=0;j<3;j++){
                if(board.getPlayingPieces()[j][i]!=playingPiece){
                    colIsFine= false;
                }
            }
            if(colIsFine)return true;
        }

        // diagonal
        Boolean diagonalIsFine= true;
        Boolean crossIsFine = true;
        for(int i=0;i<3;i++){
            if(board.getPlayingPieces()[i][i]!=playingPiece){
                diagonalIsFine= false;
            }

            if(board.getPlayingPieces()[i][3-i-1]!=playingPiece){
                crossIsFine= false;
            }

        }
        return crossIsFine || diagonalIsFine;

    }

    private void getRandomNonSelectedLocation(Board board, PlayingPiece playingPiece, int length) {
        while(true) {
            int position = ThreadLocalRandom.current().nextInt(length * length - 1);
            int row = position / length;
            int col = position % length;
            if (board.getPlayingPieces()[row][col] == null) {
                board.getPlayingPieces()[row][col] = playingPiece;
                break;
            }
        }
    }
}
