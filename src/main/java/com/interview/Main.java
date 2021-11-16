package com.interview;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    TicTacToe ticTacToe = new TicTacToe();
        init(ticTacToe);

        while(!ticTacToe.getBoard().isFinished()) {
            ticTacToe.step();
        }

        if(ticTacToe.getBoard().getWinner() > -1) {
            System.out.println("Winner is " + (ticTacToe.getBoard().getWinner() + 1));
        }
    }

    private static void init(TicTacToe ticTacToe) {
        Board board = new Board();
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                board.getGrid()[i][j] = -1;
            }
        }

        System.out.println("Single Player? ");
        if(readInt() == 0) {
            ticTacToe.init(board, false);
        } else {
            ticTacToe.init(board, true);
        }
    }

    private static int readInt() {
        Scanner myInput = new Scanner( System.in );
        return myInput.nextInt();
    }


}
