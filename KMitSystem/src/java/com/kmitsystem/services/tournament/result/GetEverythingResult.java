
package com.kmitsystem.services.tournament.result;

import com.kmitsystem.tools.objects.BaseResult;
import com.kmitsystem.tools.objects.Team;
import com.kmitsystem.tools.objects.Tournament;
import com.kmitsystem.tools.objects.User;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Malte
 */
public class GetEverythingResult extends BaseResult {
    
    private Tournament tournament = new Tournament();
    private List<Team> teams = new ArrayList<Team>();
    private List<User> member = new ArrayList<User>();
    
    public GetEverythingResult() {
        super();
    }    

    public GetEverythingResult(Tournament tournament, List<Team> teams, List<User> member) {
        this.tournament = tournament;
        this.teams = teams;
        this.member = member;       
    }
    
    public Tournament getTournament() {
        return tournament;
    }
    
    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }
    
    public List<User> getMember() {
        return member;
    }

    public void setMember(List<User> member) {
        this.member = member;
    }

    @Override
    public String toString() {
        return "GetEverythingResult{" + "tournament=" + tournament + ", teams=" + teams + ", member=" + member + '}';
    }

}
