package dev.aquashdw.demo.springtutorial.wav;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@RestController
@RequestMapping("wav")
public class WavController {
    private static final Logger logger = LoggerFactory.getLogger(WavController.class);

    private final ExtractPcmUseCase extractPcmUseCase;

    public WavController(
            @Autowired ExtractPcmUseCase extractPcmUseCase
    ){
        this.extractPcmUseCase = extractPcmUseCase;
    }

    @PostMapping(
            value = "extract-pcm",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    public void pcmExtractor(
            @RequestParam("wav-file") MultipartFile wavFile,
            HttpServletResponse response
    ){
        logger.info("received request extract-pcm");
        InputStream returnInputStream = extractPcmUseCase.extractPcm(wavFile);
        try {
            IOUtils.copy(returnInputStream, response.getOutputStream());
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
