package dev.aquashdw.demo.springtutorial.wav;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;

@Service
public class WavService {
    private static final Logger logger = LoggerFactory.getLogger(WavService.class);

    public InputStream extractPcm(byte[] rawBytes){
        String wavDataString = new String (rawBytes, StandardCharsets.UTF_8);
        logger.debug("converted bytes to string for finding data index");
        String pcmDataString = wavDataString.split("data")[1];
        byte[] pcmData = pcmDataString.getBytes();
        return new ByteArrayInputStream(pcmData);
    }
}
