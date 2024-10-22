package com.design.lld.snakeandladder;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.Queue;

@AllArgsConstructor
public class GameBoard {

    int boardSize;
    private Dice dice;
    private Queue<Player> nextTurn;
    private List<Jumper> snakes;
    private List<Jumper> ladders;
    private Map<String, Integer> playerCurrentPosition;

    public void startGame() {
        while (nextTurn.size() > 1) {
            Player player = nextTurn.poll();
            int currentPosition = playerCurrentPosition.get(player.getPlayerName());
            int diceValue = dice.rollDice();
            int nextCell = currentPosition + diceValue;
            if (nextCell == boardSize) {
                System.out.println(player.getPlayerName() + "Won the Game !!!");
            } else {
                int[] nextPosition = new int[1];
                boolean[] b = new boolean[1];
                nextPosition[0] = nextCell;
                snakes.forEach(v -> {
                    if (v.startPoint == nextCell) {
                        nextPosition[0] = v.endPoint;
                    }
                });
                if (nextPosition[0] != nextCell) {
                    System.out.println(player.getPlayerName() + "Bitten By a SNAKE !!! " + nextCell);
                }
                ladders.forEach(v -> {
                    if (v.startPoint == nextCell) {
                        nextPosition[0] = v.endPoint;
                        b[0] = true;
                    }
                });

                if (nextPosition[0] != nextCell && b[0]) {
                    System.out.println(player.getPlayerName() + " Got The Ladder !!!");
                }
                if (nextPosition[0] != boardSize) {
                    System.out.println(player.getPlayerName() + " Won the GAME !!!");
                } else {
                    playerCurrentPosition.put(player.getPlayerName(), nextPosition[0]);
                    System.out.println(player.getPlayerName() + " is at position " + nextPosition[0]);
                    nextTurn.offer(player);
                }
            }
        }
    }

}
