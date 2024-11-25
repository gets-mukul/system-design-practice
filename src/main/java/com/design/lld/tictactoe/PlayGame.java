package com.design.lld.tictactoe;

public class PlayGame {
    public static void main(String[] args) {
        Player p1 = new Player();
        p1.setId(1);
        p1.setName("Player 1 ");
        p1.setPlayerSymbol('X');

        Player p2 = new Player();
        p2.setId(2);
        p2.setName("Player 2 ");
        p2.setPlayerSymbol('O');

        Player[] players = new Player[]{p1, p2};
        GameBoard gb = new GameBoard(3, players);
        gb.startGame();
    }
}
