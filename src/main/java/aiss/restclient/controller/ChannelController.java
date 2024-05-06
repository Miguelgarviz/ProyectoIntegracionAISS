package aiss.restclient.controller;

import aiss.restclient.exception.ChannelNotFoundException;
import aiss.restclient.model.*;
import aiss.restclient.repository.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/videominer/channels")
public class ChannelController {

    @Autowired
    ChannelRepository channelRepository;

    @Autowired
    VideoRespository videoRepository;

    @Autowired
    CaptionRepository captionRepository;
    @Autowired
    CommentRepository commentRepository;

    @Autowired
    UserRepository userRepository;

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
    @ResponseStatus(code = HttpStatus.CREATED, reason = "Channel created successfully")
    public Channel create(@Valid @RequestBody Channel newChannel) {
        Channel channel = new Channel();
        channel.setId(newChannel.getId());
        channel.setName(newChannel.getName());
        channel.setDescription(newChannel.getDescription());
        channel.setCreatedTime(newChannel.getCreatedTime());
        channel.setVideoList(newChannel.getVideoList());
        return channelRepository.save(channel);
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
