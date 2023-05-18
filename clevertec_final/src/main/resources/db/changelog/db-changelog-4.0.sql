--liquibase formatted sql

--changeset grisha:1
INSERT INTO zerkalo.news (uuid, created_date, updated_date, text, title, username, modified_by)
VALUES
    ('e6dd4609-89e6-4fc6-b4b3-bda2f3a90607', '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'Sample desc0', 'News 0', 'BOSS', 'BOSS'),
    ('fa77dc45-28ea-44f4-9962-5dabbaea3e4d', '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'Sample desc1', 'News 1', 'BOSS', 'BOSS'),
    ('4aa5e7e8-14a4-4486-82b9-08fb87e61f8b', '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'Sample desc2', 'News 2', 'BOSS', 'BOSS'),
    ('557dcda5-1b63-4f6f-90e9-03b4ec3d3c28', '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'Sample desc3', 'News 3', 'BOSS', 'BOSS'),
    ('303d5c15-3d7e-484a-b5b2-8f94a70378a5', '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'Sample desc4', 'News 4', 'BOSS', 'BOSS');