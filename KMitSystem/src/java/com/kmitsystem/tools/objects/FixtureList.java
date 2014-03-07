
package com.kmitsystem.tools.objects;

import java.util.ArrayList;

/**
 * Object-Klasse für den Spielplan eines Turnieres
 *
 * @author Malte
 * @date 07.03.2014
 */
public class FixtureList {
    
    private ArrayList<Round> rounds;

    public FixtureList() {
        super();
    }

    public FixtureList(ArrayList<Round> rounds) {
        this.rounds = rounds;
    }

    public ArrayList<Round> getRounds() {
        return rounds;
    }

    public void setRounds(ArrayList<Round> rounds) {
        this.rounds = rounds;
    }

    @Override
    public String toString() {
        return "FixtureList{" + "rounds=" + rounds + '}';
    }
        
}
