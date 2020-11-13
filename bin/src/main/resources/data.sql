insert into T_USER (ID,USERNAME,CREATED_ON,PASSWORD,APPROVED,ROLE) values ('1','user1','2017-11-09','password','false','0');
insert into T_USER (ID,USERNAME,CREATED_ON,PASSWORD,APPROVED,ROLE) values ('2','user2','2018-11-09','password','false','0');
insert into T_USER (ID,USERNAME,CREATED_ON,PASSWORD,APPROVED,ROLE) values ('3','user3','2019-11-09','password','false','0');
insert into T_PROJECT (ID,PROJECT_NAME,PROJECT_DESCRIPTION) values ('PJ101','Project 1','Project Description 1');
insert into T_PROJECT (ID,PROJECT_NAME,PROJECT_DESCRIPTION) values ('PJ102','Project 2','Project Description 2');
insert into T_TICKET (TITLE,DESCRIPTION,SEVERITY,STATUS,ASSIGNED_USER_ID,CREATED_USER_ID,PROJECT_ID) values ('ticket 4','description 1','0','0','2','3','PJ101');
insert into T_TICKET (TITLE,DESCRIPTION,SEVERITY,STATUS,ASSIGNED_USER_ID,CREATED_USER_ID,PROJECT_ID) values ('ticket 4','description 1','0','0','2','3','PJ101');
insert into T_TICKET (TITLE,DESCRIPTION,SEVERITY,STATUS,ASSIGNED_USER_ID,CREATED_USER_ID,PROJECT_ID) values ('ticket 4','description 1','0','0','3','2','PJ102');
/*insert into T_TICKET (TITLE,DESCRIPTION,SEVERITY,STATUS,ASSIGNED_USER_ID,CREATED_USER_ID) values ('ticket 4','description 1','0','0','2','3');
insert into T_TICKET (TITLE,DESCRIPTION,SEVERITY,STATUS,ASSIGNED_USER_ID,CREATED_USER_ID) values ('ticket 4','description 1','0','0','2','3');
insert into T_TICKET (TITLE,DESCRIPTION,SEVERITY,STATUS,ASSIGNED_USER_ID,CREATED_USER_ID) values ('ticket 4','description 1','0','0','3','2');*/