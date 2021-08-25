package control;

//import jdk.internal.module.SystemModuleFinders;
import model.TicTacToeField;

//import java.util.Arrays;

// import model.Person;
//import view.MainView;
import view.MainViewButtons;
import view.MainViewInterface;

public class Controller {
    int counter = 0;
    MainViewInterface view;
    TicTacToeField spiel;

    public Controller() {
        view = new MainViewButtons(this);
        spiel = new TicTacToeField();

    }

    public void addInputs(int i, int j, String value) {
        spiel.setField(i, j, value);
        counter++;
        calculateResult();
        System.out.println("Kurz zum überprüfen, damit wir sehen dass er das auch wirklich aufruft");
    }

    public void addInputs(String oben1, String oben2, String oben3, String mitte1, String mitte2, String mitte3,
            String unten1, String unten2, String unten3) {

        if (oben1 == "X" || oben1 == "O") {
            spiel.setField(0, 0, oben1);
            counter++;
        }
        if (oben2 == "X" || oben2 == "O") {
            spiel.setField(0, 1, oben2);
            counter++;
        }
        if (oben3 == "X" || oben3 == "O") {
            spiel.setField(0, 2, oben3);
            counter++;
        }
        if (mitte1 == "X" || mitte1 == "O") {
            spiel.setField(1, 0, mitte1);
            counter++;
        }
        if (mitte2 == "X" || mitte2 == "O") {
            spiel.setField(1, 1, mitte2);
            counter++;
        }
        if (mitte3 == "X" || mitte3 == "O") {
            spiel.setField(1, 2, mitte3);
            counter++;
        }
        if (unten1 == "X" || unten1 == "O") {
            spiel.setField(2, 0, unten1);
            counter++;
        }
        if (unten2 == "X" || unten2 == "O") {
            spiel.setField(2, 1, unten2);
            counter++;
        }
        if (unten3 == "X" || unten3 == "O") {
            spiel.setField(2, 2, unten3);
            counter++;
        }

        calculateResult();

        // doppelt verschachtelte For Schleife

    }

    private void calculateResult() {

        String[][] matrix = spiel.getMatrix();

        // for (int i = 0, i <= matrix.length())
        System.out.println(counter);

        if (matrix[0][0].equals("X") && matrix[0][1].equals("X") && matrix[0][2].equals("X")) {
            System.out.println("Spieler X hat gewonnen, 3 Gleiche in der oberen Reihe!");
            view.setWinner("X hat gewonnen!");
        } else if (matrix[0][0].equals("O") && matrix[0][1].equals("O") && matrix[0][2].equals("O")) {
            System.out.println("Spieler O hat gewonnen, 3 Gleiche in der oberen Reihe!");
            view.setWinner("O hat gewonnen!");

        } else if (matrix[1][0].equals("X") && matrix[1][1].equals("X") && matrix[1][2].equals("X")) {
            System.out.println("Spieler X hat gewonnen, 3 Gleiche in der mittleren Reihe!");
            view.setWinner("X hat gewonnen!");

        } else if (matrix[1][0].equals("O") && matrix[1][1].equals("O") && matrix[1][2].equals("O")) {
            System.out.println("Spieler O hat gewonnen, 3 Gleiche in der mittleren Reihe!");
            view.setWinner("O hat gewonnen!");

        } else if (matrix[2][0].equals("X") && matrix[2][1].equals("X") && matrix[2][2].equals("X")) {
            System.out.println("Spieler X hat gewonnen, 3 Gleiche in der unteren Reihe!");
            view.setWinner("X hat gewonnen!");

        } else if (matrix[2][0].equals("O") && matrix[2][1].equals("O") && matrix[2][2].equals("O")) {
            System.out.println("Spieler O hat gewonnen, 3 Gleiche in der unteren Reihe!");
            view.setWinner("O hat gewonnen!");

        } else if (matrix[0][0].equals("X") && matrix[1][0].equals("X") && matrix[2][0].equals("X")) {
            System.out.println("Spieler X hat gewonnen, 3 Gleiche in der linken Reihe!");
            view.setWinner("X hat gewonnen!");

        } else if (matrix[0][0].equals("O") && matrix[1][0].equals("O") && matrix[2][0].equals("O")) {
            System.out.println("Spieler O hat gewonnen, 3 Gleiche in der linken Reihe!");
            view.setWinner("O hat gewonnen!");

        } else if (matrix[0][1].equals("X") && matrix[1][1].equals("X") && matrix[2][1].equals("X")) {
            System.out.println("Spieler X hat gewonnen, 3 Gleiche in der mittleren Reihe!");
            view.setWinner("X hat gewonnen!");

        } else if (matrix[0][1].equals("O") && matrix[1][1].equals("O") && matrix[2][1].equals("O")) {
            System.out.println("Spieler O hat gewonnen, 3 Gleiche in der mittleren Reihe!");
            view.setWinner("O hat gewonnen!");

        } else if (matrix[0][2].equals("X") && matrix[1][2].equals("X") && matrix[2][2].equals("X")) {
            System.out.println("Spieler X hat gewonnen, 3 Gleiche in der rechten Reihe!");
            view.setWinner("X hat gewonnen!");

        } else if (matrix[0][2].equals("O") && matrix[1][2].equals("O") && matrix[2][2].equals("O")) {
            System.out.println("Spieler O hat gewonnen, 3 Gleiche in der rechten Reihe!");
            view.setWinner("O hat gewonnen!");

        } else if (matrix[0][0].equals("X") && matrix[1][1].equals("X") && matrix[2][2].equals("X")) {
            System.out.println("Spieler X hat gewonnen, 3 Gleiche in der diagonalen Reihe!");
            view.setWinner("X hat gewonnen!");

        } else if (matrix[0][0].equals("O") && matrix[1][1].equals("O") && matrix[2][2].equals("O")) {
            System.out.println("Spieler O hat gewonnen, 3 Gleiche in der diagonalen Reihe!");
            view.setWinner("O hat gewonnen!");

        }else if (matrix[2][0].equals("X") && matrix[1][1].equals("X") && matrix[0][2].equals("X")) {
            System.out.println("Spieler X hat gewonnen, 3 Gleiche in der diagonalen Reihe!");
            view.setWinner("X hat gewonnen!");

        } else if (matrix[2][0].equals("O") && matrix[1][1].equals("O") && matrix[0][2].equals("O")) {
            System.out.println("Spieler O hat gewonnen, 3 Gleiche in der diagonalen Reihe!");
            view.setWinner("O hat gewonnen!");

        } else if (counter >= 9) {
            System.out.println("Kein Gewinner!");
            view.setWinner("Keiner hat gewonnen!");
            
        }

    }

    public void refresh() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                spiel.setField(i, j, "");
            }
        }
        view.refresh();
        counter = 0;
    }
}
