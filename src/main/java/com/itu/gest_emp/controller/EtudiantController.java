package com.itu.gest_emp.controller;

import servlet.ModelView;
import servlet.annotations.Controller;
import servlet.annotations.RequestParam;
import servlet.annotations.Url;

@Controller
public class EtudiantController {

    // Test 1 : parametres injectes depuis le formulaire (query params)
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

    // Test 2 : path variable {id} avec @RequestParam
    // URL : /etudiant/5 -> id=5 injecte via @RequestParam("id")
    @Url("/etudiant/{id}")
    public String getEtudiantById(@RequestParam("id") int id) {
        return "Etudiant avec ID = " + id;
    }

    // Test 3 : path variable + query param combines
    // URL : /etudiant/5/note?matiere=Math -> id=5, matiere="Math"
    @Url("/etudiant/{id}/note")
    public String getNoteEtudiant(@RequestParam("id") int id, String matiere) {
        return "Note de l'etudiant " + id + " en " + matiere;
    }

    // Test 4 : parametres partiels (certains null)
    @Url("/recherche")
    public String rechercher(String query, int page) {
        return "Recherche : '" + query + "' - Page " + page;
    }
}
