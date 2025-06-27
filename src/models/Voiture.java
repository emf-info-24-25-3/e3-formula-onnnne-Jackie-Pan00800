package models;

public class Voiture {
    private int numero;
    private String nomEquipe;

    public Voiture(int numero, String nomEquipe){
        this.numero=numero;
        this.nomEquipe=nomEquipe;
    }

    public int getNumero(){
        return numero;
    }

    public String getNomEquipe(){
        return nomEquipe;
    }

    public String toString(){
        String toString="Voiture No"+numero+" de l'équipe '"+nomEquipe+"'";
        return toString;
    }
}
