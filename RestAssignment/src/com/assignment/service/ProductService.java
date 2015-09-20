package com.assignment.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.assignment.db.SingletonDB;
import com.assignment.model.Merchant;
import com.assignment.model.Product;

@Path("/product")
public class ProductService {
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Product> getAllProduct(){
		
		 return new ArrayList<Product>(SingletonDB.getInstance().getAllProduct())     ;

	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.TEXT_PLAIN })
	@Path("/{pid}")
	public String updateProduct(@PathParam ("pid") String pid,Product product) {
		SingletonDB.getInstance().updateProduct(pid, product);
		return pid;
	}
	@PUT
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.TEXT_PLAIN })
	public String addProduct(Product product) {
		SingletonDB.getInstance().addProduct(product);
		SingletonDB.getInstance().addProductToMerchant(product.getMerchantId(), product);
		return product.getPname();
	}
	
	@DELETE
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.TEXT_PLAIN })
	@Path("/{pid}")
	public String deleteProduct(@PathParam("pid") String pid) {
		return SingletonDB.getInstance().deleteProduct(pid);
		
	}
	
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/{id}")
	public Product getProduct(@PathParam("id") String id) {
		return SingletonDB.getInstance().getProduct(id);
		
	}

}
