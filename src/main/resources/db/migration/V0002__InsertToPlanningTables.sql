insert into task_priority values(1, 1, 'IMMEDIATE', 1, TRUE, 'SYSTEM', now(), 'SYSTEM', now());
insert into task_priority values(2, 2, 'OVERDUE', 2, TRUE, 'SYSTEM', now(), 'SYSTEM', now());
insert into task_priority values(3, 3, 'HIGH', 3, TRUE, 'SYSTEM', now(), 'SYSTEM', now());
insert into task_priority values(4, 4, 'MEDIUM', 4, TRUE, 'SYSTEM', now(), 'SYSTEM', now());
insert into task_priority values(5, 5, 'LOW', 5, TRUE, 'SYSTEM', now(), 'SYSTEM', now());

insert into task_type values(1, 1, 'ETC', 1, 'Y', 'SYSTEM', now(), 'SYSTEM', now());
insert into task_type values(2, 1, 'MCE', 2, 'Y', 'SYSTEM', now(), 'SYSTEM', now());
insert into task_type values(3, 1, 'Maintenance', 3, 'Y', 'SYSTEM', now(), 'SYSTEM', now());
insert into task_type values(4, 1, 'Punch List', 4, 'Y', 'SYSTEM', now(), 'SYSTEM', now());
insert into task_type values(5, 1, 'Retrofits', 5, 'Y', 'SYSTEM', now(), 'SYSTEM', now());
insert into task_type values(6, 1, 'TIL', 6, 'Y', 'SYSTEM', now(), 'SYSTEM', now());
insert into task_type values(7, 1, 'Unplanned Maintenance', 7, 'Y', 'SYSTEM', now(), 'SYSTEM', now());
insert into task_type values(8, 1, 'Other', 8, 'Y', 'SYSTEM', now(), 'SYSTEM', now());

insert into task_types_for_role values(1, 1, 1, 'Y', 'SYSTEM', now(), 'SYSTEM', now());
insert into task_types_for_role values(2, 2, 1, 'Y', 'SYSTEM', now(), 'SYSTEM', now());
insert into task_types_for_role values(3, 3, 1, 'Y', 'SYSTEM', now(), 'SYSTEM', now());
insert into task_types_for_role values(4, 4, 1, 'Y', 'SYSTEM', now(), 'SYSTEM', now());
insert into task_types_for_role values(5, 5, 1, 'Y', 'SYSTEM', now(), 'SYSTEM', now());
insert into task_types_for_role values(6, 6, 1, 'Y', 'SYSTEM', now(), 'SYSTEM', now());
insert into task_types_for_role values(7, 7, 1, 'Y', 'SYSTEM', now(), 'SYSTEM', now());
insert into task_types_for_role values(8, 8, 1, 'Y', 'SYSTEM', now(), 'SYSTEM', now());
insert into task_types_for_role values(9, 1, 2, 'Y', 'SYSTEM', now(), 'SYSTEM', now());
insert into task_types_for_role values(10, 2, 2, 'Y', 'SYSTEM', now(), 'SYSTEM', now());
insert into task_types_for_role values(11, 3, 2, 'Y', 'SYSTEM', now(), 'SYSTEM', now());
insert into task_types_for_role values(12, 4, 2, 'Y', 'SYSTEM', now(), 'SYSTEM', now());
insert into task_types_for_role values(13, 1, 3, 'Y', 'SYSTEM', now(), 'SYSTEM', now());
insert into task_types_for_role values(14, 2, 3, 'Y', 'SYSTEM', now(), 'SYSTEM', now());
insert into task_types_for_role values(15, 3, 3, 'Y', 'SYSTEM', now(), 'SYSTEM', now());
insert into task_types_for_role values(16, 4, 3, 'Y', 'SYSTEM', now(), 'SYSTEM', now());

insert into task_status values(1, 'PLANNED', 'Y', 'SYSTEM', now(), 'SYSTEM', now());
insert into task_status values(2, 'PENDING', 'y', 'SYSTEM', now(), 'SYSTEM', now());
insert into task_status values(3, 'COMPLETED', 'Y', 'SYSTEM', now(), 'SYSTEM', now());

insert into asset_pod_config values(1, 10, CURRENT_DATE, 20, 'Y', 'SYSTEM', now(), 'SYSTEM', now());
insert into asset_pod_config values(2, 20, CURRENT_DATE, 30, 'Y', 'SYSTEM', now(), 'SYSTEM', now());
insert into asset_pod_config values(3, 30, CURRENT_DATE, 50, 'Y', 'SYSTEM', now(), 'SYSTEM', now());
insert into asset_pod_config values(4, 40, CURRENT_DATE, 70, 'Y', 'SYSTEM', now(), 'SYSTEM', now());
insert into asset_pod_config values(5, 50, CURRENT_DATE, 60, 'Y', 'SYSTEM', now(), 'SYSTEM', now());

insert into task values(1, 1, 12, 1, 1, 1, 1, 10, 12, 50, 60, 'description', 'parkDetails', 'notes', 'notes', 'notes', true, 30, 10, 25, 35, 45, now(), now(), now(), true, 'system', now(), 'system', now(), 'TURBINE');
insert into task values(2, 2, 12, 2, 2, 2, 2, 10, 12, 50, 60, 'description', 'parkDetails', 'notes', 'notes', 'notes', true, 30, 10, 25, 35, 45, now(), now(), now(), true, 'system', now(), 'system', now(), 'SITE');
insert into task values(3, 3, 12, 3, 3, 3, 3, 10, 12, 50, 60, 'description', 'parkDetails', 'notes', 'notes', 'notes', true, 30, 10, 25, 35, 45, now(), now(), now(), true, 'system', now(), 'system', now(), 'SITE');
