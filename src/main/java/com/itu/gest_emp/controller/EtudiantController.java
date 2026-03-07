package com.itu.gest_emp.controller;

import servlet.ModelView;
import servlet.annotations.Controller;
import servlet.annotations.Url;

@Controller
public class EtudiantController {

    // Test 1 : parametres String injectes depuis le formulaire
    @Url("/etudiant")
    public ModelView getEtudiant(String nom, String prenom, int age) {
        ModelView mv = new ModelView();
        mv.setView("/pages/etudiant.jsp");
        mv.addItem("nom", nom);
        mv.addItem("prenom", prenom);
        mv.addItem("age", age);
        mv.addItem("message", "Etudiant recu depuis le formulaire");
        return mv;
    }

    // Test 2 : parametres partiels (certains null)
    @Url("/recherche")
    public String rechercher(String query, int page) {
        return "Recherche : '" + query + "' - Page " + page;
    }
}
