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
public class Circuit {

    private int idCircuit;
    private Stop elem;
    private Circuit next;
    private String emptyNext;

    public Circuit(Stop elem, Circuit next) {
        this.elem = elem;
        this.next = next;
    }

    public Circuit(int idCircuit, Stop elem, Circuit next) {
        this.idCircuit = idCircuit;
        this.elem = elem;
        this.next = next;
    }

    public Circuit(int idCircuit, Stop elem, String emptyNext) {
        this.idCircuit = idCircuit;
        this.elem = elem;
        this.emptyNext = emptyNext;
    }

    public Circuit(Stop elem, String emptyNext) {
        this.elem = elem;
        this.emptyNext = emptyNext;
    }

    public Circuit(int idCircuit, Stop elem) {
        this.idCircuit = idCircuit;
        this.elem = elem;
    }

    public Circuit() {

    }

    public Stop getElem() {
        return elem;
    }

    public void setElem(Stop elem) {
        this.elem = elem;
    }

    public Circuit getNext() {
        return next;
    }

    public void setNext(Circuit next) {
        this.next = next;
    }

    public String getEmptyNext() {
        return emptyNext;
    }

    public void setEmptyNext(String emptyNext) {
        this.emptyNext = emptyNext;
    }

    public int getIdCircuit() {
        return idCircuit;
    }

    public void setIdCircuit(int idCircuit) {
        this.idCircuit = idCircuit;
    }

}
