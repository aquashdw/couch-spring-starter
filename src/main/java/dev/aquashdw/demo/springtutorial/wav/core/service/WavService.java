package dev.aquashdw.demo.springtutorial.wav.core.service;

import java.io.InputStream;

public interface WavService {
    InputStream extractPcm(byte[] rawBytes);
}
