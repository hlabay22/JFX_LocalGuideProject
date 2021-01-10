use guide4u;

drop table Travellers;
create table Travellers (
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	email VARCHAR(50) PRIMARY KEY,
	password VARCHAR(6),
	dateOfBirth  VARCHAR(14),
	gender VARCHAR(6),
	country VARCHAR(50),
	city VARCHAR(50),
	phoneNumber VARCHAR(50),
	language1 VARCHAR(50),
	language2 VARCHAR(50),
	language3 VARCHAR(50),
	travelStyle1 VARCHAR(13),
	travelStyle2 VARCHAR(13),
	travelStyle3 VARCHAR(13),
	about VARCHAR(59),
	mail VARCHAR(3)
);
insert into Travellers (first_name, last_name, email, password, dateOfBirth, gender, country, city, phoneNumber, language1, language2, language3, travelStyle1, travelStyle2, travelStyle3, about, mail) values ('Prescott', 'Smurfit', 'psmurfit0@google.co.uk', 'ewq789', '31-Oct-2019', 'Male', 'United Kingdom', 'Washington', '2023030865', 'Croatian', null, null, 'Adventure', null, null, 'I Love Travels and meeting people from all around the world', 'no');
insert into Travellers (first_name, last_name, email, password, dateOfBirth, gender, country, city, phoneNumber, language1, language2, language3, travelStyle1, travelStyle2, travelStyle3, about, mail) values ('Lucy', 'Velasquez', 'lvelasquez1@1688.com', 'zxd123', '29-Jan-2020', 'Female', 'Israel', 'H?sselby', '7949160611', 'Croatian', null, 'Persian', 'Local Culture', null, 'Sport', 'I Love Travels and meeting people from all around the world', 'yes');
insert into Travellers (first_name, last_name, email, password, dateOfBirth, gender, country, city, phoneNumber, language1, language2, language3, travelStyle1, travelStyle2, travelStyle3, about, mail) values ('Eadmund', 'Bruff', 'ebruff2@phpbb.com', 'fgd745', '02-Aug-1963', 'Male', 'United States', 'Hongtang', '5775240429', 'Luxembourgish', 'Malay', null, 'Adventure', 'Local Culture', null, 'I Love Travel <3', 'no');
insert into Travellers (first_name, last_name, email, password, dateOfBirth, gender, country, city, phoneNumber, language1, language2, language3, travelStyle1, travelStyle2, travelStyle3, about, mail) values ('Roarke', 'Viggers', 'rviggers3@google.co.jp', 'zxd123', '01-Oct-1959', 'Male', 'Israel', 'Paihia', '3175128857', 'Arabic', null, 'Lao', 'Art', null, 'Sport', 'I Love Travels and meeting people from all around the world', 'yes');
insert into Travellers (first_name, last_name, email, password, dateOfBirth, gender, country, city, phoneNumber, language1, language2, language3, travelStyle1, travelStyle2, travelStyle3, about, mail) values ('Maxine', 'Yele', 'myele4@angelfire.com', 'qwe123', '25-Apr-1944', 'Female', 'Germany', 'Kavalerovo', '7766654207', 'Polish', null, null, 'Nature', null, null, 'I Love Travel <3', 'no');
insert into Travellers (first_name, last_name, email, password, dateOfBirth, gender, country, city, phoneNumber, language1, language2, language3, travelStyle1, travelStyle2, travelStyle3, about, mail) values ('Laurena', 'Keeves', 'lkeeves5@smh.com.au', 'ewq789', '28-Mar-1998', 'Female', 'United Kingdom', 'Kalynivka', '7254565167', 'Portuguese', 'Macedonian', null, 'Art', 'Entertaiment', null, 'Let''s Travel and Rock', 'yes');
insert into Travellers (first_name, last_name, email, password, dateOfBirth, gender, country, city, phoneNumber, language1, language2, language3, travelStyle1, travelStyle2, travelStyle3, about, mail) values ('Scarface', 'Edmenson', 'sedmenson6@upenn.edu', 'dfg455', '20-Dec-1964', 'Female', 'France', 'Panjir', '7849242361', 'Amharic', null, 'Georgian', 'Nature', null, 'Adventure', 'Let''s Travel and Rock', 'yes');
insert into Travellers (first_name, last_name, email, password, dateOfBirth, gender, country, city, phoneNumber, language1, language2, language3, travelStyle1, travelStyle2, travelStyle3, about, mail) values ('Lucho', 'Duling', 'lduling7@gov.uk', 'dfg455', '06-Nov-1971', 'Male', 'France', 'Punta Gorda', '9414643538', 'Portuguese', 'Norwegian', null, 'Nature', 'Sport', null, 'Let''s Travel and Rock', 'yes');
insert into Travellers (first_name, last_name, email, password, dateOfBirth, gender, country, city, phoneNumber, language1, language2, language3, travelStyle1, travelStyle2, travelStyle3, about, mail) values ('Llywellyn', 'Whitnell', 'lwhitnell8@yale.edu', 'ewq789', '04-Sep-2000', 'Female', 'France', 'Dongtuan', '1893541925', 'Kyrgyz', 'Arabic', null, 'Art', 'Entertaiment', null, 'I Love Travels and meeting people from all around the world', 'no');
insert into Travellers (first_name, last_name, email, password, dateOfBirth, gender, country, city, phoneNumber, language1, language2, language3, travelStyle1, travelStyle2, travelStyle3, about, mail) values ('Doralynne', 'Coale', 'dcoale9@gizmodo.com', 'zxd123', '23-Dec-1994', 'Male', 'United Kingdom', 'Nularan', '5189782057', 'Pashto', null, 'Georgian', 'Art', null, 'Adventure', 'I Love Travels and meeting people from all around the world', 'yes');
insert into Travellers (first_name, last_name, email, password, dateOfBirth, gender, country, city, phoneNumber, language1, language2, language3, travelStyle1, travelStyle2, travelStyle3, about, mail) values ('Chelsea', 'Zupo', 'czupoa@hud.gov', 'dfg455', '02-Dec-1993', 'Male', 'Israel', 'Khlong Hat', '9046763789', 'Malay', 'Ndebele', 'Oriya', 'Nature', 'Hiking', 'Entertaiment', 'I Love Travels and meeting people from all around the world', 'yes');
insert into Travellers (first_name, last_name, email, password, dateOfBirth, gender, country, city, phoneNumber, language1, language2, language3, travelStyle1, travelStyle2, travelStyle3, about, mail) values ('Fredric', 'Strasse', 'fstrasseb@va.gov', 'qwe123', '21-Jul-1984', 'Male', 'United Kingdom', 'Dongba', '8085650995', 'Montenegrin', null, null, 'Local Culture', null, null, 'I Love Travels and meeting people from all around the world', 'yes');
insert into Travellers (first_name, last_name, email, password, dateOfBirth, gender, country, city, phoneNumber, language1, language2, language3, travelStyle1, travelStyle2, travelStyle3, about, mail) values ('Rozamond', 'Airy', 'rairyc@sogou.com', 'fgd745', '05-Jul-1981', 'Female', 'Germany', 'Sirnasari', '8168569716', 'Danish', 'Marathi', null, 'Shoping', 'Sport', null, 'Let''s Travel and Rock', 'no');
insert into Travellers (first_name, last_name, email, password, dateOfBirth, gender, country, city, phoneNumber, language1, language2, language3, travelStyle1, travelStyle2, travelStyle3, about, mail) values ('Forrester', 'Maier', 'fmaierd@instagram.com', 'zxd123', '14-Feb-1984', 'Male', 'United Kingdom', 'Guhuai', '4507572738', 'Irish Gaelic', null, 'Irish Gaelic', 'Entertaiment', null, 'Shoping', 'Let''s Travel and Rock', 'no');
insert into Travellers (first_name, last_name, email, password, dateOfBirth, gender, country, city, phoneNumber, language1, language2, language3, travelStyle1, travelStyle2, travelStyle3, about, mail) values ('Nickolai', 'Chamberlen', 'nchamberlene@bloglines.com', 'ewq789', '01-Jul-1974', 'Male', 'Germany', 'Zhangfang', '3694232474', 'Ndebele', 'Dari', 'Croatian', 'Art', 'Adventure', 'Hiking', 'I Love Travel <3', 'yes');
insert into Travellers (first_name, last_name, email, password, dateOfBirth, gender, country, city, phoneNumber, language1, language2, language3, travelStyle1, travelStyle2, travelStyle3, about, mail) values ('Prinz', 'Tillett', 'ptillettf@creativecommons.org', 'asd345', '16-Apr-1994', 'Female', 'Germany', 'Tortosa', '3267029120', 'Swati', null, 'Macedonian', 'Entertaiment', null, 'Adventure', 'I Love Travels and meeting people from all around the world', 'no');
insert into Travellers (first_name, last_name, email, password, dateOfBirth, gender, country, city, phoneNumber, language1, language2, language3, travelStyle1, travelStyle2, travelStyle3, about, mail) values ('Augustine', 'Van Haeften', 'avanhaefteng@cdc.gov', 'ewq789', '15-Aug-1996', 'Female', 'United States', 'Trpinja', '2435772437', 'Swati', 'Dutch', null, 'Local Culture', 'Sport', null, 'I Love Travels and meeting people from all around the world', 'no');
insert into Travellers (first_name, last_name, email, password, dateOfBirth, gender, country, city, phoneNumber, language1, language2, language3, travelStyle1, travelStyle2, travelStyle3, about, mail) values ('Granville', 'Giorio', 'ggiorioh@sohu.com', 'qwe123', '28-Jul-1988', 'Male', 'France', 'Sinegor''ye', '5714631448', 'Polish', null, null, 'Local Culture', null, null, 'Let''s Travel and Rock', 'yes');
insert into Travellers (first_name, last_name, email, password, dateOfBirth, gender, country, city, phoneNumber, language1, language2, language3, travelStyle1, travelStyle2, travelStyle3, about, mail) values ('Giacopo', 'Rosier', 'grosieri@myspace.com', 'fgd745', '22-Jun-1991', 'Female', 'Germany', 'Cholarg?s', '4563346508', 'Marathi', null, 'Quechua', 'Nature', null, 'Sport', 'Let''s Travel and Rock', 'no');
insert into Travellers (first_name, last_name, email, password, dateOfBirth, gender, country, city, phoneNumber, language1, language2, language3, travelStyle1, travelStyle2, travelStyle3, about, mail) values ('Taryn', 'Shiel', 'tshielj@bing.com', 'qwe123', '21-Jan-1973', 'Female', 'United States', 'Cergy-Pontoise', '3974159558', 'Lithuanian', null, null, 'Shoping', null, null, 'I Love Travels and meeting people from all around the world', 'yes');

drop table LocalGuides;

create table LocalGuides (
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	email VARCHAR(50) PRIMARY KEY,
	password VARCHAR(6),
	dateOfBirth  VARCHAR(14),
	gender VARCHAR(6),
	country VARCHAR(50),
	city VARCHAR(50),
	phoneNumber VARCHAR(50),
	language1 VARCHAR(50),
	language2 VARCHAR(50),
	language3 VARCHAR(50),
	travelStyle1 VARCHAR(13),
	travelStyle2 VARCHAR(13),
	travelStyle3 VARCHAR(13),
	about VARCHAR(36),
	mail VARCHAR(3)
);
insert into LocalGuides (first_name, last_name, email, password, dateOfBirth, gender, country, city, phoneNumber, language1, language2, language3, travelStyle1, travelStyle2, travelStyle3, about, mail) values ('Debor', 'Lazer', 'dlazer0@lulu.com', 'dfg455', '13-Jan-1945', 'Female', 'France', 'Ipatinga', '3639577443', 'Marathi', null, null, 'Local Culture', null, null, 'Let''s Travel and Rock', 'yes');
insert into LocalGuides (first_name, last_name, email, password, dateOfBirth, gender, country, city, phoneNumber, language1, language2, language3, travelStyle1, travelStyle2, travelStyle3, about, mail) values ('Kamillah', 'Scardefield', 'kscardefield1@bloglines.com', 'qwe123', '09-Sep-1962', 'Male', 'United States', '?elezn? Brod', '505-513-7392', 'Kannada', null, 'Northern Sotho', 'Art', null, 'Entertaiment', 'Come and Travel with me', 'yes');
insert into LocalGuides (first_name, last_name, email, password, dateOfBirth, gender, country, city, phoneNumber, language1, language2, language3, travelStyle1, travelStyle2, travelStyle3, about, mail) values ('Fenelia', 'Ohlsen', 'fohlsen2@businessweek.com', 'dfg455', '27-Mar-1949', 'Female', 'France', 'Gon?b?d', '6238313508', 'Korean', null, null, 'Shoping', null, null, 'Come and Travel with me', 'yes');
insert into LocalGuides (first_name, last_name, email, password, dateOfBirth, gender, country, city, phoneNumber, language1, language2, language3, travelStyle1, travelStyle2, travelStyle3, about, mail) values ('Maddy', 'Swateridge', 'mswateridge3@qq.com', 'qwe123', '21-Jul-1984', 'Female', 'United States', 'Bromma', '4756388483', 'Kannada', null, 'Gagauz', 'Nature', null, 'Shoping', 'Let''s Travel and Rock', 'yes');
insert into LocalGuides (first_name, last_name, email, password, dateOfBirth, gender, country, city, phoneNumber, language1, language2, language3, travelStyle1, travelStyle2, travelStyle3, about, mail) values ('Archaimbaud', 'Ecob', 'aecob4@paypal.com', 'qwe123', '17-May-2013', 'Female', 'United Kingdom', 'Mayo', '1484647557', 'Armenian', null, 'Moldovan', 'Entertaiment', null, 'Sport', 'Come and Travel with me', 'yes');
insert into LocalGuides (first_name, last_name, email, password, dateOfBirth, gender, country, city, phoneNumber, language1, language2, language3, travelStyle1, travelStyle2, travelStyle3, about, mail) values ('Domenic', 'Yitzhakov', 'dyitzhakov5@pbs.org', 'dfg455', '28-Nov-2008', 'Male', 'United States', 'Mabyan', '6718674727', 'Somali', null, null, 'Shoping', null, null, 'Let''s Travel and Rock', 'yes');
insert into LocalGuides (first_name, last_name, email, password, dateOfBirth, gender, country, city, phoneNumber, language1, language2, language3, travelStyle1, travelStyle2, travelStyle3, about, mail) values ('Mitzi', 'Just', 'mjust6@networksolutions.com', 'zxd123', '01-Aug-2011', 'Male', 'Germany', 'Hongor', '3104123403', 'English', null, null, 'Entertaiment', null, null, 'Come and explore my beatiful country', 'no');
insert into LocalGuides (first_name, last_name, email, password, dateOfBirth, gender, country, city, phoneNumber, language1, language2, language3, travelStyle1, travelStyle2, travelStyle3, about, mail) values ('Zachery', 'Hizir', 'zhizir7@statcounter.com', 'qwe123', '31-Dec-2008', 'Female', 'Israel', 'Chuangwang', '8814172453', 'Persian', null, 'Georgian', 'Shoping', null, 'Hiking', 'Come and Travel with me', 'no');
insert into LocalGuides (first_name, last_name, email, password, dateOfBirth, gender, country, city, phoneNumber, language1, language2, language3, travelStyle1, travelStyle2, travelStyle3, about, mail) values ('Cal', 'Sevior', 'csevior8@narod.ru', 'qwe123', '02-Dec-1993', 'Male', 'United States', 'El Asintal', '4267055585', 'Quechua', 'Luxembourgish', null, 'Art', 'Nature', null, 'Come and explore my beatiful country', 'yes');
insert into LocalGuides (first_name, last_name, email, password, dateOfBirth, gender, country, city, phoneNumber, language1, language2, language3, travelStyle1, travelStyle2, travelStyle3, about, mail) values ('Konstantine', 'Scantleberry', 'kscantleberry9@hao123.com', 'zxd123', '23-Dec-2014', 'Female', 'United Kingdom', 'Donja Dubica', '4834481807', 'Greek', null, null, 'Sport', null, null, 'Come and explore my beatiful country', 'yes');
insert into LocalGuides (first_name, last_name, email, password, dateOfBirth, gender, country, city, phoneNumber, language1, language2, language3, travelStyle1, travelStyle2, travelStyle3, about, mail) values ('Freedman', 'Castilljo', 'fcastilljoa@house.gov', 'qwe123', '04-Sep-2000', 'Male', 'Germany', 'Ak’ordat', '2191322404', 'Swahili', 'Mongolian', 'Punjabi', 'Hiking', 'Entertaiment', 'Entertaiment', 'Let''s Travel and Rock', 'no');
insert into LocalGuides (first_name, last_name, email, password, dateOfBirth, gender, country, city, phoneNumber, language1, language2, language3, travelStyle1, travelStyle2, travelStyle3, about, mail) values ('Patsy', 'Tumber', 'ptumberb@hibu.com', 'asd345', '06-Nov-1971', 'Female', 'United Kingdom', 'Colonia Nicolich', '5866950940', 'Northern Sotho', null, null, 'Adventure', null, null, 'Let''s Travel and Rock', 'no');
insert into LocalGuides (first_name, last_name, email, password, dateOfBirth, gender, country, city, phoneNumber, language1, language2, language3, travelStyle1, travelStyle2, travelStyle3, about, mail) values ('Julio', 'Plain', 'jplainc@wikia.com', 'zxd123', '20-Dec-1964', 'Female', 'France', 'Orekhovo-Zuyevo', '3887489677', 'Greek', 'Telugu', null, 'Adventure', 'Art', null, 'Come and Travel with me', 'yes');
insert into LocalGuides (first_name, last_name, email, password, dateOfBirth, gender, country, city, phoneNumber, language1, language2, language3, travelStyle1, travelStyle2, travelStyle3, about, mail) values ('Quinlan', 'Icom', 'qicomd@noaa.gov', 'ewq789', '28-Mar-1998', 'Female', 'Israel', 'Bat Khela', '3713634744', 'Northern Sotho', null, 'Telugu', 'Entertaiment', null, 'Shoping', 'Come and explore my beatiful country', 'yes');
insert into LocalGuides (first_name, last_name, email, password, dateOfBirth, gender, country, city, phoneNumber, language1, language2, language3, travelStyle1, travelStyle2, travelStyle3, about, mail) values ('Gualterio', 'Bouchard', 'gboucharde@mysql.com', 'ewq789', '25-Apr-1944', 'Female', 'Israel', 'Laval', '6148678177', 'Norwegian', 'Albanian', 'Hungarian', 'Shoping', 'Local Culture', 'Hiking', 'Let''s Travel and Rock', 'no');
insert into LocalGuides (first_name, last_name, email, password, dateOfBirth, gender, country, city, phoneNumber, language1, language2, language3, travelStyle1, travelStyle2, travelStyle3, about, mail) values ('Jacqui', 'Spaldin', 'jspaldinf@imdb.com', 'ewq789', '07-Jun-1979', 'Female', 'Israel', 'Jinta', '5455824713', 'Northern Sotho', null, null, 'Art', null, null, 'Come and Travel with me', 'yes');
insert into LocalGuides (first_name, last_name, email, password, dateOfBirth, gender, country, city, phoneNumber, language1, language2, language3, travelStyle1, travelStyle2, travelStyle3, about, mail) values ('Elspeth', 'Spybey', 'espybeyg@cbsnews.com', 'fgd745', '01-Oct-1959', 'Male', 'United Kingdom', 'Terpsith?a', '3102336535', 'French', null, 'Dhivehi', 'Entertaiment', null, 'Nature', 'Let''s Travel and Rock', 'yes');
insert into LocalGuides (first_name, last_name, email, password, dateOfBirth, gender, country, city, phoneNumber, language1, language2, language3, travelStyle1, travelStyle2, travelStyle3, about, mail) values ('Liza', 'Eames', 'leamesh@istockphoto.com', 'ewq789', '02-Aug-1963', 'Male', 'United Kingdom', 'Guilherand-Granges', '3448616719', 'Bengali', 'Malayalam', 'Bulgarian', 'Nature', 'Shoping', 'Hiking', 'Come and explore my beatiful country', 'yes');
insert into LocalGuides (first_name, last_name, email, password, dateOfBirth, gender, country, city, phoneNumber, language1, language2, language3, travelStyle1, travelStyle2, travelStyle3, about, mail) values ('Inger', 'Fillgate', 'ifillgatei@ibm.com', 'zxd123', '29-Jan-2020', 'Male', 'Israel', 'Sampu?s', '1578343368', 'Romanian', null, 'Georgian', 'Art', null, 'Hiking', 'Come and Travel with me', 'no');
insert into LocalGuides (first_name, last_name, email, password, dateOfBirth, gender, country, city, phoneNumber, language1, language2, language3, travelStyle1, travelStyle2, travelStyle3, about, mail) values ('Garland', 'Breslane', 'gbreslanej@wordpress.com', 'zxd123', '31-Oct-2019', 'Female', 'Israel', 'Mosetse', '3269337907', 'Chinese', 'Indonesian', null, 'Adventure', 'Hiking', null, 'Come and explore my beatiful country', 'no');


drop table Reviews
create table Reviews (
	localGuide_email VARCHAR(50) not null ,
	date VARCHAR(50) not null,
	traveller_email VARCHAR(50) not null,
	city VARCHAR(50) not null,
	country VARCHAR(50) not null,
	reviewText VARCHAR(500) not null,
	rating VARCHAR(10)not null,
	foreign key (localGuide_email) References LocalGuides(email)
	);


insert into Reviews (localGuide_email, date, traveller_email, city, country,reviewText, rating) values ('xxx@gmail.com','03-Jan-2021','har@gmail.com','Haifa','Israel','Very Kind guide! warm and welcoming. Very recommended!',9.0);
insert into Reviews (localGuide_email, date, traveller_email, city, country,reviewText, rating) values ('xxx@gmail.com','03-Jan-2021','har@gmail.com','Hadera','Israel','Great Trip to the Electric Company Factory and Park Hadera! ',8.0);
insert into Reviews (localGuide_email, date, traveller_email, city, country,reviewText, rating) values ('fohlsen2@businessweek.com','07-Oct-2020','har@gmail.com','Paris','France','Great Trip to the city of lights! ',9.5);
insert into Reviews (localGuide_email, date, traveller_email, city, country,reviewText, rating) values ('gboucharde@mysql.com','30-Dec-2020','har@gmail.com','Laval','Israel','No Good! ',3.5);
insert into Reviews (localGuide_email, date, traveller_email, city, country,reviewText, rating) values ('gboucharde@mysql.com','03-Jan-2021','har@gmail.com','Laval','Israel','Great',6.5);
insert into Reviews (localGuide_email, date, traveller_email, city, country,reviewText, rating) values ('mswateridge3@qq.com','31-Dec-2020','har@gmail.com','Bromma','United States','Very Good Guide! Highly Recomended',9.0);


drop table Places
create table Places (
	localGuide_email VARCHAR(50) not null,
	place_name VARCHAR(50) not null,
	city VARCHAR(50) not null,
	country VARCHAR(50) not null,
	infoText VARCHAR(500) not null,
	foreign key (localGuide_email) References LocalGuides(email)
	);

insert into Places (localGuide_email, place_name,city, country,infoText) values ('xxx@gmail.com','Bahai Gardens','Haifa','Israel','Beatiful Gardens on Carmel!');
insert into Places (localGuide_email, place_name,city, country,infoText) values ('xxx@gmail.com','MTM HiTech Park','Haifa','Israel','Tour To MTM Hi-Tech Park');


drop table LocalGuideUnavailibleDates
create table LocalGuideUnavailibleDates (
	localGuide_email VARCHAR(50) not null,
	date VARCHAR(50) not null,
	foreign key (localGuide_email) References LocalGuides(email)
	);

insert into LocalGuideUnavailibleDates (localGuide_email, date) values ('xxx@gmail.com','14-Jan-2021');
insert into LocalGuideUnavailibleDates (localGuide_email, date) values ('xxx@gmail.com','19-Jan-2021');
insert into LocalGuideUnavailibleDates (localGuide_email, date) values ('xxx@gmail.com','21-Jan-2021');
insert into LocalGuideUnavailibleDates (localGuide_email, date) values ('gboucharde@mysql.com','22-Jan-2021');
