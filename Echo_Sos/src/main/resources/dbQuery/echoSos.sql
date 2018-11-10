--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.12
-- Dumped by pg_dump version 9.5.12

-- Started on 2018-05-18 20:12:18 WAT

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12403)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2194 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = true;

--
-- TOC entry 183 (class 1259 OID 57439)
-- Name: account; Type: TABLE; Schema: public; Owner: root
--

CREATE TABLE public.account (
    login text,
    status text,
    pwd text,
    name text,
    "firstName" text,
    phone text,
    town text,
    image text,
    sex text,
    id_person integer NOT NULL
);


ALTER TABLE public.account OWNER TO root;

--
-- TOC entry 187 (class 1259 OID 57533)
-- Name: account_id_person_seq; Type: SEQUENCE; Schema: public; Owner: root
--

CREATE SEQUENCE public.account_id_person_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.account_id_person_seq OWNER TO root;

--
-- TOC entry 2195 (class 0 OID 0)
-- Dependencies: 187
-- Name: account_id_person_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: root
--

ALTER SEQUENCE public.account_id_person_seq OWNED BY public.account.id_person;


SET default_with_oids = false;

--
-- TOC entry 182 (class 1259 OID 57388)
-- Name: children; Type: TABLE; Schema: public; Owner: root
--

CREATE TABLE public.children (
    id_person integer,
    infochildren text
);


ALTER TABLE public.children OWNER TO root;

SET default_with_oids = true;

--
-- TOC entry 184 (class 1259 OID 57447)
-- Name: message; Type: TABLE; Schema: public; Owner: root
--

CREATE TABLE public.message (
    id_message integer NOT NULL,
    "date_ sended" date NOT NULL,
    date_received date NOT NULL,
    message text
);


ALTER TABLE public.message OWNER TO root;

--
-- TOC entry 185 (class 1259 OID 57456)
-- Name: consult_message; Type: TABLE; Schema: public; Owner: root
--

CREATE TABLE public.consult_message (
    id_consult_message integer NOT NULL
)
INHERITS (public.account, public.message);


ALTER TABLE public.consult_message OWNER TO root;

--
-- TOC entry 181 (class 1259 OID 57363)
-- Name: person; Type: TABLE; Schema: public; Owner: root
--

CREATE TABLE public.person (
    id_person integer NOT NULL,
    name text,
    firstname text,
    phone integer,
    town text,
    sex character varying(5),
    image text
);


ALTER TABLE public.person OWNER TO root;

--
-- TOC entry 186 (class 1259 OID 57497)
-- Name: rubric; Type: TABLE; Schema: public; Owner: root
--

CREATE TABLE public.rubric (
    id_rubric integer NOT NULL,
    title text,
    content text
);


ALTER TABLE public.rubric OWNER TO root;

--
-- TOC entry 2053 (class 2604 OID 57535)
-- Name: id_person; Type: DEFAULT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.account ALTER COLUMN id_person SET DEFAULT nextval('public.account_id_person_seq'::regclass);


--
-- TOC entry 2054 (class 2604 OID 57536)
-- Name: id_person; Type: DEFAULT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.consult_message ALTER COLUMN id_person SET DEFAULT nextval('public.account_id_person_seq'::regclass);


--
-- TOC entry 2183 (class 0 OID 57439)
-- Dependencies: 183
-- Data for Name: account; Type: TABLE DATA; Schema: public; Owner: root
--



--
-- TOC entry 2196 (class 0 OID 0)
-- Dependencies: 187
-- Name: account_id_person_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('public.account_id_person_seq', 1, false);


--
-- TOC entry 2182 (class 0 OID 57388)
-- Dependencies: 182
-- Data for Name: children; Type: TABLE DATA; Schema: public; Owner: root
--



--
-- TOC entry 2185 (class 0 OID 57456)
-- Dependencies: 185
-- Data for Name: consult_message; Type: TABLE DATA; Schema: public; Owner: root
--



--
-- TOC entry 2184 (class 0 OID 57447)
-- Dependencies: 184
-- Data for Name: message; Type: TABLE DATA; Schema: public; Owner: root
--



--
-- TOC entry 2181 (class 0 OID 57363)
-- Dependencies: 181
-- Data for Name: person; Type: TABLE DATA; Schema: public; Owner: root
--



--
-- TOC entry 2186 (class 0 OID 57497)
-- Dependencies: 186
-- Data for Name: rubric; Type: TABLE DATA; Schema: public; Owner: root
--



--
-- TOC entry 2058 (class 2606 OID 57551)
-- Name: account_pkey; Type: CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.account
    ADD CONSTRAINT account_pkey PRIMARY KEY (id_person);


--
-- TOC entry 2062 (class 2606 OID 57463)
-- Name: consult_message_pkey; Type: CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.consult_message
    ADD CONSTRAINT consult_message_pkey PRIMARY KEY (id_consult_message);


--
-- TOC entry 2060 (class 2606 OID 57454)
-- Name: message_pkey; Type: CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.message
    ADD CONSTRAINT message_pkey PRIMARY KEY (id_message);


--
-- TOC entry 2056 (class 2606 OID 57367)
-- Name: person_pkey; Type: CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.person
    ADD CONSTRAINT person_pkey PRIMARY KEY (id_person);


--
-- TOC entry 2064 (class 2606 OID 57504)
-- Name: rubric_pkey; Type: CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.rubric
    ADD CONSTRAINT rubric_pkey PRIMARY KEY (id_rubric);


--
-- TOC entry 2065 (class 2606 OID 57396)
-- Name: children_id_person_fkey; Type: FK CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.children
    ADD CONSTRAINT children_id_person_fkey FOREIGN KEY (id_person) REFERENCES public.person(id_person);


--
-- TOC entry 2066 (class 2606 OID 57469)
-- Name: consult_message_id_message_fkey; Type: FK CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.consult_message
    ADD CONSTRAINT consult_message_id_message_fkey FOREIGN KEY (id_message) REFERENCES public.message(id_message);


-- Completed on 2018-05-18 20:12:19 WAT

--
-- PostgreSQL database dump complete
--
