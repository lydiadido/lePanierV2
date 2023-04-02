package com.example.le_panier_v2;

public class Produit {
        private Integer id;
        private String nom;
        private Integer categorie;
        private String description;
        private Double prix;
        private Integer image;

        public Produit(Integer id, String nom, Integer categorie, String description, double prix, Integer image){
            this.id=id;
            this.nom=nom;
            this.categorie=categorie;
            this.prix=prix;
            this.description=description;
            this.image=image;
        }

        public String getNom() {
            return nom;
        }

        public void setNom(String nom) {
            this.nom = nom;
        }

        public Integer getImage() {
            return image;
        }

        public void setImage(Integer image) {
            this.image = image;
        }

        public Double getPrix() {
            return prix;
        }

        public void setPrix(Double prix) {
            this.prix = prix;
        }

        public Integer getCategorie() {
            return categorie;
        }

        public void setCategorie( Integer categorie) {
            this.categorie = categorie;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

}
