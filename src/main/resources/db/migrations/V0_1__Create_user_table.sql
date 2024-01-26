create extension if not exists "uuid-ossp";

do
$$
    begin
        if not exists(select from pg_type where typname='role') then
           create type "role" as enum ('CHILD', 'PARENT');
        end if;
        if not exists(select from pg_type where typname ='age_category') then
           create type "age_category" as enum ('KID', 'TEEN', 'ADULT');
        end if;
        if not exists(select from pg_type where typname = 'sex') then
           create type sex as enum ('M', 'F');
        end if;
    end
$$;

create table if not exists "user" (
  id varchar primary key default uuid_generate_v4(),
  firstname varchar,
  lastname varchar,
  birthdate date default null,
  role role,
  sex sex,
  age_category age_category,
  password varchar,
  age integer,
  image text,
  user_id varchar references "user"(id)
);