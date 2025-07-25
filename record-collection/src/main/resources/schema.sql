DROP TABLE IF EXISTS genre;
DROP TABLE IF EXISTS album;
DROP TABLE IF EXISTS artist;
DROP TABLE IF EXISTS artist_album;

CREATE TABLE genre (
    genre_id int NOT NULL AUTO_INCREMENT,
    name varchar(60) NOT NULL,
    PRIMARY KEY (genre_id)
);

CREATE TABLE album (
    album_id int NOT NULL AUTO_INCREMENT,
    title varchar(256) NOT NULL,
    year_released int NOT NULL,
    PRIMARY KEY (album_id)
);

CREATE TABLE artist (
    artist_id int NOT NULL AUTO_INCREMENT,
    name varchar(60) NOT NULL,
    genre_id int NOT NULL,
    PRIMARY KEY (artist_id),
    FOREIGN KEY (genre_id) REFERENCES genre (genre_id) ON DELETE CASCADE
);

CREATE TABLE artist_album (
    album_id int NOT NULL,
    artist_id int NOT NULL,
    FOREIGN KEY (artist_id) REFERENCES artist (artist_id) ON DELETE CASCADE,
    FOREIGN KEY (album_id) REFERENCES album (album_id) ON DELETE CASCADE
);