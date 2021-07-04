package dev.aquashdw.demo.springtutorial.wav;

import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;

@Service
public class WavService {
    public InputStream extractPcm(byte[] rawBytes){
        String wavDataString = new String (rawBytes, StandardCharsets.UTF_8);
        String pcmDataString = wavDataString.split("data")[1];
        pcmDataString = pcmDataString.substring(4);
        byte[] pcmData = pcmDataString.getBytes();
        return new ByteArrayInputStream(pcmData);
    }
}
