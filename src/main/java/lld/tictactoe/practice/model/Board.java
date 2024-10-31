package lld.tictactoe.practice.model;

import lld.tictactoe.practice.model.PlayingPiece;
import lombok.Data;

@Data
public class Board {
    PlayingPiece [][]playingPieces;

    public Board(int n) {
        playingPieces= new PlayingPiece[n][n];
    }
}
