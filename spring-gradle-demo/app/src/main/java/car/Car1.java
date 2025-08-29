package car;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

@Component("Car1")
@PropertySource("classpath:application.properties")
public class Car1 {

    Engine engine;

    @Value("${app.wheels}")
    Integer wheels; // string to int
    @Value("${app.isBreak}")
    boolean isBreak; // string to boolean
    @Value("${app.driver}")
    String driver;

    // Constructor Injection
    public Car1(Engine engine) {
        this.engine = engine;
    }

    @PostConstruct
    public void setUp() {
        System.out.println("Car1 Bean is ready");
    }

    public void start () {
        if (engine != null) {
            engine.start();
        } else {
            System.out.println("Engine is not initialized.");
        }
    }

    @PreDestroy
    public void tearDown() {
        System.out.println("Car1 Bean is going to be destroyed");
    }
}