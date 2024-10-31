package lld.tictactoe.practice.model;

import lld.tictactoe.practice.model.PlayingPiece;

public class Player {
    public String id;
    public PlayingPiece playingPiece;

    public Player(PlayingPiece pieceO) {
        playingPiece= pieceO;
    }
}
