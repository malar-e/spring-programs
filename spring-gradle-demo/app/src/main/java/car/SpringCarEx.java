package car;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringCarEx {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(CarConfiguration.class);
        Car1 car1 = context.getBean("Car1", Car1.class);
        car1.start();
        Car2 car2 = context.getBean("Car2", Car2.class);
        car2.start();
        Car3 car3 = context.getBean(Car3.class);
        car3.start();
        Car4 car4 = context.getBean(Car4.class);
        car4.start();

        System.out.println("Singleton beans same? " + (car1 == context.getBean("Car1", Car1.class)));
        System.out.println("Prototype beans same? " + (car4 == context.getBean(Car4.class)));

        context.close();
    }
}