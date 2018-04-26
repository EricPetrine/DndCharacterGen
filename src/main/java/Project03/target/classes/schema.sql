create table characters
(
	name varchar(250) not null,
	charClass varchar(250) not null,
	groupID integer not null,
	race varchar(250) not null,
	alignment varchar(250) not null,
	lvl integer not null,
	maxHP integer not null,
	curHP integer not null,
	rawSTR integer not null,
	strMOD integer not null,
	rawDex integer not null,
	dexMOD integer not null,
	rawCON integer not null,
	conMOD integer not null,
	rawINT integer not null,
	intMOD integer not null,
	rawWIS integer not null,
	wisMOD integer not null,
	rawCHA integer not null,
	chaMOD integer not null
);