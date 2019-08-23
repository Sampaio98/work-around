create table address (id  bigserial not null, name varchar(255), number varchar(255), observation varchar(255), reference varchar(255), city_id int8, primary key (id));

create table city (id  bigserial not null, name varchar(255), state_id int8, primary key (id));

create table party (id  bigserial not null, date timestamp, description varchar(255), name varchar(120), price numeric(19, 2), address_id int8, primary key (id));

create table person (id  bigserial not null, email varchar(255), name varchar(120), primary key (id));

create table person_cellphone (person_id int8 not null, cellphone varchar(255));

create table person_party (person_fk int8 not null, party_fk int8 not null);

create table state (id  bigserial not null, initials varchar(255), name varchar(255), primary key (id));

alter table if exists party add constraint UK_92p5dyus9h57gsn60r1yra8bc unique (name);

alter table if exists person add constraint UK_fwmwi44u55bo4rvwsv0cln012 unique (email);

alter table if exists person_cellphone add constraint UK_q8f6d672sjwys7tvk0j9y0tfo unique (cellphone);

alter table if exists address add constraint FKpo044ng5x4gynb291cv24vtea foreign key (city_id) references city;

alter table if exists city add constraint FK6p2u50v8fg2y0js6djc6xanit foreign key (state_id) references state;

alter table if exists party add constraint FKr3xd5httl0gqasj69pcxv5lf7 foreign key (address_id) references address;

alter table if exists person_cellphone add constraint FKc70ha75lmmqr4v17y75kg8lwr foreign key (person_id) references person;

alter table if exists person_party add constraint FK3twxblr3o21j5rh7uika40oq3 foreign key (party_fk) references party;

alter table if exists person_party add constraint FK24n79lwqrjjmnjf8p9pvmyydi foreign key (person_fk) references person;