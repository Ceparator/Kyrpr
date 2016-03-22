/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Ceparator
 */
public class Stop {

    private int number;
    private int idStop;
    private String name;
    private Double coordX;
    private Double coordY;

    public Stop(int number, int idStop, String name, Double coordX, Double coordY) {
        this.number = number;
        this.idStop = idStop;
        this.name = name;
        this.coordX = coordX;
        this.coordY = coordY;
    }

    public Stop(int idStop, String name, Double coordX, Double coordY) {
        this.idStop = idStop;
        this.name = name;
        this.coordX = coordX;
        this.coordY = coordY;
    }

    public Stop(String name, Double coordX, Double coordY) {
        this.name = name;
        this.coordX = coordX;
        this.coordY = coordY;
    }

    public int getIdStop() {
        return idStop;
    }

    public void setIdStop(int idStop) {
        this.idStop = idStop;
    }

    public Double getCoordX() {
        return coordX;
    }

    public void setCoordX(Double coordX) {
        this.coordX = coordX;
    }

    public Double getCoordY() {
        return coordY;
    }

    public void setCoordY(Double coordY) {
        this.coordY = coordY;
    }

    public Stop() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

}
