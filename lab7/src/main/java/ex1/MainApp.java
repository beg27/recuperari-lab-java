package ex1;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;



class Carte {
    private String titlul;
    private String autorul;
    private int anulAparitie;

    public Carte(String titlul, String autorul, int anulAparitie) {
        this.titlul = titlul;
        this.autorul = autorul;
        this.anulAparitie = anulAparitie;
    }

    // Getters
    public String getTitlul() {
        return titlul;
    }

    public String getAutorul() {
        return autorul;
    }

    public int getAnulAparitie() {
        return anulAparitie;
    }

    @Override
    public String toString() {
        return "Carte{" +
                "titlul='" + titlul + '\'' +
                ", autorul='" + autorul + '\'' +
                ", anulAparitie=" + anulAparitie +
                '}';
    }
}

public class MainApp {
    public static void main(String[] args) {

        Map<Integer, Carte> colectieCarti = new HashMap<>();


        JSONParser parser = new JSONParser();
        try (FileReader fileReader = new FileReader("carti.json")) {
            Object obj = parser.parse(fileReader);
            JSONObject carteJson = (JSONObject) obj;

            carteJson.forEach((key, value) -> {
                JSONObject carteDetalii = (JSONObject) value;
                String titlul = (String) carteDetalii.get("titlul");
                String autorul = (String) carteDetalii.get("autorul");
                long anul = (long) carteDetalii.get("anul");
                int anulAparitie = (int) anul;

                colectieCarti.put(Integer.parseInt((String) key), new Carte(titlul, autorul, anulAparitie));
            });
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }


        System.out.println("Colecția de cărți:");
        colectieCarti.forEach((key, value) -> System.out.println("ID: " + key + ", Carte: " + value));


        int idCarteDeSters = 3;
        colectieCarti.remove(idCarteDeSters);


        System.out.println("\nColecția de cărți după ștergere:");
        colectieCarti.forEach((key, value) -> System.out.println("ID: " + key + ", Carte: " + value));
    }
}

