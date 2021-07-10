package dev.aquashdw.demo.springtutorial.props;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ValueReadComponent {
    private static final Logger logger = LoggerFactory.getLogger(ValueReadComponent.class);

    public ValueReadComponent(
            @Value("string value")
            String stringValue,
            @Value("${string.from.props}")
            String stringFromProps,
            @Value("${string.nonexistence:default-string}")
            String stringWithDefaults,
            @Value("${string.as.list}")
            String[] stringListFromProps
    ){
        logger.info(String.format("stringValue: %s", stringValue));
        logger.info(String.format("stringFromProps: %s", stringFromProps));
        logger.info(String.format("stringWithDefaults: %s", stringWithDefaults));
        logger.info(String.format("stringListFromProps: %s", Arrays.toString(stringListFromProps)));
    }
}
