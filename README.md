# Student-Grade-Management-System

1. System introduction

Development tools: IDEA2018.2

JDK version: jdk1.8

MySQL version: 8.0.13

Backend: Java + Spring + SpringMVC + Mybatis

Front-end: Layui + JSP + HTML + CSS

2. System functions

  • log in system

a. Students

  • Class schedule query 
  
  • Grade query
  
  • Course inquiry 
  
  • Modify system login password
  
  • Course selection and withdrawal

b. Teacher

  • Enter student grades 
  
  • Modify system login password

c. Administrator

  • Student management: add, delete, modify and view student information
  
  • Teacher management: add, delete, modify, view teacher information

3. System Display

  •log in page
  
![image](https://user-images.githubusercontent.com/118161567/201658158-8e430edb-9a0e-451f-bb22-1913316d3244.png)
 
a. Students

  • Timetable query
  
![image](https://user-images.githubusercontent.com/118161567/201658187-6c6af686-c2fd-4ba7-b054-5a8ec392a8a0.png)

  • Course enquiry
  
![image](https://user-images.githubusercontent.com/118161567/201658223-f299f302-c3b6-420e-bd3d-3ad59924d062.png)

  • Result inquiry
  
![image](https://user-images.githubusercontent.com/118161567/201658233-8b54a7a9-b03e-4a0d-8663-b57cb241fd81.png)

  • Modify system login password
  
![image](https://user-images.githubusercontent.com/118161567/201658248-0816e329-bf93-4b7e-84ff-890e780b750c.png)

b. Teacher

  • Enter student grades
  
![image](https://user-images.githubusercontent.com/118161567/201658280-a69ec264-3c02-4852-8259-2b67c4764d5f.png)

  • Modify system login password
  
 ![image](https://user-images.githubusercontent.com/118161567/201658286-ec3166de-7baf-4519-8412-43c59ef83c29.png)

c. Administrator

  • Student management
  
![image](https://user-images.githubusercontent.com/118161567/201658317-4827eadc-694b-4a08-99bd-b0ff92627817.png)

![image](https://user-images.githubusercontent.com/118161567/201658366-c1a74a9d-f41c-4a36-8a24-d7ec8044e06d.png)
 
  • Teacher management
  
![image](https://user-images.githubusercontent.com/118161567/201658396-140f2419-9b0c-4088-818c-f2df69643914.png)

![image](https://user-images.githubusercontent.com/118161567/201658412-5c0469b2-deac-4c0a-90c5-fa95a7518a12.png)

4. Triggers
Code:
delimiter ;;
CREATE TRIGGER trig_1 BEFORE DELETE ON s FOR EACH ROW
BEGIN
 INSERT INTO s_copy (Xh,xm,xb,csrq,jg,sjhm,yxh,Zt,logn,pswd,time)
VALUES
 (old.Xh, old.xm, old.xb, old.csrq,old.jg,old.sjhm,old.yxh,old.Zt,old.logn,old.pswd,NOW());
--  (1, 1, 1, 1,NOW());
END;
;;
delimiter ;

delimiter ;;
CREATE TRIGGER trig_2 BEFORE DELETE ON t FOR EACH ROW
BEGIN
 INSERT INTO t_copy (Gh,xm,xb,csrq,Zc,jbgz,yxh,logn,pswd,time)
VALUES
 (old.Gh, old.xm, old.xb, old.csrq,old.Zc,old.jbgz,old.yxh,old.logn,old.pswd,NOW());
--  (1, 1, 1, 1,NOW());
END;
;;
delimiter ;

Function: When deleting a student (teacher) in the s(t) table, the s_copy(t_copy) table will store the deleted element and store the time of its deletion.

Result:
![image](https://user-images.githubusercontent.com/118161567/201659018-af50b3fd-8e8c-453f-9a13-527a3b774215.png)

5. Procedure
Code:
DROP PROCEDURE IF EXISTS CalculatePjjd;
CREATE PROCEDURE CalculatePjjd (in Xh char(10), in km char(10))
BEGIN
SET @zpcj=(SELECT zpcj FROM e WHERE e.Xh=Xh AND e.kh=(SELECT kh FROM c WHERE c.km=km));
-- 0-59 0
IF @zpcj BETWEEN 0 AND 59 THEN
		UPDATE e SET pjjd=0 WHERE e.Xh=Xh AND e.kh=(SELECT kh FROM c WHERE c.km=km);
-- 60 1
ELSEIF @zpcj=60 THEN
		UPDATE e SET pjjd=1 WHERE e.Xh=Xh AND e.kh=(SELECT kh FROM c WHERE c.km=km);
-- 61-63 1.3
ELSEIF @zpcj BETWEEN 61 AND 63 THEN
		UPDATE e SET pjjd=1.3 WHERE e.Xh=Xh AND e.kh=(SELECT kh FROM c WHERE c.km=km);
-- 64 1.5
ELSEIF @zpcj=64 THEN
		UPDATE e SET pjjd=1.5 WHERE e.Xh=Xh AND e.kh=(SELECT kh FROM c WHERE c.km=km);
-- 65-67 1.7
ELSEIF @zpcj BETWEEN 65 AND 67 THEN
		UPDATE e SET pjjd=1.7 WHERE e.Xh=Xh AND e.kh=(SELECT kh FROM c WHERE c.km=km);
-- 68-71 2
ELSEIF @zpcj BETWEEN 68 AND 71 THEN
		UPDATE e SET pjjd=2 WHERE e.Xh=Xh AND e.kh=(SELECT kh FROM c WHERE c.km=km);
-- 72-74 2.3
ELSEIF @zpcj BETWEEN 72 AND 74 THEN
		UPDATE e SET pjjd=2.3 WHERE e.Xh=Xh AND e.kh=(SELECT kh FROM c WHERE c.km=km);
-- 75-77 2.7
ELSEIF @zpcj BETWEEN 75 AND 77 THEN
		UPDATE e SET pjjd=2.7 WHERE e.Xh=Xh AND e.kh=(SELECT kh FROM c WHERE c.km=km);
-- 78-81 3
ELSEIF @zpcj BETWEEN 78 AND 81 THEN
		UPDATE e SET pjjd=3 WHERE e.Xh=Xh AND e.kh=(SELECT kh FROM c WHERE c.km=km);
-- 82-84 3.3
ELSEIF @zpcj BETWEEN 82 AND 84 THEN
		UPDATE e SET pjjd=3.3 WHERE e.Xh=Xh AND e.kh=(SELECT kh FROM c WHERE c.km=km);
-- 85-89 3.7
ELSEIF @zpcj BETWEEN 85 AND 89 THEN
		UPDATE e SET pjjd=3.7 WHERE e.Xh=Xh AND e.kh=(SELECT kh FROM c WHERE c.km=km);
-- 90-100 4
ELSEIF @zpcj BETWEEN 90 AND 100 THEN
		UPDATE e SET pjjd=4 WHERE e.Xh=Xh AND e.kh=(SELECT kh FROM c WHERE c.km=km);
END IF;
END;

Function: Calculate the corresponding grade point average according to the student's overall grade.

Result:

  CALL CalculatePjjd ('1102','系统结构')

For the student whose student number is 1102, calculate the grade point average of his system structure course.

Before running:
![image](https://user-images.githubusercontent.com/118161567/201659282-b5e0b3a1-fc97-4939-9ef0-cdc450b7ec10.png)

After running:
![image](https://user-images.githubusercontent.com/118161567/201659299-d98fea41-883c-4cac-a7d9-19a260f9946b.png)

