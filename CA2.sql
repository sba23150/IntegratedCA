CREATE DATABASE CA2;

USE CA2;

/*create students table from students.csv generated by AI - using Table Data Import Wizard*/

ALTER TABLE students
ADD PRIMARY KEY (id);

ALTER TABLE students
ADD UNIQUE (Name(255));

/* Add student number in the students table - join the 'Course-Enrolment-id'  */
ALTER TABLE students
ADD COLUMN studentNumber VARCHAR(255);

UPDATE students
SET studentNumber = CONCAT(Course, '_', Enrolment, '_', id);

/*create table courses - where info is from student - initial created:
CREATE TABLE coursesList AS
SELECT id, Course, Enrolment
FROM students;

I don't want column ID in the 'coursesList', so I will drop the id column
ALTER TABLE coursesList
DROP COLUMN id;

during working on the database, I found the need to do the courses List manually (on excel) as I had to add the Modules to each course, the teachers and the room the classes took place 
than imported table coursesList (Table Data Import Wizard)
*/

/*create table Enrolment (started as student_counts because I was wanted to count the students based on enrolment) 
- where info is from student table*/
CREATE TABLE student_counts (
    Course VARCHAR(255),
    Enrolment VARCHAR(255),
    num_students INT
);
/* query to count how many students as per course and enrolment*/
INSERT INTO student_counts (Course, Enrolment, num_students)
SELECT Course, Enrolment, COUNT(*) AS num_students
FROM students
GROUP BY Course, Enrolment;

RENAME TABLE student_counts TO Enrolment;

/*Create grades table*/
CREATE TABLE grades AS
SELECT id, Name, Course, Enrolment
FROM students;

ALTER TABLE grades
ADD grades double;

ALTER TABLE grades
ADD CONSTRAINT FK_grades
FOREIGN KEY (id) REFERENCES students(id)
;

/*added by mistake feedback column in the grades table - will drop down*/
ALTER TABLE grades
DROP column feedback;

/*Create feedback table*/
CREATE TABLE feedback AS
SELECT id, Name, Course, Enrolment
FROM students;

/* Added feedback column on the feedback table - depending on the students grades as per CCT/QQI grading */
ALTER TABLE feedback
ADD feedback text;

UPDATE feedback
SET feedback = 'Exceptional'
WHERE id IN (SELECT id FROM grades WHERE grades > 90 AND grades = 100);

UPDATE feedback
SET feedback = 'Outstanding'
WHERE id IN (SELECT id FROM grades WHERE grades > 80 AND grades <= 89);

UPDATE feedback
SET feedback = 'Excellent'
WHERE id IN (SELECT id FROM grades WHERE grades > 70 AND grades <= 79);

UPDATE feedback
SET feedback = 'Very Good'
WHERE id IN (SELECT id FROM grades WHERE grades > 60 AND grades <= 69);

UPDATE feedback
SET feedback = 'Good'
WHERE id IN (SELECT id FROM grades WHERE grades > 50 AND grades <= 59);

UPDATE feedback
SET feedback = 'Acceptable'
WHERE id IN (SELECT id FROM grades WHERE grades > 40 AND grades <= 49);

UPDATE feedback
SET feedback = 'Fail'
WHERE id IN (SELECT id FROM grades WHERE grades <=39);

SELECT * FROM students;

/*imported lecturers table with data about 20 lecturers, their names, role and type of class they teach - random data*/

SELECT * FROM feedback;