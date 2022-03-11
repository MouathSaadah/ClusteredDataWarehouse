# Bloomberg to analyze FX deals

Welcome this is the solution of small project that contain analyze FX deals by just one small requerment : One of customer stories is to accept deals details from and persist them into DB.

# Step Slotion
1- Creat DB
2- Start Task
3- Unit test

# 1- Creat DB
I used Postgres and for GUI design I used tool DataGrip

dawnload link  PostGris  : https://www.postgresql.org/download/
dawnload link DataGirp   : https://www.jetbrains.com/datagrip/?source=google&medium=cpc&campaign=15034927876&gclid=CjwKCAiAg6yRBhBNEiwAeVyL0PhY64sIdPLnQGPOSz5ENqiEcaA0uemQdB4h6dxNljRYYhvDjtfFzBoC8rUQAvD_BwE

I just create one table name is 'deal' and one sequance name is 'deal_id_sq'

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

alter table deal
    owner to postgres;

create unique index deal_id_uindex
    on deal (id);

deal_id_sq sequance :

create sequence deal_id_sq
    as integer
    minvalue 1001
    maxvalue 99999;

alter sequence deal_id_sq owner to postgres;

# 2-  Start Task

I used intilij IDE and I created three classes we have just one task => One of customer stories is to accept deals details from and persist them into DB.

# Main class : to add sample and make user interactive with system
# Deal class : it's cope form table deal with validation in eatch filed
# DBConnection class : to conection to db and it's contain any query or sql code in system

3-Unit test

I used JUnit 4 I tried to added some cases to finaly I see there is no method need unit test 
