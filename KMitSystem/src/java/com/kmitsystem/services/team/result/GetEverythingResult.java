
package com.kmitsystem.services.team.result;

import com.kmitsystem.tools.objects.BaseResult;
import com.kmitsystem.tools.objects.Statistics;
import com.kmitsystem.tools.objects.Tournament;
import com.kmitsystem.tools.objects.User;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Maik
 */
public class GetEverythingResult extends BaseResult {
    
    private List<User> member = new ArrayList<User>();
    private List<Tournament> tournaments = new ArrayList<Tournament>();
    private Statistics stats = new Statistics();
    
    public GetEverythingResult() {
        super();
    }    

    public GetEverythingResult(List<User> member, List<Tournament> tournaments, Statistics stats) {
        super();
        this.member = member;
        this.tournaments = tournaments;
        this.stats = stats;
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

    public Statistics getStats() {
        return stats;
    }

    public void setStats(Statistics stats) {
        this.stats = stats;
    }

    @Override
    public String toString() {
        return "GetEverythingResult{" + "member=" + member + ", tournaments=" + tournaments + ", stats=" + stats + '}';
    }
    
}
