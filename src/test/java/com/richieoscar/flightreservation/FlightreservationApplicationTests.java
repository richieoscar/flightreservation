package com.richieoscar.flightreservation;

import com.richieoscar.flightreservation.model.AppUser;
import com.richieoscar.flightreservation.util.Validate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FlightreservationApplicationTests {



    @Test
    void validateUSerData() {
        AppUser appUser = new AppUser();
        appUser.setFirstName("Oscar");
        appUser.setLastName("Anyiam");
        appUser.setEmail("oscaranyiam@gmail.com");
        appUser.setPassword("passwordone");

        Assertions.assertTrue(Validate.validateUserData(appUser));

    }

}
