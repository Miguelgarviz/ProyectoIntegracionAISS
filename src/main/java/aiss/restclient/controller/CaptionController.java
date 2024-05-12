package aiss.restclient.controller;

import aiss.restclient.exception.CaptionNotFoundException;
import aiss.restclient.model.Caption;
import aiss.restclient.model.Channel;
import aiss.restclient.repository.CaptionRepository;
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

@RestController
@RequestMapping("/videominer/captions")
public class CaptionController {

    @Autowired
    CaptionRepository captionRepository;


    @Operation(
            summary = "Retrieve all captions",
            description="Get all captions",
            tags = {"captions", "get"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = Channel.class),
                    mediaType ="application/json" )}),
            @ApiResponse(responseCode = "400", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "403", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "429", content = {@Content(schema = @Schema())})
    })
    //GET http://localhost:8080/api/v1/captions?page=0&size=10&name={name}
    @GetMapping
    public List<Caption> findAll(@RequestParam(defaultValue = "0") int page,
                                 @RequestParam(defaultValue = "10") int size,
                                 @RequestParam(required= false) String name,
                                 @RequestParam(required = false) String order
    ) {
        Page<Caption> captionPage;
        Pageable paging;
        if (order!= null)
            if (order.startsWith("-"))
                paging = PageRequest.of(page, size, Sort.by(order.substring(1)).descending());
            else
                paging = PageRequest.of(page, size, Sort.by(order).ascending());
        else
            paging = PageRequest.of(page, size);
        if (name != null)
            captionPage = captionRepository.findByName(name,paging);
        else
            captionPage = captionRepository.findAll(paging);
        return captionPage.getContent();
    }


    @Operation(
            summary = "Retrieve one caption",
            description="Get one caption",
            tags = {"caption", "get"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = Channel.class),
                    mediaType ="application/json" )}),
            @ApiResponse(responseCode = "400", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "403", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "429", content = {@Content(schema = @Schema())})
    })
    //GET http://localhost:8080/api/v1/captions/{captionId}
    @GetMapping("/{id}")
    public Caption findOne(@Parameter(description = "id of caption to be searched") @PathVariable String id,
                           @RequestParam(defaultValue = "0") int page,
                           @RequestParam(defaultValue = "10") int size) throws CaptionNotFoundException {
        Optional<Caption> caption = captionRepository.findById(id);
        if(caption.isEmpty()){
            throw new CaptionNotFoundException();
        }
        Pageable paging = PageRequest.of(page, size);
        Page<Caption> captionPage = new PageImpl<>(Collections.singletonList(caption.get()), paging, 1);

        return captionPage.get().findFirst().get();
    }


    @Operation(
            summary = "Creates one caption",
            description="Post one caption",
            tags = {"caption", "post"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = Channel.class),
                    mediaType ="application/json" )}),
            @ApiResponse(responseCode = "400", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "403", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "429", content = {@Content(schema = @Schema())})
    })
    //POST http://localhost:8080/api/v1/captions
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Caption create(@Valid @RequestBody Caption caption) {
        return captionRepository.save(caption);
    }


    @Operation(
            summary = "Updates one caption",
            description="Put one caption",
            tags = {"caption", "put"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "204", content = {@Content(schema = @Schema(implementation = Channel.class),
                    mediaType ="application/json" )}),
            @ApiResponse(responseCode = "400", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "403", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "429", content = {@Content(schema = @Schema())})
    })
    //PUT http://localhost:8080/api/v1/captions/{captionId}
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@Valid @RequestBody Caption updCaption, @Parameter(description = "id of caption to be updated") @PathVariable String id)
        throws CaptionNotFoundException{
        Optional<Caption> opCaption = captionRepository.findById(id);

        if(opCaption.isEmpty()){
            throw new CaptionNotFoundException();
        }
        Caption caption = opCaption.get();
        caption.setName(updCaption.getName());
        caption.setLanguage(updCaption.getLanguage());
        captionRepository.save(caption);
    }


    @Operation(
            summary = "Deletes one caption",
            description="Delete one caption",
            tags = {"caption", "delete"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "204", content = {@Content(schema = @Schema(implementation = Channel.class),
                    mediaType ="application/json" )}),
            @ApiResponse(responseCode = "400", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "403", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "429", content = {@Content(schema = @Schema())})
    })
    //DELETE http://localhost:8080/api/v1/captions/{captionId}
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@Parameter(description = "id of caption to be deleted") @PathVariable String id) throws CaptionNotFoundException{
        if(captionRepository.existsById(id)){
            captionRepository.deleteById(id);
        }
        else
            throw new CaptionNotFoundException();
    }
}
