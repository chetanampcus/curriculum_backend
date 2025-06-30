--CREATE TABLE sites (
--    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
--
--    site_name VARCHAR(255) NOT NULL,
--
--    entity_id BIGINT NOT NULL,
--    CONSTRAINT fk_sites_entity
--        FOREIGN KEY (entity_id)
--        REFERENCES organizations(id)
--        ON DELETE CASCADE,
--
--    contact_name VARCHAR(255),
--    contact_city VARCHAR(100),
--    contact_state VARCHAR(100),
--    contact_phone VARCHAR(50),
--    contact_email VARCHAR(255),
--
--    address VARCHAR(255),
--    zip_code VARCHAR(20),
--
--    country_label VARCHAR(100),
--    country_value VARCHAR(100),
--    country_code VARCHAR(10),
--
--    timezone_label VARCHAR(100),
--    timezone_value VARCHAR(100),
--
--    start_time TIME,
--    end_time TIME,
--
--    is_deleted BOOLEAN DEFAULT FALSE
--);

CREATE TABLE sites (
  id UUID NOT NULL,
   site_name VARCHAR(255) NOT NULL,
   entity_id BIGINT NOT NULL,
   contact_name VARCHAR(255),
   contact_city VARCHAR(255),
   contact_state VARCHAR(255),
   contact_phone VARCHAR(255),
   contact_email VARCHAR(255),
   address VARCHAR(255),
   zip_code VARCHAR(255),
   start_time time WITHOUT TIME ZONE,
   end_time time WITHOUT TIME ZONE,
   is_deleted BOOLEAN,
   country_code VARCHAR(255),
   country_label VARCHAR(255),
   country_value VARCHAR(255),
   timezone_label VARCHAR(255),
   timezone_value VARCHAR(255),
   CONSTRAINT pk_sites PRIMARY KEY (id)
);

ALTER TABLE sites ADD CONSTRAINT FK_SITES_ON_ENTITY FOREIGN KEY (entity_id) REFERENCES organizations (id);
