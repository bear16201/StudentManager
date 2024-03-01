use  spm_database;

insert into user(user_id, roll_number, full_name, gender, date_of_birth, email,mobile,  avatar_link, facebook_link, role_id, status, password, address)
values('HE150001', 1 , 'Dao Xuan Phuc', 1, '2001-06-16', 'phuc@gmail.com', 0984805545, 'dsa', 'asd', 1, 0,'phuc123', 'Xuan Hoa');
insert into user(user_id, roll_number, full_name, gender, date_of_birth, email,mobile,  avatar_link, facebook_link, role_id, status, password, address)
values('HE150002', 2 , 'Le Hoai Nam', 1, '2001-04-13', 'nam@gmail.com', 0927465924, 'rew', 'gfd', 1, 1,'nam123', 'Vinh Phuc');
insert into user(user_id, roll_number, full_name, gender, date_of_birth, email,mobile,  avatar_link, facebook_link, role_id, status, password, address)
values('HE150003', 3 , 'Doan Trong Thai', 1, '2001-12-24', 'thai@gmail.com', 0352664796, 'bsr', 'tur', 0, 1,'thai123', 'Yen Bai');
insert into user(user_id, roll_number, full_name, gender, date_of_birth, email,mobile,  avatar_link, facebook_link, role_id, status, password, address)
values('HE150004', 4 , 'Trinh Tien Dat', 1, '2001-03-16', 'dattthe151172@fpt.edu.vn', 0826481652, 'bju', 'uog', 1, 1,'123456', 'Viet Nam');

insert into setting (setting_id, type_id, setting_title, subject_name, setting_value, display_order, status, description) 
values (1, 444, 'Ky Thuat Phan Mem', 'Software Develop Project', 'G324', 3 , 1, 'good job ');
insert into setting (setting_id, type_id, setting_title, subject_name, setting_value, display_order, status, description) 
values (2, 354, 'Tri tue nhan tao', 'Software Develop Project', 'J657', 1 , 1, 'good job ');
insert into setting (setting_id, type_id, setting_title, subject_name, setting_value, display_order, status, description) 
values (3, 168, 'An toan thong tin', 'Software Develop Project', 'G564', 2 , 1, 'good job ');
insert into setting (setting_id, type_id, setting_title, subject_name, setting_value, display_order, status, description) 
values (4, 398, 'Ngon ngu Nhat', 'Academic Skills for University Success', 'G254', 2 , 1, 'good job ');
insert into setting (setting_id, type_id, setting_title, subject_name, setting_value, display_order, status, description) 
values (5, 436, 'Thiet ke do hoa', 'Academic Skills for University Success', 'G452', 4 , 1, 'good job ');
insert into setting (setting_id, type_id, setting_title, subject_name, setting_value, display_order, status, description) 
values (6, 757, 'Quan tri kinh doanh', 'Vovinam 3', 'J675', 6, 1, 'good job ');
insert into setting (setting_id, type_id, setting_title, subject_name, setting_value, display_order, status, description) 
values (7, 542, 'Quan tri khach san', 'Vovinam 3', 'A534', 1, 1, 'good job ');
insert into setting (setting_id, type_id, setting_title, subject_name, setting_value, display_order, status, description) 
values (8, 636, 'Ngon ngu Anh', 'Programming Fundamentals', 'H564', 3 , 1, 'good job ');
insert into setting (setting_id, type_id, setting_title, subject_name, setting_value, display_order, status, description) 
values (9, 765, 'Marketing', 'Programming Fundamentals', 'H564', 7, 1, 'good job ');
insert into setting (setting_id, type_id, setting_title, subject_name, setting_value, display_order, status, description) 
values (10, 235, 'Cong nghe thong tin', 'Introduction to Computer Science', 'F324', 2 , 1, 'good job ');
insert into setting (setting_id, type_id, setting_title, subject_name, setting_value, display_order, status, description) 
values (11, 543, 'Ngon ngu Trung', 'Discrete mathematics', 'A241', 3 , 1, 'good job ');


insert into subject(subject_id, subject_code, subject_name, author_id, status) 
values('SWP301', 'B342', 'Software Develop Project', 'HE150001', 1);
insert into subject(subject_id, subject_code, subject_name, author_id, status) 
values('MAD219', 'K354', 'Discrete mathematics', 'HE150002', 1);
insert into subject(subject_id, subject_code, subject_name, author_id, status) 
values('VOV134', 'K354', 'Vovinam 3', 'HE150002', 1);
insert into subject(subject_id, subject_code, subject_name, author_id, status) 
values('SSL101c', 'K354', 'Academic Skills for University Success', 'HE150002', 1);
insert into subject(subject_id, subject_code, subject_name, author_id, status) 
values('CSI104', 'K354', 'Introduction to Computer Science', 'HE150002', 1);
insert into subject(subject_id, subject_code, subject_name, author_id, status) 
values('PRF192', 'K354', 'Programming Fundamentals', 'HE150002', 1);

insert into subject_setting(setting_id, subject_id, type_id, setting_title, setting_value, display_order, status) 
values(1, 'SWP301', 444, 'Ky Thuat Phan Mem', 'G324', 3, 1);
insert into subject_setting(setting_id, subject_id, type_id, setting_title, setting_value, display_order, status) 
values(2, 'MAD219', 354, 'Tri tue nhan tao', 'J657', 1, 1);
insert into subject_setting(setting_id, subject_id, type_id, setting_title, setting_value, display_order, status) 
values(3, 'SWP301', 168, 'An toan thong tin', 'G564', 2, 1);
insert into subject_setting(setting_id, subject_id, type_id, setting_title, setting_value, display_order, status) 
values(4, 'SWP301', 398, 'Ngon ngu Nhat', 'G254', 2, 1);
insert into subject_setting(setting_id, subject_id, type_id, setting_title, setting_value, display_order, status) 
values(5, 'MAD219', 436, 'Thiet ke do hoa', 'G452', 4, 1);
insert into subject_setting(setting_id, subject_id, type_id, setting_title, setting_value, display_order, status) 
values(6, 'MAD219', 757, 'Quan tri kinh doanh', 'J675', 6, 1);
insert into subject_setting(setting_id, subject_id, type_id, setting_title, setting_value, display_order, status) 
values(7, 'SWP301', 542, 'Quan tri khach san', 'A534', 1, 1);
insert into subject_setting(setting_id, subject_id, type_id, setting_title, setting_value, display_order, status) 
values(8, 'MAD219', 636, 'Ngon ngu Anh', 'H564', 3, 1);
insert into subject_setting(setting_id, subject_id, type_id, setting_title, setting_value, display_order, status) 
values(9, 'SWP301', 765, 'Marketing', 'H564', 7, 1);
insert into subject_setting(setting_id, subject_id, type_id, setting_title, setting_value, display_order, status) 
values(10, 'MAD219', 235, 'Cong nghe thong tin', 'F324', 2, 1);
insert into subject_setting(setting_id, subject_id, type_id, setting_title, setting_value, display_order, status) 
values(11, 'SWP301', 543, 'Ngon ngu Trung', 'A241', 3, 1);

insert into class (class_id, class_code, trainer_id, subject_id, class_year, class_term, block5_class, status) 
values(1, 'SE1602', 'HE150001', 'SWP301', 'SP21', 'Spring', 1, 1);
insert into class (class_id, class_code, trainer_id, subject_id, class_year, class_term, block5_class, status) 
values(2, 'SE1503', 'HE150002', 'MAD219', 'FL20', 'Fall', 0, 1);

insert into team(team_id, class_id, class_code, topic_code, topic_name, gitlab_url, status) 
values(1, 1, 'SE1602', 'bvmt', 'Bao ve moi truong', 'alo', 1);
insert into team(team_id, class_id, class_code, topic_code, topic_name, gitlab_url, status) 
values(2, 2, 'SE1603', 'qltv', 'Quan ly thu vien', 'yaho', 1);
insert into team(team_id, class_id, class_code, topic_code, topic_name, gitlab_url, status) 
values(3, 1, 'SE1602', 'bvmt', 'Bao ve moi truong', 'alo', 0);
insert into team(team_id, class_id, class_code, topic_code, topic_name, gitlab_url, status) 
values(4, 2, 'SE1603', 'qltv', 'Quan ly thu vien', 'yaho', 1);

insert into issue(issue_id, assignee_id, issue_title, description, gitlab_id, gitlab_url, created_date, due_date, team_id, milestone_id, function_ids, labels, status) 
values(1, 'HE150001', 'Database', 'Draw Diagram',999, 'alo', '2022-05-10', '2022-05-20', 1, 11, 213, 'Doing', 1);
insert into issue(issue_id, assignee_id, issue_title, description, gitlab_id, gitlab_url, created_date, due_date, team_id, milestone_id, function_ids, labels, status) 
values(2, 'HE150002', 'Code', 'Coding', 777, 'yolo', '2022-05-10', '2022-05-20', 2, 12, 132, 'Doing', 1);

insert into feature (feature_id, team_id, feature_name, status) 
values (1, 1, 'Web Screen', 1);
insert into feature (feature_id, team_id, feature_name, status) 
values (2, 2, 'Admin Screen', 1);

insert into function_tb (function_id, team_id, function_name, feature_id, access_role, description, complexity_id, owner_id, priority, status) 
values (1, 1, 'Login', 1, 1, 'La chuc nang de dang nhap', 1, 1, 0, 1);
insert into function_tb (function_id, team_id, function_name, feature_id, access_role, description, complexity_id, owner_id, priority, status) 
values (2, 2, 'SettingList', 2, 1, 'Hien thi danh sach cai dat', 1, 1, 0, 1);

insert into class_user (class_user_id, class_id, team_id, user_id, dropout_date, user_notes, ongoing_eval, final_pres_eval, final_topic_eval, status) 
values (1,1, 1, 'HE150001', 21/05/2021, 'Xong som nghi som', 'G', 'G', 'G', 1);
insert into class_user (class_user_id, class_id, team_id, user_id, dropout_date, user_notes, ongoing_eval, final_pres_eval, final_topic_eval, status) 
values (2,2, 2, 'HE150002', 21/05/2021, 'Co gang xong som', 'G', 'G', 'G', 1);

insert into iteration (iteration_id, subject_id, iteration_name, duration, status)
values(1, 'SWP301', 'iter1', '2022-06-16', 1);
insert into iteration (iteration_id, subject_id, iteration_name, duration, status)
values(2, 'MAD219', 'iter2', '2022-06-16', 1);

insert into evaluation_criteria(criteria_id, iteration_id, iteration_name, evaluation_weight, team_evaluation, criteria_order, max_loc, status)
values(5, 1, 'iter1', '0.7', '0.8', 3, '10', 1);
insert into evaluation_criteria(criteria_id, iteration_id, iteration_name, evaluation_weight, team_evaluation, criteria_order, max_loc, status)
values(6, 2, 'iter2', '0.6', '0.5', 2, '10', 1);
insert into evaluation_criteria(criteria_id, iteration_id, iteration_name, evaluation_weight, team_evaluation, criteria_order, max_loc, status)
values(3, 1, 'iter1', '0.7', '0.8', 3, '10', 1);
insert into evaluation_criteria(criteria_id, iteration_id, iteration_name, evaluation_weight, team_evaluation, criteria_order, max_loc, status)
values(4, 2, 'iter2', '0.6', '0.5', 2, '10', 1);


