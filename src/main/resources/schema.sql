CREATE TABLE artist (
    id BIGSERIAL PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL CHECK (length(trim(first_name)) > 0),
    last_name VARCHAR(100),
    stage_name VARCHAR(100),
    contact_info VARCHAR(200),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE impresario (
    id BIGSERIAL PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL CHECK (length(trim(first_name)) > 0),
    last_name VARCHAR(100),
    organization VARCHAR(200),
    contact_info VARCHAR(200),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE genre (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE CHECK (length(trim(name)) > 0),
    description VARCHAR(500),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Venues tables (base for inheritance)
CREATE TABLE venue (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL CHECK (length(trim(name)) > 0),
    venue_type VARCHAR(50) NOT NULL CHECK (venue_type IN ('THEATRE', 'CONCERT_VENUE', 'VARIETY_STAGE', 'CULTURAL_CENTRE', 'CINEMA')),
    address VARCHAR(200),
    city VARCHAR(100),
    description VARCHAR(500),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE theatre (
    id BIGINT PRIMARY KEY REFERENCES venue(id) ON DELETE CASCADE,
    capacity INTEGER,
    stage_width_mm INTEGER,
    stage_depth_mm INTEGER
);

CREATE TABLE cinema (
    id BIGINT PRIMARY KEY REFERENCES venue(id) ON DELETE CASCADE,
    screen_width_mm INTEGER NOT NULL,
    screen_height_mm INTEGER NOT NULL,
    screen_diagonal_mm INTEGER,
    screen_aspect_ratio VARCHAR(50)
);

CREATE TABLE concert_venue (
    id BIGINT PRIMARY KEY REFERENCES venue(id) ON DELETE CASCADE,
    stage_type VARCHAR(100),
    has_sound_system BOOLEAN
);

CREATE TABLE variety_stage (
    id BIGINT PRIMARY KEY REFERENCES venue(id) ON DELETE CASCADE,
    genre_focus VARCHAR(100)
);

CREATE TABLE cultural_centre (
    id BIGINT PRIMARY KEY REFERENCES venue(id) ON DELETE CASCADE,
    community_rooms_count INTEGER
);

CREATE TABLE organizer (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL CHECK (length(trim(name)) > 0),
    contact_info VARCHAR(200),
    type VARCHAR(50),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE event (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(200) NOT NULL CHECK (length(trim(title)) > 0),
    event_type VARCHAR(50) CHECK (event_type IN ('CONCERT', 'SOLO', 'COMPETITION', 'FESTIVAL', 'OTHER')),
    venue_id BIGINT NOT NULL REFERENCES venue(id) ON DELETE CASCADE,
    organizer_id BIGINT REFERENCES organizer(id) ON DELETE SET NULL,
    start_datetime TIMESTAMP NOT NULL,
    end_datetime TIMESTAMP,
    description VARCHAR(1000),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE competition_result (
    id BIGSERIAL PRIMARY KEY,
    competition_id BIGINT NOT NULL REFERENCES competition(id) ON DELETE CASCADE,
    artist_id BIGINT NOT NULL REFERENCES artist(id) ON DELETE CASCADE,
    place INTEGER,
    award VARCHAR(200),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    UNIQUE (competition_id, artist_id)
);

-- Users for authentification
CREATE TABLE user_table (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE CHECK (length(trim(username)) > 0),
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100),
    enabled BOOLEAN NOT NULL DEFAULT TRUE,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE user_roles (
    user_id BIGINT NOT NULL REFERENCES user_table(id) ON DELETE CASCADE,
    role VARCHAR(50) NOT NULL CHECK (role IN ('USER', 'ADMIN', 'SUPERADMIN')),
    PRIMARY KEY (user_id, role)
);

-- Link tables --

CREATE TABLE artist_genre (
    id BIGSERIAL PRIMARY KEY,
    artist_id BIGINT NOT NULL REFERENCES artist(id) ON DELETE CASCADE,
    genre_id BIGINT NOT NULL REFERENCES genre(id) ON DELETE CASCADE,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    UNIQUE (artist_id, genre_id)
);

CREATE TABLE artist_impresario (
    id BIGSERIAL PRIMARY KEY,
    artist_id BIGINT NOT NULL REFERENCES artist(id) ON DELETE CASCADE,
    impresario_id BIGINT NOT NULL REFERENCES impresario(id) ON DELETE CASCADE,
    start_date DATE,
    end_date DATE,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    UNIQUE (artist_id, impresario_id, start_date)
);

CREATE TABLE event_artist (
    id BIGSERIAL PRIMARY KEY,
    event_id BIGINT NOT NULL REFERENCES event(id) ON DELETE CASCADE,
    artist_id BIGINT NOT NULL REFERENCES artist(id) ON DELETE CASCADE,
    role VARCHAR(100),
    primary_performance BOOLEAN,
    fee DECIMAL(10,2),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    UNIQUE (event_id, artist_id)
);

CREATE TABLE competition (
    id BIGSERIAL PRIMARY KEY,
    event_id BIGINT NOT NULL UNIQUE REFERENCES event(id) ON DELETE CASCADE,
    competition_type VARCHAR(100),
    rules VARCHAR(1000),
    jury_info VARCHAR(500),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Triggers --

CREATE OR REPLACE FUNCTION set_created_at_column()
RETURNS TRIGGER AS $$
BEGIN
    NEW.created_at = NOW();
    NEW.updated_at = NOW();
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION update_updated_at_column()
RETURNS TRIGGER AS $$
BEGIN
    IF NEW.created_at IS NULL THEN
        NEW.created_at = OLD.created_at;
    END IF;
    NEW.updated_at = CURRENT_TIMESTAMP;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Triggers to set created_at time

CREATE TRIGGER update_artist_updated_at BEFORE INSERT ON artist FOR EACH ROW EXECUTE FUNCTION set_created_at_column();
CREATE TRIGGER update_impresario_updated_at BEFORE INSERT ON impresario FOR EACH ROW EXECUTE FUNCTION set_created_at_column();
CREATE TRIGGER update_genre_updated_at BEFORE INSERT ON genre FOR EACH ROW EXECUTE FUNCTION set_created_at_column();
CREATE TRIGGER update_artist_genre_updated_at BEFORE INSERT ON artist_genre FOR EACH ROW EXECUTE FUNCTION set_created_at_column();
CREATE TRIGGER update_artist_impresario_updated_at BEFORE INSERT ON artist_impresario FOR EACH ROW EXECUTE FUNCTION set_created_at_column();
CREATE TRIGGER update_venue_updated_at BEFORE INSERT ON venue FOR EACH ROW EXECUTE FUNCTION set_created_at_column();
CREATE TRIGGER update_organizer_updated_at BEFORE INSERT ON organizer FOR EACH ROW EXECUTE FUNCTION set_created_at_column();
CREATE TRIGGER update_event_updated_at BEFORE INSERT ON event FOR EACH ROW EXECUTE FUNCTION set_created_at_column();
CREATE TRIGGER update_event_artist_updated_at BEFORE INSERT ON event_artist FOR EACH ROW EXECUTE FUNCTION set_created_at_column();
CREATE TRIGGER update_competition_updated_at BEFORE INSERT ON competition FOR EACH ROW EXECUTE FUNCTION set_created_at_column();
CREATE TRIGGER update_competition_result_updated_at BEFORE INSERT ON competition_result FOR EACH ROW EXECUTE FUNCTION set_created_at_column();
CREATE TRIGGER update_user_updated_at BEFORE INSERT ON user_table FOR EACH ROW EXECUTE FUNCTION set_created_at_column();

-- Triggers to update updated_at time

CREATE TRIGGER update_artist_updated_at BEFORE UPDATE ON artist FOR EACH ROW EXECUTE FUNCTION update_updated_at_column();
CREATE TRIGGER update_impresario_updated_at BEFORE UPDATE ON impresario FOR EACH ROW EXECUTE FUNCTION update_updated_at_column();
CREATE TRIGGER update_genre_updated_at BEFORE UPDATE ON genre FOR EACH ROW EXECUTE FUNCTION update_updated_at_column();
CREATE TRIGGER update_artist_genre_updated_at BEFORE UPDATE ON artist_genre FOR EACH ROW EXECUTE FUNCTION update_updated_at_column();
CREATE TRIGGER update_artist_impresario_updated_at BEFORE UPDATE ON artist_impresario FOR EACH ROW EXECUTE FUNCTION update_updated_at_column();
CREATE TRIGGER update_venue_updated_at BEFORE UPDATE ON venue FOR EACH ROW EXECUTE FUNCTION update_updated_at_column();
CREATE TRIGGER update_organizer_updated_at BEFORE UPDATE ON organizer FOR EACH ROW EXECUTE FUNCTION update_updated_at_column();
CREATE TRIGGER update_event_updated_at BEFORE UPDATE ON event FOR EACH ROW EXECUTE FUNCTION update_updated_at_column();
CREATE TRIGGER update_event_artist_updated_at BEFORE UPDATE ON event_artist FOR EACH ROW EXECUTE FUNCTION update_updated_at_column();
CREATE TRIGGER update_competition_updated_at BEFORE UPDATE ON competition FOR EACH ROW EXECUTE FUNCTION update_updated_at_column();
CREATE TRIGGER update_competition_result_updated_at BEFORE UPDATE ON competition_result FOR EACH ROW EXECUTE FUNCTION update_updated_at_column();
CREATE TRIGGER update_user_updated_at BEFORE UPDATE ON user_table FOR EACH ROW EXECUTE FUNCTION update_updated_at_column();