package com.example.emploi;

public class offres {
 
     private String filieres;
    private String entreprise;
    private String description;
    
    public offres( String filieres, String entreprise,String description)
    {
        super(); //on appelle le super et on fait le constructeur de façon normale
        
        this.setFilieres(filieres);
        this.setEntreprise(entreprise);
        this.setDescription(description);
       
    }
     
    //on fait tout les getters et setters
   
    
 
    public String getFilieres() {
        return filieres;
    }
 
    public void setFilieres(String filieres) {
        this.filieres = filieres;
    }
    
    
    public String getEntreprise() {
        return entreprise;
    }
 
    public void setEntreprise(String entreprise) {
        this.entreprise = entreprise;
    }
 
    public String getDescription() {
        return description;
    }
 
    public void setDescription(String description) {
        this.description = description;
    }
 
  
 
   
     
   
 
}