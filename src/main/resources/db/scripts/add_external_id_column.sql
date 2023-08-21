BEGIN TRANSACTION;

    ALTER TABLE products
        ADD COLUMN external_id UUID DEFAULT uuid_generate_v4();

COMMIT;