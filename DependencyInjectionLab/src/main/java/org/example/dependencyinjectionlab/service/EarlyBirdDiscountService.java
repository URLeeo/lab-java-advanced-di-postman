package org.example.dependencyinjectionlab.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class EarlyBirdDiscountService {

    public String calculateDiscount(LocalDate eventDate, LocalDate bookingDate) {

        long days = ChronoUnit.DAYS.between(bookingDate, eventDate);

        if (days < 0) {
            return "Invalid: bookingDate is after eventDate.";
        }

        if (days >= 30) {
            return "15% discount (booked at least 30 days early).";
        }
        return "No discount (booking too late).";
    }
}
