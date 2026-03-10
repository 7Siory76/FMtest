package com.itu.gest_emp.controller;

import servlet.ModelView;
import servlet.annotations.Controller;
import servlet.annotations.PostMapping;
import servlet.annotations.GetMapping;

import java.util.Map;

@Controller
public class SaveController {

    // GET : afficher le formulaire
    @GetMapping("/save")
    public String formulaire() {
        return "/pages/save_form.jsp";
    }

    // POST : recevoir tous les champs du formulaire via Map
    @PostMapping("/save")
    public ModelView save(Map<String, Object> params) {
        ModelView mv = new ModelView();
        mv.setView("/pages/save_result.jsp");
        // Transferer tous les params dans la vue
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            mv.addItem(entry.getKey(), entry.getValue());
        }
        mv.addItem("message", "Donnees recues : " + params.size() + " champ(s)");
        return mv;
    }
}
