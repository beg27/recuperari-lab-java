package ex;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
enum Stare {
    ACHIZITIONAT, EXPUS, VANDUT
}

enum TipImprimanta {
    COLOR, ALB_NEGRU
}

enum TipSistemOperare {
    WINDOWS, LINUX
}

class Echipament {
    private String denumire;
    private int nr_inv;
    private double pret;
    private String zona_mag;
    private Stare stare;

    public Echipament(String denumire, int nr_inv, double pret, String zona_mag, Stare stare) {
        this.denumire = denumire;
        this.nr_inv = nr_inv;
        this.pret = pret;
        this.zona_mag = zona_mag;
        this.stare = stare;
    }

    public void modificaStare(Stare nouaStare) {
        this.stare = nouaStare;
    }
}

class Imprimanta extends Echipament {
    private int ppm;
    private int dpi;
    private int p_car;
    private TipImprimanta mod_tiparire;

    public Imprimanta(String denumire, int nr_inv, double pret, String zona_mag, Stare stare, int ppm, int dpi, int p_car, TipImprimanta mod_tiparire) {
        super(denumire, nr_inv, pret, zona_mag, stare);
        this.ppm = ppm;
        this.dpi = dpi;
        this.p_car = p_car;
        this.mod_tiparire = mod_tiparire;
    }

    public void setModTiparire(TipImprimanta nouModTiparire) {
        this.mod_tiparire = nouModTiparire;
    }
}

class Copiator extends Echipament {
    private int p_ton;
    private String format_copiere;

    public Copiator(String denumire, int nr_inv, double pret, String zona_mag, Stare stare, int p_ton, String format_copiere) {
        super(denumire, nr_inv, pret, zona_mag, stare);
        this.p_ton = p_ton;
        this.format_copiere = format_copiere;
    }
}

class SistemCalcul extends Echipament {
    private String tip_mon;
    private double vit_proc;
    private int c_hdd;
    private TipSistemOperare sistem_operare;

    public SistemCalcul(String denumire, int nr_inv, double pret, String zona_mag, Stare stare, String tip_mon, double vit_proc, int c_hdd, TipSistemOperare sistem_operare) {
        super(denumire, nr_inv, pret, zona_mag, stare);
        this.tip_mon = tip_mon;
        this.vit_proc = vit_proc;
        this.c_hdd = c_hdd;
        this.sistem_operare = sistem_operare;
    }
}

public class MainApp
{
    private static final List<Echipament> listaEchipamente = new ArrayList<>();

    public static void main(String[] args) {
        citesteEchipamenteDinFisier("echipamente.txt");
        meniu();
    }

    public static void citesteEchipamenteDinFisier(String numeFisier) {
        try (BufferedReader br = new BufferedReader(new FileReader(numeFisier))) {
            String linie;
            while ((linie = br.readLine()) != null) {
                String[] infoEchipament = linie.split(",");

                if (infoEchipament[0].equals("Imprimanta")) {
                    listaEchipamente.add(creazaImprimanta(infoEchipament));
                } else if (infoEchipament[0].equals("Copiator")) {
                    listaEchipamente.add(creazaCopiator(infoEchipament));
                } else if (infoEchipament[0].equals("SistemCalcul")) {
                    listaEchipamente.add(creazaSistemCalcul(infoEchipament));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Implementarea metodelor creazaImprimanta, creazaCopiator, creazaSistemCalcul

    public static void meniu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            afisareMeniu();
            int optiune = scanner.nextInt();
            switch (optiune) {
                case 1:
                    afisareToateEchipamentele();
                    break;
                case 2:
                    afisareImprimante();
                    break;
                case 3:
                    afisareCopiatoare();
                    break;
                case 0:
                    System.out.println("La revedere!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opțiune invalidă.");
                    break;
            }
        }
    }

    public static void afisareMeniu() {
        System.out.println("\nMeniu:");
        System.out.println("1. Afișare toate echipamentele");
        System.out.println("2. Afișare imprimante");
        System.out.println("3. Afișare copiatoare");
        System.out.println("0. Ieșire");
        System.out.print("Selectați o opțiune: ");
    }

    public static void afisareToateEchipamentele() {
        for (Echipament echipament : listaEchipamente) {
            System.out.println(echipament.getDenumire() + " - Stare: " + echipament.getStare());
        }
    }

    public static void afisareImprimante() {
        for (Echipament echipament : listaEchipamente) {
            if (echipament instanceof Imprimanta) {
                System.out.println(echipament.getDenumire() + " - Stare: " + echipament.getStare());
            }
        }
    }

    public static void afisareCopiatoare() {
        for (Echipament echipament : listaEchipamente) {
            if (echipament instanceof Copiator) {
                System.out.println(echipament.getDenumire() + " - Stare: " + echipament.getStare());
            }
        }
    }
}
