--CREATE TABLE classrooms (
--    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
--
--    classroom_name VARCHAR(255) NOT NULL,
--
--    entity_id BIGINT NOT NULL,
--    CONSTRAINT fk_classroom_entity
--        FOREIGN KEY (entity_id)
--        REFERENCES organizations(id)
--        ON DELETE CASCADE,
--
--    site_id UUID NOT NULL,
--    CONSTRAINT fk_classroom_site
--        FOREIGN KEY (site_id)
--        REFERENCES sites(id)
--        ON DELETE CASCADE,
--
--    curriculum_type VARCHAR(100) NOT NULL,
--
--    is_deleted BOOLEAN DEFAULT FALSE
--);
CREATE TABLE classrooms (
  id UUID NOT NULL,
   classroom_name VARCHAR(255) NOT NULL,
   entity_id BIGINT NOT NULL,
   site_id UUID NOT NULL,
   curriculum_type VARCHAR(255) NOT NULL,
   is_deleted BOOLEAN,
   CONSTRAINT pk_classrooms PRIMARY KEY (id)
);

ALTER TABLE classrooms ADD CONSTRAINT FK_CLASSROOMS_ON_ENTITY FOREIGN KEY (entity_id) REFERENCES organizations (id);

ALTER TABLE classrooms ADD CONSTRAINT FK_CLASSROOMS_ON_SITE FOREIGN KEY (site_id) REFERENCES sites (id);