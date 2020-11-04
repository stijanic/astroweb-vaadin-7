#psql -h localhost -U postgres < 010-database.sql # run as postgres
psql -h localhost -U astro -W astro < 020-schema.sql
psql -h localhost -U astro -W astro < 110-country_location.sql
psql -h localhost -U astro -W astro < 210-person_account.sql
psql -h localhost -U astro -W astro < 310-celestial_aspect.sql
