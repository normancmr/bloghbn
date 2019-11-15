package minru.chen.bloghbn;

import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class BloghbnApplication {


    public static void main(String[] args) {

        ApplicationContext context=SpringApplication.run(BloghbnApplication.class, args);
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

    }

}
