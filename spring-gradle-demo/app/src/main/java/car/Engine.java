package car;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


@Component
public class Engine {

    String type;

    @Value("Diesel")
    String fuel;

    Integer horsepower;
    int speed;

    public Engine(@Value("v8") String type) {
        this.type = type;
    }

    @Autowired // if two or more constructors
    public Engine(@Value("v8") String type, @Value("200") int speed, @Qualifier("horsepower") Integer horsepower) {
        this.type = type;
        this.speed = speed;
        this.horsepower = horsepower;
    }

    public void start () {
        System.out.println(type + " engine is starting...");
        System.out.println("Fuel type: " + fuel);
        System.out.println("Horsepower: " + horsepower);
        System.out.println("Engine started successfully.\n");
    }

}