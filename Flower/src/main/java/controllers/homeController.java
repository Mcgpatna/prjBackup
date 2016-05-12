package controllers;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.validation.Errors;

import java.io.*;

//import dao.productDAOImpl;;
import org.springframework.beans.factory.annotation.Autowired;
import service.ProductService;
import models.products;

@Controller
public class homeController {

	@Autowired
	ProductService p;
	private static String UPLOAD_LOCATION="E:/MCG-TTT/DT-PROJECT/Flower/src/main/webapp/resources/images/";
	
	//String message = "Welcome to Spring MVC!";
	 
	@RequestMapping(value="/details/{id}",method=RequestMethod.GET)
	public String showDetails(@PathVariable("id") int id,Model model) {
		System.out.println("in showDetails() of homecontroller"+p.getProductById(id));
		System.out.println("Pruduct details "+p.getProductById(id));
		model.addAttribute("products", p.getProductById(id));
		model.addAttribute("pid", id);
		//System.out.println("Pruduct details "+p.getProductById(id));
		
		return "details";
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
		model.addAttribute("pcount",p.countProduct());
		return "product";
	}

	
	
	
	
	@RequestMapping(value= "/product/add", method = RequestMethod.POST)
	public String addProduct(@ModelAttribute("products") products p1, Model model,Errors errors){
		System.out.println("product/add");
		
			if(p1.getPrdImage()!=null){
            if (p1.getPrdImage().getSize() == 0) 
            {
                errors.rejectValue("file", "missing.file");
            } 
            else
            {
            int pcount=p.countProduct()+1;	
			String str=p1.getPrdImage().getOriginalFilename();
			System.out.println("Str = "+str);
			int pos=str.indexOf(".");
			System.out.println("pos = "+pos);
			String str1=str.substring(pos);
			System.out.println("Str1 = "+str1);
			String str2=String.valueOf(pcount)+'a'+str1;
			//String str2=String.valueOf(p1.getId())+'a'+str1;
			System.out.println("Str2 = "+str2);
			MultipartFile obj=p1.getPrdImage();
			try{
			byte[] pimage=obj.getBytes();
			
			FileCopyUtils.copy(p1.getPrdImage().getBytes(), new File( UPLOAD_LOCATION + str2));//p1.getPrdImage().getOriginalFilename()));
			//ByteArrayOutputStream out=new ByteArrayOutputStream(pimage.length);
			FileOutputStream fos = new FileOutputStream(str2);
			
			fos.write(pimage.length);
			}
			catch(Exception e)
			{
				System.out.println("Error for image upload");
			}
		
			p1.setpLocation(UPLOAD_LOCATION+str2);
            
			
                    
			if(p1.getId() == 0){
			//new product, add it
				
				p.addProduct(p1);
			
			}
			else
			{
			//existing product, call update
			p.updateProduct(p1);
			}
            }
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
        model.addAttribute("listProduct",  p.viewProduct());
        System.out.println("in editProduct() of homecontroller"+p.getProductById(id));
        return "product";
    }

   
	
	
}