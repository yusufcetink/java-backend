package yusuf.panel.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yusuf.panel.business.abstracts.ProductService;
import yusuf.panel.core.utilities.results.DataResult;
import yusuf.panel.core.utilities.results.Result;
import yusuf.panel.core.utilities.results.SuccessDataResult;
import yusuf.panel.core.utilities.results.SuccessResult;
import yusuf.panel.dataAccess.abstracts.ProductDao;
import yusuf.panel.entities.concretes.Product;

@Service
public class ProductManager implements ProductService{
	
	private ProductDao productDao;

	@Autowired
	public ProductManager(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}

	@Override
	public DataResult<List<Product>> getAll() {
		return new SuccessDataResult<List<Product>>(this.productDao.findAll(),"Data Listelendi");
	}

	@Override
	public Result add(Product product) {
		this.productDao.save(product);
		return new SuccessResult("Ürün Eklendi");
	}
	
	
}
