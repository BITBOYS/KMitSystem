
package com.kmitsystem.tools.interfaces;

import com.kmitsystem.tools.objects.Match;
import com.kmitsystem.tools.objects.Round;
import com.kmitsystem.tools.objects.Team;

/**
 *
 * @author Malte
 */
public interface FixtureListInterface {
    
    /**
     * Erstellen der Matches
     *
     * @param team1  erstes Team
     * @param team2  zweites Team
     */
    public void createMatch(Team team1, Team team2);
    
    
    /**
     * Erstellen der Matches
     *
     * @param match Match mit Liste alles Spiele 
     */
    public void createRound(Match match);
    
    
    /**
     * Erstellen der Matches
     *
     * @param round Runde mit Liste aller Runden
     */
    public void createFixtureList(Round round);
}
