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

ALTER TABLE IF EXISTS ONLY learn.bank DROP CONSTRAINT IF EXISTS bank_pk;
DROP TABLE IF EXISTS learn.bank;
SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: bank; Type: TABLE; Schema: learn; Owner: postgres
--

CREATE TABLE learn.bank (
    id character varying NOT NULL,
    name character varying,
    account smallint
);


ALTER TABLE learn.bank OWNER TO postgres;

--
-- Data for Name: bank; Type: TABLE DATA; Schema: learn; Owner: postgres
--

INSERT INTO learn.bank (id, name, account) VALUES ('2', 'B', 530);
INSERT INTO learn.bank (id, name, account) VALUES ('1', 'A', 70);


--
-- Name: bank bank_pk; Type: CONSTRAINT; Schema: learn; Owner: postgres
--

ALTER TABLE ONLY learn.bank
    ADD CONSTRAINT bank_pk PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

