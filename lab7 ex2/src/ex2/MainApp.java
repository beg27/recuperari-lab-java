package ex2;
import java.util.*;


enum TipChitara {
    ELECTRICA, ACUSTICA, CLASICA
}


enum TipTobe {
    ELECTRONICE, ACUSTICE
}


abstract class InstrumentMuzical {
    String producator;
    double pret;

    public InstrumentMuzical(String producator, double pret) {
        this.producator = producator;
        this.pret = pret;
    }
}


class Chitara extends InstrumentMuzical {
    TipChitara tip_chitara;
    int nr_corzi;

    public Chitara(String producator, double pret, TipChitara tip_chitara, int nr_corzi) {
        super(producator, pret);
        this.tip_chitara = tip_chitara;
        this.nr_corzi = nr_corzi;
    }
}


class SetTobe extends InstrumentMuzical {
    TipTobe tip_tobe;
    int nr_tobe;
    int nr_cinele;

    public SetTobe(String producator, double pret, TipTobe tip_tobe, int nr_tobe, int nr_cinele) {
        super(producator, pret);
        this.tip_tobe = tip_tobe;
        this.nr_tobe = nr_tobe;
        this.nr_cinele = nr_cinele;
    }
}

public class MainApp {
    public static void main(String[] args) {

        Set<InstrumentMuzical> colectieInstrumente = new HashSet<>();


        colectieInstrumente.add(new Chitara("Fender", 999.99, TipChitara.ELECTRICA, 6));
        colectieInstrumente.add(new Chitara("Yamaha", 799.99, TipChitara.ACUSTICA, 12));
        colectieInstrumente.add(new Chitara("Cordoba", 599.99, TipChitara.CLASICA, 6));

        colectieInstrumente.add(new SetTobe("Roland", 1999.99, TipTobe.ELECTRONICE, 5, 3));
        colectieInstrumente.add(new SetTobe("Pearl", 1499.99, TipTobe.ACUSTICE, 7, 4));
        colectieInstrumente.add(new SetTobe("Ludwig", 999.99, TipTobe.ELECTRONICE, 4, 2));


        for (InstrumentMuzical instrument : colectieInstrumente) {
            if (instrument instanceof Chitara) {
                Chitara chitara = (Chitara) instrument;
                System.out.println("Chitara - Producator: " + chitara.producator +
                        ", Tip: " + chitara.tip_chitara +
                        ", Nr. corzi: " + chitara.nr_corzi +
                        ", Pret: " + chitara.pret);
            } else if (instrument instanceof SetTobe) {
                SetTobe setTobe = (SetTobe) instrument;
                System.out.println("Set de Tobe - Producator: " + setTobe.producator +
                        ", Tip: " + setTobe.tip_tobe +
                        ", Nr. tobe: " + setTobe.nr_tobe +
                        ", Nr. cinele: " + setTobe.nr_cinele +
                        ", Pret: " + setTobe.pret);
            }
        }
    }
}

