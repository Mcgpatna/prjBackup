
package controllers;
 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



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
	@RequestMapping("/flower")
	public String showFlow()
	{
		return "flower";
	}
	/*@RequestMapping("/flw")
	public String shop1()
	{
		return "flower";
	}*/
}
