package com.darx.turkeytime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

/**
 * @author dfarrell on 13/12/2016.
 */

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Autowired
    FoodItemRepo foodItemRepo;

    @RequestMapping("/rlive")
    public String rlive() {
        return "\n*****\nrlive: "+new Date()+"\n*****\n";
    }

    @RequestMapping("/rlist")
    public Iterable<FoodItem> rlist() {
        return foodItemRepo.findAll();
    }

    @RequestMapping("/rlist-add")
    public Iterable<FoodItem> rlistAdd(
            @RequestParam(value="name") String name,
            @RequestParam(value="cookTimeInMin") int number) {
        foodItemRepo.save(new FoodItem(name, number));
        return foodItemRepo.findAll();
    }

    @RequestMapping("/rlist-remove")
    public Iterable<FoodItem>rlistRemove(
            @RequestParam(value="name") String name) {
        foodItemRepo.delete(name);
        return foodItemRepo.findAll();
    }
}
