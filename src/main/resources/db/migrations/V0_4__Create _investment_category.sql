create table if not exists "investment_category"(
  id varchar primary key default uuid_generate_v4(),
  label varchar,
  investment_id varchar references "investment"(id)
);