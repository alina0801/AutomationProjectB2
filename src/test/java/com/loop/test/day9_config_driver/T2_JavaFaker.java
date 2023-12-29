package com.loop.test.day9_config_driver;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class T2_JavaFaker {
    @Test
    public void java_faker(){
        Faker faker = new Faker();
        System.out.println("faker.name().firstName() = " + faker.name().fullName());
        System.out.println("faker.numerify()(\"###-###-####\") = " + faker.numerify("202-###-#####"));
        System.out.println("faker.letterify(\"???????\") = " + faker.letterify("???????"));
        System.out.println("faker.bothify(\"faker.letterify(\\\"##??##?\\\") = \" + faker.letterify(\"???????\"))");






    }
}
