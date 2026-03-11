package com.itu.gest_emp.controller;

import com.itu.gest_emp.model.Department;
import com.itu.gest_emp.model.Departement;
import com.itu.gest_emp.model.Employee;
import com.itu.gest_emp.model.Etudiant;
import servlet.ModelView;
import servlet.annotations.Controller;
import servlet.annotations.GetMapping;
import servlet.annotations.Json;
import servlet.annotations.PostMapping;
import servlet.annotations.RequestParam;
import servlet.annotations.Url;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EtudiantController {

    // Test 1 : parametres simples depuis le formulaire (query params)
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
    @Url("/etudiant/{id}")
    public String getEtudiantById(@RequestParam("id") int id) {
        return "Etudiant avec ID = " + id;
    }

    // Test 3 : path variable + query param combines
    @Url("/etudiant/{id}/note")
    public String getNoteEtudiant(@RequestParam("id") int id, String matiere) {
        return "Note de l'etudiant " + id + " en " + matiere;
    }

    // Test 4 : parametres partiels
    @Url("/recherche")
    public String rechercher(String query, int page) {
        return "Recherche : '" + query + "' - Page " + page;
    }

    // -------------------------------------------------------------
    // SPRINT 8 BIS : Binding d'objets, tableaux et proprietes imbriquees
    // -------------------------------------------------------------

    // Test Sprint 8 bis (Image 1) : POST avec objet et proprietes imbriquees (e.nom, e.departement[0].nom)
    @PostMapping("/etudiant/save")
    public ModelView saveEtudiant(Etudiant e) {
        ModelView mv = new ModelView();
        mv.setView("/pages/etudiant.jsp");
        mv.addItem("nom", e.getNom());
        mv.addItem("prenom", e.getPrenom());
        mv.addItem("age", e.getAge());

        String deptStr = "";
        if (e.getDepartement() != null) {
            for (Departement d : e.getDepartement()) {
                if (d != null) {
                    if (!deptStr.isEmpty()) deptStr += ", ";
                    deptStr += d.getNom();
                }
            }
        }
        mv.addItem("message", "Sprint 8 bis: Etudiant sauvegarde (" + e.getNom() + ") - Depts: " + deptStr);
        return mv;
    }

    // Test Sprint 8 bis exact comme l'image 1 (/some-method avec Employee)
    @PostMapping("/some-method")
    public ModelView save(Employee e) {
        ModelView mv = new ModelView();
        mv.setView("/pages/etudiant.jsp");
        mv.addItem("nom", e.getName());
        String depts = "";
        if (e.getDepartment() != null) {
            for (Department d : e.getDepartment()) {
                if (d != null) {
                    if (!depts.isEmpty()) depts += ", ";
                    depts += d.getName();
                }
            }
        }
        mv.addItem("message", "Employee recu: " + e.getName() + " [Departments: " + depts + "]");
        return mv;
    }

    // Test Sprint 8 bis : Reception d'un tableau d'objets en argument (Employee[] es)
    @PostMapping("/some-method-array")
    public String saveArray(Employee[] es, Department d, int deptId) {
        int count = (es != null) ? es.length : 0;
        String deptName = (d != null) ? d.getName() : "aucun";
        return "Sauvegarde de " + count + " employe(s) dans le dept " + deptId + " (" + deptName + ")";
    }

    // -------------------------------------------------------------
    // SPRINT 9 : API REST avec annotation @Json (Image 2)
    // -------------------------------------------------------------

    // Test Sprint 9 : Retourner une Liste sous forme de JSON avec count et data []
    @Json
    @GetMapping("/etudiant/api/list")
    public List<Etudiant> listEtudiantsApi() {
        List<Etudiant> list = new ArrayList<>();
        Departement d1 = new Departement(1, "Informatique");
        Departement d2 = new Departement(2, "Gestion");

        list.add(new Etudiant(1, "Rakoto", "Jean", 20, new Departement[]{d1}));
        list.add(new Etudiant(2, "Rabe", "Paul", 22, new Departement[]{d2}));
        return list;
    }

    // Test Sprint 9 : Retourner un objet unique sous forme de JSON
    @Json
    @GetMapping("/etudiant/api/{id}")
    public Etudiant getEtudiantApi(@RequestParam("id") int id) {
        Departement d = new Departement(1, "Informatique");
        return new Etudiant(id, "Rakoto", "Jean", 21, new Departement[]{d});
    }

    // Test Sprint 9 : Retourner un ModelView sous forme de JSON
    @Json
    @GetMapping("/etudiant/api/mv")
    public ModelView getEtudiantMvApi() {
        ModelView mv = new ModelView();
        mv.addItem("id", 100);
        mv.addItem("nom", "Andry");
        mv.addItem("status", "actif");
        return mv;
    }
}
