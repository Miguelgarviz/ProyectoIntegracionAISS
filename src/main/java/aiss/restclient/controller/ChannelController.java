package aiss.restclient.controller;

import aiss.restclient.exception.ChannelNotFoundException;
import aiss.restclient.model.*;
import aiss.restclient.repository.ChannelRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/videominer/channels")
public class ChannelController {

    @Autowired
    ChannelRepository channelRepository;

    @Autowired
    VideoController videoController;

    @Autowired
    CaptionController captionController;
    @Autowired
    CommentController commentController;

    @Autowired
    UserController userController;

    //GET http://localhost:8080/api/v1/channels
    @GetMapping
    public List<Channel> findAll(){
        return channelRepository.findAll();
    }

    //GET http://localhost:8080/api/v1/channels/{channelId}
    @GetMapping("/{id}")
    public Channel findOne(@PathVariable long id) throws ChannelNotFoundException {
        Optional<Channel> optionalChannel = channelRepository.findById(id);
        if(optionalChannel.isEmpty()){
            throw new ChannelNotFoundException();
        }
        return optionalChannel.get();
    }

    //POST http://localhost:8080/api/v1/channels
    @PostMapping
    public Channel create(@Valid @RequestBody Channel newChannel){
        Channel channel = channelRepository.save(new Channel(newChannel.getName(), newChannel.getDescription(), newChannel.getCreatedTime()));
        List<Video> newVideos = newChannel.getVideoList();
        for(Video video : newVideos){
            Video vid = videoController.create(new Video(video.getName(),video.getDescription(),video.getReleaseTime()));
            if(video.getCaptionList() != null){
                video.getCaptionList().forEach(caption -> vid.getCaptionList().add(captionController.create(new Caption(caption.getName(),caption.getLanguage()))));
            }
            video.getComments().forEach(comment -> {
                User newUser = comment.getAuthor();
                System.out.println();
                System.out.println(newUser.getName() + "//" + newUser.getUser_link());
                System.out.println(newUser.getPicture_link() + " ## ");
                vid.getComments().add(commentController.create(new Comment(comment.getText(), comment.getCreatedOn(), userController.create(new User(newUser.getName(), newUser.getUser_link(), newUser.getPicture_link())))));
            });
            channel.getVideoList().add(vid);
        }
        return newChannel;
    }

    //PUT http://localhost:8080/api/v1/channels/{channelId}
    @PutMapping("/{id}")
    public void update(@Valid @RequestBody Channel updChannel, @PathVariable long id)
        throws ChannelNotFoundException{
        Optional<Channel> channelData = channelRepository.findById(id);
        if (channelData.isEmpty()){
            throw new ChannelNotFoundException();
        }
        Channel channel = channelData.get();
        channel.setName(updChannel.getName());
        channel.setDescription(updChannel.getDescription());
        channel.setCreatedTime(updChannel.getCreatedTime());
        channelRepository.save(channel);
    }

    //DELETE http://localhost:8080/api/v1/channels/{channelId}
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        if(channelRepository.existsById(id)){
            channelRepository.deleteById(id);
        }
    }
}
