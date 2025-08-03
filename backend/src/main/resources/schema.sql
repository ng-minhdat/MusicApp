CREATE TABLE IF NOT EXISTS `genre` (
    `genre_id` INT AUTO_INCREMENT PRIMARY KEY,
    `genre_name` VARCHAR(40) NOT NULL,
    `created_at` DATE NOT NULL,
    `created_by` VARCHAR(40) NOT NULL,
    `updated_at` DATE DEFAULT NULL,
    `updated_by` VARCHAR(40) DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS `title` (
    `title_id` INT AUTO_INCREMENT PRIMARY KEY,
    `title` VARCHAR(255) NOT NULL,
    `year` INT NOT NULL,
    `genre_id` INT NOT NULL,
    `country` VARCHAR(40) NOT NULL,
    `created_at` DATE NOT NULL,
    `created_by` VARCHAR(40) NOT NULL,
    `updated_at` DATE DEFAULT NULL,
    `updated_by` VARCHAR(40) DEFAULT NULL,
    FOREIGN KEY (`genre_id`) REFERENCES genre(`genre_id`)
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
);

CREATE TABLE IF NOT EXISTS `artist` (
    `artist_id` INT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(40) NOT NULL,
    `date_of_birth` DATE NOT NULL,
    `country` VARCHAR(40) NOT NULL,
    `image_path` VARCHAR(400) DEFAULT NULL,
    `created_at` DATE NOT NULL,
    `created_by` VARCHAR(40) NOT NULL,
    `updated_at` DATE DEFAULT NULL,
    `updated_by` VARCHAR(40) DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS `song` (
    `song_id` INT AUTO_INCREMENT PRIMARY KEY,
    `title_id` INT NOT NULL,
    `release_date` DATE NOT NULL,
    `artist_id` INT NOT NULL,
    `length` INT NOT NULL,
    `user_id` INT NOT NULL,
    `path` VARCHAR(400) NOT NULL,
    `created_at` DATE NOT NULL,
    `created_by` VARCHAR(40) NOT NULL,
    `updated_at` DATE DEFAULT NULL,
    `updated_by` VARCHAR(40) DEFAULT NULL
);