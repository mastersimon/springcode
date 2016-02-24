package de.itblogging.spring.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class Application {

    public static void main(final String[] args) throws InterruptedException {
        final ApplicationContext context =
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

        System.out.println(">>>> Wait 2 seconds");
        Thread.sleep(2000);

        SingletonLazyInit singletonLazyInitBean = context.getBean(SingletonLazyInit.class);
        System.out.println("SingletonLazyInit:" + singletonLazyInitBean.getDate());

        System.out.println(">>>> Wait 2 seconds");
        Thread.sleep(2000);

        singletonLazyInitBean = context.getBean(SingletonLazyInit.class);
        System.out.println("SingletonLazyInit:" + singletonLazyInitBean.getDate());

        /**
         * Output
         * Singleton:Wed Feb 24 20:58:52 CET 2016
         * Prototype:Wed Feb 24 20:58:52 CET 2016
         * >>>> Wait 5 seconds
         * Singleton:Wed Feb 24 20:58:52 CET 2016
         * Prototype:Wed Feb 24 20:58:57 CET 2016
         * >>>> Wait 2 seconds
         * Prototype:Wed Feb 24 20:58:59 CET 2016
         * >>>> Wait 2 seconds
         * Prototype:Wed Feb 24 20:58:59 CET 2016
         */
    }
}