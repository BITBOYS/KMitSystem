
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
    
    private Team team = new Team();
    private List<User> member = new ArrayList<User>();
    private List<Tournament> tournaments = new ArrayList<Tournament>();
    
    public GetEverythingResult() {
        super();
    }    

    public GetEverythingResult(Team team, List<User> member, List<Tournament> tournaments) {
        super();
        this.team = team;
        this.member = member;
        this.tournaments = tournaments;
    }
    
    public Team getTeam() {
        return team;
    }
    
    public void setTeam(Team team) {
        this.team = team;
    }

    public List<User> getMember() {
        return member;
    }

    public void setMember(List<User> member) {
        this.member = member;
    }

    public List<Tournament> getTournaments() {
        return tournaments;
    }

    public void setTournaments(List<Tournament> tournaments) {
        this.tournaments = tournaments;
    }

    @Override
    public String toString() {
        return "GetEverythingResult{" +"team=" + team + ", member=" + member + ", tournaments=" + tournaments + '}';
    }
    
}
