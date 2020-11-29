-- sudo mkdir $HOME/tmp/astro
-- sudo chown postgres.postgres $HOME/tmp/astro
-- export ASTRO_HOME=$HOME/tmp/astro
\set location `echo "$ASTRO_HOME"`
\echo 'ASTRO_HOME:' :'location'

--DROP SCHEMA IF EXISTS astro;
DROP DATABASE IF EXISTS astro;
DROP ROLE IF EXISTS astro;
DROP TABLESPACE IF EXISTS astro;

CREATE TABLESPACE astro
  OWNER postgres
  LOCATION :'location';

CREATE ROLE astro LOGIN
  ENCRYPTED PASSWORD 'md585883cb34cfffe54c09472e18508dfad'
  NOSUPERUSER NOINHERIT NOCREATEDB NOCREATEROLE NOREPLICATION;

CREATE DATABASE astro
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = astro
       LC_COLLATE = 'en_US.UTF-8'
       LC_CTYPE = 'en_US.UTF-8'
       CONNECTION LIMIT = -1;

\connect astro
CREATE SCHEMA astro
  AUTHORIZATION astro;

GRANT ALL ON SCHEMA astro TO astro;

CREATE EXTENSION IF NOT EXISTS pgcrypto;
CREATE EXTENSION IF NOT EXISTS adminpack;
