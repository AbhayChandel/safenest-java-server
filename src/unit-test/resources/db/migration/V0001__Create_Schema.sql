CREATE SEQUENCE worker_seq;

CREATE TABLE WORKER(
id BIGINT default worker_seq.nextval NOT NULL,
booked BOOLEAN DEFAULT false,
CONSTRAINT PK_Worker PRIMARY KEY(id)
);

CREATE SEQUENCE job_seq;

CREATE TABLE JOB(
id BIGINT default job_seq.nextval NOT NULL,
worker_id BIGINT,
start_datetime TIMESTAMP,
end_datetime TIMESTAMP,
CONSTRAINT PK_Job PRIMARY KEY(id)
);