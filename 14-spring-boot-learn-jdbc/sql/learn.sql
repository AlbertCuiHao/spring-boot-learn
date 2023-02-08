--
-- PostgreSQL database dump
--

-- Dumped from database version 13.4
-- Dumped by pg_dump version 13.4

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

ALTER TABLE IF EXISTS ONLY learn.demo_user DROP CONSTRAINT IF EXISTS user_pk;
DROP TABLE IF EXISTS learn.demo_user;
DROP SCHEMA IF EXISTS learn;
--
-- Name: learn; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA learn;


ALTER SCHEMA learn OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: demo_user; Type: TABLE; Schema: learn; Owner: postgres
--

CREATE TABLE learn.demo_user (
    id character varying(32) NOT NULL,
    user_name character varying(20) NOT NULL,
    user_age smallint,
    version_no smallint NOT NULL,
    create_time timestamp without time zone NOT NULL,
    create_by character varying(32) NOT NULL,
    update_time timestamp without time zone NOT NULL,
    update_by character varying(32) NOT NULL
);


ALTER TABLE learn.demo_user OWNER TO postgres;

--
-- Data for Name: demo_user; Type: TABLE DATA; Schema: learn; Owner: postgres
--

INSERT INTO learn.demo_user (id, user_name, user_age, version_no, create_time, create_by, update_time, update_by) VALUES ('1', 'albert', NULL, 1, '2022-04-20 11:58:27.528', 'SYSTEM', '2022-04-20 11:58:27.528', 'SYSTEM');
INSERT INTO learn.demo_user (id, user_name, user_age, version_no, create_time, create_by, update_time, update_by) VALUES ('2', 'ben', NULL, 1, '2022-04-20 11:58:27.528', 'SYSTEM', '2022-04-20 11:58:27.528', 'SYSTEM');


--
-- Name: demo_user user_pk; Type: CONSTRAINT; Schema: learn; Owner: postgres
--

ALTER TABLE ONLY learn.demo_user
    ADD CONSTRAINT user_pk PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

