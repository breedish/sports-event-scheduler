CREATE SEQUENCE ses_sequence
INCREMENT BY 10;

CREATE TABLE ses_event
(
  id          BIGINT       NOT NULL
    CONSTRAINT ses_event_pkey
    PRIMARY KEY,
  created     TIMESTAMP,
  updated     TIMESTAMP,
  version     INTEGER      NOT NULL,
  name        VARCHAR(255) NOT NULL
    CONSTRAINT uk_jv10kklihsh3x8vtunygmhlme
    UNIQUE,
  sports_type VARCHAR(255) NOT NULL,
  location_id BIGINT       NOT NULL
);

CREATE TABLE ses_event_play_admins
(
  event_id  BIGINT NOT NULL
    CONSTRAINT fkp59xh5egmqw8t65e4wq8k6fn1
    REFERENCES ses_event,
  player_id BIGINT NOT NULL,
  CONSTRAINT ses_event_play_admins_pkey
  PRIMARY KEY (event_id, player_id)
);

CREATE TABLE ses_event_play
(
  id      BIGINT  NOT NULL
    CONSTRAINT ses_event_play_pkey
    PRIMARY KEY,
  created TIMESTAMP,
  updated TIMESTAMP,
  version INTEGER NOT NULL,
  closed  TIMESTAMP,
  started TIMESTAMP
);

CREATE TABLE ses_event_player
(
  optional BOOLEAN NOT NULL,
  event    BIGINT  NOT NULL
    CONSTRAINT fka3r81t0bu6sode0gv36uto5co
    REFERENCES ses_event,
  player   BIGINT  NOT NULL,
  CONSTRAINT ses_event_player_pkey
  PRIMARY KEY (event, player)
);

CREATE TABLE ses_location
(
  id        BIGINT           NOT NULL
    CONSTRAINT ses_location_pkey
    PRIMARY KEY,
  created   TIMESTAMP,
  updated   TIMESTAMP,
  version   INTEGER          NOT NULL,
  address   VARCHAR(255),
  building  VARCHAR(255),
  city      VARCHAR(255),
  street    VARCHAR(255),
  latitude  DOUBLE PRECISION NOT NULL,
  longitude DOUBLE PRECISION NOT NULL,
  name      VARCHAR(255)     NOT NULL
    CONSTRAINT uk_ctbit8emc6t48tm7b2rfckti7
    UNIQUE,
  phone     VARCHAR(255)
    CONSTRAINT uk_34cbatqy04h48xu96afarslk2
    UNIQUE
);

ALTER TABLE ses_event
  ADD CONSTRAINT fkfswumxerhwtoiy492inhgxdn5
FOREIGN KEY (location_id) REFERENCES ses_location;

CREATE TABLE ses_player
(
  id         BIGINT       NOT NULL
    CONSTRAINT ses_player_pkey
    PRIMARY KEY,
  created    TIMESTAMP,
  updated    TIMESTAMP,
  version    INTEGER      NOT NULL,
  email      VARCHAR(255) NOT NULL
    CONSTRAINT uk_ot8kippejph77fws4k6tgmikt
    UNIQUE,
  first_name VARCHAR(255) NOT NULL,
  last_name  VARCHAR(255),
  name       VARCHAR(255) NOT NULL
    CONSTRAINT uk_d898xd8bgivkg7979gvifrnf3
    UNIQUE,
  phone      VARCHAR(255) NOT NULL
    CONSTRAINT uk_bwpj7ibwysyyrp3u4d5b64kpm
    UNIQUE
);

ALTER TABLE ses_event_play_admins
  ADD CONSTRAINT fk6j57wuylhm7canmi3epujxc3q
FOREIGN KEY (player_id) REFERENCES ses_player;

ALTER TABLE ses_event_player
  ADD CONSTRAINT fkgd1xfh8egnr2qhjr3knewe8j3
FOREIGN KEY (player) REFERENCES ses_player;

