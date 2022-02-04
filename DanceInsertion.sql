
use DanceDB;

INSERT INTO DanceStyle (StyleName) VALUES ('classic ballet');
INSERT INTO DanceStyle VALUES ('modern ballet');
INSERT INTO DanceStyle VALUES ('jazz');
INSERT INTO DanceStyle VALUES ('hiphop');
INSERT INTO DanceStyle VALUES ('preschool dance');
INSERT INTO DanceStyle VALUES ('oriental dance');
INSERT INTO DanceStyle VALUES ('folk dance');
INSERT INTO DanceStyle VALUES ('zoomba');
INSERT INTO DanceStyle VALUES ('couples dances');
INSERT INTO DanceStyle VALUES ('general');

/* insert data into DanceStyle table */
INSERT INTO Course (StyleId, courseYear, DifficultyRank) VALUES (1, 2016, 'A');
INSERT INTO Course (StyleId, courseYear, DifficultyRank) VALUES (1, 2016, 'B');
INSERT INTO Course (StyleId, courseYear, DifficultyRank) VALUES (1, 2016, 'C');
INSERT INTO Course (StyleId, courseYear, DifficultyRank) VALUES (2, 2016, 'A');
INSERT INTO Course (StyleId, courseYear, DifficultyRank) VALUES (2, 2016, 'B');
INSERT INTO Course (StyleId, courseYear, DifficultyRank) VALUES (3, 2016, 'A');
INSERT INTO Course (StyleId, courseYear, DifficultyRank) VALUES (3, 2016, 'C');
INSERT INTO Course (StyleId, courseYear, DifficultyRank) VALUES (4, 2016, 'B');
INSERT INTO Course (StyleId, courseYear, DifficultyRank) VALUES (4, 2016, 'C');
INSERT INTO Course (StyleId, courseYear, DifficultyRank) VALUES (4, 2016, 'B');
INSERT INTO Course (StyleId, courseYear, DifficultyRank) VALUES (4, 2016, 'C');

INSERT INTO Course (StyleId, courseYear, DifficultyRank) VALUES (1, 2017, 'A');
INSERT INTO Course (StyleId, courseYear, DifficultyRank) VALUES (1, 2017, 'B');
INSERT INTO Course (StyleId, courseYear, DifficultyRank) VALUES (1, 2017, 'B');
INSERT INTO Course (StyleId, courseYear, DifficultyRank) VALUES (2, 2017, 'A');
INSERT INTO Course (StyleId, courseYear, DifficultyRank) VALUES (2, 2017, 'A');
INSERT INTO Course (StyleId, courseYear, DifficultyRank) VALUES (3, 2017, 'A');
INSERT INTO Course (StyleId, courseYear, DifficultyRank) VALUES (3, 2017, 'C');
INSERT INTO Course (StyleId, courseYear, DifficultyRank) VALUES (4, 2017, 'C');
INSERT INTO Course (StyleId, courseYear, DifficultyRank) VALUES (4, 2017, 'A');
INSERT INTO Course (StyleId, courseYear, DifficultyRank) VALUES (4, 2017, 'B');
INSERT INTO Course (StyleId, courseYear, DifficultyRank) VALUES (4, 2017, 'C');


INSERT INTO Teacher (TeacherId,FirstName,LastName,City,Street,HouseNo,PhoneNum,StartWorkingDate,PreviousExperience,MainStyleId, DateOfBirth)
     VALUES (11111, 'Mikhail','Baryshnikov', 'Haifa', 'Alenbi', '5a', '0521234567', '06/12/2012', 'no previous experience', 1, '07/11/1931');
INSERT INTO Teacher (TeacherId,FirstName,LastName,City,Street,HouseNo,PhoneNum,StartWorkingDate,PreviousExperience,MainStyleId, DateOfBirth)
     VALUES (22222, 'Rudolf','Nureyev', 'Haifa', 'Moria', '32', '0524567890', '02/01/2015', 'no previous experience', 2, '07/10/1991');
INSERT INTO Teacher (TeacherId,FirstName,LastName,City,Street,HouseNo,PhoneNum,StartWorkingDate,PreviousExperience,MainStyleId, DateOfBirth)
     VALUES (33333, 'Michael','Jackson', 'Haifa', 'Zafririm', '23', '0539876543', '03/07/2014', null ,3, '07/01/1981');
INSERT INTO Teacher(TeacherId,FirstName,LastName,City,Street,HouseNo,PhoneNum,StartWorkingDate,PreviousExperience,MainStyleId, DateOfBirth)
     VALUES (44444, 'Martha','Graham', 'Nesher', 'Yasmin', '11', '0529182736', '06/30/2013', null,4, '09/04/1971');
INSERT INTO Teacher(TeacherId,FirstName,LastName,City,Street,HouseNo,PhoneNum,StartWorkingDate,PreviousExperience,MainStyleId, DateOfBirth)
     VALUES (55555, 'Fred','Astaire', 'Nesher', 'Yasmin', '11', '0529182736', '06/30/2013', null,4, '03/13/1945');


INSERT INTO StylesPerTeacher(StyleId,TeacherId)
     VALUES (1,11111);
INSERT INTO StylesPerTeacher(StyleId,TeacherId)
     VALUES (2,11111);
INSERT INTO StylesPerTeacher(StyleId,TeacherId)
     VALUES (3,11111);
INSERT INTO StylesPerTeacher(StyleId,TeacherId)
     VALUES (4,11111);
INSERT INTO StylesPerTeacher(StyleId,TeacherId)
     VALUES (1,22222);
INSERT INTO StylesPerTeacher(StyleId,TeacherId)
     VALUES (2,22222);
INSERT INTO StylesPerTeacher(StyleId,TeacherId)
     VALUES (3,33333);
INSERT INTO StylesPerTeacher(StyleId,TeacherId)
     VALUES (4,33333);
INSERT INTO StylesPerTeacher(StyleId,TeacherId)
     VALUES (5,33333);
INSERT INTO StylesPerTeacher(StyleId,TeacherId)
     VALUES (6,33333);
INSERT INTO StylesPerTeacher(StyleId,TeacherId)
     VALUES (9,33333);
INSERT INTO StylesPerTeacher(StyleId,TeacherId)
     VALUES (8,33333);
INSERT INTO StylesPerTeacher(StyleId,TeacherId)
     VALUES (5,55555);
INSERT INTO StylesPerTeacher(StyleId,TeacherId)
     VALUES (6,55555);
INSERT INTO StylesPerTeacher(StyleId,TeacherId)
     VALUES (7,55555);

INSERT INTO Meeting(CourseId,MeetingNum,MeetingDate,MeetingStartHour,MeetingEndHour,TeacherId) 
	VALUES(1,1,'01/01/2016', '15:00:00', '16:00:00', 11111);
INSERT INTO Meeting(CourseId,MeetingNum,MeetingDate,MeetingStartHour,MeetingEndHour,TeacherId) 
	VALUES(1,2,'01/07/2016', '15:00:00', '16:00:00', 11111);
INSERT INTO Meeting(CourseId,MeetingNum,MeetingDate,MeetingStartHour,MeetingEndHour,TeacherId) 
	VALUES(1,3,'01/14/2016', '15:00:00', '16:00:00', 22222);
INSERT INTO Meeting(CourseId,MeetingNum,MeetingDate,MeetingStartHour,MeetingEndHour,TeacherId) 
	VALUES(1,4,'01/21/2016', '15:00:00', '16:00:00', 33333);
INSERT INTO Meeting(CourseId,MeetingNum,MeetingDate,MeetingStartHour,MeetingEndHour,TeacherId) 
	VALUES(1,5,'01/28/2016', '15:00:00', '16:00:00', 11111);
INSERT INTO Meeting(CourseId,MeetingNum,MeetingDate,MeetingStartHour,MeetingEndHour,TeacherId) 
	VALUES(1,6,'02/04/2016', '15:00:00', '16:00:00', 22222);
INSERT INTO Meeting(CourseId,MeetingNum,MeetingDate,MeetingStartHour,MeetingEndHour,TeacherId) 
	VALUES(1,7,'02/11/2016', '15:00:00', '16:00:00', 11111);
INSERT INTO Meeting(CourseId,MeetingNum,MeetingDate,MeetingStartHour,MeetingEndHour,TeacherId) 
	VALUES(1,8,'02/18/2016', '15:00:00', '16:00:00', 44444);
INSERT INTO Meeting(CourseId,MeetingNum,MeetingDate,MeetingStartHour,MeetingEndHour,TeacherId) 
	VALUES(1,9,'02/25/2016', '15:00:00', '16:00:00', 44444);
INSERT INTO Meeting(CourseId,MeetingNum,MeetingDate,MeetingStartHour,MeetingEndHour,TeacherId) 
	VALUES(1,10,'03/01/2016', '15:00:00', '16:00:00', 44444);

INSERT INTO Meeting(CourseId,MeetingNum,MeetingDate,MeetingStartHour,MeetingEndHour,TeacherId) 
	VALUES(2,1,'01/01/2016', '15:00:00', '16:00:00', 22222);
INSERT INTO Meeting(CourseId,MeetingNum,MeetingDate,MeetingStartHour,MeetingEndHour,TeacherId) 
	VALUES(2,2,'01/07/2016', '15:00:00', '16:00:00', 22222);
INSERT INTO Meeting(CourseId,MeetingNum,MeetingDate,MeetingStartHour,MeetingEndHour,TeacherId) 
	VALUES(2,3,'01/14/2016', '15:00:00', '16:00:00', 33333);
INSERT INTO Meeting(CourseId,MeetingNum,MeetingDate,MeetingStartHour,MeetingEndHour,TeacherId) 
	VALUES(2,4,'01/21/2016', '15:00:00', '16:00:00', 44444);
INSERT INTO Meeting(CourseId,MeetingNum,MeetingDate,MeetingStartHour,MeetingEndHour,TeacherId) 
	VALUES(2,5,'01/28/2016', '15:00:00', '16:00:00', 55555);
INSERT INTO Meeting(CourseId,MeetingNum,MeetingDate,MeetingStartHour,MeetingEndHour,TeacherId) 
	VALUES(2,6,'02/04/2016', '15:00:00', '16:00:00', 11111);
INSERT INTO Meeting(CourseId,MeetingNum,MeetingDate,MeetingStartHour,MeetingEndHour,TeacherId) 
	VALUES(2,7,'02/11/2016', '15:00:00', '16:00:00', 22222);
INSERT INTO Meeting(CourseId,MeetingNum,MeetingDate,MeetingStartHour,MeetingEndHour,TeacherId) 
	VALUES(2,8,'02/18/2016', '15:00:00', '16:00:00', 33333);
INSERT INTO Meeting(CourseId,MeetingNum,MeetingDate,MeetingStartHour,MeetingEndHour,TeacherId) 
	VALUES(2,9,'02/25/2016', '15:00:00', '16:00:00', 22222);
INSERT INTO Meeting(CourseId,MeetingNum,MeetingDate,MeetingStartHour,MeetingEndHour,TeacherId) 
	VALUES(2,10,'03/01/2016', '15:00:00', '16:00:00', 22222);


INSERT INTO Meeting(CourseId,MeetingNum,MeetingDate,MeetingStartHour,MeetingEndHour,TeacherId) 
	VALUES(12,1,'01/01/2017', '15:00:00', '16:00:00', 11111);
INSERT INTO Meeting(CourseId,MeetingNum,MeetingDate,MeetingStartHour,MeetingEndHour,TeacherId) 
	VALUES(12,2,'01/07/2017', '15:00:00', '16:00:00', 11111);
INSERT INTO Meeting(CourseId,MeetingNum,MeetingDate,MeetingStartHour,MeetingEndHour,TeacherId) 
	VALUES(12,3,'01/14/2017', '15:00:00', '16:00:00', NULL);
INSERT INTO Meeting(CourseId,MeetingNum,MeetingDate,MeetingStartHour,MeetingEndHour,TeacherId) 
	VALUES(12,4,'01/21/2017', '15:00:00', '16:00:00', NULL);
INSERT INTO Meeting(CourseId,MeetingNum,MeetingDate,MeetingStartHour,MeetingEndHour,TeacherId) 
	VALUES(12,5,'01/28/2017', '15:00:00', '16:00:00', 11111);
INSERT INTO Meeting(CourseId,MeetingNum,MeetingDate,MeetingStartHour,MeetingEndHour,TeacherId) 
	VALUES(12,6,'02/04/2017', '15:00:00', '16:00:00', 22222);
INSERT INTO Meeting(CourseId,MeetingNum,MeetingDate,MeetingStartHour,MeetingEndHour,TeacherId) 
	VALUES(12,7,'02/11/2017', '15:00:00', '16:00:00', 11111);
INSERT INTO Meeting(CourseId,MeetingNum,MeetingDate,MeetingStartHour,MeetingEndHour,TeacherId) 
	VALUES(12,8,'02/18/2017', '15:00:00', '16:00:00', 44444);
INSERT INTO Meeting(CourseId,MeetingNum,MeetingDate,MeetingStartHour,MeetingEndHour,TeacherId) 
	VALUES(12,9,'02/25/2017', '15:00:00', '16:00:00', 44444);
INSERT INTO Meeting(CourseId,MeetingNum,MeetingDate,MeetingStartHour,MeetingEndHour,TeacherId) 
	VALUES(12,10,'03/01/2017', '15:00:00', '16:00:00', 44444);

INSERT INTO Meeting(CourseId,MeetingNum,MeetingDate,MeetingStartHour,MeetingEndHour,TeacherId) 
	VALUES(13,1,'01/01/2017', '15:00:00', '16:00:00', 55555);
INSERT INTO Meeting(CourseId,MeetingNum,MeetingDate,MeetingStartHour,MeetingEndHour,TeacherId) 
	VALUES(13,2,'01/07/2017', '15:00:00', '16:00:00', 33333);
INSERT INTO Meeting(CourseId,MeetingNum,MeetingDate,MeetingStartHour,MeetingEndHour,TeacherId) 
	VALUES(13,3,'01/14/2017', '15:00:00', '16:00:00', 11111);
INSERT INTO Meeting(CourseId,MeetingNum,MeetingDate,MeetingStartHour,MeetingEndHour,TeacherId) 
	VALUES(13,4,'01/21/2017', '15:00:00', '16:00:00', 22222);
INSERT INTO Meeting(CourseId,MeetingNum,MeetingDate,MeetingStartHour,MeetingEndHour,TeacherId) 
	VALUES(13,5,'01/28/2017', '15:00:00', '16:00:00', null);
INSERT INTO Meeting(CourseId,MeetingNum,MeetingDate,MeetingStartHour,MeetingEndHour,TeacherId) 
	VALUES(13,6,'02/04/2017', '15:00:00', '16:00:00', null);
INSERT INTO Meeting(CourseId,MeetingNum,MeetingDate,MeetingStartHour,MeetingEndHour,TeacherId) 
	VALUES(13,7,'02/11/2017', '15:00:00', '16:00:00', 33333);
INSERT INTO Meeting(CourseId,MeetingNum,MeetingDate,MeetingStartHour,MeetingEndHour,TeacherId) 
	VALUES(13,8,'02/18/2017', '15:00:00', '16:00:00', 55555);
INSERT INTO Meeting(CourseId,MeetingNum,MeetingDate,MeetingStartHour,MeetingEndHour,TeacherId) 
	VALUES(13,9,'02/25/2017', '15:00:00', '16:00:00', 33333);
INSERT INTO Meeting(CourseId,MeetingNum,MeetingDate,MeetingStartHour,MeetingEndHour,TeacherId) 
	VALUES(13,10,'03/01/2017', '15:00:00', '16:00:00', 11111);

INSERT INTO Dancer(dancerId,FirstName,LastName,City,Street,HouseNo,PhoneNum,BeginningDate,IsSuspend,StyleId1,StyleId2,StyleId3,Gender,DateOfBirth)
	VALUES (12121, 'Bar','Rafaeli', 'Tel-Aviv', 'Rotshiled', '77b', '0501234123', '01/01/2015', 0, 1,null,null,'f', '03/13/1985');
INSERT INTO Dancer(dancerId,FirstName,LastName,City,Street,HouseNo,PhoneNum,BeginningDate,IsSuspend,StyleId1,StyleId2,StyleId3,Gender,DateOfBirth)
	VALUES (13131, 'Esti','Ginzburg', 'Ramat Hasharon', 'Dovnov', '13', '0529876987', '01/01/2014', 0, 1, 2, null,'f','05/06/1989');
INSERT INTO Dancer(dancerId,FirstName,LastName,City,Street,HouseNo,PhoneNum,BeginningDate,IsSuspend,StyleId1,StyleId2,StyleId3,Gender,DateOfBirth)
	VALUES (14141, 'Avri','Gilad', 'Haifa', 'Shacham', '43', '0524567456', '01/01/2016', 0, 1, 3, 4,'m', '03/19/1966');
INSERT INTO Dancer(dancerId,FirstName,LastName,City,Street,HouseNo,PhoneNum,BeginningDate,IsSuspend,StyleId1,StyleId2,StyleId3,Gender,DateOfBirth)
	VALUES (15151, 'Ron','Kofman', 'Haifa', 'Tel-Mana', '22', '0529182918', '01/01/2012', 0, 2, 3,null,  'm', '01/11/1965');
INSERT INTO Dancer(dancerId,FirstName,LastName,City,Street,HouseNo,PhoneNum,BeginningDate,IsSuspend,StyleId1,StyleId2,StyleId3,Gender,DateOfBirth)
	VALUES (16161, 'Lior','Shlein', 'Tel-Aviv', 'Sharona', '1', '0531231231', '01/01/2013', 0, 2, 6,null,'m','12/09/1965');
INSERT INTO Dancer(dancerId,FirstName,LastName,City,Street,HouseNo,PhoneNum,BeginningDate,IsSuspend,StyleId1,StyleId2,StyleId3,Gender,DateOfBirth)
	VALUES (17171, 'Alma','Zak', 'Hertzelia', 'Hertzel', '31A', '0539111122', '01/01/2013', 0, 3, 7,null,'f','11/15/1965');
INSERT INTO Dancer(dancerId,FirstName,LastName,City,Street,HouseNo,PhoneNum,BeginningDate,IsSuspend,StyleId1,StyleId2,StyleId3,Gender,DateOfBirth)
	VALUES (18181, 'Gal','Gadot', 'Keasaria', 'Hashoshanim', '8', '0589898989', '01/01/2014', 0, 2, 8, 1,'f','03/13/1999');
INSERT INTO Dancer(dancerId,FirstName,LastName,City,Street,HouseNo,PhoneNum,BeginningDate,IsSuspend,StyleId1,StyleId2,StyleId3,Gender,DateOfBirth)
	VALUES (19191, 'Avi','Gabay', 'Jerusalem', 'Balfur', '1', '0527222228', '01/01/2017', 0, 1,3, 4,'m','02/22/1964');
INSERT INTO Dancer(dancerId,FirstName,LastName,City,Street,HouseNo,PhoneNum,BeginningDate,IsSuspend,StyleId1,StyleId2,StyleId3,Gender,DateOfBirth)
	VALUES (21212, 'Yoram','Gaon', 'Jerusalem', 'Yafo', '51', '0537182998', '01/01/2011', 0, 2,1,null,'m','07/21/1965');


INSERT INTO CoursesPerDancer(CourseId,DancerId) VALUES (1,12121);
INSERT INTO CoursesPerDancer(CourseId,DancerId) VALUES (2,12121);
INSERT INTO CoursesPerDancer(CourseId,DancerId) VALUES (12,12121);
INSERT INTO CoursesPerDancer(CourseId,DancerId) VALUES (13,12121);

INSERT INTO CoursesPerDancer(CourseId,DancerId) VALUES (1,13131);
INSERT INTO CoursesPerDancer(CourseId,DancerId) VALUES (3,13131);
INSERT INTO CoursesPerDancer(CourseId,DancerId) VALUES (6,13131);
INSERT INTO CoursesPerDancer(CourseId,DancerId) VALUES (12,13131);

INSERT INTO CoursesPerDancer(CourseId,DancerId) VALUES (1,14141);
INSERT INTO CoursesPerDancer(CourseId,DancerId) VALUES (2,14141);
INSERT INTO CoursesPerDancer(CourseId,DancerId) VALUES (3,14141);
INSERT INTO CoursesPerDancer(CourseId,DancerId) VALUES (21,14141);

INSERT INTO CoursesPerDancer(CourseId,DancerId) VALUES (1,15151);
INSERT INTO CoursesPerDancer(CourseId,DancerId) VALUES (4,15151);
INSERT INTO CoursesPerDancer(CourseId,DancerId) VALUES (5,15151);
INSERT INTO CoursesPerDancer(CourseId,DancerId) VALUES (12,15151);
INSERT INTO CoursesPerDancer(CourseId,DancerId) VALUES (13,15151);
INSERT INTO CoursesPerDancer(CourseId,DancerId) VALUES (14,15151);
INSERT INTO CoursesPerDancer(CourseId,DancerId) VALUES (18,15151);
INSERT INTO CoursesPerDancer(CourseId,DancerId) VALUES (20,15151);

INSERT INTO CoursesPerDancer(CourseId,DancerId) VALUES (11,16161);
INSERT INTO CoursesPerDancer(CourseId,DancerId) VALUES (12,16161);

INSERT INTO CoursesPerDancer(CourseId,DancerId) VALUES (13,17171);

INSERT INTO CoursesPerDancer(CourseId,DancerId) VALUES (11,18181);
INSERT INTO CoursesPerDancer(CourseId,DancerId) VALUES (13,18181);

INSERT INTO CoursesPerDancer(CourseId,DancerId) VALUES (11,19191);
INSERT INTO CoursesPerDancer(CourseId,DancerId) VALUES (13,19191);

INSERT INTO Attendance VALUES (1,1,12121); 
INSERT INTO Attendance VALUES(1,2,12121);
INSERT INTO Attendance VALUES(1,3,12121);
INSERT INTO Attendance VALUES(1,4,12121);
INSERT INTO Attendance VALUES(1,5,12121);
INSERT INTO Attendance VALUES(1,6,12121);
INSERT INTO Attendance VALUES(1,7,12121);
INSERT INTO Attendance VALUES(1,8,12121);
INSERT INTO Attendance VALUES(1,9,12121);
INSERT INTO Attendance VALUES(1,10,12121);

INSERT INTO Attendance VALUES (1,1,13131); 
INSERT INTO Attendance VALUES(1,2,13131);
INSERT INTO Attendance VALUES(1,3,13131);
INSERT INTO Attendance VALUES(1,4,13131);
INSERT INTO Attendance VALUES(1,5,13131);
INSERT INTO Attendance VALUES(1,7,13131);
INSERT INTO Attendance VALUES(1,8,13131);
INSERT INTO Attendance VALUES(1,9,13131);
INSERT INTO Attendance VALUES(1,10,13131);



INSERT INTO RegularShow (ShowNum, ShowSubject,ShowDate,StartHour,Duration,ManagerId) VALUES (1, 'Smoke','07/31/2016','20:00:00', 3, 11111);
INSERT INTO RegularShow (ShowNum, ShowSubject,ShowDate,StartHour,Duration,ManagerId) VALUES (2, 'Fire ','07/31/2017','20:00:00', 3, 33333);

INSERT INTO FinalShow (ShowNum, ShowSubject,ShowDate,StartHour,ManagerId) VALUES (1, 'California','08/31/2016','20:00:00', 11111);
INSERT INTO FinalShow (ShowNum, ShowSubject,ShowDate,StartHour,ManagerId) VALUES (2, 'Peace','08/31/2017','20:00:00', 22222);

INSERT INTO Act VALUES(1,1,1,22222); 
INSERT INTO Act VALUES(1,2,1,22222);
INSERT INTO Act VALUES(1,3,1,11111);

INSERT INTO Act VALUES(2,1,1,22222); 
INSERT INTO Act VALUES(2,2,1,33333);
INSERT INTO Act VALUES(2,3,1,44444);


INSERT INTO DancersInRegularShow VALUES(1,12121);
INSERT INTO DancersInRegularShow VALUES(2,12121);
INSERT INTO DancersInRegularShow VALUES(1,13131);
INSERT INTO DancersInRegularShow VALUES(2,13131);
INSERT INTO DancersInRegularShow VALUES(1,14141);
INSERT INTO DancersInRegularShow VALUES(2,14141);

INSERT INTO DancersInAct VALUES(1,1,14141);
INSERT INTO DancersInAct VALUES(1,1,15151);
INSERT INTO DancersInAct VALUES(1,1,16161);
INSERT INTO DancersInAct VALUES(1,1,17171);
INSERT INTO DancersInAct VALUES(1,2,14141);
INSERT INTO DancersInAct VALUES(1,2,19191);
INSERT INTO DancersInAct VALUES(1,2,16161);
INSERT INTO DancersInAct VALUES(1,3,15151);

INSERT INTO DancersInAct VALUES(2,1,12121);
INSERT INTO DancersInAct VALUES(2,1,15151);
INSERT INTO DancersInAct VALUES(2,1,17171);
INSERT INTO DancersInAct VALUES(2,1,18181);
INSERT INTO DancersInAct VALUES(2,2,13131);
INSERT INTO DancersInAct VALUES(2,2,19191);
INSERT INTO DancersInAct VALUES(2,2,17171);
INSERT INTO DancersInAct VALUES(2,3,14141);


update course set cost = 5000.00 where difficultyrank='a';
update course set cost = 7000.00 where difficultyrank='b';
update course set cost = 10000.00 where difficultyrank='c';