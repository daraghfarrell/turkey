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

    @Autowired
    AnyDomainRepo anyDomainRepo;

    @RequestMapping("/btest")
    public String btest(Model model) {
        return "btest";
    }

    @RequestMapping("/home2")
    public String home2(Model model) {
        model.addAttribute("all", anyDomainRepo.findAll());
        return "home2";
    }

    @RequestMapping("/")
    public String home(Model model) {
        return "home";
    }

    @RequestMapping("/alive")
    public String alive(Model model) {
        model.addAttribute("date", new Date());
        return ALIVE_TEMPLATE;
    }

    @RequestMapping("/list")
    public String list(Model model) {
        model.addAttribute("all", anyDomainRepo.findAll());
        return LIST_TEMPLATE;
    }

    @RequestMapping("/addToList")
    public String addToList(
            @RequestParam(value="name") String name,
            @RequestParam(value="number") int number,
            Model model) {

        anyDomainRepo.save(new AnyDomainOne(name, number));
        model.addAttribute("all", anyDomainRepo.findAll());

        return LIST_TEMPLATE;
    }

    @RequestMapping("/removeFromList")
    public String listRemove(
            @RequestParam(value="name") String name,
            Model model) {
        anyDomainRepo.delete(name);
        model.addAttribute("all", anyDomainRepo.findAll());

        return LIST_TEMPLATE;
    }
}