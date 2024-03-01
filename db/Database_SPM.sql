CREATE DATABASE spm_database;
Use  spm_database;

create table user (
	user_id VARCHAR(20) PRIMARY KEY,
	roll_number INT,
	full_name VARCHAR(50),
	gender BIT,
	date_of_birth DATE,
	email VARCHAR(100),
	mobile INT,
	avatar_link VARCHAR(100),
	facebook_link VARCHAR(100),
	role_id INT,     
	status INT,
    password VARCHAR(255),
    address VARCHAR(100)
);
create table setting (
	setting_id INT PRIMARY KEY auto_increment,
	type_id INT ,
	setting_title VARCHAR(50),
    subject_name VARCHAR(50),
	setting_value VARCHAR(50),
	display_order INT,
	status INT,
    description VARCHAR(200)
);
create table subject (
	subject_id VARCHAR(50) PRIMARY KEY,
	subject_code VARCHAR(50),
	subject_name VARCHAR(50),
	author_id VARCHAR(50),
	status INT,
	FOREIGN KEY (author_id) REFERENCES user(user_id)
);
create table subject_setting (
	setting_id INT PRIMARY KEY auto_increment,
	subject_id VARCHAR(50),
	type_id INT,
	setting_title VARCHAR(50),
	setting_value VARCHAR(50),
	display_order INT,
	status INT,
    FOREIGN KEY (subject_id) REFERENCES subject(subject_id)
);
create table class (
	class_id INT auto_increment PRIMARY KEY,
	class_code VARCHAR(50),
	trainer_id VARCHAR(50),
	subject_id VARCHAR(50),
	class_year VARCHAR(20),
	class_term VARCHAR(20),
	block5_class INT,
	status INT,
	FOREIGN KEY (subject_id) REFERENCES subject(subject_id),
	FOREIGN KEY (trainer_id) REFERENCES user(user_id)
);
create table team (
	team_id INT auto_increment PRIMARY KEY,
	class_id INT,
    class_code VARCHAR(50),
	topic_code VARCHAR(50),
	topic_name VARCHAR(50),
	gitlab_url VARCHAR(100),
	status INT,
	FOREIGN KEY (class_id) REFERENCES class(class_id)
);
create table issue (
	issue_id INT auto_increment PRIMARY KEY,
	assignee_id VARCHAR(50),
	issue_title VARCHAR(50),
	description VARCHAR(150),
	gitlab_id INT,
	gitlab_url VARCHAR(500),
	created_date DATE,
	due_date DATE,
	team_id INT,
	milestone_id INT,
	function_ids INT,
	labels VARCHAR(50),
	status INT,
	FOREIGN KEY (team_id) REFERENCES team(team_id),
	FOREIGN KEY (assignee_id) REFERENCES user(user_id)
);
create table feature (
	feature_id INT PRIMARY KEY auto_increment,
	team_id INT,
	feature_name VARCHAR(50),
	status INT,
	FOREIGN KEY (team_id) REFERENCES team(team_id)
);
create table function_tb (
	function_id INT auto_increment PRIMARY KEY,
	team_id INT,
	function_name VARCHAR(50),
	feature_id INT,
	access_role INT,
	description VARCHAR(150),
	complexity_id INT,
	owner_id INT,
	priority VARCHAR(50),
	status INT,
	FOREIGN KEY (team_id) REFERENCES team(team_id),
	FOREIGN KEY (feature_id) REFERENCES feature(feature_id)
);

create table class_user (
	class_user_id int  auto_increment  PRIMARY KEY ,
	class_id INT, 
	team_id INT,
	user_id VARCHAR(50),
	dropout_date DATE,
	user_notes VARCHAR(50),
	ongoing_eval VARCHAR(50),
	final_pres_eval VARCHAR(50),
	final_topic_eval VARCHAR(50),
	status INT,
	FOREIGN KEY (team_id) REFERENCES team(team_id),
	FOREIGN KEY (class_id) REFERENCES class(class_id),
	FOREIGN KEY (user_id) REFERENCES user(user_id)
);
create table iteration(
	iteration_id INT auto_increment PRIMARY KEY,
    subject_id VARCHAR(50),
    iteration_name VARCHAR(50),
    duration VARCHAR(50),
    status INT,
    FOREIGN KEY (subject_id) REFERENCES subject(subject_id)
);
create table iteration_evaluation(
	evaluation_id INT auto_increment PRIMARY KEY,
    iteration_id INT,
    class_id INT,
    team_id INT,
    user_id VARCHAR(50),
    bonus DOUBLE,
    grade DOUBLE,
    note VARCHAR(100),
    FOREIGN KEY (iteration_id) REFERENCES iteration(iteration_id),
    FOREIGN KEY (class_id) REFERENCES class(class_id),
    FOREIGN KEY (team_id) REFERENCES team(team_id),
    FOREIGN KEY (user_id) REFERENCES user(user_id)
);
create table evaluation_criteria(
	criteria_id INT auto_increment PRIMARY KEY,
    iteration_id INT,
    iteration_name VARCHAR(50),
    evaluation_weight VARCHAR(50),
    team_evaluation VARCHAR(50),
    criteria_order INT,
    max_loc VARCHAR(50),
    status INT,
    FOREIGN KEY (iteration_id) REFERENCES iteration(iteration_id)
);
create table team_evaluation(
	team_eval_id INT auto_increment PRIMARY KEY,
    evaluation_id INT,
    criteria_id INT,
    team_id INT,
    grade DOUBLE,
    note VARCHAR(100),
    FOREIGN KEY (evaluation_id) REFERENCES iteration_evaluation(evaluation_id),
    FOREIGN KEY (criteria_id) REFERENCES evaluation_criteria(criteria_id),
    FOREIGN KEY (team_id) REFERENCES team(team_id)
);
create table member_evaluation(
	member_eval_id INT auto_increment PRIMARY KEY,
    evaluation_id INT,
    criteria_id INT,
    converted_loc INT,
    grade DOUBLE,
    note VARCHAR(100),
    FOREIGN KEY (evaluation_id) REFERENCES iteration_evaluation(evaluation_id),
    FOREIGN KEY (criteria_id) REFERENCES evaluation_criteria(criteria_id)
);
create table milestone(
	milestone_id INT auto_increment PRIMARY KEY,
    iteration_id INT,
    class_id INT,
    from_date DATETIME,
    to_date DATETIME,
    status INT,
    FOREIGN KEY (iteration_id) REFERENCES iteration(iteration_id),
    FOREIGN KEY (class_id) REFERENCES class(class_id)
);
create table tracking(
	tracking_id INT auto_increment PRIMARY KEY,
    team_id INT,
    milestone_id INT,
    function_id INT,
    assigner_id INT,
    assignee_id INT,
    tracking_note VARCHAR(100),
    updates VARCHAR(50),
    status INT,
    FOREIGN KEY (team_id) REFERENCES team(team_id),
    FOREIGN KEY (milestone_id) REFERENCES milestone(milestone_id),
    FOREIGN KEY (function_id) REFERENCES function_tb(function_id)
);
create table loc_evaluation(
	evaluation_id INT auto_increment PRIMARY KEY,
    evaluation_time VARCHAR(100),
    evaluation_note VARCHAR(100),
    complexity_id INT,
    quality_id INT,
    tracking_id INT,
    FOREIGN KEY (tracking_id) REFERENCES tracking(tracking_id)
);


