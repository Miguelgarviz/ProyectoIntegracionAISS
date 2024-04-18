package aiss.YouTubeMiner.services;

import aiss.YouTubeMiner.model.youtube.caption.Caption;
import aiss.YouTubeMiner.model.youtube.caption.CaptionSearch;
import aiss.YouTubeMiner.model.youtube.caption.CaptionSnippet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CaptionService {
    @Autowired
    RestTemplate restTemplate;

    public List<Caption> findAllCaptions() {
        List<Caption> captions = null;
        String uri = "https://www.googleapis.com/youtube/v3/captions";
        CaptionSearch search = restTemplate.getForObject(uri, CaptionSearch.class);
        captions = search.getItems();
        return captions;
    }

    public Caption findById (String id) {
        Caption caption = null;
        String uri = "https://www.googleapis.com/youtube/v3/captions/" + id;
        caption = restTemplate.getForObject(uri, Caption.class);
        return caption;
    }
}
