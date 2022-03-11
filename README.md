# Bloomberg to analyze FX deals

Welcome, this is the solution of a small project that contains analyzing FX deals by just one small requirement: One of the customer stories is to accept deals and persist them into DB.

# Step Solution
1- Creat DB
2- Start Task
3- Unit test

# 1- Create DB
I used Postgres, and for GUI design, I used the tool DataGrip

download link  PostGris: https://www.postgresql.org/download/

download link DataGirp   : https://www.jetbrains.com/datagrip/?source=google&medium=cpc&campaign=15034927876&gclid=CjwKCAiAg6yRBhBNEiwAeVyL0PhY64sIdPLnQGPOSz5ENqiEcaA0uemQdB4h6dxNljRYYhvDjtfFzBoC8rUQAvD_BwE

I just created one table name, 'deal,' and one sequence name, ' deal_id_sq.'


![image](https://user-images.githubusercontent.com/39570598/157900052-7a2d7f7f-2332-4bcb-ba1b-4b8e99c0b132.png)






deal table :

create table deal
(
    id                integer    not null
    constraint deal_pk
    primary key,
    sender_currency   varchar(3) not null,
    receiver_currency varchar(3) not null,
    deal_date         timestamp  not null,
    amount            numeric    not null
);

alter table deal owner to Postgres;
create unique index deal_id_uindex on deal (id);

deal_id_sq sequance :

create sequence deal_id_sq
    as integer
    minvalue 1001
    maxvalue 99999;

alter sequence deal_id_sq owner to Postgres;

# 2-  Start Task

I used IntelliJ IDE, and I created three classes. We have just one task => One of the customer stories is to accept deals details from and persist them into DB.

 * Main class: to add sample and make user interaction with the system
 * Deal class: it's cope form table deal with validation in each field
 * DBConnection class: to connect to DB and it contains any query or SQL code in the system

# 3-Unit test

I used JUnit 4. I tried to add some cases to see that no method needs a unit test. 
