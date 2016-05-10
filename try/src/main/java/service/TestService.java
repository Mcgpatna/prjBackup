package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import models.Test;
import models.TestImpl;

@Transactional
@Service 
public class TestService {
	
	@Autowired
    TestImpl dao;
	
	
	@Transactional
    public List<Test> viewProduct(){
    	return dao.viewProduct();
    }
	
	public TestService(){
		
	}

}
