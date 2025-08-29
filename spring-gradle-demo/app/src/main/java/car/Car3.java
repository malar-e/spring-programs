package car;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;

@Component
@Scope("singleton")
public class Car3 {

    Engine engine;

    // Setter Injection
    @Autowired
    public void setEngine (Engine engine) {
        this.engine = engine;
    }

    @PostConstruct
    public void setUp() {
        System.out.println("Car3 Bean is ready");
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
        System.out.println("Car3 Bean is going to be destroyed");
    }
    
}