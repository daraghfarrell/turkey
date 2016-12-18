package com.darx.turkeytime;

import org.springframework.data.repository.CrudRepository;

/**
 * @author dfarrell on 13/12/2016.
 */

public interface FoodItemRepo extends CrudRepository<FoodItem, String> {

    FoodItem findByName(String name);
}
