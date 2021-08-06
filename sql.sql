CREATE TABLE students (
	s_id		INT				PRIMARY KEY		AUTO_INCREMENT,
	s_name		VARCHAR(20)		NOT NULL,
	s_tel		VARCHAR(20)		NOT NULL,
	s_grade		INT				NOT NULL,
	s_class		CHAR(1)			NOT NULL
);