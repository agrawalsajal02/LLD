package lld.snakesandladder;

import java.util.concurrent.ThreadLocalRandom;

public class Board {
    Cell[][] cells;


    Board(int boardSize, int numberOfSnakes, int numberOfLadders) {
        initializeCells(boardSize);
        addSnakesLadders(cells, numberOfSnakes, numberOfLadders);
    }

    private void initializeCells(int boardSize) {
        cells = new Cell[boardSize][boardSize];

        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                Cell cellObj = new Cell();
                cells[i][j] = cellObj;
            }
        }

    }


    private void addSnakesLadders(Cell[][] cells, int numberOfSnakes, int numberOfLadders) {

        Integer length = cells.length;
        while (numberOfSnakes > 0) {
            int start = ThreadLocalRandom.current().nextInt(length*length-1);
            int end = ThreadLocalRandom.current().nextInt(length*length- 1);
            if (start <= end) {
                continue;
            }

            Cell startJump = getCell(start);
            Jump jump = new Jump(start,end);
            startJump.jump = jump;
            numberOfSnakes--;
        }

        while (numberOfLadders > 0) {
            int start = ThreadLocalRandom.current().nextInt(length*length-1);
            int end = ThreadLocalRandom.current().nextInt(length*length- 1);
            if (start >= end) {
                continue;
            }

            Cell startJump = getCell(start);
            Jump jump = new Jump(start,end);
            startJump.jump = jump;
            numberOfLadders--;
        }

    }

    public Cell getCell(int position) {
        int length = cells.length;
        return cells[position / length][position % length];
    }


}
