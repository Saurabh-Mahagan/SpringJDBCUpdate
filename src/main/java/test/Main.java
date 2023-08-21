package test;

import org.example.deo.ProjectDeo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("application-context.xml");
        ProjectDeo  projectDeo=applicationContext.getBean("projectDeo" ,ProjectDeo.class);

        int count = projectDeo.updateProject(1,"school management system");
        System.out.println(count);
    }

}
