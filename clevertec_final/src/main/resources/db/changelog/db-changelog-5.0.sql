--liquibase formatted sql

--changeset grisha:1
INSERT INTO zerkalo.comments (uuid, created_date, updated_date, username, text, news_uuid, modified_by)
VALUES
    ('e7dd4609-89e6-4fc6-b4b3-bda2f3a90607', '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 0', 'e6dd4609-89e6-4fc6-b4b3-bda2f3a90607', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 1', 'e6dd4609-89e6-4fc6-b4b3-bda2f3a90607', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 2', 'e6dd4609-89e6-4fc6-b4b3-bda2f3a90607', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 3', 'e6dd4609-89e6-4fc6-b4b3-bda2f3a90607', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 4', 'e6dd4609-89e6-4fc6-b4b3-bda2f3a90607', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 5', 'e6dd4609-89e6-4fc6-b4b3-bda2f3a90607', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 6', 'e6dd4609-89e6-4fc6-b4b3-bda2f3a90607', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 7', 'e6dd4609-89e6-4fc6-b4b3-bda2f3a90607', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 8', 'e6dd4609-89e6-4fc6-b4b3-bda2f3a90607', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 9', 'e6dd4609-89e6-4fc6-b4b3-bda2f3a90607', 'BOSS');


--changeset grisha:2
INSERT INTO zerkalo.comments (uuid, created_date, updated_date, username, text, news_uuid, modified_by)
VALUES
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 0', 'fa77dc45-28ea-44f4-9962-5dabbaea3e4d', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 1', 'fa77dc45-28ea-44f4-9962-5dabbaea3e4d', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 2', 'fa77dc45-28ea-44f4-9962-5dabbaea3e4d', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 3', 'fa77dc45-28ea-44f4-9962-5dabbaea3e4d', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 4', 'fa77dc45-28ea-44f4-9962-5dabbaea3e4d', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 5', 'fa77dc45-28ea-44f4-9962-5dabbaea3e4d', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 6', 'fa77dc45-28ea-44f4-9962-5dabbaea3e4d', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 7', 'fa77dc45-28ea-44f4-9962-5dabbaea3e4d', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 8', 'fa77dc45-28ea-44f4-9962-5dabbaea3e4d', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 9', 'fa77dc45-28ea-44f4-9962-5dabbaea3e4d', 'BOSS');

--changeset grisha:3
INSERT INTO zerkalo.comments (uuid, created_date, updated_date, username, text, news_uuid, modified_by)
VALUES
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 0', '4aa5e7e8-14a4-4486-82b9-08fb87e61f8b', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 1', '4aa5e7e8-14a4-4486-82b9-08fb87e61f8b', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 2', '4aa5e7e8-14a4-4486-82b9-08fb87e61f8b', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 3', '4aa5e7e8-14a4-4486-82b9-08fb87e61f8b', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 4', '4aa5e7e8-14a4-4486-82b9-08fb87e61f8b', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 5', '4aa5e7e8-14a4-4486-82b9-08fb87e61f8b', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 6', '4aa5e7e8-14a4-4486-82b9-08fb87e61f8b', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 7', '4aa5e7e8-14a4-4486-82b9-08fb87e61f8b', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 8', '4aa5e7e8-14a4-4486-82b9-08fb87e61f8b', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 9', '4aa5e7e8-14a4-4486-82b9-08fb87e61f8b', 'BOSS');

--changeset grisha:4
INSERT INTO zerkalo.comments (uuid, created_date, updated_date, username, text, news_uuid, modified_by)
VALUES
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 0', '557dcda5-1b63-4f6f-90e9-03b4ec3d3c28', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 1', '557dcda5-1b63-4f6f-90e9-03b4ec3d3c28', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 2', '557dcda5-1b63-4f6f-90e9-03b4ec3d3c28', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 3', '557dcda5-1b63-4f6f-90e9-03b4ec3d3c28', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 4', '557dcda5-1b63-4f6f-90e9-03b4ec3d3c28', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 5', '557dcda5-1b63-4f6f-90e9-03b4ec3d3c28', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 6', '557dcda5-1b63-4f6f-90e9-03b4ec3d3c28', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 7', '557dcda5-1b63-4f6f-90e9-03b4ec3d3c28', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 8', '557dcda5-1b63-4f6f-90e9-03b4ec3d3c28', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 9', '557dcda5-1b63-4f6f-90e9-03b4ec3d3c28', 'BOSS');

--changeset grisha:5
INSERT INTO zerkalo.comments (uuid, created_date, updated_date, username, text, news_uuid, modified_by)
VALUES
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 0', '303d5c15-3d7e-484a-b5b2-8f94a70378a5', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 1', '303d5c15-3d7e-484a-b5b2-8f94a70378a5', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 2', '303d5c15-3d7e-484a-b5b2-8f94a70378a5', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 3', '303d5c15-3d7e-484a-b5b2-8f94a70378a5', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 4', '303d5c15-3d7e-484a-b5b2-8f94a70378a5', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 5', '303d5c15-3d7e-484a-b5b2-8f94a70378a5', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 6', '303d5c15-3d7e-484a-b5b2-8f94a70378a5', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 7', '303d5c15-3d7e-484a-b5b2-8f94a70378a5', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 8', '303d5c15-3d7e-484a-b5b2-8f94a70378a5', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 9', '303d5c15-3d7e-484a-b5b2-8f94a70378a5', 'BOSS');
