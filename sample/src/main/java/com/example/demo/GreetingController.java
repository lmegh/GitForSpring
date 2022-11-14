package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {
	 @Autowired
	    private SimpMessagingTemplate simpMessagingTemplate;
	 
	 @MessageMapping("/hellos")
	  @SendTo("/topic/greeting")
	  public Greeting greeting(HelloMessage message) throws Exception {
	    Thread.sleep(1000); // simulated delay
	    return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
	  }
	 
//	   @MessageMapping("/private")
//		  @SendTo("/topic/s/greetings")
//	    public Greeting privateGreeting(HelloMessage message) throws Exception {
//	        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
//	    }
}
