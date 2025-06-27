package models;

import java.text.DecimalFormat;

public class Pilote {
    public final int NOMBRE_PNEU_EN_RESERVE = 16;
    private String nom;
    private String nationalite;
    private int nombrePoints;
    private int nombreCourses;
    private int nombreVictoires;
    private int nombrePodiums;
    private Pneu[] pneusEnReserve;
    private Voiture voiture;

    public Pilote(String nom, String nationalite) {
        this.nom = nom;
        this.nationalite = nationalite;
        this.pneusEnReserve = new Pneu[0];
        this.voiture = null;
        this.nombrePoints = 0;
        this.nombreCourses = 0;
        this.nombreVictoires = 0;
        this.nombrePodiums = 0;
    }

    public Pilote(String nom, String nationalite, Voiture voiture) {
        this.nom = nom;
        this.nationalite = nationalite;
        this.pneusEnReserve = new Pneu[NOMBRE_PNEU_EN_RESERVE];
        this.voiture = voiture;
        this.nombrePoints = 0;
        this.nombreCourses = 0;
        this.nombreVictoires = 0;
        this.nombrePodiums = 0;
    }

    public boolean deposerPneuEnReserve(Pneu pneu) {
        boolean depose = false;
        for (int i = 0; i < pneusEnReserve.length; i++) {
            if (pneusEnReserve[i] == null) {
                pneusEnReserve[i] = pneu;
                depose = true;
                return depose;
            }
        }
        return depose;
    }

    public Pneu retirerPneuEnReserve(TypePneu type) {
        Pneu[] pneu = new Pneu[1];
        for (int i = 0; i < pneusEnReserve.length; i++) {
            if (pneusEnReserve[i] != null) {
                if (pneusEnReserve[i].getType() == type) {
                    pneu[0] = pneusEnReserve[i];
                    pneusEnReserve[i] = null;
                    return pneu[0];
                }
            }
        }
        return pneu[0];
    }

    public int compterNombrePneusEnReserveDeType(TypePneu type) {
        int nbrePneuDeCeType = 0;
        for (int i = 0; i < pneusEnReserve.length; i++) {
            if (pneusEnReserve[i] != null) {
                if (pneusEnReserve[i].getType() == type) {
                    nbrePneuDeCeType++;
                }
            }
        }
        return nbrePneuDeCeType;
    }

    public int getNombrePneusEnReserve() {
        int nbrePneu = 0;
        for (int i = 0; i < pneusEnReserve.length; i++) {
            if (pneusEnReserve[i] != null) {
                nbrePneu++;
            }
        }
        return nbrePneu;
    }

    public Pneu[] getPneusEnReserveSansTrous() {
        int nombrePneu = 0;
        for (int i = 0; i < pneusEnReserve.length; i++) {
            if (pneusEnReserve[i] != null) {
                nombrePneu++;
            }
        }
        Pneu[] nouveauTableau = new Pneu[nombrePneu];
        for (int j = 0; j < pneusEnReserve.length; j++) {
            if (pneusEnReserve[j] != null) {
                for (int k = 0; k < nouveauTableau.length; k++) {
                    if (nouveauTableau[k] == null) {
                        nouveauTableau[k] = pneusEnReserve[j];
                        break;
                    }
                }
            }
        }
        return nouveauTableau;
    }

    public String pressionMoyenneDesPneusEnReserveFormatee() {
        DecimalFormat decim = new DecimalFormat();
        double sommePression = 0;
        double nombrePneu = 0;
        for (int i = 0; i < pneusEnReserve.length; i++) {
            if (pneusEnReserve[i] != null) {
                nombrePneu++;
                sommePression = sommePression + pneusEnReserve[i].getPression();
            }
        }
        double moyennePression = sommePression / nombrePneu;
        String moyenneEnPhraseString = "Pression moyenne des pneus en réserve : " + moyennePression;
        return moyenneEnPhraseString;
    }

    public int supprimerPneusDePressionInferieure(double pression) {
        int nombrePneuSupprime = 0;
        for (int i = 0; i < pneusEnReserve.length; i++) {
            if (pneusEnReserve[i].getPression() < pression) {
                nombrePneuSupprime++;
                pneusEnReserve[i] = null;
            }
        }
        return nombrePneuSupprime;
    }

    public boolean ajouterLotDePneus(Pneu[] pneus) {
        int nombreEspaceEnReserve = 0;
        int nombrePneuAAjouter = 0;
        boolean possibleDajouter = false;
        for (int i = 0; i < pneusEnReserve.length; i++) {
            if (pneusEnReserve[i] == null) {
                nombreEspaceEnReserve++;
            }
        }
        for (int j = 0; j < pneus.length; j++) {
            if (pneus[j] != null) {
                nombrePneuAAjouter++;
            }
        }
        if (nombreEspaceEnReserve > nombrePneuAAjouter) {
            possibleDajouter = true;
            for (int i = 0; i < pneus.length; i++) {
                if (pneus[i] != null) {
                    for (int j = 0; j < pneusEnReserve.length; j++) {
                        if (pneusEnReserve[j] == null) {
                            pneusEnReserve[j] = pneus[i];
                        }
                    }
                }
            }
        }
        return possibleDajouter;
    }

    public String getNom() {
        return nom;
    }

    public String getNationalite() {
        return nationalite;
    }

    public int getNombrePoints() {
        return nombrePoints;
    }

    public void setNombrePoints(int nombrePoints) {
        this.nombrePoints = nombrePoints;
    }

    public int getNombreCourses() {
        return nombreCourses;
    }

    public void setNombreCourses(int nombreCourses) {
        this.nombreCourses = nombreCourses;
    }

    public int getNombreVictoires() {
        return nombreVictoires;
    }

    public void setNombreVictoires(int nombreVictoires) {
        this.nombreVictoires = nombreVictoires;
    }

    public int getNombrePodiums() {
        return nombrePodiums;
    }

    public void setNombrePodiums(int nombrePodiums) {
        this.nombrePodiums = nombrePodiums;
    }

    public String toString() {
        String toString = "Pilote: " + nom + " (" + nationalite + ")";
        return toString;
    }
}
