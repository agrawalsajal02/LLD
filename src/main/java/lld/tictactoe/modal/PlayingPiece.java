package lld.tictactoe.modal;

public abstract class PlayingPiece {
    public PieceType pieceType;
    public PlayingPiece(PieceType playingPiece){
        this.pieceType=playingPiece;
    }
}
