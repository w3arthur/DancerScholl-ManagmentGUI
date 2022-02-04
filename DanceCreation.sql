/*drop database dance;*/
use DanceDB;
 
create table DanceStyle(
	StyleId int identity (1,1) primary key, 
	StyleName varchar(15) not null unique
);

create table Course(
	CourseId int identity (1,1) primary key, 
	StyleId int,
	CourseYear int,
	DifficultyRank char(1) check ( (DifficultyRank='A') or (DifficultyRank='B') or (DifficultyRank='C')) default 'A',
	/*  A - beginner, B-advance, C-professionaltext_of_comment */
	constraint fk1 foreign key (StyleId) references DanceStyle(StyleId)
);

create table Teacher(
	TeacherId int primary key,
	FirstName varchar(15) not null,
	LastName varchar(15) not null,
	City varchar(15),
	Street varchar(15),
	HouseNo char(5),
	PhoneNum varchar(10),
	StartWorkingDate date not null default getdate(), 
	PreviousExperience text,
	MainStyleId int,
	DateOfBirth date,
	check (PhoneNum like '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]'),
	constraint fk2 foreign key (MainStyleId) references DanceStyle(StyleId)
);

create table StylesPerTeacher(
	StyleId int,
	TeacherId int,
	constraint pk1 primary key (StyleId, TeacherId),
	constraint fk3 foreign key (StyleId) references DanceStyle(StyleId) on delete no action on update cascade,
	constraint fk4 foreign key (TeacherId) references Teacher(TeacherId) on delete no action on update cascade
);

create table Meeting(
	CourseId int,
	MeetingNum int,
	MeetingDate date,
	MeetingStartHour time,
	MeetingEndHour time,
	TeacherId int,
	constraint pk2 primary key (CourseId, MeetingNum),
	constraint fk5 foreign key (CourseId) references Course(CourseId) on delete cascade on update cascade,
	constraint fk6 foreign key (TeacherId) references Teacher(TeacherId) on delete cascade on update cascade
); 

create table Dancer(
	DancerId int primary key,
	FirstName varchar(15) not null,
	LastName varchar(15) not null,
	City varchar(15),
	Street varchar(15),
	HouseNo char(5),
	PhoneNum varchar(10),
	BeginningDate date  not null, 
	IsSuspend bit,
	StyleId1 int not null,
	StyleId2 int,
	StyleId3 int,
	check (PhoneNum like '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]'),
	constraint fk7 foreign key (StyleId1) references DanceStyle(StyleId) on delete no action on update no action,
	constraint fk8 foreign key (StyleId2) references DanceStyle(StyleId) on delete no action on update no action,
	constraint fk9 foreign key (StyleId3) references DanceStyle(StyleId) on delete no action on update no action,
	constraint chk1 check ((StyleId1 <> StyleId2) and (StyleId2 <> StyleId3) and StyleId3 <> StyleId1) 
);	

create table CoursesPerDancer(
	CourseId int,
	DancerId int,
	constraint pk3 primary key (CourseId, DancerId),
	constraint fk10 foreign key (CourseId) references Course(CourseId) on delete no action on update cascade,
	constraint fk11 foreign key (DancerId) references Dancer(DancerId) on delete no action on update cascade
);

create table Attendance(
	CourseId int,
	MeetingNum int,
	DancerId int,
	constraint pk4 primary key (CourseId, DancerId, MeetingNum),
	constraint fk12 foreign key (CourseId, MeetingNum) references Meeting(CourseId, MeetingNum) on delete cascade on update cascade,
	constraint fk13 foreign key (DancerId) references Dancer(DancerId) on delete cascade on update cascade
);

create table RegularShow(
	ShowNum int primary key, 
	ShowSubject varchar(15) not null,
	ShowDate date,
	StartHour time,
	duration int,
	ManagerId int,
	constraint fk14 foreign key (ManagerId) references Teacher(TeacherId) on delete no action on update cascade
); 

create table FinalShow(
	ShowNum int primary key, 
	ShowSubject varchar(15) not null,
	ShowDate date,
	StartHour datetime,
	ManagerId int,
	constraint fk15 foreign key (ManagerId) references Teacher(TeacherId) on delete no action on update cascade
); 

create table Act(
	ShowNum int, 
	ActNum int, 
	duration int,
	TeacherInCharge int,
	constraint pk5 primary key (ShowNum, ActNum),
	constraint fk16 foreign key (TeacherInCharge) references Teacher(TeacherId) on update cascade,
	constraint fk17 foreign key (ShowNum) references FinalShow(ShowNum) on delete no action on update no action
); 

create table DancersInRegularShow(
	ShowNum int,
	DancerId int,
	constraint pk6 primary key (ShowNum, DancerId),
	constraint fk18 foreign key (ShowNum) references RegularShow(ShowNum) on delete cascade on update cascade,
	constraint fk19 foreign key (DancerId) references Dancer(DancerId) on delete no action on update cascade
);

create table DancersInAct(
	ShowNum int,
	ActNum int,
	DancerId int,
	constraint pk7 primary key (ShowNum, ActNum, DancerId),
	constraint fk20 foreign key (ShowNum,ActNum) references Act(ShowNum,ActNum) on delete cascade on update cascade,
	constraint fk21 foreign key (DancerId) references Dancer(DancerId) on delete no action on update cascade
); 

alter table course add cost decimal(7,2) null;
alter table Dancer add DateOfBirth date null;
alter table Dancer add Gender char(1) check ( (Gender='m') or (Gender='f')) default 'f';
alter table FinalShow alter column StartHour time null;
alter table Attendance add constraint fk22 foreign key (courseid, dancerid) references coursesperdancer(courseid, dancerid);
