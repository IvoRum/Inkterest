CREATE TABLE Ink_User(
    id BIGINT NOT NULL,
    email VARCHAR(50) NOT NULL,
    name VARCHAR(50) NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    surname_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    date_of_birth DATE NOT NULL,
    status BIGINT NOT NULL,
    time_stamp TIMESTAMP(0) WITHOUT TIME ZONE NOT NULL
);
ALTER TABLE
    Ink_User ADD PRIMARY KEY(id);
CREATE TABLE Post(
    id BIGINT NOT NULL,
    name VARCHAR(255) NOT NULL,
    image VARCHAR(255) NOT NULL,
    likes BIGINT NOT NULL
);
ALTER TABLE
    Post ADD PRIMARY KEY(id);
CREATE TABLE Location(
    id BIGINT NOT NULL,
    street VARCHAR(255) NOT NULL,
    number BIGINT NOT NULL
);
ALTER TABLE
    Location ADD PRIMARY KEY(id);
CREATE TABLE Artist(
    user_id BIGINT NOT NULL,
    post BIGINT NOT NULL
);
ALTER TABLE
    Artist ADD PRIMARY KEY(user_id);
CREATE TABLE Studio(
    id BIGINT NOT NULL,
    name VARCHAR(90) NOT NULL,
    location INTEGER NOT NULL,
    owner BIGINT NOT NULL,
    staff BIGINT NOT NULL
);
ALTER TABLE
    Studio ADD PRIMARY KEY(id);
ALTER TABLE
    Studio ADD CONSTRAINT studio_location_foreign FOREIGN KEY(location) REFERENCES Location(id);
ALTER TABLE
    Ink_User ADD CONSTRAINT user_id_foreign FOREIGN KEY(id) REFERENCES Artist(user_id);
ALTER TABLE
    Artist ADD CONSTRAINT artist_post_foreign FOREIGN KEY(post) REFERENCES Post(id);
ALTER TABLE
    Studio ADD CONSTRAINT studio_staff_foreign FOREIGN KEY(staff) REFERENCES Ink_User(id);
ALTER TABLE
    Studio ADD CONSTRAINT studio_owner_foreign FOREIGN KEY(owner) REFERENCES Ink_User(id);