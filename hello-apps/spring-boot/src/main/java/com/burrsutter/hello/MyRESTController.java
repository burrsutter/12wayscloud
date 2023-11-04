package com.burrsutter.hello;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRESTController {
   int count;
   String greeting;
   boolean behave = true;
   boolean alive = true;

   @RequestMapping("/")
   public String sayHello() {
     greeting = "Bonjour";
     count++;
     System.out.println(greeting + ": " + count);
     return greeting + " from Spring Boot! " + count + "\n";
   }

   @RequestMapping(method = RequestMethod.GET, value = "/health")   
   public ResponseEntity<String> health() {               
        if (behave) {
          return ResponseEntity.status(HttpStatus.OK)
          .body("I am fine, thank you\n");     
        } else {             
          return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("unwell");          
        }
   }

   @RequestMapping(method = RequestMethod.GET, value = "/alive")   
   public ResponseEntity<String> alive() {               
        if (alive) {
          return ResponseEntity.status(HttpStatus.OK)
          .body("It's Alive! (Frankenstein)\n");
        } else {             
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("All dead, not mostly dead (Princess Bride)");
        }
   }


}
