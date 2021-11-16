package com.interview;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TicTacToe {
    Board board;
    int currentPlayer = 0;
    boolean singlePlayer = false;
    HashMap<String, Set<Location>> moves = new HashMap<String, Set<Location>>();
    String player;

    public void init(Board board, boolean singlePlayer) {
        this.board = board;
        this.singlePlayer = singlePlayer;
        moves.put(PlayerEnum.PLAYER_ONE.name(), new HashSet<>());
        moves.put(PlayerEnum.PLAYER_TWO.name(), new HashSet<>());
    }

    public void step() {
        board.printBoard();
        System.out.println("Move for player " + (currentPlayer + 1));
        if ((currentPlayer + 1) == 1) {
            player = PlayerEnum.PLAYER_ONE.name();
        } else {
            player = PlayerEnum.PLAYER_TWO.name();
        }
        if (currentPlayer == 1 && singlePlayer) {
            System.out.println("You are playing with bot!! there can be multiple iterations");
            Location location = IntelligentMoveGenerator.nextMove();
            while (true) {
                if (ifMoveIsValidMove(location, player)) {
                    board.getGrid()[location.i][location.j] = currentPlayer;
                    break;
                } else {
                    System.out.println("Re-Move for player " + (currentPlayer + 1));
                    location = IntelligentMoveGenerator.nextMove();
                }
            }
        } else {
            Location location = new Location(readInt(), readInt());
            while (true) {
                if (ifMoveIsValidMove(location, player)) {
                    board.getGrid()[location.i][location.j] = currentPlayer;
                    break;
                } else {
                    System.out.println("Re-Move for player " + (currentPlayer + 1));
                    location = new Location(readInt(), readInt());
                }
            }
        }
        currentPlayer = currentPlayer == 0 ? 1 : 0;
    }

    private boolean ifMoveIsValidMove(Location location, String player) {
        boolean validMove = true;
        Set<Location> playerOneLocations = moves.get(PlayerEnum.PLAYER_ONE.name());
        Set<Location> playerTwoLocations = moves.get(PlayerEnum.PLAYER_TWO.name());
        if (playerOneLocations.contains(location) || playerTwoLocations.contains(location)) {
            validMove = false;
        }else{
            if(player.equals(PlayerEnum.PLAYER_ONE.name())){
                playerOneLocations.add(location);
                moves.put(PlayerEnum.PLAYER_ONE.name(), playerOneLocations);
            }else{
                playerTwoLocations.add(location);
                moves.put(PlayerEnum.PLAYER_TWO.name(), playerTwoLocations);
            }
        }
        if(!validMove){
            System.out.println("Move is not valid for the "+ player);
        }
        return validMove;
    }

    public Board getBoard() {
        return board;
    }

    private static int readInt() {
        Scanner myInput = new Scanner( System.in );
        return myInput.nextInt();
    }


    /*
     1-> One player orriding other player move
     2-> No wining considtion
     3-> refactor the classes cleaner class
pavan.kumar@cleartax.in
     */
}
