package com.staggarlee.mancala.models;

/**
 * Created by nicolas on 4/9/15.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.List;
import java.util.ArrayList;


public class CupBoard {

    // member variables
    List<Cup> mCupBoard;


    // constructor
    public CupBoard() {

        // creating the board
        mCupBoard = new ArrayList<Cup>();

        // filling in all the cups
        for(int index = 0 ; index < 14 ; index++) {
            mCupBoard.add(new Cup(index));
        }

    }

    // return the board
    public List<Cup> getBoard() {
        return mCupBoard;
    }

    // get the cup on the board
    public Cup getCup(int index) {
        return getBoard().get(index);
    }
}