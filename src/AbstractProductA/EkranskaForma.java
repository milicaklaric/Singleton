/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractProductA;
import javax.swing.JFrame;
/**
 *
 * @author MK
 */
public abstract class EkranskaForma extends JFrame{
    public Panel getPanel() {return (Panel)getContentPane();}  
    public void setPanel(Panel pan1) {setContentPane(pan1);//pan=pan1;
        
    }
    public void prikaziEkranskuFormu(){setVisible(true);}
    abstract public void odrediDekoracijuForme();
}
