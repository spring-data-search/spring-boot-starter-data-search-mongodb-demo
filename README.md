## Getting Started

This is a demo project for the library [spring-boot-starter-data-search-mongodb](https://github.com/commerce-io/spring-boot-starter-data-search)

### Requirements
**Java version** 11 or higher (_If java 8 support is needed, please vote for [this issue](https://github.com/commerce-io/spring-boot-starter-data-search/issues/3)_)

**SpringBoot version** 2.1.0 or higher

### Usage
Clone, build and start as any other SpringBoot application.

spring-boot-starter-data-search-mongodb comes with an embedded mongodb and the customers' collection is initialized 
on startup with 10000 documents. 

If you want to deactivate the data init, or you want more data for your tests, 
you can adapt the configuration file.

```properties
demo.data-init=true
demo.data-size=10000
```

#### Customer structure
```json
{
    "id": "13e3afc8-0832-41c4-bb12-812e516d0980",
    "ref": 1966,
    "title": "Ms.",
    "firstName": "Angelique",
    "lastName": "VonRueden",
    "emailAddress": "angelique.vonrueden@gmail.com",
    "emailAddressVerified": true,
    "birthDate": "1989-04-14",
    "addresses": [
        {
            "streetAddress": "942 Charlette Forges",
            "postalCode": "98527-5724",
            "city": "Stiedemannberg",
            "country": "Curaçao",
            "countryCode": "CW"
        },
        {
            "streetAddress": "400 Schamberger Lodge",
            "postalCode": "22998",
            "city": "Andreshire",
            "country": "China",
            "countryCode": "CN"
        }
    ],
    "coins": 44.801514,
    "createdDate": "2021-06-12T11:21:13.897Z"
}
```

#### Search API

By default, with  [data-search](https://github.com/commerce-io/spring-boot-starter-data-search), all customer fields become searchable. 
```cURL
curl -L -X  GET 'http://localhost:8080/customers?search=birthDate >: 1988-01-01 and (emailAddress : /.*gmail.com/ or emailAddress: /.*protonmail.com/)&page=0&size=100&sort=birthDate,desc'
```