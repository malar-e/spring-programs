package example;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import java.util.Arrays;
import org.springframework.context.annotation.Scope;


public class SpringEx {
    public static void main(String[] args) {
        // var is local variable type - only for local vars

        // 1. Launch a Spring Context
        var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);

        // 3. Retrieving Beans managed by Spring
        String name1 = (String) context.getBean("name"); // returns object
        System.out.println("Name: "+name1);
        String name2 = context.getBean("name", String.class); // return string
        System.out.println("Name: "+name2);
        System.out.println("Name1 == Name2? " + (name1 == name2));
        System.out.println("Age: "+context.getBean("age",  Integer.class));
        Address add1 = (Address) context.getBean("address");
        System.out.println("Address1: "+ add1);
        Address add2 = context.getBean("address", Address.class);
        System.out.println("Address2: "+ add2);
        System.out.println("Address1 == Address2? " + (add1 == add2));
        System.out.println("Address: "+context.getBean(Address.class));
        Person person1 = (Person) context.getBean("person11");
        System.out.println("Person1: "+person1);
        Person person2 = context.getBean("person11", Person.class);
        System.out.println("Person2: "+person2);
        System.out.println("Person1 == Person2? " + (person1 == person2));
        System.out.println("Person: "+context.getBean("person12"));
        System.out.println("Person: "+context.getBean("person13"));
        System.out.println(Arrays.toString(context.getBeanDefinitionNames()));
        System.out.println(context.getBeanDefinitionCount());
        System.out.println(context.getBeanDefinition("name"));
    }
}

record Person(String name, int age, Address address) { };
record Address(String street, String city, String zip) { };

@Configuration 
class HelloWorldConfiguration {
    // 2. Configure the things that we want Spring to manage in HelloworldConfiguration
    // name - @Bean

    @Bean
    @Scope("prototype")
    public String name () {
        return "Malar";
    }

    @Bean
    public int age () {
        return 20;
    }

    @Bean
    @Primary
    @Scope("prototype")
    public Address address () {
        return new Address("50, South street", "Thozhuvur", "612804");
    }

    @Bean(name="address12")
    @Qualifier("addressQual")
    public Address address2 () {
        return new Address("50, West street", "Valangaiman", "612000");
    }

    @Bean(name="person11")
    public Person person1() { // manual wiring
        var person = new Person(name(), age(), address()); // name, age, address - calling bean method directly
        return person;
    }

    @Bean(name="person12")
    public Person person2() {
        var person = new Person("Aksh", 21, new Address("50, North street", "Coimbatore", "612805")); // name, age, address
        return person;
    }

    @Bean(name="person13")
    public Person person3(String name, @Qualifier("age") int age, @Qualifier("addressQual") Address address12) { // wiring or injecting the beans here
        var person = new Person(name, age, address12); // name, age, address12 - passing as parameters
        return person;
    }

}

