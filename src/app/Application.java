package app;

import models.Pilote;
import models.Pneu;
import models.Voiture;
import models.TypePneu;

public class Application {

    public static void main(String[] args) {
        // ---------------------------------------------------------------------------------------
        // Etape 1 : Création d'une voiture de Formule 1
        // ---------------------------------------------------------------------------------------
        Voiture voiture = new Voiture(16, "Ferrari");
        // ---------------------------------------------------------------------------------------
        // Etape 2 : Afficher la voiture
        // ---------------------------------------------------------------------------------------
        System.out.println(voiture);
        // ---------------------------------------------------------------------------------------
        // Etape 3 : Création d'un pilote de Formule 1 et afficher ses informations
        // ---------------------------------------------------------------------------------------
        Pilote pilote = new Pilote("Charles Leclerc", "Monégasque", voiture);
        pilote.setNombreCourses(16);
        pilote.setNombrePoints(65);
        pilote.setNombreVictoires(3);
        pilote.setNombrePodiums(7);
        // ---------------------------------------------------------------------------------------
        // Etape 4 : Afficher le Pilote
        // ---------------------------------------------------------------------------------------
        System.out.println(pilote);
        System.out.println("-> Voiture Ferrari("+voiture.getNumero()+")");
        System.out.println("-> Points: "+pilote.getNombrePoints()+")");
        System.out.println("-> Courses: "+pilote.getNombreCourses()+")");
        System.out.println("-> Victoires: "+pilote.getNombreVictoires()+")");
        System.out.println("-> Podiums: "+pilote.getNombrePodiums()+")");
        // ---------------------------------------------------------------------------------------
        // Etape 5 : Tests des méthodes de la classe Pilote
        // ---------------------------------------------------------------------------------------
        Pneu pneu1 = new Pneu(TypePneu.DUR_BLANC, 1.5);
        Pneu pneu2 = new Pneu(TypePneu.MEDIUM_JAUNE, 1.8);
        Pneu pneu3 = new Pneu(TypePneu.TENDRE_ROUGE, 2.0);
        Pneu pneu4 = new Pneu(TypePneu.DUR_BLANC, 1.6);
        Pneu pneu5 = new Pneu(TypePneu.MEDIUM_JAUNE, 1.7);
        // deposerPneuEnReserve() 5 fois de types différents
        pilote.deposerPneuEnReserve(pneu1);
        pilote.deposerPneuEnReserve(pneu2);
        pilote.deposerPneuEnReserve(pneu3);
        pilote.deposerPneuEnReserve(pneu4);
        pilote.deposerPneuEnReserve(pneu5);
        // retirerPneuEnReserve() de type TENDRE_ROUGE et l'afficher
        System.out.println(pilote.retirerPneuEnReserve(TypePneu.TENDRE_ROUGE));
        // getNombrePneusEnReserve() et afficher le nombre de pneus en réserve
        System.out.println("Nombre de pneus en réserve: "+pilote.getNombrePneusEnReserve());
        // getPneusEnReserveSansTrous() et afficher les pneus en réserve
        Pneu[] pneuTableauSansTrou = pilote.getPneusEnReserveSansTrous();
        System.out.println("Pneus en réserve sans trous :");
        for (int i = 0; i < pneuTableauSansTrou.length; i++) {
            System.out.println("- "+pneuTableauSansTrou[i].getType()+" avec pression "+pneuTableauSansTrou[i].getPression());
        }
        // pressionMoyenneDesPneusEnReserveFormatee() et afficher la pression moyenne des
        // pneus
        System.out.println(pilote.pressionMoyenneDesPneusEnReserveFormatee());
        // compterNombrePneusEnReserveDeType() et afficher le nombre de pneus en réserve
        // de type DUR_BLANC
        System.out.println("Nombre de pneus en réserve du type "+TypePneu.DUR_BLANC+": "+pilote.compterNombrePneusEnReserveDeType(TypePneu.DUR_BLANC));
        // Créer les 3 pneus et ajout le lot de pneus pour le pilote et afficher réussi
        // ou échoué
        Pneu pneuTest1 = new Pneu(TypePneu.DUR_BLANC, 1.3);
        Pneu pneuTest2 = new Pneu(TypePneu.DUR_BLANC, 1.2);
        Pneu pneuTest3 = new Pneu(TypePneu.DUR_BLANC, 1.1);
        Pneu[] pneuTest = new Pneu[3];
        pneuTest[0] = pneuTest1;
        pneuTest[1] = pneuTest2;
        pneuTest[2] = pneuTest3;
        pilote.ajouterLotDePneus(pneuTest);
        if(pilote.ajouterLotDePneus(pneuTest)==true){
            System.out.println("Ajout du lot de pneus réussi :-)");
        }else{
            System.out.println("Ajout du lot de pneus échoué :-(");
        }
        // Supprimer les pneus de pression inférieure à 1.4 et afficher le nombre de
        // pneus supprimés
        System.out.println("Nombre de pneus supprimés de pression inférieure à 1.4 : "+pilote.supprimerPneusDePressionInferieure(1.4));
        // ---------------------------------------------------------------------------------------

    }
}


