package com.blu4ck.demo.business.concretes;


import com.blu4ck.demo.business.abstracts.BrandService;
import com.blu4ck.demo.business.requests.CreateBrandRequest;
import com.blu4ck.demo.business.requests.UpdateBrandRequest;
import com.blu4ck.demo.business.responses.GetAllBrandResponse;
import com.blu4ck.demo.business.responses.GetByIdBrandResponse;
import com.blu4ck.demo.business.rules.BrandBusinessRules;
import com.blu4ck.demo.core.utilities.mappers.ModelMapperService;
import com.blu4ck.demo.dataAccess.BrandRepository;
import com.blu4ck.demo.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {
    private ModelMapperService modelMapperService;
    private final BrandRepository brandRepository;
    private BrandBusinessRules brandBusinessRules;

    @Override
    public List<GetAllBrandResponse> getAll() {

        List<Brand> brands = brandRepository.findAll();
        return brands.stream().map(brand -> this.modelMapperService.forResponse().map(brand,GetAllBrandResponse.class)).collect(Collectors.toList());
    }

    @Override
    public void add(CreateBrandRequest createBrandRequest) {
        this.brandBusinessRules.CheckIfBrandNameExists(createBrandRequest.getName());
        Brand brand = this.modelMapperService.forRequest().map(createBrandRequest,Brand.class);
                this.brandRepository.save(brand);
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
        Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest,Brand.class);
        this.brandRepository.save(brand);
    }

    @Override
    public void delete(int id) {
        this.brandRepository.deleteById(id);
    }

    @Override
    public GetByIdBrandResponse getById(int id) {
        Brand brand = this.brandRepository.findById(id).orElseThrow();
// işin aslı bu şekilde ancak aşağıdaki gibi yazabiliyoruz -> GetByIdBrandResponse response = modelMapperService.forResponse().map(brand,GetByIdBrandResponse.class);
        return modelMapperService.forResponse().map(brand, GetByIdBrandResponse.class);
    }
}
