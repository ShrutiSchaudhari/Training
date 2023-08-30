package com.concerto.Test;

import java.io.BufferedReader;
import java.io.FileReader;


/**
 * Hello world!
 *
 */
public class StringToClassDemo 
{
	    public static void main(String[] args) {
	        String filePath = "C:\\Users\\shruti.chaudhari\\Desktop\\Training\\FileReadingDemo.txt"; // Replace with the actual path to your file

	        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
	            String taskName;
	            while ((taskName = reader.readLine()) != null) {
	                try {
	                    Task task = TaskFactory.creatTask(taskName);
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
	

//    public static void main( String[] args )
//    {
    	//String filePath = "C:\\Users\\shruti.chaudhari\\Desktop\\Training\\FileReadingDemo.txt"; // Replace with the actual path

      //  ClassPathResource resource = new ClassPathResource(filePath);
//    	TaskFactory taskFactory = applicationContext.getBean(TaskFactory.class);
//        try {
//			taskFactory.runTasksFromFile(filePath);
//		} catch (IllegalAccessException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
        
//        try {
//            InputStream inputStream = resource.getInputStream();
//            // Now you can work with the inputStream, read the contents, etc.
//            // Remember to close the inputStream when you're done.
//        } catch (Exception e) {
//            // Handle exceptions
//        }
//    	
//        try {
//        	String taskName = "Command1";
//        	
//        	Task myTask= TaskFactory.creatTask(taskName);
//        	myTask.execute();
//        	
//			
//		} catch (Exception e) {
//			System.out.println("Error occured main class");
//		}
    }

