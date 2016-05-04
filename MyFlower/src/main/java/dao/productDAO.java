package dao;

import models.products;
import java.util.*;


public interface productDAO {
	

	public void insertProduct();
	
	public List<products> viewProduct();
	
	//public int updateProduct(int id);

}
