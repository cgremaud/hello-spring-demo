package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Chris Bay
 */
@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    ///hello/goodbye
    @GetMapping("goodbye")

    public String goodbye() {
        return "Goodbye, Spring!";
    }


    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})

    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!  sent with @RequestMethod";
    }

    // Handles requests of the form /hello/LaunchCode
    @GetMapping("hello/{name}")

    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping
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
