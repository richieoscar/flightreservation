package com.richieoscar.flightreservation;

import com.richieoscar.flightreservation.model.User;
import com.richieoscar.flightreservation.util.Validate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class FlightreservationApplicationTests {



    @Test
    void validateUSerData() {
        User user = new User();
        user.setFirstName("Oscar");
        user.setLastName("Anyiam");
        user.setEmail("oscaranyiam@gmail.com");
        user.setPassword("passwordone");

        Assertions.assertTrue(Validate.validateUserData(user));

    }

}
