package org.example.dependencyinjectionlab.controller;

import org.example.dependencyinjectionlab.service.EarlyBirdDiscountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Optional;

@RestController
public class DiscountController {

    private final Optional<EarlyBirdDiscountService> earlyBirdDiscountService;

    public DiscountController(Optional<EarlyBirdDiscountService> earlyBirdDiscountService) {
        this.earlyBirdDiscountService = earlyBirdDiscountService;
    }
    @GetMapping("/api/discount")
    public String getDiscount(@RequestParam String eventDate, @RequestParam String bookingDate
    ) {
        if (earlyBirdDiscountService.isEmpty()) {
            return "Early bird feature is disabled. Set feature.earlybird.enabled=true";
        }
        LocalDate event = LocalDate.parse(eventDate);
        LocalDate booking = LocalDate.parse(bookingDate);

        return earlyBirdDiscountService.get().calculateDiscount(event, booking);
    }
}