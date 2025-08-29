package car;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.Profile;

@Component("Car2")
@Profile("dev")
@Scope("prototype")
public class Car2 {

    // Field Injection
    @Autowired
    Engine engine;

    @PostConstruct
    public void setUp() {
        System.out.println("Car2 Bean is ready");
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
        System.out.println("Car2 Bean is going to be destroyed");
    }

}
