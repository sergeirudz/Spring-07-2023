package sergei.webshop.controller;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import sergei.webshop.dto.*;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class NordpoolController {


    @GetMapping("nordpool") // http://localhost:8080/nordpool // ee,lt,lv,fi
    public NordpoolResult getNordpoolPrices(
            @RequestParam("country") Optional<String> countryCode,
            @RequestParam("startDate") Optional<String> startDate,
            @RequestParam("endDate") Optional<String> endDate
    ) {

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Nordpool> response = restTemplate.exchange("https://dashboard.elering.ee/api/nps/price", HttpMethod.GET, null, Nordpool.class);
        Nordpool nordpool = response.getBody();

        NordpoolResult nordpoolResult = new NordpoolResult();
        List<TimestampPrice> filteredPrices = new ArrayList<>();

        System.out.println("Country code: " + countryCode);
        if (!countryCode.isPresent() || countryCode.get().isEmpty()) {
            nordpoolResult.setNordpool(nordpool);
        } else {
            List<TimestampPrice> prices = getPricesByCountryCode(nordpool, countryCode.get());
            System.out.println("Prices for country code " + countryCode.get() + ": " + prices);
            nordpoolResult.setCountryPrices(prices);
            filteredPrices = prices; // Initialize the filteredPrices with the initial prices
        }

        if (startDate.isPresent() && endDate.isPresent()) {
            LocalDateTime startDateTime = LocalDateTime.parse(startDate.get());
            LocalDateTime endDateTime = LocalDateTime.parse(endDate.get());
            filteredPrices = filterPricesByDateTime(filteredPrices, startDateTime, endDateTime);
            System.out.println(filteredPrices);
            nordpoolResult.setCountryPrices(filteredPrices);
        }

        return nordpoolResult;


        // TODO: Apply startDate and endDate filters to the prices
        // TODO: return one country at a time
        // TODO: return startDate and endDate
        // https://dashboard.elering.ee/api/nps/price?start=2023-05-20T12%3A59%3A59.999Z&end=2023-05-24T20%3A59%3A59.999Z
        // https://dashboard.elering.ee/api/nps/price?start=2023-05-20T12%3A59%3A59.999Z&end=2023-05-24T20%3A59%3A59.999Z
        // https://dashboard.elering.ee/api/nps/price?start=2023-05-20T12:59:59.999Z&end=2023-05-24T20:59:59.999Z


    }

    private List<TimestampPrice> filterPricesByDateTime(List<TimestampPrice> prices, LocalDateTime startDate, LocalDateTime endDate) {
        return prices.stream()
                .filter(price -> {
                    LocalDateTime timestamp = LocalDateTime.ofEpochSecond(price.getTimestamp(), 0, ZoneOffset.UTC);
                    return timestamp.isAfter(startDate) && timestamp.isBefore(endDate);
                })
                .collect(Collectors.toList());
    }

    public List<TimestampPrice> getPricesByCountryCode(Nordpool nordpool, String countryCode) {
        CountryPrices countryPrices = (CountryPrices) nordpool.getCountryPrices();

        switch (countryCode.toUpperCase()) {
            case "EE":
                return countryPrices.getEe();
            case "FI":
                return countryPrices.getFi();
            case "LV":
                return countryPrices.getLv();
            case "LT":
                return countryPrices.getLt();
            default:
                return Collections.emptyList(); // Return an empty list for unknown country codes
        }

    }
}

