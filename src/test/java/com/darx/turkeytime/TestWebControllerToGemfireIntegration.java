package com.darx.turkeytime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author dfarrell on 12/12/2016.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestWebControllerToGemfireIntegration {

    @Autowired
    private TestRestTemplate template;

    @Autowired
    private FoodItemRepo foodItemRepo;

    @Test
    public void testWeCanAddToGemfireCache() throws Exception {
        String name0 = "Name0";
        String name1 = "Name1";
        FoodItem any0 = new FoodItem(name0, 0);
        FoodItem any1 = new FoodItem(name1, 1);

        foodItemRepo.save(any0);
        foodItemRepo.save(any1);

        foodItemRepo.delete(name0);
        foodItemRepo.delete(name1);
    }

}
