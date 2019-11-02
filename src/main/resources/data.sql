CREATE TABLE IF NOT EXISTS Todo (id IDENTITY  PRIMARY KEY, done BOOLEAN, text VARCHAR );
DELETE FROM Todo;
INSERT INTO Todo VALUES (1, true, 'prepare presentation');
INSERT INTO Todo VALUES (2, true, 'food shopping');
INSERT INTO Todo VALUES (3, true, 'examination preparation');