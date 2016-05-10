package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import service.TestService;


@Controller
public class MyController {
	
	@Autowired
	TestService p;
	
	@RequestMapping("/List")
	public ModelAndView dispProduct() 
	{
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("pList",p.viewProduct());
		return mv;
	}
	
    @RequestMapping("/")
	public String showIndex()
	{
		return "index";
	}

    //@RequestMapping(value = "/edit", method = RequestMethod.GET)
    @RequestMapping(value="/details/{pid}",method = RequestMethod.GET)
    public ModelAndView showDetails(@PathVariable("pid") Integer pid)
    {
    	ModelAndView mv=new ModelAndView();
    	mv.addObject("pid",pid);
    	return mv;
    }
}
