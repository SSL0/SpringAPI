CREATE TABLE IF NOT EXISTS groups (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    subdivision VARCHAR(100) NOT NULL,
    yearOfRecruitment INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS students (
    id SERIAL PRIMARY KEY,
    lastname VARCHAR(255) NOT NULL,
    firstname VARCHAR(255) NOT NULL,
    surname VARCHAR(255),
    groupID INTEGER REFERENCES groups(id) ON DELETE SET NULL,
    birthDate DATE NOT NULL,
    gender CHAR(1) CHECK (gender IN ('M', 'F')),
    status VARCHAR(50) NOT NULL CHECK (status IN ('STUDYING', 'EXPELLED'))
);