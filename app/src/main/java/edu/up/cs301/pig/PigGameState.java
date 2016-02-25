package edu.up.cs301.pig;

import edu.up.cs301.game.infoMsg.GameState;

/**
 * Created by mannj17 on 2/24/2016.
 */
public class PigGameState extends GameState {
    private int playerID;
    private int player0_score;
    private int player1_score;
    private int currentDice;
    private int currentTotal;

    PigGameState(){
        playerID = 0;
        player0_score = 0;
        player1_score = 0;
        currentTotal = 0;
        currentDice = 1;
    }

    PigGameState(PigGameState tempPig){
        this.playerID = tempPig.playerID;
        this.player0_score = tempPig.player0_score;
        this.player1_score = tempPig.player1_score;
        this.currentTotal = tempPig.currentTotal;
        this.currentDice = tempPig.currentDice;
    }

    public void setCurrentDice(int currentDice) {
        this.currentDice = currentDice;
    }

    public void setPlayerID(int newPlayerID){
        this.playerID = newPlayerID;
    }

    public void setPlayer0_score(int newPlayer0_score){
        this.player0_score = newPlayer0_score;
    }

    public void setPlayer1_score(int newPlayer1_score){
        this.player1_score = newPlayer1_score;
    }

    public void setCurrentTotal(int newCurrentTotal){
        this.currentTotal = newCurrentTotal;
    }

    public int getPlayerID(){
        return this.playerID;
    }

    public int getPlayer0_score(){
        return this.player0_score;
    }

    public int getPlayer1_score(){
        return this.player1_score;
    }

    public int getCurrentTotal(){
        return this.currentTotal;
    }

    public int getCurrentDice() {
        return currentDice;
    }
}
