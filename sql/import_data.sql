COPY houses FROM STDIN WITH CSV HEADER DELIMITER ',' QUOTE '"'  NULL AS 'null';

COPY real_estate_announcements FROM STDIN WITH CSV HEADER DELIMITER ',' QUOTE '"' NULL AS 'null';