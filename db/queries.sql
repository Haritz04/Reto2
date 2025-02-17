SELECT * FROM agencies WHERE name='?' AND password='?';
SELECT * FROM agencyTypes;
SELECT * FROM roomTypes;
SELECT * FROM maxEmployees;
SELECT * FROM travelTypes WHERE id=?;

INSERT INTO agencies (idAgencyTypes, idMaxEmployees, name, password, logo, color) VALUES (?, ?, '?', '?', '?', '?');
INSERT INTO travels (name, description, descServiceNotIncluded, travelDate, duration, idAgency, idTravelType) VALUES ('?', '?', '?', '?', ?, ?, ?);
INSERT INTO accommodation (name, price, enterDate, exitDate, idTravel, idCity , idRoomType) VALUES ('?', ?, '?', '?', ?, ?, ?);
INSERT INTO `flights` (`idTravel`, `idAirportStart`, `idAirportEnd`, `idAirline`, `code`, `price`, `startMoment`, `duration`) VALUES (?,?,?,?,'?',?,'?',?)
INSERT INTO `flightpairs` (`idTravel`, `idGoFlight`, `idReturnFlight`) VALUES (?,?,?);

SELECT avg(duration) AS 'agencyAvgTravelDuration' FROM travels WHERE idAgency=? GROUP BY idAgency;
SELECT avg(price) AS 'accommodationAvgPrice' FROM accommodations AS acc JOIN travels ON travels.id = acc.idTravel WHERE idAgency=? GROUP BY idAgency;
SELECT avg(price) AS 'flightsAvgPrice' FROM flights JOIN travels ON travels.id = flights.idTravel WHERE idAgency=? GROUP BY idAgency;
SELECT max(price) AS 'otherMaxPrice' FROM others JOIN travels ON travels.id = others.idTravel WHERE idAgency=? GROUP BY idAgency;
SELECT max(price) AS 'otherMinPrice' FROM others JOIN travels ON travels.id = others.idTravel WHERE idAgency=? GROUP BY idAgency;
