 package com.itu.gest_emp.controller;

 import servlet.annotations.Controller;
 import servlet.annotations.Url;

 @Controller
 public class HelloController{

     // Test 1 : retour String -> affiche directement
     @Url("/hello")
     public String hello() {
         return "Bonjour depuis le framework !";
     }

     // Test 2 : retour String -> affiche directement
     @Url("/bye")
     public String bye() {
         return "Au revoir !";
     }

     // Test 3 : retour .jsp -> forward vers la JSP
     @Url("/page")
     public String page() {
         return "/pages/hello.jsp";
     }

     @Url("/bug")
     public int bug() {
         return 42;
     }

     // Test 4 : retour int (non supporte) -> message d'erreur
     @Url("/error")
     public int error() {
         return 42;
     }

 }
