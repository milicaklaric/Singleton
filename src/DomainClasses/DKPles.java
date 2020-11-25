/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainClasses;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author MK
 */
public class DKPles implements GeneralDObject {

    int id;
    String naziv;
    String instruktor;
    double cena;
    int brojPolaznika;

    public DKPles() {
        id = 0;
        naziv = "";
        instruktor = "";
        cena = 0;
        brojPolaznika = 0;
    }

    public DKPles(int id, String naziv, String instruktor, double cena, int brojPolaznika) {
        this.id = id;
        this.naziv = naziv;
        this.instruktor = instruktor;
        this.cena = cena;
        this.brojPolaznika = brojPolaznika;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getInstruktor() {
        return instruktor;
    }

    public void setInstruktor(String instruktor) {
        this.instruktor = instruktor;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public int getBrojPolaznika() {
        return brojPolaznika;
    }

    public void setBrojPolaznika(int brojPolaznika) {
        this.brojPolaznika = brojPolaznika;
    }

    @Override
    public String getAtrValue() {
        return id + ", " + (naziv == null ? null : "'" + naziv + "'") + ", " + (instruktor == null ? null : "'" + instruktor + "'") + ", " + cena + ", " + brojPolaznika;
    }

    @Override
    public String setAtrValue() {
        return "id=" + id + ", " + "naziv=" + (naziv == null ? null : "'" + naziv + "'") + ", " + "instruktor=" + (instruktor == null ? null : "'" + instruktor + "'") + ", " + "cena=" + cena + ", " + "brojPolaznika=" + brojPolaznika;
    }

    @Override
    public String getClassName() {
        return "DKPles";
    }

    @Override
    public String getWhereCondition() {
        return "id = " + id;
    }

    @Override
    public String getNameByColumn(int column) {
        String names[] = {"id", "naziv", "instruktor", "cena", "brojPolaznika"};
        return names[column];
    }

    @Override
    public GeneralDObject getNewRecord(ResultSet rs) throws SQLException {
        return new DKPles(rs.getInt("id"), rs.getString("naziv"), rs.getString("instruktor"), rs.getDouble("cena"), rs.getInt("brojPolaznika"));
    }
}
