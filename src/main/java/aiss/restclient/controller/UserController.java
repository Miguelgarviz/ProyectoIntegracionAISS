package aiss.restclient.controller;

import aiss.restclient.exception.UserNotFoundException;
import aiss.restclient.model.Channel;
import aiss.restclient.model.User;
import aiss.restclient.repository.UserRepository;
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
@RequestMapping("/videominer/users")
public class UserController {

    @Autowired
    UserRepository userRepository;


    @Operation(
            summary = "Retrieve users",
            description="Get all users",
            tags = {"users", "get"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = Channel.class),
                    mediaType ="application/json" )}),
            @ApiResponse(responseCode = "400", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "403", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "429", content = {@Content(schema = @Schema())})
    })
    // GET http://localhost:8080/api/v1/users
    @GetMapping
    public List<User> findAll(@RequestParam(defaultValue = "0") int page,
                              @RequestParam(defaultValue = "10") int size,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String order
    ) {
        Pageable paging;
        if (order!= null)
            if (order.startsWith("-"))
                paging = PageRequest.of(page, size, Sort.by(order.substring(1)).descending());
            else
                paging = PageRequest.of(page, size, Sort.by(order).ascending());
        else
            paging = PageRequest.of(page, size);
        Page<User> userPage;
        if (name != null)
            userPage = userRepository.findByName(name,paging);
        else
            userPage = userRepository.findAll(paging);
        return userPage.getContent();
    }


    @Operation(
            summary = "Retrieve one user",
            description="Get one user",
            tags = {"user", "get"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = Channel.class),
                    mediaType ="application/json" )}),
            @ApiResponse(responseCode = "400", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "403", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "429", content = {@Content(schema = @Schema())})
    })
    // GET http://localhost:8080/api/v1/users/{userId}
    @GetMapping("/{id}")
    public User findOne(@Parameter(description = "id of user to be searched") @PathVariable long id,
                        @RequestParam(defaultValue = "0") int page,
                        @RequestParam(defaultValue = "10") int size) throws UserNotFoundException {
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isEmpty()){
            throw new UserNotFoundException();
        }
        Pageable paging = PageRequest.of(page, size);
        Page<User> userPage = new PageImpl<>(Collections.singletonList(optionalUser.get()), paging, 1);
        return userPage.get().findFirst().get();
    }


    @Operation(
            summary = "Create user",
            description="Post user",
            tags = {"user", "post"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = Channel.class),
                    mediaType ="application/json" )}),
            @ApiResponse(responseCode = "400", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "403", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "429", content = {@Content(schema = @Schema())})
    })
    // POST http://localhost:8080/api/v1/users
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@Valid @RequestBody User user){
        return userRepository.save(user);
    }


    @Operation(
            summary = "Update user",
            description="Put user",
            tags = {"user", "put"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "204", content = {@Content(schema = @Schema(implementation = Channel.class),
                    mediaType ="application/json" )}),
            @ApiResponse(responseCode = "400", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "403", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "429", content = {@Content(schema = @Schema())})
    })
    // PUT http://localhost:8080/api/v1/users/{userId}
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@Valid @RequestBody User updUser, @Parameter(description = "id of user to be updated") @PathVariable long id)
        throws UserNotFoundException{
        Optional<User> opUser = userRepository.findById(id);
        if(opUser.isEmpty()){
            throw new UserNotFoundException();
        }
        User user = opUser.get();
        user.setName(updUser.getName());
        user.setUser_link(updUser.getUser_link());
        user.setPicture_link(updUser.getPicture_link());
        userRepository.save(user);
    }


    @Operation(
            summary = "Delete user",
            description="Delete user",
            tags = {"user", "delete"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "204", content = {@Content(schema = @Schema(implementation = Channel.class),
                    mediaType ="application/json" )}),
            @ApiResponse(responseCode = "400", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "403", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "429", content = {@Content(schema = @Schema())})
    })
    // DELETE http://localhost:8080/api/v1/users/{userId}
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@Parameter(description = "id of user to be deleted") @PathVariable long id) throws UserNotFoundException {
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
        }
        else
            throw new UserNotFoundException();
    }
}
