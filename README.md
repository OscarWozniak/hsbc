Oskar Woźniak 21.06.2017

# HSBC - Code Challenge
https://github.com/HStoneAge/code-challenge

> Build a simple social networking application, similar to Twitter, and expose it through a web API. The application should support the scenarios below.

> **Details**
> - use JAVA
> - provide some documentation for the API, so that we know how to use it!
> - don't care about registering users: a user is created as soon as they post their first message
> - don't care about user authentication
> - don't care about frontend, only backend
> - don't care about storage: storing everything in memory is fine

## Requirements
- Maven
*(3.3.9 works fine)*
- Java 8

## Technologies used
- Java 8
- Maven
- Tomcat
- Spring Boot
- Yaml

## Running

**To run application**

*In project root folder*

`mvn spring-boot:run`

**Base url for further requests**

http://localhost:8080/api/v1/

## Endpoints

**Justification**

- userId and followerId can be string(name), only because everyone likes Alice and Bob
- user is only created when he post some posts
- This is only POC - not every case is covered for example `PUT users/Bob/followers/Alice` when Alice or Bob is not existing

*Working workflow*
1. Alice posts post (so she is created) `POST .../users/{userId}/posts`
```
{
  "message":"Wow! look at this cat.jpg!"
}
```
![image](test.jpg)

2. Bob < same >
3. Carol < same > (We need him just for better testing purposes)
4. Dave < same > (He is just Carols good friend)

5. Every one can see his wall `GET .../users/{userId}/posts`

6. Bob follows Alice and Carol (not Dave because he is uploading only Memes + testing purpses) `PUT .../users/{userId}/followers/{followerId}`

7. Bob can see his Timeline `GET .../users/{userId}/timeline`


**Posting**

> A user should be able to post a 140 character message.

`POST .../users/{userId}/posts`

*Example*

`POST .../users/Alice/posts`

```
{
  "message":"Hello Bob! I like this new Twitter."
}
```

**Wall**

> A user should be able to see a list of the messages they've posted, in reverse chronological order.

`GET .../users/{userId}/posts`

*Example*

`GET .../users/Alice/posts`

**Following**

> A user should be able to follow another user. Following doesn't have to be reciprocal: Alice can follow Bob without Bob having to follow Alice.

`PUT .../users/{userId}/followers/{followerId}`

*Example*

`PUT .../users/Bob/followers/Alice`

**Timeline**

> A user should be able to see a list of the messages posted by all the people they follow, in reverse chronological order.

`GET .../users/{userId}/timeline`

*Example*

`GET .../users/Bob/timeline`