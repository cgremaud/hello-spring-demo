package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Chris Bay
 */
@Controller
public class HelloController {

    //    // Handle request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    // Handles requests of the form /hello?name=LaunchCode
//    @PostMapping("hello")
    @RequestMapping(value = "hello", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!  sent with @RequestMethod";
    }

    // Handles requests of the form /hello/LaunchCode
    @GetMapping("hello/{name}")
    @ResponseBody
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping
    @ResponseBody
    public String helloForms(){
        return "<html>" +
                "<body>" +
                "<form method = 'post' action = 'hello'>" + //action = 'hello' tells it to send the form to this/hello, which will activate the handler above.
                "<input type = 'text' name = 'name' / >" +
                "<button>submit</button>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

}
