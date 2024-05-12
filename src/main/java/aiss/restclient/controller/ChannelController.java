package aiss.restclient.controller;

import aiss.restclient.exception.ChannelNotFoundException;
import aiss.restclient.model.*;
import aiss.restclient.repository.*;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Collections;
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
        summary = "Retrieve channels",
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
    // GET http://localhost:8080/videominer/channels?page=0&size=10&name={name}&order={order}
    @GetMapping
    public List<Channel> findAll(@RequestParam(defaultValue = "0") int page,
                                 @RequestParam(defaultValue = "10") int size,
                                 @RequestParam(required= false) String name,
                                 @RequestParam(required = false) String order
    ) {
        Page<Channel> pageChannels;
        Pageable paging;
        if (order!= null)
            if (order.startsWith("-"))
                paging = PageRequest.of(page, size, Sort.by(order.substring(1)).descending());
            else
                paging = PageRequest.of(page, size, Sort.by(order).ascending());
        else
            paging = PageRequest.of(page, size);
        if(name!= null)
            pageChannels= channelRepository.findByName(name, paging);
        else
            pageChannels = channelRepository.findAll(paging);
        return pageChannels.getContent();
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
    //GET http://localhost:8080/videominer/channels/{channelId}?page=0&size=10
    @GetMapping("/{id}")
    public Channel findOne(@Parameter(description = "id of channel to be searched") @PathVariable String id,
    @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) throws ChannelNotFoundException {
        Optional<Channel> optionalChannel = channelRepository.findById(id);
        if(optionalChannel.isEmpty()){
            throw new ChannelNotFoundException();
        }
        Pageable paging = PageRequest.of(page, size);
        Page<Channel> pageResult = new PageImpl<>(Collections.singletonList(optionalChannel.get()), paging, 1);

        return pageResult.getContent().get(0);
    }


    @Operation(
            summary = "Retrieve videos of a channel",
            description="Get video of a channel",
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
    //GET http://localhost:8080/videominer/channels/{channelId}/videos?page=0&size=10
    @GetMapping("/{id}/videos")
    public List<Video> findVideosOfOneChannel(@Parameter(description = "id of channel whose videos are to be searched")
                                                  @PathVariable String id,
                                              @RequestParam(defaultValue = "0") int page,
                                              @RequestParam(defaultValue = "10") int size,
                                              @RequestParam(required= false) String name,
                                              @RequestParam(required = false) String order) throws ChannelNotFoundException {
        Channel channel = findOne(id,page,size);
        Pageable paging;
        if (order!= null)
            if (order.startsWith("-"))
                paging = PageRequest.of(page, size, Sort.by(order.substring(1)).descending());
            else
                paging = PageRequest.of(page, size, Sort.by(order).ascending());
            else
                paging = PageRequest.of(page, size);
        List<Video> videos;
        if (name!= null)
            videos = channel.getVideos().stream().filter(video -> video.getName().equals(name)).toList();
        else
            videos = channel.getVideos();
        int start = (int) paging.getOffset();
        int end = Math.min((start + paging.getPageSize()), videos.size());

        Page<Video> videoPage = new PageImpl<>(videos.subList(start, end), paging, videos.size());

        return videoPage.getContent();
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
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@Valid @RequestBody Channel updChannel,  @Parameter(description = "id of channel to be updated") @PathVariable String id)
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
        @ApiResponse(responseCode = "204", content = {@Content(schema = @Schema(implementation = Channel.class),
                mediaType ="application/json" )}),  
        @ApiResponse(responseCode = "400", content = {@Content(schema = @Schema())}),  
        @ApiResponse(responseCode = "403", content = {@Content(schema = @Schema())}),  
        @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),  
        @ApiResponse(responseCode = "429", content = {@Content(schema = @Schema())})  
    })
    //DELETE http://localhost:8080/api/v1/channels/{channelId}
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@Parameter(description = "id of channel to be deleted") @PathVariable String id) throws ChannelNotFoundException{
        if(channelRepository.existsById(id)){
            channelRepository.deleteById(id);
        }
        else
            throw new ChannelNotFoundException();
    }
}
