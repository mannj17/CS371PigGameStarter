package edu.up.cs301.pig;

import java.util.Random;

import edu.up.cs301.game.GameComputerPlayer;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameInfo;
import edu.up.cs301.game.util.Tickable;

/**
 * An AI for Pig
 *
 * @author Andrew M. Nuxoll
 * @version August 2015
 */
public class PigComputerPlayer extends GameComputerPlayer {
    private PigRollAction myRoll;
    private  PigHoldAction myHold;

    /**
     * ctor does nothing extra
     */
    public PigComputerPlayer(String name) {
        super(name);
        myRoll = new PigRollAction(this);
        myHold = new PigHoldAction(this);
    }

    /**
     * callback method--game's state has changed
     *
     * @param info
     * 		the information (presumably containing the game's state)
     */
    @Override
    protected void receiveInfo(GameInfo info) {
        // TODO  You will implement this method
        if (info instanceof PigGameState){
            info = (PigGameState) info;
            if (((PigGameState) info).getPlayerID() == this.playerNum){
                Random rand = new Random();
                if(rand.nextBoolean()){
                    this.game.sendAction(myHold);
                } else {
                    this.game.sendAction(myRoll);
                }
            }
        } else {
            return;
        }
    }//receiveInfo

}
