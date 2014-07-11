INSERT INTO user (username, password, email, goals, goals_conceded, 
					wins, defeats, tournament_wins, tournament_participations)
          VALUES ("Maik", "Passwort", "maik@kms.de", 0, 0, 0, 0, 0, 0);
          
INSERT INTO user (username, password, email, goals, goals_conceded, 
			wins, defeats, tournament_wins, tournament_participations)
	  VALUES ("Malte", "Passwort", "malte@kms.de", 0, 0, 0, 0, 0, 0);

INSERT INTO user (username, password, email, goals, goals_conceded, 
			wins, defeats, tournament_wins, tournament_participations)
	  VALUES ("Alex", "Passwort", "alex@kms.de", 0, 0, 0, 0, 0, 0);
	  
INSERT INTO user (username, password, email, goals, goals_conceded, 
			wins, defeats, tournament_wins, tournament_participations)
	  VALUES ("Louis", "Passwort", "louis@kms.de", 0, 0, 0, 0, 0, 0);	 

INSERT INTO user (username, password, email, goals, goals_conceded, 
			wins, defeats, tournament_wins, tournament_participations)
	  VALUES ("Lorenz", "Passwort", "lorenz@kms.de", 0, 0, 0, 0, 0, 0);
	  
	  
	  
	  
INSERT INTO team (name, tag, leader, goals, goals_conceded, 
					wins, defeats, tournament_wins, tournament_participations)
          VALUES ("Team Maik Malte", "TMaMa", "Maik", 0, 0, 0, 0, 0, 0);

INSERT INTO team (name, tag, leader, goals, goals_conceded, 
					wins, defeats, tournament_wins, tournament_participations)
          VALUES ("Team Maik Alex", "TMaAl", "Maik", 0, 0, 0, 0, 0, 0);

INSERT INTO team (name, tag, leader, goals, goals_conceded, 
					wins, defeats, tournament_wins, tournament_participations)
          VALUES ("Team Maik Louis", "TMaLou", "Maik", 0, 0, 0, 0, 0, 0);

INSERT INTO team (name, tag, leader, goals, goals_conceded, 
					wins, defeats, tournament_wins, tournament_participations)
          VALUES ("Team Maik Lorenz", "TMaLo", "Maik", 0, 0, 0, 0, 0, 0);
          
INSERT INTO team (name, tag, leader, goals, goals_conceded, 
					wins, defeats, tournament_wins, tournament_participations)
          VALUES ("Team Malte Alex", "TMaAl", "Malte", 0, 0, 0, 0, 0, 0);         
          
INSERT INTO team (name, tag, leader, goals, goals_conceded, 
					wins, defeats, tournament_wins, tournament_participations)
          VALUES ("Team Malte Louis", "TMaLou", "Malte", 0, 0, 0, 0, 0, 0);   
          
INSERT INTO team (name, tag, leader, goals, goals_conceded, 
					wins, defeats, tournament_wins, tournament_participations)
          VALUES ("Team Malte Lorenz", "TMaLo", "Malte", 0, 0, 0, 0, 0, 0);  
          
INSERT INTO team (name, tag, leader, goals, goals_conceded, 
					wins, defeats, tournament_wins, tournament_participations)
          VALUES ("Team Alex Louis", "TAlLou", "Alex", 0, 0, 0, 0, 0, 0);  
          
INSERT INTO team (name, tag, leader, goals, goals_conceded, 
					wins, defeats, tournament_wins, tournament_participations)
          VALUES ("Team Alex Lorenz", "TAlLo", "Alex", 0, 0, 0, 0, 0, 0);            
          
INSERT INTO team (name, tag, leader, goals, goals_conceded, 
					wins, defeats, tournament_wins, tournament_participations)
          VALUES ("Team Louis Lorenz", "TLouLo", "Louis", 0, 0, 0, 0, 0, 0);
          
          
          
          
INSERT INTO user_team (user, team, enter_dat)
		  VALUES ("Maik", "Team Maik Malte", "2014-01-01");
		  
INSERT INTO user_team (user, team, enter_dat)
		  VALUES ("Maik", "Team Maik Alex", "2014-01-01");
		  
INSERT INTO user_team (user, team, enter_dat)
		  VALUES ("Maik", "Team Maik Louis", "2014-01-01");
		  
INSERT INTO user_team (user, team, enter_dat)
		  VALUES ("Maik", "Team Maik Lorenz", "2014-01-01");

INSERT INTO user_team (user, team, enter_dat)
		  VALUES ("Malte", "Team Maik Malte", "2014-01-01");

INSERT INTO user_team (user, team, enter_dat)
		  VALUES ("Malte", "Team Malte Alex", "2014-01-01");
		  
INSERT INTO user_team (user, team, enter_dat)
		  VALUES ("Malte", "Team Malte Louis", "2014-01-01");		  
		  
INSERT INTO user_team (user, team, enter_dat)
		  VALUES ("Malte", "Team Malte Lorenz", "2014-01-01");		  
		  
INSERT INTO user_team (user, team, enter_dat)
		  VALUES ("Alex", "Team Alex Louis", "2014-01-01");
		  
INSERT INTO user_team (user, team, enter_dat)
		  VALUES ("Alex", "Team Alex Lorenz", "2014-01-01");		  
		  
INSERT INTO user_team (user, team, enter_dat)
		  VALUES ("Alex", "Team Maik Alex", "2014-01-01");		  

INSERT INTO user_team (user, team, enter_dat)
		  VALUES ("Alex", "Team Malte Alex", "2014-01-01");
		  
INSERT INTO user_team (user, team, enter_dat)
		  VALUES ("Louis", "Team Maik Louis", "2014-01-01");		  
		  
INSERT INTO user_team (user, team, enter_dat)
		  VALUES ("Louis", "Team Malte Louis", "2014-01-01");
		  
INSERT INTO user_team (user, team, enter_dat)
		  VALUES ("Louis", "Team Louis Lorenz", "2014-01-01");		  
		  
INSERT INTO user_team (user, team, enter_dat)
		  VALUES ("Louis", "Team Alex Louis", "2014-01-01");		  
		  
INSERT INTO user_team (user, team, enter_dat)
		  VALUES ("Lorenz", "Team Maik Lorenz", "2014-01-01");		  
		  
INSERT INTO user_team (user, team, enter_dat)
		  VALUES ("Lorenz", "Team Malte Lorenz", "2014-01-01");		  
		  
INSERT INTO user_team (user, team, enter_dat)
		  VALUES ("Lorenz", "Team Alex Lorenz", "2014-01-01");		  
		  
INSERT INTO user_team (user, team, enter_dat)
		  VALUES ("Lorenz", "Team Louis Lorenz", "2014-01-01");		  
		  		  
		  		  
		  		  
		  		  
		  		  
		  		  		  		  		  		  		  		  
INSERT INTO tournament (name, leader, start_date, end_date, 
					    nr_of_matchdays, venue, term_of_application, description)
		  VALUES ("GDIS - alle", "Maik", "2014-01-01", "2014-07-18", 4, "Kicko Eingango", "2014-01-01", "Jeden Mittag nach dem Essen KICKO! Und vielleicht gibts auch noch den ein oder anderen Kaffo =)");




INSERT INTO team_tournament (team, tournament, goals, goals_conceded, 
					wins, defeats) 
		  VALUES ("Team Maik Malte", "GDIS - alle", 150, 57, 15, 0);

INSERT INTO team_tournament (team, tournament, goals, goals_conceded, 
					wins, defeats) 
		  VALUES ("Team Maik Alex", "GDIS - alle", 160, 68, 16, 0);
		  
INSERT INTO team_tournament (team, tournament, goals, goals_conceded, 
					wins, defeats) 
		  VALUES ("Team Malte Alex", "GDIS - alle", 133, 107, 10, 5);		  
		  
INSERT INTO team_tournament (team, tournament, goals, goals_conceded, 
					wins, defeats) 
		  VALUES ("Team Maik Lorenz", "GDIS - alle", 119, 115, 7, 7);		  
		  
INSERT INTO team_tournament (team, tournament, goals, goals_conceded, 
					wins, defeats) 
		  VALUES ("Team Malte Louis", "GDIS - alle", 120, 138, 7, 9);		  
		  
INSERT INTO team_tournament (team, tournament, goals, goals_conceded, 
					wins, defeats) 
		  VALUES ("Team Maik Louis", "GDIS - alle", 130, 119, 6, 9);		  
		  
INSERT INTO team_tournament (team, tournament, goals, goals_conceded, 
					wins, defeats) 
		  VALUES ("Team Alex Louis", "GDIS - alle", 93, 115, 5, 8);		  
		  
INSERT INTO team_tournament (team, tournament, goals, goals_conceded, 
					wins, defeats) 
		  VALUES ("Team Malte Lorenz", "GDIS - alle", 106, 152, 5, 11);		  
		  
INSERT INTO team_tournament (team, tournament, goals, goals_conceded, 
					wins, defeats) 
		  VALUES ("Team Alex Lorenz", "GDIS - alle", 92, 140, 3, 12);		  
		  
INSERT INTO team_tournament (team, tournament, goals, goals_conceded, 
					wins, defeats) 
		  VALUES ("Team Louis Lorenz", "GDIS - alle", 52, 144, 1, 14);
		  
		  
		  
