package za.co.enigma.business.domain.product.control;

import javax.ejb.Stateless;
import javax.inject.Inject;

import za.co.enigma.business.domain.product.dao.ProductDAO;

@Stateless
public class ProductManager {

	private ProductDAO productDao;
	
	public ProductManager(){}
	
	@Inject
	public ProductManager(ProductDAO productDao){
		this.productDao = productDao;
	}
}
