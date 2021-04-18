package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chris Bay
 */
@Controller
public class HelloController {

    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    // Handles requests of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    public String helloWithQueryParam(@RequestParam String name, Model model) {
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting", greeting); //attributeName matches up with the name used in the template.
        return "hello";
    }

   // Handles requests of the form /hello/LaunchCode
    @GetMapping("hello/{name}")
    public String helloWithPathParam(@PathVariable String name, Model model) {
        String greeting = "Hello " + name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";
    }

    // /hello/form
    @GetMapping("form")
    public String helloForm() {
        return "form";
    }

    @GetMapping("hello-names")
    public String helloNames(Model model){
        List<String> names = new ArrayList<>();
        names.add("Lex Luthor");
        names.add("Superman");
        names.add("Batgirl");
        model.addAttribute("names", names);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(-5);
        numbers.add(0);
        numbers.add(3);
        numbers.add(8);
        numbers.add(12);
        numbers.add(10);
        model.addAttribute("numbers", numbers);


        return "hello-list";
    }
}
