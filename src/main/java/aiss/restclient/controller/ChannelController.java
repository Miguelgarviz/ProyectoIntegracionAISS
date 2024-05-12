package aiss.restclient.controller;

import aiss.restclient.exception.ChannelNotFoundException;
import aiss.restclient.model.*;
import aiss.restclient.repository.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

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

    @Operation(  
        summary = "Retrieve channel",  
        description="Get all channels",  
        tags = {"channels", "get"}  
        )  
        @ApiResponses({  
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = Channel.class),  
                    mediaType ="application/json" )}),  
            @ApiResponse(responseCode = "400", content = {@Content(schema = @Schema())}),  
            @ApiResponse(responseCode = "403", content = {@Content(schema = @Schema())}),  
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),  
            @ApiResponse(responseCode = "429", content = {@Content(schema = @Schema())})  
        }) 
    //GET http://localhost:8080/api/v1/channels
    @GetMapping
    public List<Channel> findAll(){
        return channelRepository.findAll();
    }


    @Operation(  
    summary = "Retrieve channel",  
    description="Get channel",  
    tags = {"channel", "get"}  
    )  
    @ApiResponses({  
        @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = Channel.class),  
                mediaType ="application/json" )}),  
        @ApiResponse(responseCode = "400", content = {@Content(schema = @Schema())}),  
        @ApiResponse(responseCode = "403", content = {@Content(schema = @Schema())}),  
        @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),  
        @ApiResponse(responseCode = "429", content = {@Content(schema = @Schema())})  
    }) 
    //GET http://localhost:8080/api/v1/channels/{channelId}
    @GetMapping("/{id}")
    public Channel findOne(@PathVariable String id) throws ChannelNotFoundException {
        Optional<Channel> optionalChannel = channelRepository.findById(id);
        if(optionalChannel.isEmpty()){
            throw new ChannelNotFoundException();
        }
        return optionalChannel.get();
    }


    @Operation(  
    summary = "Post channel",  
    description="Post channel",  
    tags = { "channel", "post"}  
    )  
    @ApiResponses({  
        @ApiResponse(responseCode = "201", content = {@Content(schema = @Schema(implementation = Channel.class),  
                mediaType ="application/json" )}),  
        @ApiResponse(responseCode = "400", content = {@Content(schema = @Schema())}),  
        @ApiResponse(responseCode = "403", content = {@Content(schema = @Schema())}),  
        @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),  
        @ApiResponse(responseCode = "429", content = {@Content(schema = @Schema())})  
    }) 
    //POST http://localhost:8080/videominer/channels
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Channel create(@Valid @RequestBody Channel newChannel) {
        return channelRepository.save(newChannel);
    }


    @Operation(  
    summary = "Update channel",  
    description="put channel",  
    tags = { "channel", "put"}  
    )  
    @ApiResponses({  
        @ApiResponse(responseCode = "204", content = {@Content(schema = @Schema(implementation = Channel.class),  
                mediaType ="application/json" )}),  
        @ApiResponse(responseCode = "400", content = {@Content(schema = @Schema())}),  
        @ApiResponse(responseCode = "403", content = {@Content(schema = @Schema())}),  
        @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),  
        @ApiResponse(responseCode = "429", content = {@Content(schema = @Schema())})  
    })
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


    @Operation(  
    summary = "Delete channel",  
    description="Delete channel",  
    tags = { "channel", "delete"}  
    )  
    @ApiResponses({  
        @ApiResponse(responseCode = "201", content = {@Content(schema = @Schema(implementation = Channel.class),  
                mediaType ="application/json" )}),  
        @ApiResponse(responseCode = "400", content = {@Content(schema = @Schema())}),  
        @ApiResponse(responseCode = "403", content = {@Content(schema = @Schema())}),  
        @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),  
        @ApiResponse(responseCode = "429", content = {@Content(schema = @Schema())})  
    })
    //DELETE http://localhost:8080/api/v1/channels/{channelId}
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        if(channelRepository.existsById(id)){
            channelRepository.deleteById(id);
        }
    }
}
