select name from students;
select name from students where stud_id = 1;


/*
inner join
*/
select stud_id, name, email,phone, a.addr_id, street, city, state, zip, country
FROM students s 
inner join addresses a 
on s.addr_id=a.addr_id;

/*
left outer join
*/
select stud_id, name, email,phone, a.addr_id, street, city, state, zip, country
FROM students s 
left outer join addresses a 
on s.addr_id=a.addr_id;
     
/*
right outer join
*/    
select stud_id, name, email,phone, a.addr_id, street, city, state, zip, country
  		FROM students s 
      right outer join addresses a 
      on s.addr_id=a.addr_id;   
 
/*
full outer join
*/    
select stud_id, name, email,phone, a.addr_id, street, city, state, zip, country
  		FROM students s 
      full outer join addresses a 
      on s.addr_id=a.addr_id;   

--findStudentByIdWithAddress--
/*
stdents + address join
*/
select stud_id, name, email,phone, a.addr_id, street, city, state, zip, country
  		FROM students s 
      left outer join addresses a 
      on s.addr_id=a.addr_id
      where s.stud_id=1;
 
/*
courses + students join
*/     

select c.*,s.* 
		from courses c 
		join course_enrollment ce
		on c.course_id = ce.course_id
		join students s
		on ce.stud_id=s.stud_id where c.course_id=1;


/*
students + courses join
*/


select s.* ,c.*
		from students s 
		join course_enrollment ce
		on s.stud_id = ce.stud_id
		join courses c
		on ce.course_id=c.course_id where s.stud_id=1;
       

/*
tutor + courses join
*/
/*
inner join
*/
SELECT t.tutor_id, t.name as tutor_name, email,course_id, c.name, description, start_date, end_date
      FROM tutors t 
      inner join courses c 
      on t.tutor_id=c.tutor_id; 
      
/*
left outer join
*/
SELECT t.tutor_id, t.name as tutor_name, email,course_id, c.name, description, start_date, end_date
      FROM tutors t 
      left outer join courses c 
      on t.tutor_id=c.tutor_id;
      
SELECT t.tutor_id, t.name as tutor_name, email,course_id, c.name, description, start_date, end_date
      FROM tutors t 
      left outer join courses c 
      on t.tutor_id=c.tutor_id
      where t.tutor_id=1;  
/*
tutor + address + courses
*/      
SELECT t.tutor_id, t.name as tutor_name, email, a.addr_id, street, city, state, zip, country,
       			course_id, c.name, description, start_date, end_date
      FROM tutors t 
      left outer join addresses a 
      on t.addr_id=a.addr_id
	  left outer join courses c on t.tutor_id=c.tutor_id
      where t.tutor_id=1;   
  
  

      
      
-- Courses검색      
SELECT * FROM COURSES
WHERE TUTOR_ID = 1
AND NAME LIKE '%Quick%'
AND START_DATE >= TO_DATE('2015/05/01');
      
      
      
      
      
      
      
      