package de.itblogging.spring.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class Application {

  public static void main(String[] args) throws InterruptedException {
    ApplicationContext context =
        new AnnotationConfigApplicationContext(Application.class);
    Singleton singletonBean = context.getBean(Singleton.class);
    Prototype prototypeBean = context.getBean(Prototype.class);
    System.out.println("Singleton:" + singletonBean.getDate());
    System.out.println("Prototype:" + prototypeBean.getDate());
    System.out.println(">>>> Wait 5 seconds");
    Thread.sleep(5000);
    singletonBean = context.getBean(Singleton.class);
    prototypeBean = context.getBean(Prototype.class);
    System.out.println("Singleton:" + singletonBean.getDate());
    System.out.println("Prototype:" + prototypeBean.getDate());


    /**
     * Output
     * Singleton:Wed Feb 24 20:32:36 CET 2016
     * Prototype:Wed Feb 24 20:32:37 CET 2016
     * >>>> Wait 5 seconds
     * Singleton:Wed Feb 24 20:32:36 CET 2016
     * Prototype:Wed Feb 24 20:32:42 CET 2016
     */
  }
}