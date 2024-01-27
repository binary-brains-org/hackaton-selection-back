do
$$
    begin
        if not exists(select from pg_type where typname='status') then
            create type status as enum ('ENABLE', 'DENIED');
        end if;
    end
$$;

create table if not exists "investment"(
  id varchar primary key default uuid_generate_v4(),
  comment varchar,
  status status default 'DENIED',
  price integer,
  image text,
  user_id varchar references "user"(id)
);