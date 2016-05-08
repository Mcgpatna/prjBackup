
package controllers;

 
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


//import dao.productDAOImpl;;
import org.springframework.beans.factory.annotation.Autowired;
import service.ProductService;
import models.products;

@Controller
public class homeController {

	@Autowired
	ProductService p;
	
	//String message = "Welcome to Spring MVC!";
	 
	@RequestMapping(value="/details",method=RequestMethod.GET)
	public ModelAndView showDetails(@RequestParam(value = "name", required = false) Integer id) {
		System.out.println("in controller");
 
		ModelAndView mv = new ModelAndView();
	//	mv.addObject("message", message);
		mv.addObject("name", id);
		
		return mv;
	}
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
		//dao.productDAOImpl prd=new dao.productDAOImpl();
	//	prd.insertProduct();
		ModelAndView mv = new ModelAndView();
		mv.addObject("pList",p.viewProduct());
		
		
		return mv;
	}
	
	// spring form dated 8-5-16
	
	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public String viewProduct(Model model) {
		model.addAttribute("products", new products());
		model.addAttribute("listProduct", p.viewProduct());
		return "product";
	}

	
	
	
	
	@RequestMapping(value= "/product/add", method = RequestMethod.POST)
	public String addProduct(@ModelAttribute("products") products p1){
		
		if(p1.getId() == 0){
			//new product, add it
			p.addProduct(p1);
		}else{
			//existing product, call update
			p.updateProduct(p1);
		}
		
		return "redirect:/product";
		
	}
	
	
    
    @RequestMapping("/remove/{id}")
    public String removeProduct(@PathVariable("id") int id){
		
        p.removeProduct(id);
        return "redirect:/product";
    }
 
    @RequestMapping("/edit/{id}")
    public String editProduct(@PathVariable("id") int id, Model model){
        model.addAttribute("products", p.getProductById(id));
        model.addAttribute("listPersons",  p.viewProduct());
        return "product";
    }

   
	
	
}
