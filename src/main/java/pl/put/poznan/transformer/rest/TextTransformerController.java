package pl.put.poznan.transformer.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.transformer.logic.TextTransformer;
import java.util.Arrays;

@RestController
@RequestMapping("/{text}")
public class TextTransformerController {
    private static final Logger logger = LoggerFactory.getLogger(TextTransformerController.class);

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public String get(@PathVariable String text, @RequestParam(value = "transformations", defaultValue = "upper") String[] transformations) {
        // Log the parameters
        logger.debug(text);
        logger.debug(Arrays.toString(transformations));

        // Perform the transformation, you should run your logic here, below is just a silly example
        TextTransformer transformer = new TextTransformer(transformations);
        return transformer.transform(text);
    }
}