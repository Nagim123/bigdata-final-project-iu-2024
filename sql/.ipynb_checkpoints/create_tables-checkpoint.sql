START TRANSACTION;

CREATE TABLE IF NOT EXISTS houses (
    house_id INTEGER NOT NULL PRIMARY KEY,
    id_region SMALLINT,
    street_id INTEGER,
    postal_code INTEGER,
    building_type SMALLINT,
    geo_lon FLOAT,
    geo_lat FLOAT,
    object_type SMALLINT
);

CREATE TABLE IF NOT EXISTS real_estate_announcements (
    announcement_id INTEGER NOT NULL PRIMARY KEY,
    publication_date DATE NOT NULL,
    price BIGINT NOT NULL,
    level SMALLINT,
    levels SMALLINT,
    rooms SMALLINT,
    area DECIMAL(3, 2),
    kitchen_area DECIMAL(3, 2),
    house_id INTEGER NOT NULL
);

ALTER TABLE real_estate_announcements DROP CONSTRAINT IF EXISTS fk_real_estate_announcements_house_id_houses;

ALTER TABLE real_estate_announcements ADD CONSTRAINT fk_real_estate_announcements_house_id_houses FOREIGN KEY(house_id) REFERENCES houses (house_id);

-- This is related to how the date types are stored in my dataset
ALTER DATABASE team14_projectdb SET datestyle TO iso, ymd;


COMMIT;