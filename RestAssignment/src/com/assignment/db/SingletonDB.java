package com.assignment.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.assignment.model.Merchant;
import com.assignment.model.Product;

public final class SingletonDB {
	private static SingletonDB singltonObj;
	private long merchantId ;
	private long productId ;
	private SingletonDB(){
	}
	public static SingletonDB getInstance(){
		if(singltonObj==null){
			singltonObj=new SingletonDB();
		}
		return singltonObj;
		}
	
private HashMap<String,Merchant> merchantMap = new HashMap<>();
private HashMap<String,Product> productMap = new HashMap<>();

public Merchant getMerchant(String id){
	return getMerchantMap().get(id);
}

public Product getProduct(String id){
	return getProductMap().get(id);
}

public HashMap<String, Merchant> getMerchantMap() {
	return merchantMap;
}
public void setMerchantMap(HashMap<String, Merchant> merchantMap) {
	this.merchantMap = merchantMap;
}
public HashMap<String, Product> getProductMap() {
	return productMap;
}
public void setProductMap(HashMap<String, Product> productMap) {
	this.productMap = productMap;
}

public List<Merchant> getAllMerchants() {
	return new ArrayList<Merchant>(getMerchantMap().values()) ;

}

public String updateMerchant(String id,Merchant merchant) {
	
	getMerchantMap().put(id,merchant);
	return id;
}

public String addMerchant(Merchant merchant) {
	long merchantId = this.merchantId ++;
	String id = merchantId + "" ;
	merchant.setId(id);
	getMerchantMap().put(id,merchant);
	return id;
}


public String deleteMerchant( String id) {
	getMerchantMap().remove(id);
	return id;
}



public List<Product> getAllProduct(){
	return new ArrayList<Product>( getProductMap().values());

}


public String updateProduct( String pid,Product product) {
	getProductMap().put(pid,product);
	return pid;
	
}

public String addProduct(Product product) {
	long productId = this.productId ++;
	String pid = productId + "" ;
	product.setPid(pid);
	getProductMap().put(pid,product);
	return pid;
	
}


public String deleteProduct(String pid) {
	for(String id : getMerchantMap().keySet()){
		Merchant mer = getMerchantMap().get(id);
		for(Product p : mer.getProductList()){
			if(p.getPid()!=null){
				if(Long.parseLong(p.getPid())==Long.parseLong(pid)){
					mer.getProductList().remove(p);
					break;
				}
			}
			
		}
		
	}
	getProductMap().remove(pid);
	return pid;
}


public void addProductToMerchant(String merchantId,Product product){
	Merchant merchant = getMerchantMap().get(merchantId);
	merchant.getProductList().add(product);
	
}
}
