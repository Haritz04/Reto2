CREATE TABLE agencyTypes (
	id   INT(11)     AUTO_INCREMENT,
	aid  VARCHAR(2)  UNIQUE NOT NULL,
	name VARCHAR(32) UNIQUE NOT NULL,
	
	CONSTRAINT pk_id_agencyTypes
	PRIMARY KEY(id)
);

CREATE TABLE maxEmployees (
	id          INT(11)     AUTO_INCREMENT,
	aid         VARCHAR(2)  UNIQUE NOT NULL,
	maxEmployee INT(11)            NOT NULL,
	message     VARCHAR(32)        NOT NULL,
	
	CONSTRAINT pk_id_maxEmployees
	PRIMARY KEY(id)
);

CREATE TABLE agencies (
	id             INT(11)      AUTO_INCREMENT,
	idAgencyTypes  INT(11)             NOT NULL,
	idMaxEmployees INT(11)             NOT NULL,
	name           VARCHAR(32)  UNIQUE NOT NULL,
	password       VARCHAR(32)         NOT NULL,
	logo           VARCHAR(255)        NOT NULL,
	color          VARCHAR(7)          NOT NULL,
	
	CONSTRAINT pk_id_agencies
	PRIMARY KEY(id),
	
	CONSTRAINT fk_idAgencyTypes_agencies
	FOREIGN KEY(idAgencyTypes)
	REFERENCES agencyTypes(id)
	ON UPDATE CASCADE
	ON DELETE CASCADE,
	
	CONSTRAINT fk_idMaxEmployees_agencies
	FOREIGN KEY(idMaxEmployees)
	REFERENCES maxEmployees(id)
	ON UPDATE CASCADE
	ON DELETE CASCADE
);

CREATE TABLE travelTypes (
	id          INT(11)     AUTO_INCREMENT,
	aid         VARCHAR(2)  UNIQUE NOT NULL, -- Clave alternativa.
	description VARCHAR(32)        NOT NULL,
	
	CONSTRAINT pk_id_travelTypes
	PRIMARY KEY(id)
);

CREATE TABLE travels (
	id                     INT(11)      AUTO_INCREMENT,
	idTravelType           INT(11)             NOT NULL,
	idAgency               INT(11)             NOT NULL,
	name                   VARCHAR(32)  UNIQUE NOT NULL,
	description            VARCHAR(512)        NOT NULL,
	travelDate             DATE                NOT NULL,
	duration               INT(11)             NOT NULL,
	descServiceNotIncluded VARCHAR(512)        NOT NULL,
	
	CONSTRAINT pk_id_travels
	PRIMARY KEY(id),
	
	CONSTRAINT fk_idTravelType_travel
	FOREIGN KEY(idTravelType)
	REFERENCES travelTypes(id)
	ON UPDATE CASCADE
	ON DELETE CASCADE,
	
	CONSTRAINT fk_idAgency_travels
	FOREIGN KEY(idAgency)
	REFERENCES agencies(id)
	ON UPDATE CASCADE
	ON DELETE CASCADE
);

CREATE TABLE countries (
	id   INT(11)     AUTO_INCREMENT,
	aid  VARCHAR(2)  UNIQUE NOT NULL,
	name VARCHAR(32) UNIQUE NOT NULL,
	
	CONSTRAINT pk_id_countries
	PRIMARY KEY(id)
);

CREATE TABLE cities (
	id        INT(11)     AUTO_INCREMENT,
	idCountry INT(11)     NOT NULL,
	name      VARCHAR(32) NOT NULL,
	
	CONSTRAINT pk_id_cities
	PRIMARY KEY(id),
	
	CONSTRAINT fk_idCountry_cities
	FOREIGN KEY(idCountry)
	REFERENCES countries(id)
	ON UPDATE CASCADE
	ON DELETE CASCADE
);

CREATE TABLE roomTypes (
	id   INT(11)     AUTO_INCREMENT,
	aid  VARCHAR(2)  UNIQUE NOT NULL,
	name VARCHAR(32) UNIQUE NOT NULL,
	
	CONSTRAINT pk_id_roomTypes
	PRIMARY KEY(id)
);

CREATE TABLE accommodation (
	id         INT(11)       AUTO_INCREMENT,
	idTravel   INT(11)       NOT NULL,
	idCity     INT(11)       NOT NULL,
	idRoomType INT(11)       NOT NULL,
	name       VARCHAR(32)   NOT NULL, -- Nombre del hotel.
	price      NUMERIC(5, 2) NOT NULL,
	enterDate  DATE          NOT NULL,
	exitDate   DATE          NOT NULL,
	
	CONSTRAINT pk_id_accommodation
	PRIMARY KEY(id),
	
	CONSTRAINT fk_idTravel_accommodation
	FOREIGN KEY(idTravel)
	REFERENCES travels(id)
	ON UPDATE CASCADE
	ON DELETE CASCADE,
	
	CONSTRAINT fk_idCity_accommodation
	FOREIGN KEY(idCity)
	REFERENCES cities(id)
	ON UPDATE CASCADE
	ON DELETE CASCADE,
	
	CONSTRAINT fk_idRoomType_accommodation
	FOREIGN KEY(idRoomType)
	REFERENCES roomTypes(id)
	ON UPDATE CASCADE
	ON DELETE CASCADE
);

CREATE TABLE others (
	id          INT(11)       AUTO_INCREMENT,
	idTravel    INT(11)       NOT NULL,
	name        VARCHAR(32)   NOT NULL,
	eventDate   DATE          NOT NULL,
	description VARCHAR(512)  NOT NULL,
	price       NUMERIC(5, 2) NOT NULL,
	
	CONSTRAINT pk_id_others
	PRIMARY KEY(id),
	
	CONSTRAINT fk_idTravel_others
	FOREIGN KEY(idTravel)
	REFERENCES travels(id)
	ON UPDATE CASCADE
	ON DELETE CASCADE
);

CREATE TABLE airports (
	id     INT(11)     AUTO_INCREMENT,
	idCity INT(11)            NOT NULL,
	aid    VARCHAR(3)  UNIQUE NOT NULL, -- Clave alternativa.
	name   VARCHAR(32)        NOT NULL,
	
	CONSTRAINT pk_id_airport
	PRIMARY KEY(id),
	
	CONSTRAINT fk_idCity_airports
	FOREIGN KEY(idCity)
	REFERENCES cities(id)
	ON UPDATE CASCADE
	ON DELETE CASCADE
);

CREATE TABLE airlines (
	id     INT(11)     AUTO_INCREMENT,
	aid    VARCHAR(4)  UNIQUE NOT NULL, -- Clave alternativa.
	name   VARCHAR(32)        NOT NULL,
	
	CONSTRAINT pk_id_airlines
	PRIMARY KEY(id)
);

CREATE TABLE flights (
	id             INT(11)       AUTO_INCREMENT,
	idTravel       INT(11)              NOT NULL,
	idAirportStart INT(11)              NOT NULL,
	idAirportEnd   INT(11)              NOT NULL,
	idAirline      INT(11)              NOT NULL,
	code           VARCHAR(9)    UNIQUE NOT NULL, -- Clave alternativa.
	price          NUMERIC(5, 2)        NOT NULL,
	startMoment    TIMESTAMP            NOT NULL,
	duration       INT(11)              NOT NULL,
	
	CONSTRAINT pk_id_flights
	PRIMARY KEY(id),

	CONSTRAINT fk_idTravel_flights
	FOREIGN KEY(idTravel)
	REFERENCES travels(id)
	ON UPDATE CASCADE
	ON DELETE CASCADE,
	
	CONSTRAINT fk_idAirportStart_flights
	FOREIGN KEY(idAirportStart)
	REFERENCES airports(id)
	ON UPDATE CASCADE
	ON DELETE CASCADE,
	
	CONSTRAINT fk_idAirportEnd_flighst
	FOREIGN KEY(idAirportEnd)
	REFERENCES airports(id)
	ON UPDATE CASCADE
	ON DELETE CASCADE,
	
	CONSTRAINT fk_idAirline_flights
	FOREIGN KEY(idAirline)
	REFERENCES airlines(id)
	ON UPDATE CASCADE
	ON DELETE CASCADE
);

CREATE TABLE flightPairs (
	id             INT(11) AUTO_INCREMENT,
	idTravel       INT(11) NOT NULL,
	idGoFlight     INT(11) NOT NULL,
	idReturnFlight INT(11) NOT NULL,

	CONSTRAINT pk_id_flightPairs
	PRIMARY KEY(id),

	CONSTRAINT fk_idTravel_flightPairs
	FOREIGN KEY(idTravel)
	REFERENCES travels(id)
	ON UPDATE CASCADE
	ON DELETE CASCADE,

	CONSTRAINT fk_idGoFlight_flightPairs
	FOREIGN KEY(idGoFlight)
	REFERENCES flights(id)
	ON UPDATE CASCADE
	ON DELETE CASCADE,

	CONSTRAINT fk_idReturnFlight_flightPairs
	FOREIGN KEY(idReturnFlight)
	REFERENCES flights(id)
	ON UPDATE CASCADE
	ON DELETE CASCADE
);

/* DATA */

INSERT INTO agencyTypes (aid, name)
VALUES
	("A1", "Mayorista"),
	("A2", "Minorista"),
	("A3", "Mayorista-minorista");

INSERT INTO maxEmployees (aid, message, maxEmployee)
VALUES
	("L1", "Numero de empleados de 1 a 10", 10),
	("L2", "Numero de empleados de 10 a 100", 100),
	("L3", "Numero de empleados de 100 a 1000", 1000);

INSERT INTO travelTypes (aid, description)
VALUE
	("B1", "Novios"),
	("B2", "Senior"),
	("B3", "Grupos"),
	("B4", "Viajes largos (destinos exoticos + vuelo + alojamiento)"),
	("B5", "Escapada"),
	("B6", "Familia (con hijos pequeños)");

INSERT INTO roomTypes (aid, name)
VALUES
	("DB", "Bikoitza"),
	("DUI", "Bikoitza, erabilpen indibiduala"),
	("SIN", "Indibiduala"),
	("TPL", "Hirukoitza");

INSERT INTO countries (aid, name)
VALUES
	("AR", "ARGENTINA"),
	("AT", "AUSTRIA"),
	("BE", "BÉLGICA"),
	("BR", "BRASIL"),
	("CA", "CANADA"),
	("CH", "SUIZA"),
	("CN", "CHINA"),
	("CU", "CUBA"),
	("CY", "CHIPRE"),
	("CZ", "REPUBLICA CHECA"),
	("DE", "ALEMANIA"),
	("DK", "DINAMARCA"),
	("EC", "EQUADOR"),
	("EE", "ESTONIA"),
	("EG", "EGIPTO"),
	("ES", "ESPAÑA"),
	("FI", "FINLANDIA"),
	("FR", "FRANCIA"),
	("GB", "REINO UNIDO"),
	("GR", "GRECIA"),
	("GT", "GUATEMALA"),
	("HK", "HONG-KONG"),
	("HR", "CROACIA"),
	("HU", "HUNGRIA"),
	("ID", "INDONESIA"),
	("IE", "IRLANDA"),
	("IL", "ISRAEL"),
	("IN", "INDIA"),
	("IS", "ISLANDIA"),
	("IT", "ITALIA"),
	("JM", "JAMAICA"),
	("JP", "JAPÓN"),
	("KE", "KENIA"),
	("LU", "LUXEMBURGO"),
	("MA", "MARRUECOS"),
	("MC", "MÓNACO"),
	("MT", "MALTA"),
	("MV", "MALDIVAS"),
	("MX", "MEXICO"),
	("NL", "PAISES BAJOS"),
	("NO", "NORUEGA"),
	("PA", "PANAMÁ"),
	("PE", "PERÚ"),
	("PL", "POLONIA"),
	("PR", "PUERTO RICO"),
	("PT", "PORTUGAL"),
	("QA", "QATAR"),
	("RO", "RUMANIA"),
	("RU", "RUSIA"),
	("SC", "SEYCHELLES"),
	("SE", "SUECIA"),
	("SG", "SINGAPUR"),
	("TH", "TAILANDIA"),
	("TN", "TÚNEZ"),
	("TR", "TURQUIA"),
	("TZ", "TANZANIA (INCLUYE ZANZIBAR)"),
	("US", "ESTADOS UNIDOS"),
	("VE", "VENEZUELA"),
	("VN", "VIETNAM"),
	("ZA", "SUDÁFRICA");

INSERT INTO airlines (aid, name)
VALUES
	("2K", "AVIANCA-Ecuador dba AVIANCA"),
	("3P", "World 2 Fly PT, S.A."),
	("6B*", "TUIfly Nordic AB"),
	("A.C.", "Air France "),
	("A0", "BA Euroflyer Limited dba British Airways"),
	("AA", "American Airlines"),
	("AM", "Aerovias de Mexico SA de CV dba AeroMexico"),
	("AR", "Aerolineas Argentinas S.A."),
	("AV", "Aerovias del Continente Americano S.A. AVIANCA"),
	("AY", "Finnair"),
	("AZ", "Alitalia"),
	("BA", "British Airways PLC"),
	("CL", "Lufthansa CityLine GmbH"),
	("DE", "Condor Flugdienst GmbH"),
	("DL", "Delta Air Lines Inc"),
	("DS", "Easyjet CH S.A"),
	("GL", "Air GRL"),
	("JJ", "Tam Linhas Aereas SA dba Latam Airlines Brasil"),
	("KL", "KLM"),
	("KN", "CN United Airlines"),
	("LH", "Lufthansa"),
	("LX", "SWISS Internation Air Lines Ltd"),
	("M3", "BSA - Aerolinhas Brasileiras S.A dba LATAM Cargo Br"),
	("MS", "Egyptair"),
	("MT", "MT Air Travel Ltd dba MT MedAir"),
	("N0", "Norse Atlantic Airways AS"),
	("OU", "HR Airlines d.d."),
	("PC", "Pegasus Airlines"),
	("QR", "QA Airways Group Q.C.S.C dba QA Airways"),
	("RJ", "Alia - The Royal JOn Airlines dba Royal JOn"),
	("RK", "RYNAIR"),
	("S4", "SATA Internacional - Azores Airlines, S.A."),
	("SN", "Brussels Airlines"),
	("SP", "SATA (Air Acores)"),
	("TK", "Turkish Airlines Inc"),
	("TP", "TAP PT"),
	("TS", "Air Transat"),
	("U2", "EASYJET UK LIMITED"),
	("UA", "United Airlines Inc"),
	("UX", "Air Europa Lineas Aereas, S.A."),
	("VOY", "Aerolínea Vueling SA"),
	("VS", "Virgin Atlantic Airways Ltd"),
	("WA", "KLM Cityhopper"),
	("WFL", "World2Fly"),
	("WK", "Edelweiss Air AG"),
	("X3*", "TUIfly Gmbh"),
	("X7", "Challenge Airlines (BE) S.A."),
	("YW", "Air Nostrum, Lineas aereas del Mediterra neo SA");

INSERT INTO cities (idCountry, name)
VALUES
	(1, "MÉXICO (ACAPULCO)"),
	(1, "Lanzarote"),
	(1, "MALAGA"),
	(1, "Alicante"),
	(1, "JO (Ammán) AMM"),
	(1, "HOLANDA Amsterdam"),
	(1, "GRECIA (Atenas)"),
	(1, "barcelona"),
	(1, "ALEMANIA (Berlín)"),
	(1, "Bilbao"),
	(1, "Badajoz"),
	(1, "TAILANDIA Bagkok"),
	(1, "COLOMBIA Bogotá"),
	(1, "Boston"),
	(1, "BELGICA (Bruselas)"),
	(1, "BRASIL (brasilia)"),
	(1, "Buenos Aires"),
	(1, "EG El Cairo"),
	(1, "MARRUECOS (Casablanca)"),
	(1, "VENEZUELA (CARACAS)"),
	(1, "FRANCIA,París (aeropuerto Charles de Gaulle)"),
	(1, "DINAMARCA"),
	(1, "DETROIT"),
	(1, "IRLANDA (DUBLIN)"),
	(1, "ALEMANIA (Dusseldorf)"),
	(1, "SAN SEBASTIAN"),
	(1, "ALEMANIA (Frankfurt)"),
	(1, "FUERTEVENTURA"),
	(1, "LA GOMERA"),
	(1, "Gerona"),
	(1, "Granada"),
	(1, "SUIZA (Ginebra)"),
	(1, "ALEMANIA (hamburgo)"),
	(1, "FINLANDIA (Helsinki)"),
	(1, "Houston"),
	(1, "Ibiza"),
	(1, "TR (ESTAMBUL)"),
	(1, "Nueva York"),
	(1, "JAMAICA (kingston)"),
	(1, "LOS ANGELES"),
	(1, "FRANCIA ,Le Bourget,"),
	(1, "La Coruña LCG"),
	(1, "LONDRES (GATWICK)"),
	(1, "LONDRES Heathrow"),
	(1, "PERU (Lima)"),
	(1, "PT (lisboa)"),
	(1, "GRAN CANARIA"),
	(1, "FRANCIA (lyon)"),
	(1, "Madrid"),
	(1, "MAHON"),
	(1, "AUSTRALIA Melbourne"),
	(1, "México D.F."),
	(1, "Miami"),
	(1, "ITALIA (Milán)"),
	(1, "Murcia"),
	(1, "RUSIA (Moscú) MOW"),
	(1, "FRANCIA (Marsella)"),
	(1, "ALEMANIA (Munich)"),
	(1, "KENIA (Nairobi)"),
	(1, "Córdoba"),
	(1, "FRANCIA (ORLY)"),
	(1, "NORUEGA (oslo)"),
	(1, "Asturias"),
	(1, "Philadelphia PHL"),
	(1, "PALMA DE MALLORCA"),
	(1, "Pamplona"),
	(1, "REPUBLICA CHECA (Praga)"),
	(1, "MARRUECOS (Marrakech)"),
	(1, "REUS"),
	(1, "BRASIL (Rio de Janeiro)"),
	(1, "BRASIL (Sao Paulo)"),
	(1, "Santiago de Compostela"),
	(1, "REPUBLICA DOMINICANA (Santo Domingo)"),
	(1, "SANTANDER"),
	(1, "Seattle"),
	(1, "SAN FRANCISCO"),
	(1, "Salamanca"),
	(1, "Santa Cruz de la Palma"),
	(1, "LONDRES (Stanted)"),
	(1, "SUECIA (Estocolmo)"),
	(1, "ALEMANIA (Stuttgart)"),
	(1, "AUSTRALIA (SIYNEY)"),
	(1, "Tenerife Norte"),
	(1, "Tenerife Sur"),
	(1, "Túnez"),
	(1, "HIERRO"),
	(1, "Vigo"),
	(1, "AUSTRIA (Viena)"),
	(1, "VITORIA"),
	(1, "Valencia"),
	(1, "WASHINGTON"),
	(1, "POLONIA (Varsovia) WAW"),
	(1, "JEREZ DE LA FRONTERA"),
	(1, "Montreal, Québec"),
	(1, "CA Ottawa, Ontario YOW"),
	(1, "CA Toronto, Ontario YTO"),
	(1, "CA VANCOUVER"),
	(1, "Zaragoza"),
	(1, "SUIZA (Zurich)");

INSERT INTO airports (idCity, aid, name)
VALUES
	(1, "ACA", "MÉXICO (ACAPULCO)"),
	(1, "ACE", "Lanzarote"),
	(1, "AGP", "MALAGA"),
	(1, "ALC", "Alicante"),
	(1, "AMM", "JO (Ammán) AMM"),
	(1, "AMS", "HOLANDA Amsterdam"),
	(1, "ATH", "GRECIA (Atenas)"),
	(1, "BCN", "barcelona"),
	(1, "BER", "ALEMANIA (Berlín)"),
	(1, "BIO", "Bilbao"),
	(1, "BJZ", "Badajoz"),
	(1, "BKK", "TAILANDIA Bagkok"),
	(1, "BOG", "COLOMBIA Bogotá"),
	(1, "BOS", "Boston"),
	(1, "BRU", "BELGICA (Bruselas)"),
	(1, "BSB", "BRASIL (brasilia)"),
	(1, "BUE", "Buenos Aires"),
	(1, "CAI", "EG El Cairo"),
	(1, "CAS", "MARRUECOS (Casablanca)"),
	(1, "CCS", "VENEZUELA (CARACAS)"),
	(1, "CDG", "FRANCIA,París (aeropuerto Charles de Gaulle)"),
	(1, "CPH", "DINAMARCA"),
	(1, "DTT", "DETROIT"),
	(1, "DUB", "IRLANDA (DUBLIN)"),
	(1, "DUS", "ALEMANIA (Dusseldorf)"),
	(1, "EAS", "SAN SEBASTIAN"),
	(1, "FRA", "ALEMANIA (Frankfurt)"),
	(1, "FUE", "FUERTEVENTURA"),
	(1, "GMZ", "LA GOMERA"),
	(1, "GRO", "Gerona"),
	(1, "GRX", "Granada"),
	(1, "GVA", "SUIZA (Ginebra)"),
	(1, "HAM", "ALEMANIA (hamburgo)"),
	(1, "HEL", "FINLANDIA (Helsinki)"),
	(1, "HOU", "Houston"),
	(1, "IBZ", "Ibiza"),
	(1, "IST", "TR (ESTAMBUL)"),
	(1, "JFK", "Nueva York"),
	(1, "KIN", "JAMAICA (kingston)"),
	(1, "LAX", "LOS ANGELES"),
	(1, "LBG", "FRANCIA ,Le Bourget,"),
	(1, "LCG", "La Coruña LCG"),
	(1, "LGH", "LONDRES (GATWICK)"),
	(1, "LHR", "LONDRES Heathrow"),
	(1, "LIM", "PERU (Lima)"),
	(1, "LIS", "PT (lisboa)"),
	(1, "LPA", "GRAN CANARIA"),
	(1, "LYS", "FRANCIA (lyon)"),
	(1, "MAD", "Madrid"),
	(1, "MAH", "MAHON"),
	(1, "MEL", "AUSTRALIA Melbourne"),
	(1, "MEX", "México D.F."),
	(1, "MIA", "Miami"),
	(1, "MIL", "ITALIA (Milán)"),
	(1, "MJV", "Murcia"),
	(1, "MOW", "RUSIA (Moscú) MOW"),
	(1, "MRS", "FRANCIA (Marsella)"),
	(1, "MUC", "ALEMANIA (Munich)"),
	(1, "NBO", "KENIA (Nairobi)"),
	(1, "ODB", "Córdoba"),
	(1, "ORY", "FRANCIA (ORLY)"),
	(1, "OSL", "NORUEGA (oslo)"),
	(1, "OVD", "Asturias"),
	(1, "PHL", "Philadelphia PHL"),
	(1, "PMI", "PALMA DE MALLORCA"),
	(1, "PNA", "Pamplona"),
	(1, "PRG", "REPUBLICA CHECA (Praga)"),
	(1, "RAK", "MARRUECOS (Marrakech)"),
	(1, "REU", "REUS"),
	(1, "RIO", "BRASIL (Rio de Janeiro)"),
	(1, "SAO", "BRASIL (Sao Paulo)"),
	(1, "SCQ", "Santiago de Compostela"),
	(1, "SDQ", "REPUBLICA DOMINICANA (Santo Domingo)"),
	(1, "SDR", "SANTANDER"),
	(1, "SEA", "Seattle"),
	(1, "SFO", "SAN FRANCISCO"),
	(1, "SLM", "Salamanca"),
	(1, "SPC", "Santa Cruz de la Palma"),
	(1, "STN", "LONDRES (Stanted)"),
	(1, "STO", "SUECIA (Estocolmo)"),
	(1, "STR", "ALEMANIA (Stuttgart)"),
	(1, "SYD", "AUSTRALIA (SIYNEY)"),
	(1, "TFN", "Tenerife Norte"),
	(1, "TFS", "Tenerife Sur"),
	(1, "TUN", "Túnez"),
	(1, "VDE", "HIERRO"),
	(1, "VGO", "Vigo"),
	(1, "VIE", "AUSTRIA (Viena)"),
	(1, "VIT", "VITORIA"),
	(1, "VLC", "Valencia"),
	(1, "WAS", "WASHINGTON"),
	(1, "WAW", "POLONIA (Varsovia) WAW"),
	(1, "XRY", "JEREZ DE LA FRONTERA"),
	(1, "YMQ", "Montreal, Québec"),
	(1, "YOW", "CA Ottawa, Ontario YOW"),
	(1, "YTO", "CA Toronto, Ontario YTO"),
	(1, "YVR", "CA VANCOUVER"),
	(1, "ZAZ", "Zaragoza"),
	(1, "ZRH", "SUIZA (Zurich)");
