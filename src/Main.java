import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // On créé le nombre d'étudiants

        int studentsNumber = 1;
        Scanner s = new Scanner(System.in);

        // On demande à l'utilisateur de nous en donner la valeur

        System.out.println("Combien d'étudiants avez-vous ?");
        boolean validInput = false;

        // On boucle jusqu'à obtenir un nombre valide
        while (!validInput) {
            try {
                studentsNumber = s.nextInt();
                if (studentsNumber > 0) {
                    validInput = true; // Entrée valide, on sort de la boucle
                } else {
                    System.out.println("Veuillez entrer un nombre positif.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Veuillez entrer un nombre valide.");
                s.next(); // Consomme l'entrée incorrecte
            }
        }

        // On va demander à recevoir la note de chacun, et, pour chacun, entrer son nom (Étudiant + i) et sa note

        int[] notes = new int[studentsNumber]; // Création du tableau de notes
        System.out.println("Quelle est la note du premier étudiant ?");

          for (int i = 0; i < studentsNumber; i++)
            {
                boolean noteValide = false;

                while (!noteValide) {
                    System.out.print("Entrez la note de l'étudiant " + (i + 1) + ": ");
                    try {
                        notes[i] = s.nextInt();
                        noteValide = true; // Note valide entrée, on sort de la boucle
                    } catch (InputMismatchException err) {
                        System.out.println("Veuillez entrer un nombre valide.");
                        s.next(); // Consomme l'entrée incorrecte
                    }
                }
            }
        // Afficher les notes saisies
        System.out.println("Les notes saisies sont: ");
        for (int i = 0; i < notes.length; i++) {
            System.out.println("Étudiant " + (i + 1) + ": " + notes[i]);
        }
        int additionNotes  = 0 ;
        int max = notes[0];
        int min = notes[0];
        for (int i = 0; i < notes.length; i++) {
            additionNotes = (additionNotes + notes[i]);
            if (notes[i] > max) {
                max = notes[i];
            }
            if (notes[i] < min) {
                min = notes[i];
            }
        }
        double moyenne = additionNotes / notes.length;
        System.out.println("La moyenne de la classe est de : " + moyenne);
        System.out.println("La note la plus élevée est de " + max);
        System.out.println("La note la moins élevée est de " + min);

        for (int i = 0; i < notes.length; i++) {
            if (notes[i] < moyenne) {
                System.out.println(notes[i] + " : En dessous de la moyenne");
            } else if (notes[i]> moyenne) {
                System.out.println(notes[i] + " : Au dessus de la moyenne");
            } else {
                System.out.println(notes[i] + " : Est à la moyenne");
            }
        }
        Arrays.sort(notes);
        System.out.println("Tableau trié:");
        for (int entier : notes) {
            System.out.println("nombre: " + entier);
        }

        s.close();
    }

}
