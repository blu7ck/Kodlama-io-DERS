package com.blu4ck.demo.business.concretes;


import com.blu4ck.demo.business.abstracts.BrandRepository;
import com.blu4ck.demo.business.abstracts.BrandService;
import com.blu4ck.demo.business.requests.CreateBrandRequest;
import com.blu4ck.demo.business.responses.GetAllBrandResponse;
import com.blu4ck.demo.core.utilities.mappers.ModelMapperService;
import com.blu4ck.demo.dataAccess.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {
    private ModelMapperService modelMapperService;
    private final BrandRepository brandRepository;

    @Override
    public List<GetAllBrandResponse> getAll() {

        List<Brand> brands = brandRepository.findAll();
        return brands.stream().map(brand -> this.modelMapperService.forResponse().map(brand,GetAllBrandResponse.class)).collect(Collectors.toList());
    }

    @Override
    public void add(CreateBrandRequest createBrandRequest) {

        Brand brand = this.modelMapperService.forRequest().map(createBrandRequest,Brand.class);
                this.brandRepository.save(brand);
    }
}
