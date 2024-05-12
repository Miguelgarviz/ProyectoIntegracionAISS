package aiss.restclient.controller;

import aiss.restclient.exception.VideoNotFoundException;
import aiss.restclient.model.Caption;
import aiss.restclient.model.Channel;
import aiss.restclient.model.Comment;
import aiss.restclient.model.Video;
import aiss.restclient.repository.VideoRespository;
import org.springframework.data.domain.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Collections;

@RestController
@RequestMapping("/videominer/videos")
public class VideoController {

    @Autowired
    VideoRespository videoRepository;

    @Operation(
            summary = "Retrieve videos",
            description="Get all videos",
            tags = {"videos", "get"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = Channel.class),
                    mediaType ="application/json" )}),
            @ApiResponse(responseCode = "400", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "403", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "429", content = {@Content(schema = @Schema())})
    })
    // GET http://localhost:8080/videominer/videos?page=0&size=10&name={name}
    @GetMapping
    public List<Video> findAll(@RequestParam(defaultValue = "0") int page,
                               @RequestParam(defaultValue = "10") int size,
                               @RequestParam(required= false) String name,
                               @RequestParam(required = false) String order) {
        Pageable paging;
        if (order!= null)
            if (order.startsWith("-"))
                paging = PageRequest.of(page, size, Sort.by(order.substring(1)).descending());
            else
                paging = PageRequest.of(page, size, Sort.by(order).ascending());
        else
            paging = PageRequest.of(page, size);
        Page<Video> videoPage;
        if (name != null)
            videoPage = videoRepository.findByName(name,paging);
        else
            videoPage = videoRepository.findAll(paging);
        return videoPage.getContent();
    }


    @Operation(
            summary = "Retrieve one video",
            description="Get one video",
            tags = {"video", "get"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = Channel.class),
                    mediaType ="application/json" )}),
            @ApiResponse(responseCode = "400", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "403", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "429", content = {@Content(schema = @Schema())})
    })
    // GET http://localhost:8080/videominer/videos/{videoId}
    @GetMapping("/{id}")
    public Video findOne(@Parameter(description = "id of video to be searched") @PathVariable String id,
                         @RequestParam(defaultValue = "0") int page,
                         @RequestParam(defaultValue = "10") int size) throws VideoNotFoundException
    {
        Optional<Video> optionalVideo = videoRepository.findById(id);
        if (optionalVideo.isEmpty())
            throw new VideoNotFoundException();

        Pageable paging = PageRequest.of(page, size);
        Page<Video> pageResult = new PageImpl<>(Collections.singletonList(optionalVideo.get()), paging, 1);

        return pageResult.get().findFirst().get();
    }


    @Operation(
            summary = "Retrieve captions of a video",
            description="Get captions of a video",
            tags = {"captions", "video", "get"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = Channel.class),
                    mediaType ="application/json" )}),
            @ApiResponse(responseCode = "400", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "403", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "429", content = {@Content(schema = @Schema())})
    })
    //GET http://localhost:8080/videominer/videos/{videoId}/captions
    @GetMapping("/{id}/captions")
    public List<Caption> findCaptionsOfOneVideo(@Parameter(description = "id of video whose captions are to be searched")
                                                    @PathVariable String id,
                                                @RequestParam(defaultValue = "0") int page,
                                                @RequestParam(defaultValue = "10") int size,
                                                @RequestParam(required= false) String name,
                                                @RequestParam(required = false) String order) throws VideoNotFoundException {
        Video video = findOne(id, page, size);
        List<Caption> captions;
        if (name != null)
            captions = video.getCaptions().stream().filter(caption -> caption.getName().equals(name)).toList();
        else
            captions = video.getCaptions();
        Pageable paging;
        if (order!= null)
            if (order.startsWith("-"))
                paging = PageRequest.of(page, size, Sort.by(order.substring(1)).descending());
            else
                paging = PageRequest.of(page, size, Sort.by(order).ascending());
        else
            paging = PageRequest.of(page,size);
        int start = (int) paging.getOffset();
        int end = Math.min((start + paging.getPageSize()), captions.size());

        Page<Caption> captionPage = new PageImpl<>(captions.subList(start, end), paging, captions.size());

        return captionPage.getContent();
    }


    @Operation(
            summary = "Retrieve comments of a video",
            description="Get comments of a video",
            tags = {"comments", "video", "get"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = Channel.class),
                    mediaType ="application/json" )}),
            @ApiResponse(responseCode = "400", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "403", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "429", content = {@Content(schema = @Schema())})
    })
    //GET http://localhost:8080/videominer/videos/{videoId}/comments
    @GetMapping("/{id}/comments")
    public List<Comment> findCommentsOfOneVideo(@Parameter(description = "id of video whose comments are to be searched")
                                                    @PathVariable String id,
                                                @RequestParam(defaultValue = "0") int page,
                                                @RequestParam(defaultValue = "10") int size,
                                                @RequestParam(required= false) String createdOn,
                                                @RequestParam(required = false) String order) throws VideoNotFoundException {
        Video video = findOne(id, page, size);
        List<Comment> comments;
        if (createdOn != null)
            comments = video.getComments().stream().filter(comment -> comment.getCreatedOn().equals(createdOn)).toList();
        else
            comments = video.getComments();
        Pageable paging;
        if (order!= null)
            if (order.startsWith("-"))
                paging = PageRequest.of(page, size, Sort.by(order.substring(1)).descending());
            else
                paging = PageRequest.of(page, size, Sort.by(order).ascending());
        else
            paging = PageRequest.of(page,size);
        int start = (int) paging.getOffset();
        int end = Math.min((start + paging.getPageSize()), comments.size());

        Page<Comment> captionPage = new PageImpl<>(comments.subList(start, end), paging, comments.size());

        return captionPage.getContent();
    }


    @Operation(
            summary = "Post video",
            description="Post video",
            tags = { "video", "post"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = {@Content(schema = @Schema(implementation = Channel.class),
                    mediaType ="application/json" )}),
            @ApiResponse(responseCode = "400", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "403", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "429", content = {@Content(schema = @Schema())})
    })
    // POST http://localhost:8080/api/v1/videos
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Video create(@Valid @RequestBody Video video){
        return videoRepository.save(video);
    }


    @Operation(
            summary = "Update video",
            description="put video",
            tags = { "video", "put"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "204", content = {@Content(schema = @Schema(implementation = Channel.class),
                    mediaType ="application/json" )}),
            @ApiResponse(responseCode = "400", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "403", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "429", content = {@Content(schema = @Schema())})
    })
    // PUT http://localhost:8080/api/v1/videos/{videoId}
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@Valid @RequestBody Video video, @Parameter(description = "id of video to be updated") @PathVariable String id)
        throws VideoNotFoundException{
        Optional<Video> opVideo = videoRepository.findById(id);
        if(opVideo.isEmpty()){
            throw new VideoNotFoundException();
        }
        Video videoData = opVideo.get();
        videoData.setName(video.getName());
        videoData.setDescription(video.getDescription());
        videoData.setReleaseTime(video.getReleaseTime());
        videoRepository.save(videoData);
    }


    @Operation(
            summary = "Delete video",
            description="Delete video",
            tags = { "video", "delete"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = {@Content(schema = @Schema(implementation = Channel.class),
                    mediaType ="application/json" )}),
            @ApiResponse(responseCode = "400", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "403", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "429", content = {@Content(schema = @Schema())})
    })
    // DELETE http://localhost:8080/api/v1/videos/{videoId}
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@Parameter(description = "id of video to be deleted") @PathVariable String id) throws VideoNotFoundException{
        if(videoRepository.existsById(id)){
            videoRepository.deleteById(id);
        }
        else
            throw new VideoNotFoundException();
    }
}
