package pl.put.poznan.transformer.rest;

import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.transformer.logic.TextTransformer;

@RestController
public class TextTransformerController {
    private static final Logger logger = LoggerFactory.getLogger(TextTransformerController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    public String index() {
        // TODO: List of available endpoints

        return "Index";
    }

    @RequestMapping(value = "/transform/{text}", method = RequestMethod.GET, produces = "application/json")
    public String transform(@PathVariable String text, @RequestParam(value = "transformations", defaultValue = "upper") String[] transformations) {
        logger.debug(text);
        logger.debug(Arrays.toString(transformations));

        TextTransformer transformer = new TextTransformer(transformations);

        return transformer.transform(text);
    }
}