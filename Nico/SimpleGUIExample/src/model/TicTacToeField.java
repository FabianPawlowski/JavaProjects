package model;

public class TicTacToeField {
    private String[][] matrix;
    

   public TicTacToeField() {
    	 matrix = new String[3][3];
         for (int i = 0; i < matrix.length; i++) {
             for (int j = 0; j < matrix[i].length; j++) {
                 matrix[i][j] = "";
             }
             
         }
   }
    public void setField(int i, int j, String neuerEintrag) {
        matrix[i][j] = neuerEintrag;
    }


    public String[][] getMatrix() {
        return matrix;
    }



//    public Person(String vorname, String nachname, String adresse, int alter) {
//        this.vorname = vorname;
//        this.nachname = nachname;
//       this.adresse = adresse;
//        this.alter = alter;
//   }
//
 //   }

//    }
//    public void setAlter(int alter) {
//       this.alter = alter;
 //   }
//    public void setNachname(String nachname) {
//        this.nachname = nachname;
//    }
//    public void setVorname(String vorname) {
///        this.vorname = vorname;
    }
