package dev.aquashdw.demo.springtutorial.wav;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Component
public class ExtractPcmUseCase {
    private final WavService service;

    private static final Logger logger = LoggerFactory.getLogger(ExtractPcmUseCase.class);

    public ExtractPcmUseCase(
            @Autowired WavService service
    ){
        this.service = service;
    }

    public InputStream extractPcm(MultipartFile file){
        byte[] rawBytes;
        try {
            rawBytes = file.getBytes();
            String dataContent = new String(rawBytes, StandardCharsets.UTF_8);
            logger.debug(dataContent.substring(0, 100));
            if(!dataContent.contains("data")){
                logger.warn("no data found in file");
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            }
        } catch (IOException e) {
            logger.error("io exception");
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return service.extractPcm(rawBytes);
    }
}
