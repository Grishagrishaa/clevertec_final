--liquibase formatted sql

--changeset grisha:1
INSERT INTO signed.users (uuid, create_date, mail, nick, password, role, status, update_date)
VALUES  ('76601d1d-eded-474e-8d3f-bdff9ea0c177', '1111-11-11 11:11:11.000', 'ADMIN@gmail.com', 'BOSS',
        '$2a$10$NV5Uk.Xnl4WFDBfce04cYuLCldGuf5VubtgOcjfXD3bmjhlGPgH56','ADMIN', 'ACTIVATED', '1111-11-11 11:11:11.000'),
        ('84b25364-d220-42ae-b971-f1a4952aeef3', '1000-01-01 00:00:00.000', 'USER@gmail.com', 'USER',
        '$2a$10$NV5Uk.Xnl4WFDBfce04cYuLCldGuf5VubtgOcjfXD3bmjhlGPgH56', 'USER', 'ACTIVATED', '1000-01-01 00:00:00.000'),
        ('10251c42-0da7-4589-8ac6-10c91a7815e0', '1000-01-01 00:00:00.000', 'JOURNALIST@gmail.com', 'JOURNALIST',
        '$2a$10$NV5Uk.Xnl4WFDBfce04cYuLCldGuf5VubtgOcjfXD3bmjhlGPgH56', 'JOURNALIST', 'ACTIVATED', '1000-01-01 00:00:00.000');
