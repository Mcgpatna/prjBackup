package dao;


import java.util.ArrayList;
import java.util.List;

import models.products;

public class productDAOImpl implements productDAO{
	
	List<models.products> pList=new ArrayList<models.products>();
	
	public void insertProduct()
			{
		
			models.products p1=new products(1,"flower1","desc1","catg1",100,"available");
			models.products p2=new products(2,"flower2","desc2","catg2",200,"available");
			models.products p3=new products(3,"flower3","desc3","catg3",300,"available");
			models.products p4=new products(4,"flower4","desc4","catg4",250,"available");
			models.products p5=new products(5,"flower5","desc5","catg5",150,"available");
			models.products p6=new products(6,"flower6","desc6","catg6",20,"available");
			pList.add(p1);
			pList.add(p2);
			pList.add(p3);
			pList.add(p4);
			pList.add(p5);
			pList.add(p6);
			
			}
	
	public List<models.products> viewProduct()
	{
		return pList;
	}
	
	

}
