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
public class PigSmartComputerPlayer extends GameComputerPlayer {
    private PigRollAction myRoll;
    private  PigHoldAction myHold;

    /**
     * ctor does nothing extra
     */
    public PigSmartComputerPlayer(String name) {
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
                sleep(1000);
                Random rand = new Random();
                if(((PigGameState) info).getPlayer1_score() <= 40 && ((PigGameState) info).getPlayer0_score() >= ((PigGameState) info).getPlayer1_score()){
                    for(int i=0; i<3; i++){
                        this.game.sendAction(myRoll);
                    }
                    this.game.sendAction(myHold);
                } else {
                    this.game.sendAction(myRoll);
                    this.game.sendAction(myHold);
                }
            }
        } else {
            return;
        }
    }//receiveInfo

}
