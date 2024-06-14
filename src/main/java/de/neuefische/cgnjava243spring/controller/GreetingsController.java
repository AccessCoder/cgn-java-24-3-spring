package de.neuefische.cgnjava243spring.controller;

import de.neuefische.cgnjava243spring.model.Student;
import org.springframework.web.bind.annotation.*;

@RestController //"Verleiht" die Macht eines Controllers, unsere Klasse kann jetzt Anfragen entgegennehmen
@RequestMapping("/api/greet") //Wo befindet sich der Controller? Also wie müssen wir die URL anpassen.
public class GreetingsController {

    @GetMapping//Lauscht auf GET-Anfrage
    public String sayHello(){
        return "Hello";
    }

    @GetMapping("/{greetform}")
    public String sayCustomGreet(@PathVariable String greetform, //Gibt an das ein Variabler Pfad in der URL steckt -> Name muss übereinstimmen mit url
                                 @RequestParam(required = false, defaultValue = "") String name, //?{variablenname}={Wert} -> ?name=Max
                                 @RequestParam(required = false, defaultValue = "") String s){
        return greetform + " " + name + s;
    }

    @PostMapping
    public String readData(@RequestBody Student student){
        return student.name();
    }

}
