package com.darx.turkeytime;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.gemfire.mapping.Region;

/**
 * @author dfarrell on 13/12/2016.
 */

@Region("test")
public class FoodItem {

    @Id
    public String name;
    public int cookTimeInMin;

    @PersistenceConstructor
    public FoodItem(String name, int cookTimeInMin) {
        this.name = name;
        this.cookTimeInMin = cookTimeInMin;
    }

    @Override
    public String toString() {
        return "FoodItem{" +
                "name='" + name + '\'' +
                ", cookTimeInMin=" + cookTimeInMin +
                '}';
    }

    public int getCookTimeInMin() {
        return cookTimeInMin;
    }

    public void setCookTimeInMin(int cookTimeInMin) {
        this.cookTimeInMin = cookTimeInMin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
