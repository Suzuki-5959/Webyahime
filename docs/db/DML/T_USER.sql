TRUNCATE TABLE t_user CASCADE;

INSERT INTO
    t_user (user_id, password, user_name)
VALUES
    (
        '13bb9ce1-3353-4f90-a200-e81707a69fa6',
        'dummy_pass',
        'dummy_name'
    ),
    (
        '305d561f-1896-4a6a-90e5-deaa2737f2b6',
        'dummy_pass',
        'dummy_name'
    ),
    (
        '416bf112-7d32-4abd-b8aa-8b10cebc838e',
        'dummy_pass',
        'dummy_name'
    );