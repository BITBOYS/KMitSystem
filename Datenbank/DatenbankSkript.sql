DROP TABLE user_team;
DROP TABLE team_tournament;
DROP TABLE game;
DROP TABLE team;
DROP TABLE tournament;
DROP TABLE user;

CREATE TABLE user (
        username char(30) NOT NULL,
        password char(32) NOT NULL,
        email char(40) UNIQUE NOT NULL,
        create_date DATE,
        goals INT,
        goals_conceded INT,
        wins INT,
        defeats INT,
		tournament_wins INT,
		tournament_participations INT,
        PRIMARY KEY (username)
);

CREATE TABLE tournament (
        name CHAR(30) NOT NULL,
        leader CHAR(30) NOT NULL,
        start_date DATETIME,
        end_date DATETIME,
        create_date DATE NOT NULL DEFAULT CURDATE(),
        password CHAR(32),
        description CHAR(255),
        nr_of_matchdays INT,
        venue CHAR(30),
        term_of_application DATETIME,
        PRIMARY KEY (name),
        FOREIGN KEY (leader) REFERENCES user(username) ON DELETE RESTRICT ON UPDATE CASCADE
);

CREATE TABLE team (
        name CHAR(30) NOT NULL,
        tag CHAR(4) NOT NULL,
        leader CHAR(30) NOT NULL,
        password CHAR(32),
        create_date DATE,
        goals INT,
        goals_conceded INT,
        wins INT,
        defeats INT,
		tournament_wins INT,
		tournament_participations INT,
        PRIMARY KEY (name),
        FOREIGN KEY (leader) REFERENCES user(username) ON DELETE RESTRICT ON UPDATE CASCADE
);

CREATE TABLE game (
        tournament CHAR(30) NOT NULL,
        game_id INT NOT NULL,
        season_id INT NOT NULL,
        team_home CHAR(30),
        team_away CHAR(30),
        goals_home TINYINT,
        goals_away TINYINT,
        PRIMARY KEY (tournament, game_id),
        FOREIGN KEY (tournament) REFERENCES tournament(name) ON DELETE CASCADE ON UPDATE CASCADE,
        FOREIGN KEY (team_home) REFERENCES team(name) ON DELETE RESTRICT ON UPDATE CASCADE,
        FOREIGN KEY (team_away) REFERENCES team(name) ON DELETE RESTRICT ON UPDATE CASCADE
);

CREATE TABLE team_tournament (
        team CHAR(30) NOT NULL,
        tournament CHAR(30) NOT NULL,
        goals INT,
        goals_conceded INT,
        wins INT,
        defeats INT,
        PRIMARY KEY (team, tournament),
        FOREIGN KEY (team) REFERENCES team(name) ON DELETE CASCADE ON UPDATE CASCADE,
        FOREIGN KEY (tournament) REFERENCES tournament(name) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE user_team (
        user CHAR(30) NOT NULL,
        team CHAR(30) NOT NULL,
        enter_dat DATE NOT NULL,
        quit_dat DATE,
        PRIMARY KEY (user, team),
        FOREIGN KEY (user) REFERENCES user(username) ON DELETE CASCADE ON UPDATE CASCADE,
        FOREIGN KEY (team) REFERENCES team(name) ON DELETE CASCADE ON UPDATE CASCADE
);
