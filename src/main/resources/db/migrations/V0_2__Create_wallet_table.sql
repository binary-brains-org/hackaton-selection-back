create table if not exists "wallet" (
    id varchar primary key default uuid_generate_v4(),
    e_money integer,
    user_id varchar references "user"(id)
);