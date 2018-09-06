package edu.ap.spring.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import edu.ap.spring.jpa.JokeRepository;

@Controller
@Scope("session")
public class JokeController {
   
   public JokeController() {
   }
       
   @RequestMapping("/joke")
   public String joke() {
	   return "joke";
   }
		   
   @RequestMapping("/joke_post")
   public String joke_post() {
	   return "";
   }
   
   @RequestMapping("/")
   public String root() {
	   return "redirect:/joke";
   }

   @PostMapping("/joke")
   public String setJoke(@RequestParam("firstName") String firstName, 
		   				 @RequestParam("lastName") String lastName,
		   				 Model model) {

      model.addAttribute("firstName", firstName);
      model.addAttribute("lastName", lastName);
      
      
      
      //model.addAttribute("joke", joke);
      
      //repository.save(new Joke(firstName, lastName, joke));
      
      return "joke_post";
   }
}
