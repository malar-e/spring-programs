package car;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;

@Component
@Scope("prototype")
public class Car4 {

    Engine engine;

    public void start () {
        if (engine != null) {
            engine.start();
        } else {
            System.out.println("Engine is not initialized.");
        }
    }

    @PostConstruct
    public void setUp() {
        System.out.println("Car4 Bean is ready");
    }

    @PreDestroy
    public void tearDown() {
        System.out.println("Car4 Bean is going to be destroyed");
    }

}
