package javaKampSpring.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javaKampSpring.northwind.business.abstracts.IProductService;
import javaKampSpring.northwind.core.utilities.results.DataResult;
import javaKampSpring.northwind.core.utilities.results.Result;
import javaKampSpring.northwind.core.utilities.results.SuccesDataResult;
import javaKampSpring.northwind.core.utilities.results.SuccessResult;
import javaKampSpring.northwind.dataAccess.abstracts.ProductDao;
import javaKampSpring.northwind.entities.concretes.Product;
import javaKampSpring.northwind.entities.dtos.ProductWithCategoryDto;

@Service
public class ProductManager implements IProductService{
	
	private ProductDao productDao;
	
	@Autowired
	public ProductManager(ProductDao pruductDao) {
		this.productDao = pruductDao;
	}

	@Override
	public DataResult<List<Product>>  getAll() {
		return new SuccesDataResult<List<Product>>
		(this.productDao.findAll(),"Data listelendi");
	}

	@Override
	public Result add(Product product) {
		this.productDao.save(product);
		return new SuccessResult("Ürün eklendi");
	}

	

	@Override
	public DataResult<Product> getByProductName(String productName) {
		return new SuccesDataResult<Product>
		(this.productDao.getByProductName(productName),"Data listelendi");
	}

	@Override
	public DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId) {
		return new SuccesDataResult<Product>
		(this.productDao.getByProductNameAndCategory_CategoryId(productName,categoryId),"Data listelendi");
	}

	@Override
	public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
		return new SuccesDataResult<List<Product>>
		(this.productDao.getByProductNameOrCategory_CategoryId(productName,categoryId),"Data listelendi");
	}

	@Override
	public DataResult<List<Product>> getByCategoryIdInCategoryId(List<Integer> categories) {
		return new SuccesDataResult<List<Product>>
		(this.productDao.getByCategoryIn(categories),"Data listelendi");
	}

	@Override
	public DataResult<List<Product>> getByProductNameContains(String productName) {
		return new SuccesDataResult<List<Product>>
		(this.productDao.getByProductNameContains(productName),"Data listelendi");
	}

	@Override
	public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
		return new SuccesDataResult<List<Product>>
		(this.productDao.getByProductNameStartsWith(productName),"Data listelendi");
	
	}

	@Override
	public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
		
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		
		
		return new SuccesDataResult<List<Product>>(this.productDao.findAll(pageable).getContent());
	}

	@Override
	public DataResult<List<Product>> getAllSorted() {
		Sort sort = Sort.by(Sort.Direction.DESC,"productName");
		return new SuccesDataResult<>(this.productDao.findAll());
	}

	//8.gün
	@Override
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
		// TODO Auto-generated method stub
		return new SuccesDataResult<List<ProductWithCategoryDto>> 
		(this.productDao.getProductWithCategoryDetails(),"Data listelendi");
	}

}
