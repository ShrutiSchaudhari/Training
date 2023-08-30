package com.concerto.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import org.springframework.core.io.ClassPathResource;

//this class map string to the class type and allows to instance based on string
public class TaskFactory {

	 private static final Map<String, Class<? extends Task>> taskMap = new HashMap<String, Class<? extends Task>>();
	 
	 static{
		 taskMap.put("Command1", Command1.class);
		 taskMap.put("Command2", Command2.class);
	 }
	 
	 public static Task creatTask(String taskName) throws InstantiationException, IllegalAccessException {
		 Class<? extends Task> taskClass = taskMap.get(taskName);
		 if(taskClass != null) {
			 return taskClass.newInstance();
		 }
		 else {
			 throw new IllegalArgumentException("Unknown task name :" +taskName);
		 }
	 }
	 
	 
//	 public void runTasksFromFile(String filePath) throws Exception, IllegalAccessException {
//	        try {
//	            InputStream inputStream = new ClassPathResource(filePath).getInputStream();
//	            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
//	            String line;
//	            while ((line = reader.readLine()) != null) {
//	                line = line.trim();
//	                if (!line.isEmpty()) {
//	                	creatTask(line);
//	                }
//	            }
//	            reader.close();
//	        } catch (IOException e) {
//	            throw new RuntimeException("Error reading tasks file", e);
//	        }
//	    }
	 
	 
}
