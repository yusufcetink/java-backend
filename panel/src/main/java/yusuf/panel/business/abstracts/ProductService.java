package yusuf.panel.business.abstracts;

import java.util.List;

import yusuf.panel.core.utilities.results.DataResult;
import yusuf.panel.core.utilities.results.Result;
import yusuf.panel.entities.concretes.Product;

public interface ProductService {
	
	DataResult<List<Product>> getAll();
	
	Result add(Product product);
}
