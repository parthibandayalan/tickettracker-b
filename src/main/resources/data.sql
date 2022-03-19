insert into T_USER (ID,USERNAME,CREATED_ON,PASSWORD,APPROVED,ROLE,FULLNAME) values ('1','username1','2017-11-09','password1P@45','true','0','James Mueller');
insert into T_USER (ID,USERNAME,CREATED_ON,PASSWORD,APPROVED,ROLE,FULLNAME) values ('2','username2','2018-11-09','password2P$56','true','0','John Taylor');
insert into T_USER (ID,USERNAME,CREATED_ON,PASSWORD,APPROVED,ROLE,FULLNAME) values ('3','username3','2019-11-09','password3H&345','true','0','John Adams');
insert into T_USER (ID,USERNAME,CREATED_ON,PASSWORD,APPROVED,ROLE,FULLNAME) values ('4','username4','2017-1-09','password1P@45','false','0','David Larson');
insert into T_USER (ID,USERNAME,CREATED_ON,PASSWORD,APPROVED,ROLE,FULLNAME) values ('5','username5','2015-1-09','password1P@45','false','0','Phoenix Jones');

insert into T_USER (ID,USERNAME,CREATED_ON,PASSWORD,APPROVED,ROLE,FULLNAME) values ('6','username6','2018-10-09','password2P$56','true','1','Allison Lyons');
insert into T_USER (ID,USERNAME,CREATED_ON,PASSWORD,APPROVED,ROLE,FULLNAME) values ('7','username7','2019-5-09','password3H&345','true','1','Remington Garza');
insert into T_USER (ID,USERNAME,CREATED_ON,PASSWORD,APPROVED,ROLE,FULLNAME) values ('8','username8','2018-5-09','password3H&345','true','1','Gina Shannon');
insert into T_USER (ID,USERNAME,CREATED_ON,PASSWORD,APPROVED,ROLE,FULLNAME) values ('9','username9','2017-5-09','password3H&345','false','1','Howard Shea');
insert into T_USER (ID,USERNAME,CREATED_ON,PASSWORD,APPROVED,ROLE,FULLNAME) values ('10','username10','2018-11-09','password2P$56','false','1','Joel Davila');

insert into t_user (id, username, created_on, password, approved, role, fullname) values (11, 'pglossop0', '11/16/2019', 'soUpcCNGKGfT', true, 2, 'Jamie Williams');
insert into t_user (id, username, created_on, password, approved, role, fullname) values (12, 'dcockroft1', '7/29/2020', 'mGM0Xal', true, 2, 'Daniel Cockroft');
insert into t_user (id, username, created_on, password, approved, role, fullname) values (13, 'mtrevan2', '6/27/2020', 'a744nhlf', true, 2, 'Marvin Trevan');
insert into t_user (id, username, created_on, password, approved, role, fullname) values (14, 'hocarroll3', '4/14/2021', 'PH83jsKnaN5', true, 2, 'Hermaine Carroll');
insert into t_user (id, username, created_on, password, approved, role, fullname) values (15, 'jdennes4', '10/30/2020', 'M6996Ku0xW', true, 2, 'Jo Dennis');

insert into t_user (id, username, created_on, password, approved, role, fullname) values (16, 'mhallowes5', '3/23/2021', 'X1om7K', true, 2, 'Maria Hallows');/*Manager*/
insert into t_user (id, username, created_on, password, approved, role, fullname) values (17, 'mfawdry6', '5/3/2019', 'vCYDnzF0VjEh', true, 2, 'Melissa Fawndry');/*Manager*/
insert into t_user (id, username, created_on, password, approved, role, fullname) values (18, 'ncullagh7', '10/9/2020', 'L4wzzJCXonTE', true, 2, 'Nelly Robinson');/*Manager*/
insert into t_user (id, username, created_on, password, approved, role, fullname) values (19, 'hgeane8', '11/23/2018', 'b792Y3op', true, 2, 'Ester Gene');
insert into t_user (id, username, created_on, password, approved, role, fullname) values (20, 'bgorden9', '11/22/2018', 'yIwmlKHVfyd', true, 2, 'Binny Gorden');

insert into t_user (id, username, created_on, password, approved, role, fullname) values (21, 'ssigharda', '1/31/2019', '7pCRfvREb1', true, 2, 'Saleem Sighard');
insert into t_user (id, username, created_on, password, approved, role, fullname) values (22, 'yweitzelb', '1/4/2021', '4SgWvI', true, 2, 'York Weitzel');
insert into t_user (id, username, created_on, password, approved, role, fullname) values (23, 'bjanicijevicc', '5/8/2020', 'e3YrD72', true, 2, 'Brigit Janicijevic');
insert into t_user (id, username, created_on, password, approved, role, fullname) values (24, 'lschollingd', '1/11/2019', 'o3ZfnpHFYXZ', true, 2, 'Lindsey Scholling');
insert into t_user (id, username, created_on, password, approved, role, fullname) values (25, 'lbrabane', '6/5/2019', 'lU0g0e', true, 2, 'Loleta Braban');

insert into t_user (id, username, created_on, password, approved, role, fullname) values (26, 'htompkinf', '6/26/2019', 'ApCn5wpZW', false, 2, 'Heindrick Tompkin');
insert into t_user (id, username, created_on, password, approved, role, fullname) values (27, 'tdunridgeg', '3/11/2019', 'ec6XNIrA', false, 2, 'Tiphani Dunridge');
insert into t_user (id, username, created_on, password, approved, role, fullname) values (28, 'hlenoirh', '1/15/2019', 'dpltU4ZTNl', false, 2, 'Huntlee Lenoir');
insert into t_user (id, username, created_on, password, approved, role, fullname) values (29, 'mpougheri', '5/28/2021', 'GuwyvxXmzh', false, 2, 'Mile Pougher');
insert into t_user (id, username, created_on, password, approved, role, fullname) values (30, 'aadrianelloj', '9/8/2018', '5rZK7dh', false, 2, 'Andeee Adrianello');

alter sequence T_USER_ID_SEQ restart with 31;

insert into T_PROJECT (ID,PROJECT_NAME,PROJECT_DESCRIPTION,PROJECT_MANAGER_ID) values ('PJ101','Project 1','Project Description 1','6');
insert into T_PROJECT (ID,PROJECT_NAME,PROJECT_DESCRIPTION,PROJECT_MANAGER_ID) values ('PJ102','Project 2','Project Description 2','6');
insert into T_PROJECT (ID,PROJECT_NAME,PROJECT_DESCRIPTION,PROJECT_MANAGER_ID) values ('PJ103','Project 3','Project Description 3','6');

insert into T_PROJECT (ID,PROJECT_NAME,PROJECT_DESCRIPTION,PROJECT_MANAGER_ID) values ('PJ104','Project 4','Project Description 4','7');
insert into T_PROJECT (ID,PROJECT_NAME,PROJECT_DESCRIPTION,PROJECT_MANAGER_ID) values ('PJ105','Project 5','Project Description 5','7');
insert into T_PROJECT (ID,PROJECT_NAME,PROJECT_DESCRIPTION,PROJECT_MANAGER_ID) values ('PJ106','Project 6','Project Description 6','7');

insert into T_PROJECT (ID,PROJECT_NAME,PROJECT_DESCRIPTION,PROJECT_MANAGER_ID) values ('PJ107','Project 7','Project Description 7','8');
insert into T_PROJECT (ID,PROJECT_NAME,PROJECT_DESCRIPTION,PROJECT_MANAGER_ID) values ('PJ108','Project 8','Project Description 8','8');
insert into T_PROJECT (ID,PROJECT_NAME,PROJECT_DESCRIPTION,PROJECT_MANAGER_ID) values ('PJ109','Project 9','Project Description 9','8');

insert into T_TICKET (TITLE,DESCRIPTION,SEVERITY,STATUS,ASSIGNED_USER_ID,CREATED_USER_ID,PROJECT_ID) values ('ticket 1','description 1','0','0','6','11','PJ101');
insert into T_TICKET (TITLE,DESCRIPTION,SEVERITY,STATUS,ASSIGNED_USER_ID,CREATED_USER_ID,PROJECT_ID) values ('ticket 2','description 2','0','0','6','12','PJ101');
insert into T_TICKET (TITLE,DESCRIPTION,SEVERITY,STATUS,ASSIGNED_USER_ID,CREATED_USER_ID,PROJECT_ID) values ('ticket 3','description 3','0','0','6','13','PJ101');

insert into T_TICKET (TITLE,DESCRIPTION,SEVERITY,STATUS,ASSIGNED_USER_ID,CREATED_USER_ID,PROJECT_ID) values ('ticket 4','description 4','0','0','6','14','PJ102');
insert into T_TICKET (TITLE,DESCRIPTION,SEVERITY,STATUS,ASSIGNED_USER_ID,CREATED_USER_ID,PROJECT_ID) values ('ticket 5','description 5','0','0','6','15','PJ102');
insert into T_TICKET (TITLE,DESCRIPTION,SEVERITY,STATUS,ASSIGNED_USER_ID,CREATED_USER_ID,PROJECT_ID) values ('ticket 6','description 6','0','0','6','16','PJ102');

insert into T_TICKET (TITLE,DESCRIPTION,SEVERITY,STATUS,ASSIGNED_USER_ID,CREATED_USER_ID,PROJECT_ID) values ('ticket 7','description 7','0','0','6','17','PJ103');
insert into T_TICKET (TITLE,DESCRIPTION,SEVERITY,STATUS,ASSIGNED_USER_ID,CREATED_USER_ID,PROJECT_ID) values ('ticket 8','description 8','0','0','6','18','PJ103');
insert into T_TICKET (TITLE,DESCRIPTION,SEVERITY,STATUS,ASSIGNED_USER_ID,CREATED_USER_ID,PROJECT_ID) values ('ticket 9','description 9','0','0','6','19','PJ103');

insert into T_TICKET (TITLE,DESCRIPTION,SEVERITY,STATUS,ASSIGNED_USER_ID,CREATED_USER_ID,PROJECT_ID) values ('ticket 10','description 10','0','0','7','20','PJ104');
insert into T_TICKET (TITLE,DESCRIPTION,SEVERITY,STATUS,ASSIGNED_USER_ID,CREATED_USER_ID,PROJECT_ID) values ('ticket 11','description 11','0','0','7','21','PJ104');
insert into T_TICKET (TITLE,DESCRIPTION,SEVERITY,STATUS,ASSIGNED_USER_ID,CREATED_USER_ID,PROJECT_ID) values ('ticket 12','description 12','0','0','7','22','PJ104');

insert into T_TICKET (TITLE,DESCRIPTION,SEVERITY,STATUS,ASSIGNED_USER_ID,CREATED_USER_ID,PROJECT_ID) values ('ticket 13','description 13','0','0','7','23','PJ105');
insert into T_TICKET (TITLE,DESCRIPTION,SEVERITY,STATUS,ASSIGNED_USER_ID,CREATED_USER_ID,PROJECT_ID) values ('ticket 14','description 14','0','0','7','24','PJ105');
insert into T_TICKET (TITLE,DESCRIPTION,SEVERITY,STATUS,ASSIGNED_USER_ID,CREATED_USER_ID,PROJECT_ID) values ('ticket 15','description 15','0','0','7','25','PJ105');

insert into T_TICKET (TITLE,DESCRIPTION,SEVERITY,STATUS,ASSIGNED_USER_ID,CREATED_USER_ID,PROJECT_ID) values ('ticket 16','description 16','0','0','7','11','PJ106');
insert into T_TICKET (TITLE,DESCRIPTION,SEVERITY,STATUS,ASSIGNED_USER_ID,CREATED_USER_ID,PROJECT_ID) values ('ticket 17','description 17','0','0','7','12','PJ106');
insert into T_TICKET (TITLE,DESCRIPTION,SEVERITY,STATUS,ASSIGNED_USER_ID,CREATED_USER_ID,PROJECT_ID) values ('ticket 18','description 18','0','0','7','13','PJ106');

insert into T_TICKET (TITLE,DESCRIPTION,SEVERITY,STATUS,ASSIGNED_USER_ID,CREATED_USER_ID,PROJECT_ID) values ('ticket 19','description 19','0','0','8','14','PJ107');
insert into T_TICKET (TITLE,DESCRIPTION,SEVERITY,STATUS,ASSIGNED_USER_ID,CREATED_USER_ID,PROJECT_ID) values ('ticket 20','description 20','0','0','8','15','PJ107');
insert into T_TICKET (TITLE,DESCRIPTION,SEVERITY,STATUS,ASSIGNED_USER_ID,CREATED_USER_ID,PROJECT_ID) values ('ticket 21','description 21','0','0','8','16','PJ107');

insert into T_TICKET (TITLE,DESCRIPTION,SEVERITY,STATUS,ASSIGNED_USER_ID,CREATED_USER_ID,PROJECT_ID) values ('ticket 22','description 22','0','0','8','17','PJ108');
insert into T_TICKET (TITLE,DESCRIPTION,SEVERITY,STATUS,ASSIGNED_USER_ID,CREATED_USER_ID,PROJECT_ID) values ('ticket 23','description 23','0','0','8','18','PJ108');
insert into T_TICKET (TITLE,DESCRIPTION,SEVERITY,STATUS,ASSIGNED_USER_ID,CREATED_USER_ID,PROJECT_ID) values ('ticket 24','description 24','0','0','8','19','PJ108');

insert into T_TICKET (TITLE,DESCRIPTION,SEVERITY,STATUS,ASSIGNED_USER_ID,CREATED_USER_ID,PROJECT_ID) values ('ticket 25','description 25','0','0','8','20','PJ109');
insert into T_TICKET (TITLE,DESCRIPTION,SEVERITY,STATUS,ASSIGNED_USER_ID,CREATED_USER_ID,PROJECT_ID) values ('ticket 26','description 26','0','0','8','21','PJ109');
insert into T_TICKET (TITLE,DESCRIPTION,SEVERITY,STATUS,ASSIGNED_USER_ID,CREATED_USER_ID,PROJECT_ID) values ('ticket 27','description 27','0','0','8','22','PJ109');

INSERT INTO T_PROJECT_CONTRIBUTORS (PROJECT_ID,CONTRIBUTORS_ID) VALUES ('PJ101','11');
INSERT INTO T_PROJECT_CONTRIBUTORS (PROJECT_ID,CONTRIBUTORS_ID) VALUES ('PJ101','12');
INSERT INTO T_PROJECT_CONTRIBUTORS (PROJECT_ID,CONTRIBUTORS_ID) VALUES ('PJ101','13');

INSERT INTO T_PROJECT_CONTRIBUTORS (PROJECT_ID,CONTRIBUTORS_ID) VALUES ('PJ102','14');
INSERT INTO T_PROJECT_CONTRIBUTORS (PROJECT_ID,CONTRIBUTORS_ID) VALUES ('PJ102','15');
INSERT INTO T_PROJECT_CONTRIBUTORS (PROJECT_ID,CONTRIBUTORS_ID) VALUES ('PJ102','16');
INSERT INTO T_PROJECT_CONTRIBUTORS (PROJECT_ID,CONTRIBUTORS_ID) VALUES ('PJ103','17');

INSERT INTO T_COMMENT (CREATED_ON,MESSAGE,AUTHOR_ID) values ('2020-5-5','Comment 1','1');
INSERT INTO T_COMMENT (CREATED_ON,MESSAGE,AUTHOR_ID) values ('2020-5-6','Comment 2','2');
INSERT INTO T_COMMENT (CREATED_ON,MESSAGE,AUTHOR_ID) values ('2020-5-7','Comment 3','3');
INSERT INTO T_COMMENT (CREATED_ON,MESSAGE,AUTHOR_ID) values ('2020-5-8','Comment 4','4');
INSERT INTO T_COMMENT (CREATED_ON,MESSAGE,AUTHOR_ID) values ('2020-5-9','Comment 5','5');
INSERT INTO T_COMMENT (CREATED_ON,MESSAGE,AUTHOR_ID) values ('2020-5-10','Comment 6','4');

INSERT INTO T_TICKET_COMMENTS (TICKET_ID,COMMENTS_ID) VALUES (7,1);
INSERT INTO T_TICKET_COMMENTS (TICKET_ID,COMMENTS_ID) VALUES (7,2);
INSERT INTO T_TICKET_COMMENTS (TICKET_ID,COMMENTS_ID) VALUES (7,3);
INSERT INTO T_TICKET_COMMENTS (TICKET_ID,COMMENTS_ID) VALUES (3,4);
INSERT INTO T_TICKET_COMMENTS (TICKET_ID,COMMENTS_ID) VALUES (3,5);
INSERT INTO T_TICKET_COMMENTS (TICKET_ID,COMMENTS_ID) VALUES (3,6);