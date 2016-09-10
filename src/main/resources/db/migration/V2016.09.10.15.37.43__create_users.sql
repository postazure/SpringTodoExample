CREATE TABLE IF NOT EXISTS users (
  id          bigserial NOT NULL PRIMARY KEY,
  username    text NOT NULL,
  created_at  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
);