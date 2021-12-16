package pl.put.poznan.transformer.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * dupa javadoc
 */
@SpringBootApplication(scanBasePackages = {"pl.put.poznan.transformer.rest"})
public class TextTransformerApplication {
    /**
     * dupa javadoc
     */
    public static void main(String[] args) {
        SpringApplication.run(TextTransformerApplication.class, args);
    }
}
