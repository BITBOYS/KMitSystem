
package com.kmitsystem.services.tournament.input;

/**
 *
 * @author Malte
 */
public class DeleteTournamentInput {
    
    String tournamentToDelete;

    public DeleteTournamentInput() {
        super();
    }

    public DeleteTournamentInput(String tournamentToDelete) {
        this.tournamentToDelete = tournamentToDelete;
    }

    public String getTournamentToDelete() {
        return tournamentToDelete;
    }

    public void setTournamentToDelete(String tournamentToDelete) {
        this.tournamentToDelete = tournamentToDelete;
    }

    @Override
    public String toString() {
        return "DeleteTournamentInput{" + "tournamentToDelete=" + tournamentToDelete + '}';
    }
        
    
}
