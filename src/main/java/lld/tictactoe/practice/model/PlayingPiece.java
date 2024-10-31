package lld.tictactoe.practice.model;

public abstract class PlayingPiece {
    PieceType pieceType;
    PlayingPiece(PieceType pieceType){
        this.pieceType=pieceType;
    }
}
