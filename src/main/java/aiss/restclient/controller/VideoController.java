package aiss.restclient.controller;

import aiss.restclient.exception.VideoNotFoundException;
import aiss.restclient.model.Video;
import aiss.restclient.repository.VideoRespository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/videominer/videos")
public class VideoController {

    @Autowired
    VideoRespository videoRespository;

    // GET http://localhost:8080/api/v1/videos
    @GetMapping
    public List<Video> findAll(){
        return videoRespository.findAll();
    }

    // GET http://localhost:8080/api/v1/videos/{videoId}
    @GetMapping("/{id}")
    public Video findOne(@PathVariable long id) throws VideoNotFoundException {
        Optional<Video> optionalVideo = videoRespository.findById(id);
        if(optionalVideo.isEmpty()){
            throw new VideoNotFoundException();
        }
        return optionalVideo.get();
    }

    // POST http://localhost:8080/api/v1/videos
    @PostMapping
    public Video create(@Valid @RequestBody Video video){
        return videoRespository.save(new Video(video.getName(),video.getDescription(),video.getReleaseTime()));
    }

    // PUT http://localhost:8080/api/v1/videos/{videoId}
    @PutMapping("/{id}")
    public void update(@Valid @RequestBody Video video, @PathVariable long id)
        throws VideoNotFoundException{
        Optional<Video> opVideo = videoRespository.findById(id);
        if(opVideo.isEmpty()){
            throw new VideoNotFoundException();
        }
        Video videoData = opVideo.get();
        videoData.setName(video.getName());
        videoData.setDescription(video.getDescription());
        videoData.setReleaseTime(video.getReleaseTime());
        videoRespository.save(videoData);
    }

    // DELETE http://localhost:8080/api/v1/videos/{videoId}
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        if(videoRespository.existsById(id)){
            videoRespository.deleteById(id);
        }
    }
}
