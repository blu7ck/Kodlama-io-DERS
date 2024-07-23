package com.blu4ck.demo.webApi.controllers;

import com.blu4ck.demo.business.abstracts.ModelService;
import com.blu4ck.demo.business.requests.CreateModelRequest;
import com.blu4ck.demo.business.responses.GetAllModelsResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/models")
@AllArgsConstructor
public class ModelsController {
    private ModelService modelService;

    @GetMapping
    public List<GetAllModelsResponse> getAll(){
        return modelService.getAll();
    }

//    @DeleteMapping("/{id]")
//    public void delete(@PathVariable int id){
//        this.modelService.delete(id);
//    }
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void create(@RequestBody @Valid CreateModelRequest createModelRequest){
        this.modelService.create(createModelRequest);
    }
}
