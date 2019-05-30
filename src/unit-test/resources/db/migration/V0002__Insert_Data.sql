insert into WORKER(booked) values (false );
insert into WORKER(booked) values (true);
insert into WORKER(booked) values (false);

insert into JOB(worker_id, start_datetime, end_datetime)
values(2, PARSEDATETIME('2019-06-01 7:00', 'yyyy-MM-dd hh:mm'), PARSEDATETIME('2019-06-03 19:00', 'yyyy-MM-dd hh:mm'));
insert into JOB(worker_id, start_datetime, end_datetime)
values(2, PARSEDATETIME('2019-06-04 7:00', 'yyyy-MM-dd hh:mm'), PARSEDATETIME('2019-06-06 19:00', 'yyyy-MM-dd hh:mm'));
