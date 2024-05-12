package aiss.restclient.controller;

import aiss.restclient.exception.ChannelNotFoundException;
import aiss.restclient.exception.CommentNotFoundException;
import aiss.restclient.model.Channel;
import aiss.restclient.model.Comment;
import aiss.restclient.repository.CommentRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/videominer/comments")
public class CommentController {

    @Autowired
    CommentRepository commentRepository;

    @Operation(
            summary = "Retrieve comments",
            description="Get all comments",
            tags = {"comments", "get"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = Channel.class),
                    mediaType ="application/json" )}),
            @ApiResponse(responseCode = "400", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "403", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "429", content = {@Content(schema = @Schema())})
    })
    // GET http://localhost:8080/videominer/comments?page=0&size=10&createdOn={createdOn}
    @GetMapping
    public List<Comment> findAll(@RequestParam(defaultValue = "0") int page,
                                 @RequestParam(defaultValue = "10") int size,
                                 @RequestParam(required= false) String createdOn,
                                 @RequestParam(required = false) String order
    ) {
        Page<Comment> commentPage;
        Pageable paging;
        if (order!= null)
            if (order.startsWith("-"))
                paging = PageRequest.of(page, size, Sort.by(order.substring(1)).descending());
            else
                paging = PageRequest.of(page, size, Sort.by(order).ascending());
        else
            paging = PageRequest.of(page, size);
        if(createdOn != null)
            commentPage = commentRepository.findByCreatedOn(createdOn, paging);
        else
            commentPage = commentRepository.findAll(paging);
        return commentPage.getContent();
    }


    @Operation(
            summary = "Retrieve comments of one user",
            description="Get comments of user",
            tags = {"comments", "user", "get"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = Channel.class),
                    mediaType ="application/json" )}),
            @ApiResponse(responseCode = "400", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "403", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "429", content = {@Content(schema = @Schema())})
    })
    // GET http://localhost:8080/videominer/comments/usuarios/{userId}?page=0&size=10&createdOn={createdOn}
    @GetMapping("/usuarios/{userId}")
    public List<Comment> findCommentsOfUser(@Parameter(description = "id of user whose comments to be searched") @PathVariable long userId,
                                            @RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "10") int size,
                                            @RequestParam(required= false) String createdOn,
                                            @RequestParam(required = false) String order) {
        // No hace falta poner nada porque ya está implementado en el findAll
        List<Comment> comments = findAll(page,size,createdOn,order);
        return comments.stream().filter(comment -> comment.getAuthor().getId().equals(userId)).collect(Collectors.toList());
    }


    @Operation(
            summary = "Retrieve one comment",
            description="Get one comment",
            tags = {"comment", "get"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = Channel.class),
                    mediaType ="application/json" )}),
            @ApiResponse(responseCode = "400", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "403", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "429", content = {@Content(schema = @Schema())})
    })
    // GET http://localhost:8080/videominer/comments/{commentId}
    @GetMapping("/{id}")
    public Comment findOne(@Parameter(description = "id of channel to be searched") @PathVariable String id,
                           @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) throws ChannelNotFoundException {
        Optional<Comment> optionalChannel = commentRepository.findById(id);
        if(optionalChannel.isEmpty()){
            throw new ChannelNotFoundException();
        }
        Pageable paging = PageRequest.of(page, size);
        Page<Comment> pageResult = new PageImpl<>(Collections.singletonList(optionalChannel.get()), paging, 1);
        return pageResult.getContent().get(0);
    }


    @Operation(
            summary = "Create one comment",
            description="Post one comment",
            tags = {"comment", "post"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = Channel.class),
                    mediaType ="application/json" )}),
            @ApiResponse(responseCode = "400", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "403", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "429", content = {@Content(schema = @Schema())})
    })
    // POST http://localhost:8080/videominer/comments
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Comment create(@Valid @RequestBody Comment comment) {
        return commentRepository.save(comment);
    }


    @Operation(
            summary = "Update one comment",
            description="Put one comment",
            tags = {"comment", "put"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "204", content = {@Content(schema = @Schema(implementation = Channel.class),
                    mediaType ="application/json" )}),
            @ApiResponse(responseCode = "400", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "403", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "429", content = {@Content(schema = @Schema())})
    })
    // PUT http://localhost:8080/videominer/comments/{commentId}
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@Valid @RequestBody Comment comment, @Parameter(description = "id of comment to be updated") @PathVariable String id)
            throws CommentNotFoundException{
        Optional<Comment> opComment = commentRepository.findById(id);
        if(opComment.isEmpty()){
            throw new CommentNotFoundException();
        }
        Comment commentData = opComment.get();
        commentData.setText(comment.getText());
        commentData.setCreatedOn(comment.getCreatedOn());
        commentData.setAuthor(comment.getAuthor());
        commentRepository.save(commentData);
    }


    @Operation(
            summary = "Delete one comment",
            description="Delete one comment",
            tags = {"comment", "delete"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "204", content = {@Content(schema = @Schema(implementation = Channel.class),
                    mediaType ="application/json" )}),
            @ApiResponse(responseCode = "400", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "403", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "429", content = {@Content(schema = @Schema())})
    })
    // DELETE http://localhost:8080/api/v1/comments/{commentId}
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@Parameter(description = "id of comment to be deleted") @PathVariable String id) throws CommentNotFoundException{
        if (commentRepository.existsById(id)) {
            commentRepository.deleteById(id);
        }
        else
            throw new CommentNotFoundException();
    }
}
