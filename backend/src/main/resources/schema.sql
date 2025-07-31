CREATE TABLE IF NOT EXISTS `genre` (
    `genre_id` INT AUTO_INCREMENT PRIMARY KEY,
    `genre_name` VARCHAR(40) NOT NULL,
    `created_at` DATE NOT NULL,
    `created_by` VARCHAR(40) NOT NULL,
    `updated_at` DATE DEFAULT NULL,
    `updated_by` VARCHAR(40) DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS `user` (
    `user_id` INT AUTO_INCREMENT PRIMARY KEY,
    `username` VARCHAR(40) NOT NULL,
    `password` VARCHAR(255) NOT NULL,
    `status` INT NOT NULL,
    `avatar_path` VARCHAR(400) DEFAULT NULL,
    `created_at` DATE NOT NULL,
    `created_by` VARCHAR(40) NOT NULL,
    `updated_at` DATE DEFAULT NULL,
    `updated_by` VARCHAR(40) DEFAULT NULL
)