package models;



import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository 
public class TestImpl {
	
List<models.Test> pList=new ArrayList<models.Test>();
	
	@Autowired
    SessionFactory sessionFactory;
	
	public List<models.Test> viewProduct() 
	{
		 
		Session session=sessionFactory.getCurrentSession();
		List<models.Test> pList= session.createQuery("from Test").list();  
		
		return pList;
		  
		
	}
	public TestImpl(){
		
	}
	

}
