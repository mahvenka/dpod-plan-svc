CREATE TABLE task_type (
   task_type_id INTEGER PRIMARY KEY,
   tenant_id INTEGER NOT NULL,
   task_type_name_default VARCHAR(2000) NOT NULL,
   display_order INTEGER NOT NULL,
   is_active BOOLEAN NOT NULL DEFAULT true,
   created_by VARCHAR(30) NOT NULL,
   created_on TIMESTAMP NOT NULL,
   last_updated_by VARCHAR(30) NOT NULL,
   last_updated_on TIMESTAMP NOT NULL
);

CREATE TABLE task_types_for_role (
   task_type_user_role_relation_id BIGSERIAL PRIMARY KEY,
   task_type_id INTEGER NOT NULL CONSTRAINT task_type_id_fk REFERENCES task_type(task_type_id),
   user_role_id INTEGER NOT NULL,
   is_active BOOLEAN NOT NULL,
   created_by VARCHAR(30) NOT NULL,
   created_on TIMESTAMP NOT NULL,
   last_updated_by VARCHAR(30) NOT NULL,
   last_updated_on TIMESTAMP NOT NULL
);

CREATE TABLE asset_pod_config
(
	asset_pod_config_id BIGSERIAL PRIMARY KEY,
	site_asset_id BIGSERIAL NOT NULL,
	pod_date DATE NOT NULL,
	asset_pod_priority_order INTEGER NOT NULL,
	is_active BOOLEAN NOT NULL DEFAULT true,
	created_by VARCHAR(30) NOT NULL,
   	created_on TIMESTAMP NOT NULL,
    last_updated_by VARCHAR(30) NOT NULL,
    last_updated_on TIMESTAMP NOT NULL
);

CREATE TABLE task_priority
(
	task_priority_id SERIAL PRIMARY KEY,
	tenant_id SERIAL NOT NULL,
	task_priority_name_default VARCHAR(1000) NOT NULL,
	task_priority_order INTEGER NOT NULL,
	is_active BOOLEAN NOT NULL,
	created_by VARCHAR(30) NOT NULL,
	created_on TIMESTAMP NOT NULL,
	last_updated_by VARCHAR(30) NOT NULL,
	last_updated_on TIMESTAMP NOT NULL
);

CREATE TABLE task_status
(
	task_status_id SERIAL PRIMARY KEY,
	task_status_name_default VARCHAR NOT NULL,
	is_active BOOLEAN NOT NULL,
	created_by VARCHAR(30) NOT NULL,
	created_on TIMESTAMP NOT NULL,
	last_updated_by VARCHAR(30) NOT NULL,
	last_updated_on TIMESTAMP NOT NULL
);

CREATE TABLE task
(
	task_id BIGSERIAL PRIMARY KEY,
	asset_id BIGSERIAL NOT NULL,
	task_current_status_id INTEGER NOT NULL,
	asset_pod_config_id INTEGER CONSTRAINT asset_pod_config_id_task_fk REFERENCES asset_pod_config(asset_pod_config_id),
	task_type_id INTEGER NOT NULL CONSTRAINT task_type_id_task_fk REFERENCES task_type(task_type_id),
	task_status_id INTEGER NOT NULL CONSTRAINT task_status_id_fk REFERENCES task_status(task_status_id),
	task_priority_id INTEGER NOT NULL CONSTRAINT task_priority_id_fk REFERENCES task_priority(task_priority_id),
	task_estimated_duration_hrs INTEGER NOT NULL,
	task_estimated_duration_mins INTEGER NOT NULL,
	task_actual_duration_hrs INTEGER,
	task_actual_duration_mins INTEGER,
	task_description VARCHAR(2000) NOT NULL,
	part_details VARCHAR(2000),
	task_internal_notes VARCHAR,
	task_external_notes VARCHAR,
	task_resolution_notes VARCHAR,
	is_pod_task BOOLEAN,
	task_parent_id INTEGER,
	number_of_tech_required INTEGER,
	task_location_at_asset INTEGER,
	task_section_at_location INTEGER,
	task_component_at_section INTEGER,
	task_added_on TIMESTAMP,
	task_due_on TIMESTAMP,
	task_completed_on TIMESTAMP,
	is_active BOOLEAN NOT NULL,
	created_by VARCHAR(30) NOT NULL,
	created_on TIMESTAMP NOT NULL,
	last_updated_by VARCHAR(30) NOT NULL,
	last_updated_on TIMESTAMP NOT NULL,
	task_category VARCHAR(30)
);

CREATE TABLE task_recurrence_details
(
	task_recurrence_id BIGSERIAL PRIMARY KEY,
	task_id INTEGER,
	recurrence_type VARCHAR(20) NOT NULL,
	recurrence VARCHAR(20) NOT NULL,
	recurrence_cycle VARCHAR(20) NOT NULL,
	recurrence_end_by_date DATE,
	recurrence_end_by_count INTEGER,
	is_active BOOLEAN NOT NULL,
	created_by VARCHAR(30) NOT NULL,
	created_on TIMESTAMP NOT NULL,
	last_updated_by VARCHAR(30) NOT NULL,
	last_updated_on TIMESTAMP NOT NULL
);

CREATE TABLE task_attachment
(
	task_attachment_id BIGSERIAL PRIMARY KEY,
	attachment_id INTEGER,
	attachment_name VARCHAR(200) NOT NULL,
	is_active BOOLEAN NOT NULL,
	created_by VARCHAR(30) NOT NULL,
	created_on TIMESTAMP NOT NULL,
	last_updated_by VARCHAR(30) NOT NULL,
	last_updated_on TIMESTAMP NOT NULL
);

CREATE TABLE task_status_history_details
(
	task_history_id BIGSERIAL PRIMARY KEY,
	task_id INTEGER NOT NULL CONSTRAINT task_id_history_fk REFERENCES task(task_id),
	task_status_id INTEGER NOT NULL CONSTRAINT task_status_history_id_fk REFERENCES task_status(task_status_id),
	is_active BOOLEAN NOT NULL,
	created_by VARCHAR(30) NOT NULL,
	created_on TIMESTAMP NOT NULL,
	last_updated_by VARCHAR(30) NOT NULL,
	last_updated_on TIMESTAMP NOT NULL
);

CREATE TABLE common_codes (
	id BIGSERIAL PRIMARY KEY,
	dropdown_type VARCHAR(50) NOT NULL,
	dropdown_code VARCHAR(50) NOT NULL,
	dropdown_value VARCHAR(50) NOT NULL,
	language_code VARCHAR(50) NOT NULL,
	is_active BOOLEAN NOT NULL DEFAULT true,
	created_by VARCHAR(30) NOT NULL,
	created_on TIMESTAMP,
	last_updated_by VARCHAR(30) NOT NULL,
	last_updated_on TIMESTAMP
);

CREATE TABLE languages (
	language_id BIGSERIAL PRIMARY KEY,
	language_code VARCHAR(10) NOT NULL,
	language_value VARCHAR(50) NOT NULL,
	is_active BOOLEAN NOT NULL DEFAULT true,
	created_by VARCHAR(30) NOT NULL,
	created_on TIMESTAMP,
	last_updated_by VARCHAR(30) NOT NULL,
	last_updated_on TIMESTAMP
);
