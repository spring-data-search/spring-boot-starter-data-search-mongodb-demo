## Getting Started

This is a demo project for the library [spring-boot-starter-data-search-mongodb](https://github.com/commerce-io/spring-boot-starter-data-search)

### Online Demo
This demo is deployed on [heroku](https://www.heroku.com/) and sleeps after 30 minutes of inactivity. 
Your first request could be slow if it occurs when the application is sleeping. In this case, please retry a few seconds after your first request.

[https://data-search-mongodb-demo.herokuapp.com/customers](https://data-search-mongodb-demo.herokuapp.com/customers?search=birthDate%20%3E:%201988-01-01%20and%20(emailAddress%20:%20/.*gmail.com/%20or%20emailAddress:%20/.*outlook.com/)&page=0&size=100&sort=coins,desc)

### Requirements
**Java version** 11 or higher (_If java 8 support is needed, please vote for [this issue](https://github.com/commerce-io/spring-boot-starter-data-search/issues/3)_)

**SpringBoot version** 2.1.0 or higher

### Usage
Clone, build and start as any other SpringBoot application.

spring-boot-starter-data-search-mongodb-demo comes with an embedded mongodb and the customers' collection is initialized 
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
curl -L -X  GET 'http://localhost:8080/customers?search=birthDate >: 1988-01-01 and (emailAddress : /.*gmail.com/ or emailAddress: /.*protonmail.com/)&page=0&size=10&sort=coins,desc'
```