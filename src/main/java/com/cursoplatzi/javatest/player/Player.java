package com.cursoplatzi.javatest.player;

public class Player {

    private Dice dice;
    private int minNumberWin;

    public Player(Dice dice, int minNumberWin) {
        this.dice = dice;
        this.minNumberWin = minNumberWin;
    }

    public boolean play() {
        int diceNumber = dice.roll();
        return diceNumber> minNumberWin;
    }
}
