create table if not exists "wallet" (
    id varchar primary key default uuid_generate_v4(),
    e_money integer,
    withdraw_limit integer,
    user_id varchar references "user"(id)
);

create index user_wallet_index on "wallet" (user_id);