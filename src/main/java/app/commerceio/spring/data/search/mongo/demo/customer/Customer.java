package app.commerceio.spring.data.search.mongo.demo.customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "customers")
public class Customer {

    @Id
    private String id;
    @Indexed
    private long ref;
    @Indexed
    private String title;
    @Indexed
    private String firstName;
    @Indexed
    private String lastName;
    @Indexed
    private String emailAddress;
    @Indexed
    private boolean emailAddressVerified;
    @Indexed
    private LocalDate birthDate;
    @Indexed
    private List<Address> addresses;
    @Indexed
    private double coins;
    @Indexed
    private OffsetDateTime createdDate;

    @Version
    private Long version;
}
