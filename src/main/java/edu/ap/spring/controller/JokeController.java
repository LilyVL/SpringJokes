package edu.ap.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.json.Json;
import javax.json.JsonReader;
import javax.json.JsonObject;
import javax.json.JsonValue;
import java.io.StringReader;

import edu.ap.spring.jpa.JokeRepository;
import edu.ap.spring.jpa.Joke;

@Controller
@Scope("session")
public class JokeController {
   
   public JokeController() {
   }
   
   @Autowired
   JokeRepository repository;   
   
   @RequestMapping("/joke")
   public String joke() {
	   return "joke";
   }
		
   @RequestMapping("/list")
   public String list(Model model) {
	   model.addAttribute("jokes", repository.findAll());
	   
	   return "list";
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
      
      RestTemplate restTemplate = new RestTemplate();
      String reply = restTemplate.getForObject("http://api.icndb.com/jokes/random?firstName=" + firstName + "&lastName=" + lastName, String.class);
      System.out.println(reply);
      //model.addAttribute("joke", joke);
      
      JsonReader reader = Json.createReader(new StringReader(reply));
      JsonObject object = reader.readObject();
      JsonObject innerReply = object.getJsonObject("value");
      String joke = innerReply.getString("joke");
      System.out.println(joke);
      reader.close();

      model.addAttribute("joke", joke);
      repository.save(new Joke(firstName, lastName, joke));
      
      return "joke_post";
   }
}
