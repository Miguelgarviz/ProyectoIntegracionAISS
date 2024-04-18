package aiss.YouTubeMiner.services;

import aiss.YouTubeMiner.model.youtube.caption.Caption;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CaptionServiceTest {

    @Autowired
    CaptionService service;

    @Test
    @DisplayName("Get all captions")
    void findAllCaptions() {
        List<Caption> captions = service.findAllCaptions();
        assertFalse(captions.isEmpty(),"The list of captions is empty");
        System.out.println(captions);
    }

    @Test
    @DisplayName("Get caption by id")
    void findById(String id) {
        Caption caption = service.findById(id);
        assertNotNull(caption,"The caption is null");
        System.out.println(caption);
    }
}