
package controllers;

 
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import dao.productDAOImpl;;


@Controller
public class homeController {

	
	String message = "Welcome to Spring MVC!";
	 
	/*@RequestMapping("/hello")
	public ModelAndView showMessage(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		System.out.println("in controller");
 
		ModelAndView mv = new ModelAndView("world");
		mv.addObject("message", message);
		mv.addObject("name", name);
		
		return mv;
	}*/
	@RequestMapping(value={"/","/index"})
	public String showIndex()
	{
		return "index";
	}
	
	@RequestMapping("/signup")
	public String showSignUp()
	{
		return "signup";
	}
	@RequestMapping("/productDetails")
	public String showProduct()
	{
		return "productDetails";
	}
	
	@RequestMapping("/productView")
	public ModelAndView dispProduct()
	{
		dao.productDAOImpl prd=new dao.productDAOImpl();
		prd.insertProduct();
		ModelAndView mv = new ModelAndView();
		mv.addObject("pList",prd.viewProduct());
		
		
		return mv;
	}
}
