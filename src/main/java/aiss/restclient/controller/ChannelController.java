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
    public Channel findOne(@PathVariable String id) throws ChannelNotFoundException {
        Optional<Channel> optionalChannel = channelRepository.findById(id);
        if(optionalChannel.isEmpty()){
            throw new ChannelNotFoundException();
        }
        return optionalChannel.get();
    }


    //POST http://localhost:8080/videominer/channels
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Channel create(@Valid @RequestBody Channel newChannel) {
        return channelRepository.save(newChannel);
    }

    //PUT http://localhost:8080/api/v1/channels/{channelId}
    @PutMapping("/{id}")
    public void update(@Valid @RequestBody Channel updChannel, @PathVariable String id)
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
    public void delete(@PathVariable String id){
        if(channelRepository.existsById(id)){
            channelRepository.deleteById(id);
        }
    }
}
