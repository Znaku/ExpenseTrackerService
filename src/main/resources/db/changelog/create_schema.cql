-- Create the keyspace
CREATE KEYSPACE IF NOT EXISTS znaku_keyspace
    WITH replication = {
        'class': 'SimpleStrategy',
        'replication_factor': 3
        };

-- Switch to the keyspace
USE znaku_keyspace;

-- Create a table
CREATE TABLE IF NOT EXISTS conversion (
                                          made_at date,
                                          rate decimal,
                                          rate_on_previous_close decimal,
                                          symbol text,
                                          PRIMARY KEY(symbol, made_at)
) WITH CLUSTERING ORDER BY (made_at DESC);