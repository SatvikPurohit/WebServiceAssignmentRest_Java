package com.assignment.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.assignment.db.SingletonDB;
import com.assignment.model.Merchant;

@Path("/merchant")
public class MerchantService {

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Merchant> getAllMerchants() {
		// System.out.println("LLLLLLLLLLLLLLLLLLLLLLLLLLLLL");
		return SingletonDB.getInstance().getAllMerchants()     ;

	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.TEXT_PLAIN })
	@Path("/{id}")
	public String updateMerchant(@PathParam("id") String id, Merchant merchant) {
		return SingletonDB.getInstance().updateMerchant(id, merchant);
		
	}
	
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/{id}")
	public Merchant getMerchant(@PathParam("id") String id) {
		return SingletonDB.getInstance().getMerchant(id);
		
	}
	

	@PUT
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.TEXT_PLAIN })
	public String addMerchant(Merchant merchant) {

		SingletonDB.getInstance().addMerchant(merchant);
		return merchant.getName();
	}

	@DELETE
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.TEXT_PLAIN })
	@Path("/{id}")
	public String deleteMerchant(@PathParam("id") String id) {
		return SingletonDB.getInstance().deleteMerchant(id) ;

	}
	
	    @PUT
	    @Produces({ MediaType.TEXT_PLAIN })
	    @Consumes({ MediaType.APPLICATION_FORM_URLENCODED})
	    @Path("/merchantFormParam")
	    public String createMerchantUsingForm(@FormParam("merchantName") String merchantName, @FormParam("country") String country , @FormParam("currency") String currency){
	    	//System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
	    	Merchant merchant = new Merchant(); 
	    	//System.out.println(")))))))))))))))))"+merchantName );
	    	merchant.setCountry(country);
	    	merchant.setCurrency(currency);
	    	merchant.setName(merchantName);
	    	SingletonDB.getInstance().addMerchant(merchant);
			return merchant.getName();
	    }

}
