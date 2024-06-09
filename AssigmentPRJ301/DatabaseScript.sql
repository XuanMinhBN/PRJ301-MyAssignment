CREATE TABLE student(
	id bigint primary key identity(1,1),
	roll varchar(8),
	student_name nvarchar(100),
);

CREATE TABLE student_and_course(
	student_id bigint not null,
	course_id bigint not null,
);

CREATE TABLE course(
	id bigint primary key identity(1,1),
	course_code varchar(50),
	course_name nvarchar(200),
	status bit not null,
	rate float,
);

CREATE TABLE course_and_detail_mark(
	course_id bigint not null,
	detail_mark_id bigint not null,
);

CREATE TABLE detail_mark(
	id int primary key identity(1,1),
	small_test_1 float,
	small_test_2 float,
	small_test_3 float,
	small_test_4 float,
	small_test_5 float,
	progress_test_1 float,
	progress_test_2 float,
	mid_term float,
	practice_exam float,
	final_exam float,
	total float,
);



CREATE TABLE user_account(
	id bigint primary key identity(1,1),
	username nvarchar(200),
	email varchar(200),
	password varchar(200),
	status bit not null,
);

CREATE TABLE user_and_role(
	user_account_id bigint,
	role_id bigint,
);

CREATE TABLE role(
	id bigint primary key identity(1,1),
	role_name nvarchar(200),
);

CREATE TABLE role_and_feature(
	role_id bigint,
	feature_id bigint,
);

CREATE TABLE feature(
	id bigint primary key identity(1,1),
	url varchar(300),
);

