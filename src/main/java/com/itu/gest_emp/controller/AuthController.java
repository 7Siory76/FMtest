package com.itu.gest_emp.controller;

import servlet.ModelView;
import servlet.MySession;
import servlet.annotations.Authorized;
import servlet.annotations.Controller;
import servlet.annotations.GetMapping;
import servlet.annotations.PostMapping;
import servlet.annotations.Role;
import servlet.annotations.Session;

import java.util.Map;

@Controller
public class AuthController {

    // 1. Page de connexion & Dashboard de test
    @GetMapping("/auth-test")
    public String index() {
        return "/pages/login.jsp";
    }

    // 2. Traitement de la connexion : Stockage dans la session via MySession
    @PostMapping("/login")
    public ModelView login(String username, String role, MySession session) {
        ModelView mv = new ModelView();
        mv.setView("/pages/login.jsp");

        if (username != null && !username.trim().isEmpty()) {
            // session.put("auth", username) & session.put("role", role)
            session.put("auth", username);
            session.put("role", role);
            mv.addItem("loginMessage", "Connexion réussie ! Utilisateur: " + username + " | Rôle: " + role);
        } else {
            mv.addItem("loginError", "Veuillez saisir un nom d'utilisateur valide.");
        }
        return mv;
    }

    // 3. Déconnexion : Invalidation de la session
    @GetMapping("/logout")
    public ModelView logout(MySession session) {
        session.invalidate();
        ModelView mv = new ModelView();
        mv.setView("/pages/login.jsp");
        mv.addItem("loginMessage", "Vous avez été déconnecté avec succès.");
        return mv;
    }

    // 4. Route protégée : Necessite d'etre authentifie (@Authorized)
    @Authorized
    @GetMapping("/profile")
    public String profile() {
        return "/pages/session_test.jsp";
    }

    // 5. Route protégée : Necessite le role "chef" (@Role("chef"))
    @Role("chef")
    @GetMapping("/espace-chef")
    public ModelView espaceChef(MySession session) {
        ModelView mv = new ModelView();
        mv.setView("/pages/session_test.jsp");
        mv.addItem("roleMessage", "Bienvenue dans l'Espace Chef ! (Rôle de session: " + session.get("role") + ")");
        return mv;
    }

    // 6. Route protégée : Necessite le role "prof" (@Role("prof"))
    @Role("prof")
    @GetMapping("/espace-prof")
    public ModelView espaceProf(MySession session) {
        ModelView mv = new ModelView();
        mv.setView("/pages/session_test.jsp");
        mv.addItem("roleMessage", "Bienvenue dans l'Espace Professeur ! (Rôle de session: " + session.get("role") + ")");
        return mv;
    }

    // 7. Test Operations CRUD sur la session avec @Session Map<String, Object>
    @PostMapping("/session-crud")
    public ModelView sessionCrud(@Session Map<String, Object> fako, String key, String value, String action) {
        ModelView mv = new ModelView();
        mv.setView("/pages/session_test.jsp");

        if ("add".equalsIgnoreCase(action) || "put".equalsIgnoreCase(action)) {
            if (key != null && !key.trim().isEmpty()) {
                fako.put(key, value);
                mv.addItem("crudMessage", "Attribut ajouté dans la session: " + key + " = " + value);
            }
        } else if ("delete".equalsIgnoreCase(action) || "remove".equalsIgnoreCase(action)) {
            if (key != null && !key.trim().isEmpty()) {
                fako.remove(key);
                mv.addItem("crudMessage", "Attribut supprimé de la session: " + key);
            }
        } else if ("clear".equalsIgnoreCase(action)) {
            fako.clear();
            mv.addItem("crudMessage", "Toutes les données de la session ont été effacées.");
        }

        return mv;
    }
}
