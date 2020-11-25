/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractProductA;

import java.awt.event.KeyEvent;
import java.util.Date;

/**
 *
 * @author MK
 */
public abstract class Panel extends javax.swing.JPanel {

    public abstract String getId();
    public abstract javax.swing.JTextField getId1();

    public abstract String getNaziv();

    public abstract String getInstruktor();

    public abstract String getCena();

    public abstract String getBrojPolaznika();
    

    public abstract void setId(String id);

    public abstract void setNaziv(String naziv);

    public abstract void setInstruktor(String instruktor);

    public abstract void setCena(String cena);

    public abstract void setBrojPolaznika(String brojPolaznika);
    
    

    public abstract javax.swing.JButton getKreiraj();

    public abstract javax.swing.JButton getPromeni();

    public abstract javax.swing.JButton getObrisi();

    public abstract javax.swing.JButton getNadji();
    
    public abstract void setPoruka(String Poruka);
}
