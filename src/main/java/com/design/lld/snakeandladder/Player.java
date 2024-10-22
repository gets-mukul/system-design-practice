package com.design.lld.snakeandladder;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {
    private String playerName;
    private int id;

    public Player(String playerName, int id) {
        this.id = id;
        this.playerName = playerName;
    }
}
