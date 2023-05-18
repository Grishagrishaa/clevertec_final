--liquibase formatted sql

--changeset grisha:1
INSERT INTO zerkalo.comments (uuid, created_date, updated_date, username, text, news_uuid, modified_by)
VALUES
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 0', 'e6dd4609-89e6-4fc6-b4b3-bda2f3a90607', 'BOSS'),
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

--changeset grisha:6
INSERT INTO zerkalo.comments (uuid, created_date, updated_date, username, text, news_uuid, modified_by)
VALUES
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 0', '5f516d7f-1f6f-475d-8c8b-ffeddcdb06e9', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 1', '5f516d7f-1f6f-475d-8c8b-ffeddcdb06e9', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 2', '5f516d7f-1f6f-475d-8c8b-ffeddcdb06e9', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 3', '5f516d7f-1f6f-475d-8c8b-ffeddcdb06e9', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 4', '5f516d7f-1f6f-475d-8c8b-ffeddcdb06e9', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 5', '5f516d7f-1f6f-475d-8c8b-ffeddcdb06e9', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 6', '5f516d7f-1f6f-475d-8c8b-ffeddcdb06e9', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 7', '5f516d7f-1f6f-475d-8c8b-ffeddcdb06e9', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 8', '5f516d7f-1f6f-475d-8c8b-ffeddcdb06e9', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 9', '5f516d7f-1f6f-475d-8c8b-ffeddcdb06e9', 'BOSS');

--changeset grisha:7
INSERT INTO zerkalo.comments (uuid, created_date, updated_date, username, text, news_uuid, modified_by)
VALUES
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 0', '9c9a013c-684c-4412-8e81-23f7640de215', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 1', '9c9a013c-684c-4412-8e81-23f7640de215', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 2', '9c9a013c-684c-4412-8e81-23f7640de215', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 3', '9c9a013c-684c-4412-8e81-23f7640de215', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 4', '9c9a013c-684c-4412-8e81-23f7640de215', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 5', '9c9a013c-684c-4412-8e81-23f7640de215', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 6', '9c9a013c-684c-4412-8e81-23f7640de215', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 7', '9c9a013c-684c-4412-8e81-23f7640de215', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 8', '9c9a013c-684c-4412-8e81-23f7640de215', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 9', '9c9a013c-684c-4412-8e81-23f7640de215', 'BOSS');

--changeset grisha:8
INSERT INTO zerkalo.comments (uuid, created_date, updated_date, username, text, news_uuid, modified_by)
VALUES
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 0', '88c59a09-1c6d-4633-85e5-7c25ddcf7d38', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 1', '88c59a09-1c6d-4633-85e5-7c25ddcf7d38', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 2', '88c59a09-1c6d-4633-85e5-7c25ddcf7d38', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 3', '88c59a09-1c6d-4633-85e5-7c25ddcf7d38', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 4', '88c59a09-1c6d-4633-85e5-7c25ddcf7d38', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 5', '88c59a09-1c6d-4633-85e5-7c25ddcf7d38', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 6', '88c59a09-1c6d-4633-85e5-7c25ddcf7d38', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 7', '88c59a09-1c6d-4633-85e5-7c25ddcf7d38', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 8', '88c59a09-1c6d-4633-85e5-7c25ddcf7d38', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 9', '88c59a09-1c6d-4633-85e5-7c25ddcf7d38', 'BOSS');

--changeset grisha:9
INSERT INTO zerkalo.comments (uuid, created_date, updated_date, username, text, news_uuid, modified_by)
VALUES
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 0', '9a480a19-1377-491d-98c3-315c4e4f9db3', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 1', '9a480a19-1377-491d-98c3-315c4e4f9db3', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 2', '9a480a19-1377-491d-98c3-315c4e4f9db3', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 3', '9a480a19-1377-491d-98c3-315c4e4f9db3', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 4', '9a480a19-1377-491d-98c3-315c4e4f9db3', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 5', '9a480a19-1377-491d-98c3-315c4e4f9db3', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 6', '9a480a19-1377-491d-98c3-315c4e4f9db3', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 7', '9a480a19-1377-491d-98c3-315c4e4f9db3', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 8', '9a480a19-1377-491d-98c3-315c4e4f9db3', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 9', '9a480a19-1377-491d-98c3-315c4e4f9db3', 'BOSS');

--changeset grisha:10
INSERT INTO zerkalo.comments (uuid, created_date, updated_date, username, text, news_uuid, modified_by)
VALUES
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 0', 'b54bb338-c9ba-4f22-a27a-3fca64f7cfe5', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 1', 'b54bb338-c9ba-4f22-a27a-3fca64f7cfe5', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 2', 'b54bb338-c9ba-4f22-a27a-3fca64f7cfe5', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 3', 'b54bb338-c9ba-4f22-a27a-3fca64f7cfe5', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 4', 'b54bb338-c9ba-4f22-a27a-3fca64f7cfe5', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 5', 'b54bb338-c9ba-4f22-a27a-3fca64f7cfe5', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 6', 'b54bb338-c9ba-4f22-a27a-3fca64f7cfe5', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 7', 'b54bb338-c9ba-4f22-a27a-3fca64f7cfe5', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 8', 'b54bb338-c9ba-4f22-a27a-3fca64f7cfe5', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 9', 'b54bb338-c9ba-4f22-a27a-3fca64f7cfe5', 'BOSS');

--changeset grisha:11
INSERT INTO zerkalo.comments (uuid, created_date, updated_date, username, text, news_uuid, modified_by)
VALUES
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 0', '57b3e33a-940f-44af-8a0e-cb4b69b99f1b', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 1', '57b3e33a-940f-44af-8a0e-cb4b69b99f1b', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 2', '57b3e33a-940f-44af-8a0e-cb4b69b99f1b', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 3', '57b3e33a-940f-44af-8a0e-cb4b69b99f1b', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 4', '57b3e33a-940f-44af-8a0e-cb4b69b99f1b', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 5', '57b3e33a-940f-44af-8a0e-cb4b69b99f1b', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 6', '57b3e33a-940f-44af-8a0e-cb4b69b99f1b', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 7', '57b3e33a-940f-44af-8a0e-cb4b69b99f1b', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 8', '57b3e33a-940f-44af-8a0e-cb4b69b99f1b', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 9', '57b3e33a-940f-44af-8a0e-cb4b69b99f1b', 'BOSS');

--changeset grisha:12
INSERT INTO zerkalo.comments (uuid, created_date, updated_date, username, text, news_uuid, modified_by)
VALUES
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 0', 'f72b1d6c-3a7d-4f52-8813-22ab096711e2', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 1', 'f72b1d6c-3a7d-4f52-8813-22ab096711e2', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 2', 'f72b1d6c-3a7d-4f52-8813-22ab096711e2', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 3', 'f72b1d6c-3a7d-4f52-8813-22ab096711e2', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 4', 'f72b1d6c-3a7d-4f52-8813-22ab096711e2', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 5', 'f72b1d6c-3a7d-4f52-8813-22ab096711e2', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 6', 'f72b1d6c-3a7d-4f52-8813-22ab096711e2', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 7', 'f72b1d6c-3a7d-4f52-8813-22ab096711e2', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 8', 'f72b1d6c-3a7d-4f52-8813-22ab096711e2', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 9', 'f72b1d6c-3a7d-4f52-8813-22ab096711e2', 'BOSS');

--changeset grisha:13
INSERT INTO zerkalo.comments (uuid, created_date, updated_date, username, text, news_uuid, modified_by)
VALUES
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 0', '0d9476f2-09d1-4a7f-a45d-62e9bcb49d6d', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 1', '0d9476f2-09d1-4a7f-a45d-62e9bcb49d6d', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 2', '0d9476f2-09d1-4a7f-a45d-62e9bcb49d6d', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 3', '0d9476f2-09d1-4a7f-a45d-62e9bcb49d6d', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 4', '0d9476f2-09d1-4a7f-a45d-62e9bcb49d6d', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 5', '0d9476f2-09d1-4a7f-a45d-62e9bcb49d6d', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 6', '0d9476f2-09d1-4a7f-a45d-62e9bcb49d6d', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 7', '0d9476f2-09d1-4a7f-a45d-62e9bcb49d6d', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 8', '0d9476f2-09d1-4a7f-a45d-62e9bcb49d6d', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 9', '0d9476f2-09d1-4a7f-a45d-62e9bcb49d6d', 'BOSS');

--changeset grisha:14
INSERT INTO zerkalo.comments (uuid, created_date, updated_date, username, text, news_uuid, modified_by)
VALUES
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 0', 'e15efab5-71f5-4605-ba9f-b7b6a8ba43ea', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 1', 'e15efab5-71f5-4605-ba9f-b7b6a8ba43ea', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 2', 'e15efab5-71f5-4605-ba9f-b7b6a8ba43ea', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 3', 'e15efab5-71f5-4605-ba9f-b7b6a8ba43ea', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 4', 'e15efab5-71f5-4605-ba9f-b7b6a8ba43ea', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 5', 'e15efab5-71f5-4605-ba9f-b7b6a8ba43ea', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 6', 'e15efab5-71f5-4605-ba9f-b7b6a8ba43ea', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 7', 'e15efab5-71f5-4605-ba9f-b7b6a8ba43ea', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 8', 'e15efab5-71f5-4605-ba9f-b7b6a8ba43ea', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 9', 'e15efab5-71f5-4605-ba9f-b7b6a8ba43ea', 'BOSS');

--changeset grisha:15
INSERT INTO zerkalo.comments (uuid, created_date, updated_date, username, text, news_uuid, modified_by)
VALUES
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 0', 'f61fb729-fd3c-4b20-bd1d-d42fc4b0b7e7', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 1', 'f61fb729-fd3c-4b20-bd1d-d42fc4b0b7e7', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 2', 'f61fb729-fd3c-4b20-bd1d-d42fc4b0b7e7', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 3', 'f61fb729-fd3c-4b20-bd1d-d42fc4b0b7e7', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 4', 'f61fb729-fd3c-4b20-bd1d-d42fc4b0b7e7', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 5', 'f61fb729-fd3c-4b20-bd1d-d42fc4b0b7e7', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 6', 'f61fb729-fd3c-4b20-bd1d-d42fc4b0b7e7', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 7', 'f61fb729-fd3c-4b20-bd1d-d42fc4b0b7e7', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 8', 'f61fb729-fd3c-4b20-bd1d-d42fc4b0b7e7', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 9', 'f61fb729-fd3c-4b20-bd1d-d42fc4b0b7e7', 'BOSS');

--changeset grisha:16
INSERT INTO zerkalo.comments (uuid, created_date, updated_date, username, text, news_uuid, modified_by)
VALUES
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 0', 'fbc16e0c-0ca4-40e5-86ab-181f5a6b7b33', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 1', 'fbc16e0c-0ca4-40e5-86ab-181f5a6b7b33', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 2', 'fbc16e0c-0ca4-40e5-86ab-181f5a6b7b33', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 3', 'fbc16e0c-0ca4-40e5-86ab-181f5a6b7b33', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 4', 'fbc16e0c-0ca4-40e5-86ab-181f5a6b7b33', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 5', 'fbc16e0c-0ca4-40e5-86ab-181f5a6b7b33', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 6', 'fbc16e0c-0ca4-40e5-86ab-181f5a6b7b33', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 7', 'fbc16e0c-0ca4-40e5-86ab-181f5a6b7b33', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 8', 'fbc16e0c-0ca4-40e5-86ab-181f5a6b7b33', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 9', 'fbc16e0c-0ca4-40e5-86ab-181f5a6b7b33', 'BOSS');

--changeset grisha:17
INSERT INTO zerkalo.comments (uuid, created_date, updated_date, username, text, news_uuid, modified_by)
VALUES
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 0', 'a575b46e-82d4-43bd-96ed-9a1c1dfdb6de', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 1', 'a575b46e-82d4-43bd-96ed-9a1c1dfdb6de', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 2', 'a575b46e-82d4-43bd-96ed-9a1c1dfdb6de', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 3', 'a575b46e-82d4-43bd-96ed-9a1c1dfdb6de', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 4', 'a575b46e-82d4-43bd-96ed-9a1c1dfdb6de', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 5', 'a575b46e-82d4-43bd-96ed-9a1c1dfdb6de', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 6', 'a575b46e-82d4-43bd-96ed-9a1c1dfdb6de', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 7', 'a575b46e-82d4-43bd-96ed-9a1c1dfdb6de', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 8', 'a575b46e-82d4-43bd-96ed-9a1c1dfdb6de', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 9', 'a575b46e-82d4-43bd-96ed-9a1c1dfdb6de', 'BOSS');

--changeset grisha:18
INSERT INTO zerkalo.comments (uuid, created_date, updated_date, username, text, news_uuid, modified_by)
VALUES
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 0', '49b1762f-5b93-49d5-9dfc-5b63d2b43775', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 1', '49b1762f-5b93-49d5-9dfc-5b63d2b43775', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 2', '49b1762f-5b93-49d5-9dfc-5b63d2b43775', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 3', '49b1762f-5b93-49d5-9dfc-5b63d2b43775', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 4', '49b1762f-5b93-49d5-9dfc-5b63d2b43775', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 5', '49b1762f-5b93-49d5-9dfc-5b63d2b43775', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 6', '49b1762f-5b93-49d5-9dfc-5b63d2b43775', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 7', '49b1762f-5b93-49d5-9dfc-5b63d2b43775', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 8', '49b1762f-5b93-49d5-9dfc-5b63d2b43775', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 9', '49b1762f-5b93-49d5-9dfc-5b63d2b43775', 'BOSS');

--changeset grisha:19
INSERT INTO zerkalo.comments (uuid, created_date, updated_date, username, text, news_uuid, modified_by)
VALUES
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 0', 'e56306de-eb97-4702-9680-ff3bcde93b87', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 1', 'e56306de-eb97-4702-9680-ff3bcde93b87', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 2', 'e56306de-eb97-4702-9680-ff3bcde93b87', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 3', 'e56306de-eb97-4702-9680-ff3bcde93b87', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 4', 'e56306de-eb97-4702-9680-ff3bcde93b87', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 5', 'e56306de-eb97-4702-9680-ff3bcde93b87', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 6', 'e56306de-eb97-4702-9680-ff3bcde93b87', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 7', 'e56306de-eb97-4702-9680-ff3bcde93b87', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 8', 'e56306de-eb97-4702-9680-ff3bcde93b87', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 9', 'e56306de-eb97-4702-9680-ff3bcde93b87', 'BOSS');

--changeset grisha:20
INSERT INTO zerkalo.comments (uuid, created_date, updated_date, username, text, news_uuid, modified_by)
VALUES
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 0', '4ffb7bac-f9b1-4150-be0e-9d7b434341e7', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 1', '4ffb7bac-f9b1-4150-be0e-9d7b434341e7', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 2', '4ffb7bac-f9b1-4150-be0e-9d7b434341e7', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 3', '4ffb7bac-f9b1-4150-be0e-9d7b434341e7', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 4', '4ffb7bac-f9b1-4150-be0e-9d7b434341e7', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 5', '4ffb7bac-f9b1-4150-be0e-9d7b434341e7', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 6', '4ffb7bac-f9b1-4150-be0e-9d7b434341e7', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 7', '4ffb7bac-f9b1-4150-be0e-9d7b434341e7', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 8', '4ffb7bac-f9b1-4150-be0e-9d7b434341e7', 'BOSS'),
    (uuid_generate_v4(), '2023-05-10 10:23:00', '2023-05-10 10:23:00', 'BOSS', 'Comment 9', '4ffb7bac-f9b1-4150-be0e-9d7b434341e7', 'BOSS');