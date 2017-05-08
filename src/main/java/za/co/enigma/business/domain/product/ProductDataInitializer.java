package za.co.enigma.business.domain.product;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import za.co.enigma.business.domain.product.boundary.ProductsResource;

@Startup
@Singleton
public class ProductDataInitializer {

	private ProductsResource productsResource;
	
	public ProductDataInitializer(){}
	
	@Inject
	public ProductDataInitializer(ProductsResource productsResource){
		this.productsResource = productsResource;
	}
	
	@PostConstruct
	private void init(){
		createProducts();
	}

	private void createProducts() {
		// TODO Auto-generated method stub
		
	}
	
	
}
