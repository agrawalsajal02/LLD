package lld.tictactoe.modal;

public abstract class PlayingPiece {
    public PieceType pieceType;
    PlayingPiece(PieceType playingPiece){
        this.pieceType=playingPiece;
    }
}
