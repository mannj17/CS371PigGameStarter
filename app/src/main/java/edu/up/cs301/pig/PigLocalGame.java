package edu.up.cs301.pig;

import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.LocalGame;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameState;

import android.util.Log;

import java.util.Random;

/**
 * class PigLocalGame controls the play of the game
 *
 * @author Andrew M. Nuxoll, modified by Steven R. Vegdahl
 * @version February 2016
 */
public class PigLocalGame extends LocalGame {
    private PigGameState myPigGameState;

    /**
     * This ctor creates a new game state
     */
    public PigLocalGame() {
        myPigGameState = new PigGameState();
    }

    /**
     * can the player with the given id take an action right now?
     */
    @Override
    protected boolean canMove(int playerIdx) {
        return (myPigGameState.getPlayerID() == playerIdx);
    }

    /**
     * This method is called when a new action arrives from a player
     *
     * @return true if the action was taken or false if the action was invalid/illegal.
     */
    @Override
    protected boolean makeMove(GameAction action) {
        if (action instanceof PigRollAction){
            Random rand = new Random();
            int diceVal = rand.nextInt(6)+1;
            myPigGameState.setCurrentDice(diceVal);

            if(diceVal != 1){
                myPigGameState.setCurrentTotal(myPigGameState.getCurrentTotal() + myPigGameState.getCurrentDice());
            } else {
                myPigGameState.setCurrentTotal(0);

                if(myPigGameState.getPlayerID() == 0 && this.players.length != 1) {
                   myPigGameState.setPlayerID(1);
                }else if (myPigGameState.getPlayerID() == 1){
                    myPigGameState.setPlayerID(0);
                }
            }
            return true;
        } else if (action instanceof PigHoldAction)
        {
            if(myPigGameState.getPlayerID() == 0) {
                myPigGameState.setPlayer0_score(myPigGameState.getPlayer0_score() + myPigGameState.getCurrentTotal());
                if (this.players.length != 1){
                    myPigGameState.setPlayerID(1);
                }
            } else if (myPigGameState.getPlayerID() == 1){
                myPigGameState.setPlayer1_score(myPigGameState.getPlayer1_score()+myPigGameState.getCurrentTotal());
                myPigGameState.setPlayerID(0);
            }
            myPigGameState.setCurrentTotal(0);
            return true;
        }
        return false;
    }//makeMove

    /**
     * send the updated state to a given player
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        PigGameState copyState = new PigGameState(myPigGameState);
        p.sendInfo(copyState);
    }//sendUpdatedSate

    /**
     * Check if the game is over
     *
     * @return
     * 		a message that tells who has won the game, or null if the
     * 		game is not over
     */
    @Override
    protected String checkIfGameOver() {
        if (myPigGameState.getPlayer0_score() >= 50){
            return this.playerNames[0] + " Won! Thier score was " + myPigGameState.getPlayer0_score()+ ".";
        } else if (myPigGameState.getPlayer1_score() >= 50){
            return this.playerNames[1] + " Won! Thier score was " + myPigGameState.getPlayer1_score()+ ".";
        }
        return null;
    }

}// class PigLocalGame
