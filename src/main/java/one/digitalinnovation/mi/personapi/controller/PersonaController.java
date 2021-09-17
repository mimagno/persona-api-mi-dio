package one.digitalinnovation.mi.personapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/miv1/people")
public class PersonaController {

    @GetMapping
    public String getTest(){
        return "API Online";
    }
}
