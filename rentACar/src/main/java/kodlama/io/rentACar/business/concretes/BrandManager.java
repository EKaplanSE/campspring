package kodlama.io.rentACar.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.core.utilities.results.DataResult;
import kodlama.io.rentACar.core.utilities.results.Result;
import kodlama.io.rentACar.core.utilities.results.SuccessDataResult;
import kodlama.io.rentACar.core.utilities.results.SuccessResult;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRespository;
import kodlama.io.rentACar.entities.concretes.Brand;

@Service //Bu sınıf bir Business nesnesidir.
public class BrandManager implements BrandService{

	private BrandRespository brandRepository;
	
	@Autowired
	public BrandManager(BrandRespository brandRepository) {
		this.brandRepository = brandRepository;
	}

	@Override
	public DataResult<List<GetAllBrandsResponse>> getAll() {
		
		List<Brand> brands = brandRepository.findAll();
		List<GetAllBrandsResponse> brandsResponse = new ArrayList<GetAllBrandsResponse>();
		
		for (Brand brand : brands) {
			GetAllBrandsResponse responseItem = new GetAllBrandsResponse();
			responseItem.setId(brand.getId());
			responseItem.setName(brand.getName());
			brandsResponse.add(responseItem);
		}

		return new SuccessDataResult<List<GetAllBrandsResponse>>(brandsResponse,"Data listelendi") ;
	}

	@Override
	public Result add(CreateBrandRequest createBrandRequest) {
		Brand brand = new Brand();
		brand.setName(createBrandRequest.getName());
		this.brandRepository.save(brand);
		return new SuccessResult("Marka eklendi");
	}

}
