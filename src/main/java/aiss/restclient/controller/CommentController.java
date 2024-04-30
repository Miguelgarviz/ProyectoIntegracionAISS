package aiss.restclient.controller;

import aiss.restclient.exception.CommentNotFoundException;
import aiss.restclient.model.Comment;
import aiss.restclient.repository.CommentRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/comments")
public class CommentController {

    @Autowired
    CommentRepository repository;

    // GET http://localhost:8080/api/v1/comments
    @GetMapping
    public List<Comment> findAll(){
        return repository.findAll();
    }

    // GET http://localhost:8080/api/v1/comments/{commentId}
    @GetMapping("/{id}")
    public Comment findOne(@PathVariable long id) throws CommentNotFoundException {
        Optional<Comment> optionalComment = repository.findById(id);
        if (optionalComment.isEmpty()) {
            throw new CommentNotFoundException();
        }
        return optionalComment.get();
    }

    // POST http://localhost:8080/api/v1/comments
    @PostMapping
    public Comment create(@Valid @RequestBody Comment comment){
        return repository.save(new Comment(comment.getText(),comment.getCreatedOn(),comment.getAuthor()));
    }

    // PUT http://localhost:8080/api/v1/comments/{commentId}
    @PutMapping("/{id}")
    public Comment update(@Valid @RequestBody Comment comment, @PathVariable long id)
            throws CommentNotFoundException{
        Optional<Comment> opComment = repository.findById(id);
        if(opComment.isEmpty()){
            throw new CommentNotFoundException();
        }
        Comment commentData = opComment.get();
        commentData.setText(comment.getText());
        commentData.setCreatedOn(comment.getCreatedOn());
        commentData.setAuthor(comment.getAuthor());
        return repository.save(commentData);
    }

    // DELETE http://localhost:8080/api/v1/comments/{commentId}
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
    }
}
