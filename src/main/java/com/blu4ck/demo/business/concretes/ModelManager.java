package com.blu4ck.demo.business.concretes;

import com.blu4ck.demo.business.abstracts.ModelService;
import com.blu4ck.demo.business.requests.CreateModelRequest;
import com.blu4ck.demo.business.responses.GetAllModelsResponse;
import com.blu4ck.demo.core.utilities.mappers.ModelMapperService;
import com.blu4ck.demo.dataAccess.ModelRepository;
import com.blu4ck.demo.entities.concretes.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {
    private ModelRepository modelRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllModelsResponse> getAll() {

        List<Model> models = modelRepository.findAll();

        return models.stream().map(model -> this.modelMapperService.forResponse().map(model,GetAllModelsResponse.class)).collect(Collectors.toList());
    }

    @Override
    public void create(CreateModelRequest createModelRequest) {
    Model model = this.modelMapperService.forRequest().map(createModelRequest,Model.class);
    
    this.modelRepository.save(model);
    }

//    @Override
//    public void delete(int id) {
//        this.modelRepository.deleteById(id);

    }
//
//    @Override
//    public void update(UpdateModelRequest updateModelRequest) {
//        Model model = this.modelMapperService.forRequest().map
//    }
//
//    @Override
//    public GetByIdModelResponse getById(int id) {
//        return null;
//    }

