package app.commerceio.spring.data.search.mongo.demo.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String streetAddress;
    private String postalCode;
    private String city;
    private String country;
    private String countryCode;
}

