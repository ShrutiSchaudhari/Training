package com.concerto.Test1;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 * Hello world!
 *
 */
public class ApplicationContextDemo 
{
//	@Autowired
//	 private ApplicationContext applicationContext;
	
	    public static void main(String[] args) {
	    	 ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
	         TaskManager taskManager = new TaskManager(applicationContext);
	         //hardcoded
//	         String taskName = "Command2"; // Replace with the desired task name
//	         Task task = taskManager.runTask(taskName);
//	         task.execute();
	         
	         
	         //dynamic
	         String filePath = "C:\\Users\\shruti.chaudhari\\Desktop\\Training\\FileReadingDemo.txt"; // Replace with the actual path to your file

		        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
		            String taskName;
		            while ((taskName = reader.readLine()) != null) {
		                try {
		                    Task task = TaskManager.runTask(taskName);
		                    task.execute();
		                    //Task task2 = TaskFactory.creatTask(taskName);                    
		                } catch (Exception e) {
		                    e.printStackTrace();
		                }
		            }
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
	    }
	

}
