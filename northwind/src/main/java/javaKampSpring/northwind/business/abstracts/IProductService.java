package javaKampSpring.northwind.business.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import javaKampSpring.northwind.core.utilities.results.DataResult;
import javaKampSpring.northwind.core.utilities.results.Result;
import javaKampSpring.northwind.entities.concretes.Product;
import javaKampSpring.northwind.entities.dtos.ProductWithCategoryDto;

public interface IProductService {
	
	//List<Product> getAll();
	DataResult<List<Product>> getAll();
	
	DataResult<List<Product>> getAllSorted();
	//Sayfalama
	DataResult<List<Product>> getAll(int pageNo ,int pageSize);
	
	Result add(Product product);


	DataResult<Product> getByProductName(String productName);
	
	DataResult<Product> getByProductNameAndCategoryId(String productName , int categoryId);
	
	DataResult<List<Product>> getByProductNameOrCategoryId(String productName , int categoryId);

	DataResult<List<Product>> getByCategoryIdInCategoryId(List<Integer> categories);
	
	DataResult<List<Product>> getByProductNameContains(String productName);

	DataResult<List<Product>> getByProductNameStartsWith(String productName);
	
	DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails();
	
	
	
}
