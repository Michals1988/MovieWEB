SET CHARACTER SET UTF8;

CREATE SCHEMA IF NOT EXISTS `movieweb`;

CREATE TABLE movieweb.`library`
(
    `id`                int NOT NULL AUTO_INCREMENT,
    `title`             varchar(200) DEFAULT NULL,
    `releaseYear`       int          DEFAULT NULL,
    `descriptionMovie`  varchar(250) DEFAULT NULL,
    `rating`            int          DEFAULT NULL,
    `categoryNameMovie` varchar(100) DEFAULT NULL,
    `img`               varchar(250) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE movieweb.`category`
(
    `idCategory`   int NOT NULL AUTO_INCREMENT,
    `categoryName` varchar(45) DEFAULT NULL,
    PRIMARY KEY (`idCategory`)
);

CREATE TABLE movieweb.`rating`
(
    `idRating` int NOT NULL AUTO_INCREMENT,
    `movieId`  int DEFAULT NULL,
    `movieRating`  int DEFAULT NULL,
    PRIMARY KEY (`idRating`)
);



INSERT INTO movieweb.library (title, releaseYear, descriptionMovie, rating, categoryNameMovie, img)
VALUES ('SKAZANI NA SHAWSHANK', 1994,
        'Adaptacja opowiadania Stephena Kinga. Niesłusznie skazany na dożywocie bankier, stara się przetrwać w brutalnym.',
        0, 'Dramat', 'https://fwcdn.pl/fpo/10/48/1048/6925401.6.jpg'),
       ('NIETYKALNI', 2011,
        'Sparaliżowany milioner zatrudnia do opieki młodego chłopaka z przedmieścia, który właśnie wyszedł z więzienia.',
        0, 'Biograficzny', 'https://fwcdn.pl/fpo/33/90/583390/7441162.6.jpg'),
       ('ZIELONA MILA', 1999,
        'Emerytowany strażnik więzienny opowiada przyjaciółce o niezwykłym mężczyźnie, którego skazano na śmierć za zabójstwo dwóch 9-letnich dziewczynek.',
        0, 'Dramat', 'https://fwcdn.pl/fpo/08/62/862/7517878.6.jpg'),
       ('OJCIEC CHRZESTNY', 1972,
        'Opowieść o nowojorskiej rodzinie mafijnej. Starzejący się Don Corleone pragnie przekazać władzę swojemu synowi.',
        0, 'Gangsterski', 'https://fwcdn.pl/fpo/10/89/1089/7196615.6.jpg'),
       ('DWUNASTU GNIEWNYCH LUDZI', 1957,
        'Dwunastu przysięgłych ma wydać wyrok w procesie o morderstwo. Jeden z nich ma wątpliwości dotyczące winy oskarżonego.',
        0, 'Dramat', 'https://fwcdn.pl/fpo/07/01/30701/8094290.6.jpg'),
       ('FORREST GUMP', 1994,
        'Historia życia Forresta, chłopca o niskim ilorazie inteligencji z niedowładem kończyn, który staje się miliarderem i bohaterem wojny w Wietnamie.',
        0, 'Dramat', 'https://fwcdn.pl/fpo/09/98/998/8021615.6.jpg'),
       ('LOT NAD KUKUŁCZYM GNIAZDEM', 1975,
        'Historia złodzieja, szulera i chuligana, który, by uniknąć więzienia, udaje niepoczytalność. Trafia do szpitala dla umysłowo chorych, gdzie twardą ręką rządzi siostra Ratched.',
        0, 'Dramat', 'https://fwcdn.pl/fpo/10/19/1019/6974780.6.jpg'),
       ('OJCIEC CHRZESTNY II', 1974,
        'Rok 1917. Młody Vito Corleone stawia pierwsze kroki w mafijnym świecie Nowego Jorku. Ponad 40 lat później jego syn Michael walczy o interesy i dobro rodziny.',
        0, 'Gangsterski', 'https://fwcdn.pl/fpo/10/90/1090/7196616.6.jpg'),
       ('WŁADCA PIERŚCIENI: POWRÓT KRÓLA', 2003,
        'Zwieńczenie filmowej trylogii wg powieści Tolkiena. Aragorn jednoczy siły Śródziemia, szykując się do bitwy, która ma odwrócić uwagę Saurona od podążających w kierunku Góry Przeznaczenia hobbitów.',
        0, 'Fantasy', 'https://fwcdn.pl/fpo/18/41/11841/7494142.6.jpg'),
       ('LISTA SCHINDLERA', 1993,
        'Historia przedsiębiorcy Oskara Schindlera, który podczas II wojny światowej uratował przed pobytem w obozach koncentracyjnych 1100 Żydów.',
        0, 'Historyczny', 'https://fwcdn.pl/fpo/12/11/1211/7876866.6.jpg'),
       ('PULP FICTION', 1994,
        'Przemoc i odkupienie w opowieści o dwóch płatnych mordercach pracujących na zlecenie mafii, żonie gangstera, bokserze i parze okradającej ludzi w restauracji.',
        0, 'Gangsterski', 'https://fwcdn.pl/fpo/10/39/1039/7517880.6.jpg'),
       ('Życie jest piękne', 1994,
        'Zamknięty w obozie koncentracyjnym wraz z synem Guido próbuje przekonać chłopca, że okrutna rzeczywistość jest jedynie formą zabawy dla dorosłych.',
        0, 'Dramat', 'https://fwcdn.pl/fpo/02/08/208/7520031.6.jpg'),
       ('Siedem', 1995,
        'Dwóch policjantów stara się złapać seryjnego mordercę wybierającego swoje ofiary według specjalnego klucza - siedmiu grzechów głównych.',
        0, 'Kryminał', 'https://fwcdn.pl/fpo/07/02/702/8021069.6.jpg'),
       ('PODZIEMNY KRĄG', 1999,
        'Cierpiący na bezsenność mężczyzna poznaje gardzącego konsumpcyjnym stylem życia Tylera Durdena, który jest jego zupełnym przeciwieństwem.',
        0, 'Thriller', 'https://fwcdn.pl/fpo/08/37/837/7522091.6.jpg'),
       ('CHŁOPCY Z FERAJNY', 1990,
        'Kilkunastoletni Henry i Tommy DeVito trafiają pod opiekę potężnego gangstera. Obaj szybko uczą się panujących w mafii reguł.',
        0, 'Gangsterski', 'https://fwcdn.pl/fpo/10/33/1033/6941458.6.jpg'),
       ('Dawno temu w trawie', 1998,
        'Mrówki ciężko pracują wiosną i latem, by zebrać jedzenie na haracz dla koników polnych. Flik nie godzi się z tym, dlatego wyrusza w świat, poszukując owadów mogących ochronić mrowisko. ',
        0, 'Animacja', 'https://fwcdn.pl/fpo/00/34/34/7824862.6.jpg'),
       ('EuroTrip', 2004,
        'Absolwent liceum wyrusza z grupą przyjaciół w szaloną podróż do Europy, by spotkać się ze swoją internetową znajomą.',
        0, 'Komedia', 'https://fwcdn.pl/fpo/81/22/108122/7695048.6.jpg'),
       ('Król Lew', 1994,
        'Targany niesłusznymi wyrzutami sumienia po śmierci ojca mały lew Simba skazuje się na wygnanie, rezygnując z przynależnego mu miejsca na czele stada.',
        0, 'Familijny', 'https://fwcdn.pl/fpo/68/78/6878/7389475.6.jpg');



INSERT INTO movieweb.category (categoryName)
VALUES ('Dramat'),
       ('Komedia'),
       ('Biograficzny'),
       ('Animacja'),
       ('Historyczny'),
       ('Familijny'),
       ('Horror'),
       ('Gangsterski'),
       ('Dokumentalny'),
       ('Sportowy'),
       ('Katastroficzny'),
       ('Obyczajowy'),
       ('Thriller'),
       ('Kryminał'),
       ('Fantasy');



