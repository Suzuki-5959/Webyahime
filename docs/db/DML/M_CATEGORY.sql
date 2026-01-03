TRUNCATE TABLE m_category RESTART IDENTITY CASCADE;

INSERT INTO
    m_category (category_name)
VALUES
    ('ゲーム(スプラ)'),
    ('ゲーム(ゼルダ)'),
    ('雑談'),
    ('IT'),
    ('その他');