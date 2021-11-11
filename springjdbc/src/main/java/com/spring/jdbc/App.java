package com.spring.jdbc;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entites.Student;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "My Program started..." );
        // spring-JDBC = JdbcTemplate
        
		/*
		 * //for xml file 
		 * ApplicationContext con = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
		 */
        
        //for jdbcconfig.java
        ApplicationContext con = new AnnotationConfigApplicationContext(JdbcConfig.class);
        
        
		/*
		 * JdbcTemplate templet = con.getBean("jdbcTemplate",JdbcTemplate.class);
		 * 
		 * //insert query.... 
		 * String query = "insert into student(id,name,city) values(?,?,?)";
		 * 
		 * //fire query 
		 * int result = templet.update(query, 451, "Ashish Mewada", "Bhopal");
		 * System.out.println("number of record inserted..." +result);
		 */
       
        StudentDao studentDao = con.getBean("studentDao",StudentDao.class);
        //Insert................
//        Student student = new Student();
//        student.setId(121);
//        student.setName("Deepika");
//        student.setCity("Bhopal");
//        
//        int result = studentDao.insert(student);
//        
//        System.out.println("student added..."+result);
        
        //update............
		/*
		  Student student = new Student(); 
		  student.setId(222); 
		  student.setName("Ajay");
		  student.setCity("Mumbai");
		  
		  int result = studentDao.change(student);
		  System.out.println("data change."+result);
		 */
        
		/*
		 * //1.delete............. 
		 * Student student = new Student(); 
		 * student.setId(222);
		 * 
		 * int result = studentDao.delete(student);
		 * System.out.println("data deleted.."+result);
		 */
        
		/*//2.delete......... 
		 * int result = studentDao.delete(222);
		 * System.out.println("data deleted.."+result);
		 * */
        
		/*//select single student data
		 * Student student = studentDao.getStudent(123); 
		 * System.out.println(student);
		 */
        
        //select multiple student data
        List<Student> student = studentDao.getAllStudent();
        for(Student s:student) {
        	System.out.println(s);
        }
    }
}
