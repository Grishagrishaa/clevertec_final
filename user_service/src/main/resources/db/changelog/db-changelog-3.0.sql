--liquibase formatted sql

--changeset grisha:1
INSERT INTO signed.users (uuid, create_date, mail, nick, password, role, status, update_date)
VALUES ('2a983f1b-71c7-48de-958c-21425b70850b', '2022-03-11 15:30:00.000', 'test1@gmail.com', 'user1',
        '$2a$10$MWZjGkxtAony6nP3UaNXWuSkAlDRmkR75KoLc0Bjiu7iTXanelnqW', 'ADMIN', 'ACTIVATED', '2022-03-11 15:30:00.000'),
       ('e714e1af-4de5-4d25-a223-d23d635a4291', '2022-04-07 09:15:00.000', 'test2@gmail.com', 'user2',
        '$2a$10$7F.d.WXRXb8hxHJZ3LShk.1uWcG9QAbw4wbAGz7C4it8LEpCv5tJe', 'ADMIN', 'ACTIVATED', '2022-04-07 09:15:00.000'),
       ('d07d8d6c-9e10-4410-99ca-7710c39a4a32', '2022-05-25 12:45:00.000', 'test3@gmail.com', 'user3',
        '$2a$10$wYODnyL8WVxIF4eGnV1HIu2jbbZS52Mf3fDCfC5RCVwGkpmPrat.q', 'ADMIN', 'ACTIVATED', '2022-05-25 12:45:00.000'),
       ('09a1c6a3-02e5-45d9-a95d-5d50f26d2d5b', '2022-06-18 18:20:00.000', 'test4@gmail.com', 'user4',
        '$2a$10$xXmJymGdrbzDK4.oHL7K9ebX9q31Es7SYo0.K2t.5zlaN6bIUXpPu', 'ADMIN', 'ACTIVATED', '2022-06-18 18:20:00.000'),
       ('9c70cc9e-cb89-42db-87eb-5d5b3b94b232', '2022-07-13 10:10:00.000', 'test5@gmail.com', 'user5',
        '$2a$10$kZFlCnpESttKvY4eV1kYwuev5FTBop5KbIgNNN6zgRS5lUKM/O2WC', 'ADMIN', 'ACTIVATED', '2022-07-13 10:10:00.000'),
       ('9e4b609f-cbe1-4a4f-9a7b-51e4491618fb', '2022-09-03 16:30:00.000', 'test7@gmail.com', 'user6',
        '$2a$10$5jxQU7pIECjRwYltccG2suSdy5J19iy7H5sXFOFARrhmVXvR23gJq', 'USER', 'ACTIVATED', '2022-09-03 16:30:00.000'),
       ('c94b8a85-06f5-44a9-a41e-4e25e5c6feae', '2022-10-19 11:45:00.000', 'test8@gmail.com', 'user7',
        '$2a$10$tz9a0a2lTPMIzMXAIXKqcev8CZsIt7AAOOBAsB7cR9B3RQ15x4y1y', 'USER', 'ACTIVATED', '2022-10-19 11:45:00.000'),
       ('1b15f0d4-bb77-4dc2-bf8d-69b80a7a8486', '2022-11-24 09:15:00.000', 'test9@gmail.com', 'user8',
        '$2a$10$DwXwEWTU4D79c2i/Hue3IunlMfFjQVUMY0R/ZO.RT9Qh4xshDbR6.', 'USER', 'ACTIVATED', '2022-11-24 09:15:00.000'),
       ('cb023c2b-2f6f-4d9c-93b2-af6f11af23d1', '2022-12-30 13:00:00.000', 'test10@gmail.com', 'user9',
        '$2a$10$wDruyvWdGccq3P6bTmkg1ucR9XqfPpAT14tpJHKW32k0uH9a.OSS6', 'USER', 'ACTIVATED', '2022-12-30 13:00:00.000'),
        ('ea2e11af-51a5-4b4c-9a75-81547b3b0bc7', '2023-01-05 08:30:00.000', 'test11@gmail.com', 'user10',
        '$2a$10$hn6dHgQByh/NwIbhqtEwQuGbS/FQ8kg.NchqigxBtmxKq5L7FwFt6', 'USER', 'ACTIVATED', '2023-01-05 08:30:00.000');


