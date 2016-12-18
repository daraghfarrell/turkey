package com.darx.turkeytime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

/**
 * @author dfarrell on 12/12/2016.
 */

@Controller
public class WebController {

    public static final String LIST_TEMPLATE = "list";
    public static final String ALIVE_TEMPLATE = "alive";
    public static final String TURKEY_TIME = "turkey-time";

    @Autowired
    FoodItemRepo foodItemRepo;

    @RequestMapping("/bootstrap-exs")
    public String btest(Model model) {
        return "bootstrap-examples";
    }


    @RequestMapping("/")
    public String home(Model model) {
        return TURKEY_TIME;
    }

    @RequestMapping("/alive")
    public String alive(Model model) {
        model.addAttribute("date", new Date());
        return ALIVE_TEMPLATE;
    }

    @RequestMapping("/addToList")
    public String addToList(
            @RequestParam(value="name") String name,
            @RequestParam(value="cookTimeInMin") int number,
            Model model) {

        foodItemRepo.save(new FoodItem(name, number));
        model.addAttribute("all", foodItemRepo.findAll());

        return TURKEY_TIME;
    }

    @RequestMapping("/removeFromList")
    public String listRemove(
            @RequestParam(value="name") String name,
            Model model) {
        foodItemRepo.delete(name);
        model.addAttribute("all", foodItemRepo.findAll());

        return TURKEY_TIME;
    }
}
