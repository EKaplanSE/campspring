package kodlama.io.rentACar.business.abstracts;

import java.util.List;

import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.core.utilities.results.DataResult;
import kodlama.io.rentACar.core.utilities.results.Result;

public interface BrandService {
	DataResult<List<GetAllBrandsResponse>> getAll();
	Result add(CreateBrandRequest createBrandRequest);
}
