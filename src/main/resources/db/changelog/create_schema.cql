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
                                     id UUID PRIMARY KEY,
                                     made_at timestamp,
                                     rate bigint,
                                     rate_on_previous_close bigint,
                                     symbol text
);