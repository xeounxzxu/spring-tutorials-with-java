package com.example.app.mock;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class MockUtil {

    public static <T> T readJoin(String path, Class<T> type) {

        File jsonFile = null;

        try {
            jsonFile = new ClassPathResource(path).getFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String fileString = null;

        try {
            fileString = new String(Files.readAllBytes(jsonFile.toPath()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.readValue(fileString, type);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
