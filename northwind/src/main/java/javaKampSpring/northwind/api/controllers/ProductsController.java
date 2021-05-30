package javaKampSpring.northwind.api.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javaKampSpring.northwind.business.abstracts.IProductService;
import javaKampSpring.northwind.core.utilities.results.DataResult;
import javaKampSpring.northwind.core.utilities.results.Result;
import javaKampSpring.northwind.core.utilities.results.SuccesDataResult;
import javaKampSpring.northwind.entities.concretes.Product;
import javaKampSpring.northwind.entities.dtos.ProductWithCategoryDto;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@EnableSwagger2
@RestController
@RequestMapping("/api/products")
public class ProductsController {
	
	private IProductService productService;
	
	
	
	@Autowired
	public ProductsController(IProductService productService) {
		super();
		this.productService = productService;
	}



	//veri isteme
	@GetMapping("/getall")
	public DataResult<List<Product>> getAll(){
		return this.productService.getAll();
		
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Product product){
		return this.productService.add(product);
		
		
	}
	
	@GetMapping("/getByProductName")
	public DataResult<Product> getByProductName(@RequestParam String productName){
		return this.productService.getByProductName(productName);
		
	}
	@GetMapping("/getByProductNameAndCategoryId")
	DataResult<Product> getByProductNameAndCategoryId(@RequestParam("productName") String productName , @RequestParam("categoryId") int categoryId){
		return this.productService.getByProductNameAndCategoryId(productName,categoryId);
	}
	
	@GetMapping("/getByProductNameContains")
	public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName) {
		return this.productService.getByProductNameContains(productName);
	}
	
	
	@GetMapping("/geAllByPage")
	public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
		return this.productService.getAll(pageNo,pageSize);
	}
	
	@GetMapping("/geAllSortedDesc")
	public DataResult<List<Product>> getAllSorted() {
		return this.productService.getAllSorted();
	}
	
	@GetMapping("/getProductWithCategoryDetails")
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails(){
		return this.productService.getProductWithCategoryDetails();
		
	}
	

}
