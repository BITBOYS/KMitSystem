package com.kmitsystem.services.tournament.input;

import com.kmitsystem.tools.objects.FixtureList;

/**
 *
 * @author Malte
 */
public class CreateFixtureListInput {

    private FixtureList spielplan;

    public CreateFixtureListInput() {
        super();
    }

    public CreateFixtureListInput(FixtureList spielplan) {
        this.spielplan = spielplan;
    }

    public FixtureList getSpielplan() {
        return spielplan;
    }

    public void setSpielplan(FixtureList spielplan) {
        this.spielplan = spielplan;
    }

    @Override
    public String toString() {
        return "CreateFixtureListInput{" + "spielplan=" + spielplan + '}';
    }

}
