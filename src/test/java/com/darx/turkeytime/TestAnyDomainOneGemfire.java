package com.darx.turkeytime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * @author dfarrell on 13/12/2016.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestAnyDomainOneGemfire {
    @Autowired
    FoodItemRepo foodItemRepo;

    @Test
    public void testWeCanCreateAndStoreADomainObject() {
        String name0 = "Name0";
        String name1 = "Name1";
        FoodItem any0 = new FoodItem(name0, 0);
        FoodItem any1 = new FoodItem(name1, 1);

        foodItemRepo.save(any0);
        foodItemRepo.save(any1);

        FoodItem resultA = foodItemRepo.findByName(name0);
        assertThat(name0, is(resultA.getName()));

        FoodItem resultB = foodItemRepo.findByName(name1);
        assertThat(name1, is(resultB.getName()));

        assertThat(name0, not(resultB));
        assertThat(name1, not(resultA));

        foodItemRepo.delete(name0);
        foodItemRepo.delete(name1);
    }

}
