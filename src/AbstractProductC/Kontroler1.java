/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractProductC;

import AbstractProductA.EkranskaForma;
import AbstractProductB.BrokerBazePodataka;
import DomainClasses.DKPles;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import static java.lang.Double.parseDouble;
import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author MK
 */
public class Kontroler1 extends Kontroler {

    public Kontroler1(EkranskaForma ef1, BrokerBazePodataka bbp1) {
        ef = ef1;
        bbp = bbp1;
        Povezi();
    }

    void Povezi() {
        javax.swing.JButton Kreiraj = ef.getPanel().getKreiraj();
        javax.swing.JButton Promeni = ef.getPanel().getPromeni();
        javax.swing.JButton Obrisi = ef.getPanel().getObrisi();
        javax.swing.JButton Nadji = ef.getPanel().getNadji();
        Kreiraj.addActionListener(new OsluskivacKreiraj(this));
        Promeni.addActionListener(new OsluskivacPromeni(this));
        Obrisi.addActionListener(new OsluskivacObrisi(this));
        Nadji.addActionListener(new OsluskivacNadji(this));

        javax.swing.JTextField SifraPrijave = ef.getPanel().getId1(); // Promenljivo!!!
        SifraPrijave.addFocusListener(new OsluskivacNadji1(this));
    }

// Promenljivo!!!  
    void napuniDomenskiObjekatIzGrafickogObjekta() {
        ples = new DKPles();
        try {
            ples.setId(getInteger(ef.getPanel().getId()));
            ples.setNaziv(ef.getPanel().getNaziv());
            ples.setInstruktor(ef.getPanel().getInstruktor());
            ples.setCena(parseDouble(ef.getPanel().getCena()));
            ples.setBrojPolaznika(getInteger(ef.getPanel().getBrojPolaznika()));
        } catch (Exception e) {
        }

    }

// Promenljivo!!!
    void napuniGrafickiObjekatIzDomenskogObjekta(DKPles ples) {
        ef.getPanel().setId(Integer.toString(ples.getId()));
        ef.getPanel().setNaziv(ples.getNaziv());
        ef.getPanel().setInstruktor(ples.getInstruktor());
        ef.getPanel().setCena(Double.toString(ples.getCena()));
        ef.getPanel().setBrojPolaznika(Integer.toString(ples.getBrojPolaznika()));

    }

// Promenljivo!!!
    void isprazniGrafickiObjekat() {

        ef.getPanel().setId("");
        ef.getPanel().setNaziv("");
        ef.getPanel().setInstruktor("");
        ef.getPanel().setCena("0");
        ef.getPanel().setBrojPolaznika("0");
    }

    void prikaziPoruku() {
        ef.getPanel().setPoruka(poruka);

        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                ef.getPanel().setPoruka("");
            }
        }, 5000);

    }
    public int getInteger(String s) {
        int broj = 0;
        try {
            if (s != null) {
                broj = Integer.parseInt(s);
            }
        } catch (NumberFormatException e) {
            broj = 0;
        }

        return broj;
    }

    boolean zapamtiDomenskiObjekat() {
        napuniDomenskiObjekatIzGrafickogObjekta();
        bbp.makeConnection();
        boolean signal = bbp.insertRecord(ples);
        if (signal == true) {
            bbp.commitTransation();
            poruka = "Sistem je zapamtio novi plesni kurs!"; // Promenljivo!!!
        } else {
            bbp.rollbackTransation();
            poruka = "Sistem ne može da zapamti novi plesni kurs!"; // Promenljivo!!!  
        }
        prikaziPoruku();
        bbp.closeConnection();
        return signal;

    }

    boolean kreirajDomenskiObjekat() {
        boolean signal;
        ples = new DKPles(); // Promenljivo!!!
        napuniDomenskiObjekatIzGrafickogObjekta();
        AtomicInteger counter = new AtomicInteger(0);

        bbp.makeConnection();
        if (!bbp.getCounter(ples, counter)) {
            return false;
        }
        if (!bbp.increaseCounter(ples, counter)) {
            return false;
        }

        ples.setId(counter.get()); // Promenljivo!!!
        signal = bbp.insertRecord(ples);
        if (signal == true) {
            bbp.commitTransation();
            napuniGrafickiObjekatIzDomenskogObjekta(ples);
            poruka = "Sistem je kreirao novi plesni kurs!"; // Promenljivo!!!
        } else {
            bbp.rollbackTransation();
            isprazniGrafickiObjekat();
            poruka = "Sistem ne može da kreira novi plesni kurs!"; // Promenljivo!!!
        }
         prikaziPoruku();
        bbp.closeConnection();
        return signal;
    }

    boolean obrisiDomenskiObjekat() {
        bbp.makeConnection();
        boolean signal = bbp.deleteRecord(ples);
        if (signal == true) {
            bbp.commitTransation();
            poruka = "Sistem je obrisao plesni kurs!"; // Promenljivo!!!
            isprazniGrafickiObjekat();
        } else {
            bbp.rollbackTransation();
            poruka = "Sistem ne može da obriše plesni kurs!"; // Promenljivo!!!
        }
        prikaziPoruku();
        bbp.closeConnection();
        return signal;
    }

    boolean promeniDomenskiObjekat() {
        bbp.makeConnection();
        boolean signal = bbp.updateRecord(ples);
        if (signal == true) {
            bbp.commitTransation();
            poruka = "Sistem je promenio podatke o plesnom kursu!"; // Promenljivo!!!
        } else {
            bbp.rollbackTransation();
            isprazniGrafickiObjekat();
            poruka = "Sistem ne može da promeni podatke o plesnom kursu!"; // Promenljivo!!!
        }
        prikaziPoruku();
        bbp.closeConnection();
        return signal;
    }

    boolean nadjiDomenskiObjekat() {
        boolean signal;
        bbp.makeConnection();
        ples = (DKPles) bbp.findRecord(ples); // Promenljivo!!!
        if (ples != null) {
            napuniGrafickiObjekatIzDomenskogObjekta(ples);
            poruka = "Sistem je pronašao plesni kurs!"; // Promenljivo!!!
            signal = true;
        } else {
            isprazniGrafickiObjekat();
            poruka = "Sistem ne može da pronadje plesni kurs!"; // Promenljivo!!!
            signal = false;
        }
        prikaziPoruku();
        bbp.closeConnection();
        return signal;
    }

}

class OsluskivacZapamti implements ActionListener {

    Kontroler1 kon;

    OsluskivacZapamti(Kontroler1 kon1) {
        kon = kon1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        kon.napuniDomenskiObjekatIzGrafickogObjekta();
        kon.zapamtiDomenskiObjekat();

    }
}

class OsluskivacKreiraj implements ActionListener {

    Kontroler1 kon;

    OsluskivacKreiraj(Kontroler1 kon1) {
        kon = kon1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        kon.kreirajDomenskiObjekat();

    }
}

class OsluskivacObrisi implements ActionListener {

    Kontroler1 kon;

    OsluskivacObrisi(Kontroler1 kon1) {
        kon = kon1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        kon.napuniDomenskiObjekatIzGrafickogObjekta();
        kon.obrisiDomenskiObjekat();

    }
}

class OsluskivacPromeni implements ActionListener {

    Kontroler1 kon;

    OsluskivacPromeni(Kontroler1 kon1) {
        kon = kon1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        kon.napuniDomenskiObjekatIzGrafickogObjekta();
        kon.promeniDomenskiObjekat();

    }
}

class OsluskivacNadji implements ActionListener {

    Kontroler1 kon;

    OsluskivacNadji(Kontroler1 kon1) {
        kon = kon1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        kon.napuniDomenskiObjekatIzGrafickogObjekta();
        kon.nadjiDomenskiObjekat();

    }
}

class OsluskivacNadji1 implements FocusListener {

    Kontroler1 kon;

    OsluskivacNadji1(Kontroler1 kon1) {
        kon = kon1;
    }

    public void focusLost(java.awt.event.FocusEvent e) {
        kon.napuniDomenskiObjekatIzGrafickogObjekta();
        kon.nadjiDomenskiObjekat();

    }

    @Override
    public void focusGained(FocusEvent e) {

    }
}
