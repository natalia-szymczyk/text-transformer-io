package pl.put.poznan.transformer.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Application used to transform text
 * Runs on localhost
 * Endpoints define text transformation
 */
@SpringBootApplication(scanBasePackages = {"pl.put.poznan.transformer.rest"})
public class TextTransformerApplication {
    public static void main(String[] args) {
        SpringApplication.run(TextTransformerApplication.class, args);
    }
}
