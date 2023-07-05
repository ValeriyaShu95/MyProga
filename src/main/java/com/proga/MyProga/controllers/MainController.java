package com.proga.MyProga.controllers;

import com.proga.MyProga.models.Database;
import com.proga.MyProga.repo.DatabaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Controller
public class MainController {


    private DatabaseRepository databaseRepository;

    @Autowired
    public MainController(DatabaseRepository databaseRepository) {
        this.databaseRepository = databaseRepository;
    }


    @GetMapping("/")
    public String home() {
        return "progas";
    }

//    @GetMapping("/progas")
//    public String home(Model model) {
//        Iterable<Database> database = databaseRepository.findAll();
//        model.addAttribute("database", database);
////        model.addAttribute("title", "Главная страница");
//        model.addAttribute("name", "LERA");
//        return "progas";
//    }
//
//    @GetMapping("/user/add")
//    public String userAdd(Model model) {
//        return "userAdd";
//    }

//    @PostMapping("/user/add")
//    public String userPostAdd(@RequestParam String name, @RequestParam Long id, @RequestParam int age, Model model) {
//        Database database = new Database(id, name, age);
//        databaseRepository.save(database);
//
//        return "redirect:/progas";
//    }
//
//    @GetMapping("/user/{id}")
//    public String userAdd(@PathVariable(value = "id") long id, Model model) {
//        Optional<Database> database = databaseRepository.findById(id);
//        ArrayList<Database> res = new ArrayList<>();
//        database.ifPresent(res::add);
//        model.addAttribute("database", res);
//        return "userGetInformation";
//    }


    @GetMapping("/user/max-age")
    public String getUserWithMaxAge(Model model) {
        Database database = databaseRepository.findUserWithMaxAge();
        model.addAttribute("database", database);
        return "user-details";
    }

    @GetMapping("/user/min-age")
    public String getUserWithMinAge(Model model) {
        Database database = databaseRepository.findUserWithMinAge();
        model.addAttribute("database", database);
        return "user-details";
    }

    @GetMapping("/user/avg-age")
    public String getUserWithAvgAge(Model model) {
        float database = databaseRepository.findUserAverageAge();
        model.addAttribute("title", database);
        return "user-average";
                //"user-average";
    }


    @GetMapping("/user/avg-more-then-age")
    public String getUserWithAgeMoreThenAvr(Model model) {
        List<Database> database = databaseRepository.findUserWithAgeMoreThenAvr();
        model.addAttribute("database", database);
        return "user-moreThen";
        //"user-average";
    }

}

//    @GetMapping("/greeting")
//    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
//        model.addAttribute("name", name);
//        return "greeting";
//    }