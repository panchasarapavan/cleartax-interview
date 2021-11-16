package com.interview;

public class Board {
    int[][] grid = new int[3][3];
    int winner = -1;

    public int[][] getGrid() {
        return grid;
    }

    public boolean isFinished() {
        if(isGameFinished(grid)){
            printBoard();
            return true;
        }else{
            return false;
        }

    }

    private boolean isGameFinished(int[][] grid) {
        boolean isGameFinished = false;
        int countMinus = 0;
        for(int i =0; i<3; i++){
            int count0 = 0;
            int count1 =0;
            int count01 = 0;
            int count11 =0;
            for(int j =0; j< 3; j++){
                if(grid[i][j] ==0){
                    count0++;
                }
                if(grid[i][j] ==1){
                    count1++;
                }
                if(grid[j][i] ==0){
                    count01++;
                }
                if(grid[j][1] ==1){
                    count11++;
                }
                if(grid[i][j] ==-1){
                    countMinus++;
                }
            }
            if(count0 == 3 || count01 == 3){
                winner = 0;
                return true;
            }
            if(count1 == 3 || count11 == 3){
                winner = 1;
                return true;
            }
        }
        if(countMinus == 0){
            winner = -1;
            return true;
        }
        return isGameFinished;
    }

    public int getWinner() {
        return winner;
    }
    public void printBoard() {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

}
