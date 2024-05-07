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
@RequestMapping("/videominer/captions")
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
    public Caption findOne(@PathVariable String id) throws CaptionNotFoundException {
        Optional<Caption> caption = captionRepository.findById(id);
        if(caption.isEmpty()){
            throw new CaptionNotFoundException();
        }
        return caption.get();
    }

    //POST http://localhost:8080/api/v1/captions
    @PostMapping
    public Caption create(@Valid @RequestBody Caption caption){
        return captionRepository.save(caption);
    }

    //PUT http://localhost:8080/api/v1/captions/{captionId}
    @PutMapping("/{id}")
    public void update(@Valid @RequestBody Caption updCaption, @PathVariable String id)
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
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        if(captionRepository.existsById(id)){
            captionRepository.deleteById(id);
        }
    }
}
