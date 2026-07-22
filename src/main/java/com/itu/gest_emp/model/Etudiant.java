package com.itu.gest_emp.model;

public class Etudiant {
    private int id;
    private String nom;
    private String prenom;
    private int age;
    private Departement[] departement;

    public Etudiant() {
    }

    public Etudiant(int id, String nom, String prenom, int age) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
    }

    public Etudiant(int id, String nom, String prenom, int age, Departement[] departement) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.departement = departement;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Departement[] getDepartement() {
        return departement;
    }

    public void setDepartement(Departement[] departement) {
        this.departement = departement;
    }
}
