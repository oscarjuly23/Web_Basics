CREATE DATABASE Exercici1;
USE Exercici1;
CREATE TABLE agenda(ID INT NOT NULL, document XMLTYPE);
INSERT INTO agenda VALUES(null,XMLTYPE('<data dia="10-10-2011"><cita hora="10:00"><titol>Visita al dentista</titol><durada>60</durada><comentari/></cita></data>)');
INSERT INTO agenda VALUES(null,XMLTYPE('<data dia="11-10-2011">'));
INSERT INTO agenda VALUES(null,XMLTYPE('<data dia="12-10-2011"><cita hora="8:00"><titol>Excursió a la Salut de Terrades</titol><durada>240</durada><comentari>Trucar a en Pere i en Pau per veure si venen</comentari></cita></data>'));
INSERT INTO agenda VALUES(null,XMLTYPE('<data dia="12-10-2011"><cita hora="21:00"><titol>Cinéma</titol><durada>240</durada><comentari>Trucar un dia abans a la Maria per confirmar si pot venir</comentari></cita></data>'));
INSERT INTO agenda VALUES(null,XMLTYPE('<data dia="13-10-2011"><cita hora="09:30"><titol>Reunió amb els representants de Porquets, SA</titol><durada>180</durada><comentari/></cita></data>'));
INSERT INTO agenda VALUES(null,XMLTYPE('<data dia="14-10-2011"><cita hora="08:00"><titol>Congrés de Telefonia mòbil</titol><durada>08:00</durada><comentari/></cita></data>'));
INSERT INTO agenda VALUES(null,XMLTYPE('<data dia="14-10-2011"><cita hora="08:00"><titol></titol><durada>08:00</durada><comentari/></cita></data>'));
CREATE TABLE contacte (ID INT NOT NULL, document XMLTYPE);
INSERT INTO values (null,XMLTYPE('<nom>Pere<correu>pere@mailz.com</correu>'));
INSERT INTO values (null,XMLTYPE('<nom>Maria<correu>maria@catmail.cat</correu>'));

