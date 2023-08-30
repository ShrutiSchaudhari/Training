package com.concerto.Test1;

import java.util.HashMap;
import java.util.Map;


import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class TaskManager {

	private static ApplicationContext applicationContext;

    private static final Map<String, Class<? extends Task>> taskMap = new HashMap<String, Class<? extends Task>>();

 
    public TaskManager(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
        populateTaskMap();
    }
    
    
 

	private void populateTaskMap() {
        // Populate the taskMap with task names and their corresponding class types
        taskMap.put("Command1", Command1.class);
        taskMap.put("Command2", Command2.class);
        // Add more task mappings here
    }

	

	public static Task runTask(String taskName) {
        Class<? extends Task> taskClass = taskMap.get(taskName);
        if (taskClass != null) {
            Task taskInstance = applicationContext.getBean(taskClass);
            //taskInstance.execute();
            return taskInstance;
        } else {
            throw new IllegalArgumentException("Task not found: " + taskName);
        }
    }
//	 @Autowired
//    private ApplicationContext applicationContext;

//    public void runTask(String taskName) {
//       Task task = applicationContext.getBean(taskName, Task.class);
//        task.execute();
//    }

	
}
