package com.design.lld.snakeandladder;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Jumper {
    int startPoint;
    int endPoint;

    public Jumper(int startPoint, int endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }
}
