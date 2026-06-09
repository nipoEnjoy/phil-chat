-- Добавить DEFAULT, если его нет
ALTER TABLE role ALTER COLUMN created_at SET DEFAULT CURRENT_TIMESTAMP;
ALTER TABLE role ALTER COLUMN updated_at SET DEFAULT CURRENT_TIMESTAMP;

-- Обновить существующие NULL значения (если они есть)
UPDATE role SET created_at = CURRENT_TIMESTAMP WHERE created_at IS NULL;
UPDATE role SET updated_at = CURRENT_TIMESTAMP WHERE updated_at IS NULL;

-- Аналогично для user_table
ALTER TABLE user_table ALTER COLUMN created_at SET DEFAULT CURRENT_TIMESTAMP;
ALTER TABLE user_table ALTER COLUMN updated_at SET DEFAULT CURRENT_TIMESTAMP;
UPDATE user_table SET created_at = CURRENT_TIMESTAMP WHERE created_at IS NULL;
UPDATE user_table SET updated_at = CURRENT_TIMESTAMP WHERE updated_at IS NULL;

-- Теперь вставка роли сработает, если она отсутствует
INSERT INTO role (name, description) VALUES
                                         ('USER', 'Обычный пользователь - только чтение'),
                                         ('ADMIN', 'Администратор – создание и редактирование');

-- Назначить роль пользователю (если ещё не назначена)
INSERT INTO user_roles (user_id, role_id)
SELECT u.id, r.id
FROM user_table u, role r
WHERE u.username = 'user1' AND r.name = 'USER'
ON CONFLICT DO NOTHING;