package com.itu.gest_emp.controller;

import servlet.ModelView;
import servlet.annotations.Controller;
import servlet.annotations.GetMapping;
import servlet.annotations.PostMapping;
import servlet.annotations.RequestMapping;

@Controller
public class HttpMethodController {

    // GET seulement : afficher le formulaire
    @GetMapping("/inscription")
    public String formulaireInscription() {
        return "/pages/inscription.jsp";
    }

    // POST seulement : traiter les donnees du formulaire
    @PostMapping("/inscription")
    public ModelView inscrire(String nom, String prenom, String email) {
        ModelView mv = new ModelView();
        mv.setView("/pages/resultat_inscription.jsp");
        mv.addItem("nom", nom);
        mv.addItem("prenom", prenom);
        mv.addItem("email", email);
        mv.addItem("message", "Inscription reussie !");
        return mv;
    }

    // Accessible GET et POST
    @RequestMapping("/ping")
    public String ping() {
        return "pong (accessible via GET et POST)";
    }
}
