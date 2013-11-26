INSERT INTO user (username, password, email, goals, goals_conceded, 
					wins, defeats, tournament_wins, tournament_participations)
          VALUES ("Maik", "Passwort", "maik@kms.de", 10, 0, 1, 0, 1, 1);

INSERT INTO team (name, tag, leader, goals, goals_conceded, 
					wins, defeats, tournament_wins, tournament_participations)
          VALUES ("Team Dede", "Dede", "Maik", 10, 0, 1, 0, 1, 1);

INSERT INTO user_team (user, team, enter_dat)
		  VALUES ("Maik", "Team Dede", "2013-11-10");

INSERT INTO tournament (name, leader, start_date, end_date, 
					    nr_of_matchdays, venue, term_of_application, description)
		  VALUES ("Tournament Xa", "Maik", "2013-12-24", "2014-01-01", 4, "Kicko Geheimo", "2013-12-20", "Beschreibung Beschreibung Beschreibung Beschreibung Beschreibung Beschreibung Beschreibung Beschreibung Beschreibung Beschreibung");

INSERT INTO team_tournament (team, tournament, goals, goals_conceded, 
					wins, defeats) 
		  VALUES ("Team Dede", "Tournament Xa", 10, 0, 1, 0);
