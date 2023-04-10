Last updated: 4/10/2021
## Building a Simple API using Spring Boot

```
package com.ahmed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
    @GetMapping("/")
    public String greet(){
        return "Hello";
    }
}
```
The example above shows a simple spring boot application.
The required annotation are ``@SpringBootApplication``, which says that
this is going to be a spring boot application.

You also need the ``@RestController`` annotation
to let spring boot know that this is going to be
a Restful application with different routes.

One of the routes in the example above is ``("/")`` provided by the
following method.

```
    @GetMapping("/")
    public String greet(){
        return "Hello";
    }
```
The ``@GetMapping()`` annotation is required
to let the server know that the method below that annotation
will serve as an endpoint. In this case, the method provides the root
endpoint. So when the client visits ``localhost:8080``, they will get the
``Hello`` response on the webpage.

## Spring Web MVC
### Java Objects in JSON
```
@SpringBootApplication
@RestController
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
    @GetMapping("/")
    public GreetResponse greet(){
        return new GreetResponse("Hello");
    }

   static class GreetResponse{
        private final String greet;


       GreetResponse(String greet) {
           this.greet = greet;
       }

       public String getGreet() {
           return greet;
       }
}
```
In the above Spring Boot code, There is a class
called GreetResponse which has once instance variable, ``greet``.
the ``greet()`` method returns a GreetResponse object
with the value `hello`. When that method is called
we get a JSON response that looks like this:
``
{
"greet": "Hello"
}
``
The `greet` in the JSON response maps to the greet instance
variable. the `Hello` in the JSON response maps to the value
for the greet instance variable which was initialized by the
`greet()` method.

**Alternative Java JSON Representation (using Java record)**

To represent the same java object in a much simpler way, we can use a
java `record`. A java `record` is used just like a Java class without all
constructors, getters, setters ... They can be defined like so:
`record GreetResponse(String greet){}`.
Then we are able to return a new GreetResponse like usual
... `return new GreetResponse("Hello")`.

Here's the above code but using Java record instead:

```
@SpringBootApplication
@RestController
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
    @GetMapping("/")
    public GreetResponse greet(){
        return new GreetResponse("Hello");
    }

    record GreetResponse(String greet){}
```




