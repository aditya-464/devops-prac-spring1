package devops_prac.devops_prac_spring1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Welcome {
    @GetMapping("/welcome")
    public ResponseEntity<String> welcome(){
        return new ResponseEntity<>("Jai Shree Radha", HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<String> getMyName(@PathVariable String name){
//        return new ResponseEntity<>("Your name is: " + name + " with the blessings of Shri Radha Rani!", HttpStatus.OK);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Your name is: " + name + " with the blessings of Shri Radha Rani!");
    }

    @GetMapping("/bhajan")
    public ResponseEntity<String> bhajan(){
        return new ResponseEntity<>("Radha, Radha, Radha", HttpStatus.OK);
    }
}
