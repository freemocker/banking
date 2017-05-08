package za.co.enigma.business.domain.product.boundary;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import za.co.enigma.business.domain.product.control.ProductManager;

@Stateless
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Path("product")
public class ProductsResource {

	private ProductManager productManager;
	
	public ProductsResource(){}
	
	@Inject
	public ProductsResource(ProductManager productManager){
		this.productManager = productManager;
	}
}
