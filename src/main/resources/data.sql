insert into T_USER (ID,USERNAME,CREATED_ON,PASSWORD,APPROVED,ROLE) values ('1','username1','2017-11-09','password1P@45','false','0');
insert into T_USER (ID,USERNAME,CREATED_ON,PASSWORD,APPROVED,ROLE) values ('2','username2','2018-11-09','password2P$56','false','2');
insert into T_USER (ID,USERNAME,CREATED_ON,PASSWORD,APPROVED,ROLE) values ('3','username3','2019-11-09','password3H&345','false','1');
insert into T_USER (ID,USERNAME,CREATED_ON,PASSWORD,APPROVED,ROLE) values ('4','username4','2017-1-09','password1P@45','false','1');
insert into T_USER (ID,USERNAME,CREATED_ON,PASSWORD,APPROVED,ROLE) values ('5','username6','2018-10-09','password2P$56','false','2');
insert into T_USER (ID,USERNAME,CREATED_ON,PASSWORD,APPROVED,ROLE) values ('6','username7','2019-5-09','password3H&345','false','0');

insert into T_PROJECT (ID,PROJECT_NAME,PROJECT_DESCRIPTION,PROJECT_MANAGER_ID) values ('PJ101','Project 1','Project Description 1','3');
insert into T_PROJECT (ID,PROJECT_NAME,PROJECT_DESCRIPTION,PROJECT_MANAGER_ID) values ('PJ102','Project 2','Project Description 2','4');

insert into T_TICKET (TITLE,DESCRIPTION,SEVERITY,STATUS,ASSIGNED_USER_ID,CREATED_USER_ID,PROJECT_ID) values ('ticket 4','description 1','0','0','2','3','PJ101');
insert into T_TICKET (TITLE,DESCRIPTION,SEVERITY,STATUS,ASSIGNED_USER_ID,CREATED_USER_ID,PROJECT_ID) values ('ticket 4','description 1','0','0','2','3','PJ101');
insert into T_TICKET (TITLE,DESCRIPTION,SEVERITY,STATUS,ASSIGNED_USER_ID,CREATED_USER_ID,PROJECT_ID) values ('ticket 4','description 1','0','0','3','2','PJ102');
/*insert into T_TICKET (TITLE,DESCRIPTION,SEVERITY,STATUS,ASSIGNED_USER_ID,CREATED_USER_ID) values ('ticket 4','description 1','0','0','2','3');
insert into T_TICKET (TITLE,DESCRIPTION,SEVERITY,STATUS,ASSIGNED_USER_ID,CREATED_USER_ID) values ('ticket 4','description 1','0','0','2','3');
insert into T_TICKET (TITLE,DESCRIPTION,SEVERITY,STATUS,ASSIGNED_USER_ID,CREATED_USER_ID) values ('ticket 4','description 1','0','0','3','2');*/