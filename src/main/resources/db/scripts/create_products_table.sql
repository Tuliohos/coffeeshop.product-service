BEGIN TRANSACTION;

    CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

    CREATE TABLE products (
        id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
        name VARCHAR(255) NOT NULL,
        calories INT,
        description TEXT,
        price DECIMAL(10, 2),
        type VARCHAR(20),
        is_vegan BOOLEAN,
        is_gluten_free BOOLEAN,
        image_url VARCHAR(255),
        created_at TIMESTAMPTZ DEFAULT current_timestamp,
        updated_at TIMESTAMPTZ DEFAULT current_timestamp
    );

COMMIT;