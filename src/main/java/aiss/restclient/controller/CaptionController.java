package aiss.restclient.controller;

import aiss.restclient.exception.CaptionNotFoundException;
import aiss.restclient.model.Caption;
import aiss.restclient.repository.CaptionRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/captions")
public class CaptionController {

    @Autowired
    CaptionRepository captionRepository;

    //GET http://localhost:8080/api/v1/captions
    @GetMapping
    public List<Caption> findAll(){
        return captionRepository.findAll();
    }

    //GET http://localhost:8080/api/v1/captions/{captionId}
    @GetMapping("/{id}")
    public Caption findOne(@PathVariable long id) throws CaptionNotFoundException {
        Optional<Caption> caption = captionRepository.findById(id);
        if(caption.isEmpty()){
            throw new CaptionNotFoundException();
        }
        return caption.get();
    }

    //POST http://localhost:8080/api/v1/captions
    @GetMapping
    public Caption create(@Valid @RequestBody Caption caption){
        return captionRepository.save(new Caption(caption.getName(), caption.getLanguage()));
    }

    //PUT http://localhost:8080/api/v1/captions/{captionId}
    @GetMapping("/{id}")
    public void update(@Valid @RequestBody Caption updCaption, @PathVariable long id)
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

    //DELETE http://localhost:8080/api/v1/captions/{captionId}
    @GetMapping("/{id}")
    public void delete(@PathVariable long id){
        if(captionRepository.existsById(id)){
            captionRepository.deleteById(id);
        }
    }
}
