create table tab_user
(
    id              VARCHAR(255) primary key NOT NULL,
    cin             VARCHAR(8) unique        NOT NULL,
    gender          VARCHAR(5),
    first_name      VARCHAR(255)             NOT NULL,
    last_name       VARCHAR(255)             NOT NULL,
    address         VARCHAR(255)             NOT NULL,
    phone           VARCHAR(15)              NOT NULL,
    passport_number VARCHAR(20),
    birthdate       VARCHAR(50),
    username        VARCHAR(30) unique       NOT NULL,
    password        VARCHAR(255)             NOT NULL,
    role            VARCHAR(30)              NOT NULL,
    has_account     tinyint

);

INSERT INTO tab_user
VALUES ('fd545121854',
        '09346591',
        'Male',
        'Iheb',
        'Chiha',
        'Khezama Est',
        '50609725',
        '12345687',
        '18/07/1995',
        'katana',
        '',
        'USER',
        1);
INSERT INTO tab_user
VALUES ('ljbkhljbj4554',
        '09346592',
        'Male',
        'Ahmed',
        'BenAli',
        'Khezama Ouest',
        '50650725',
        '12385687',
        '19/08/1990',
        'mido',
        '',
        'USER',
        1);