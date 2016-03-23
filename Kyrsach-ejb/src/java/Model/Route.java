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
public class Route {

    private int idRoute;
    private int number;
    private int first;
    private int second;
    private Stop firstStop;
    private Stop lastStop;
    private Circuit firstScheme;
    private Circuit secondScheme;
    private int price;
    private int rating;

    public Route(int number, Stop firstStop, Stop lastStop, Circuit firstScheme, Circuit secondScheme, int price, int rating) {
        this.number = number;
        this.firstStop = firstStop;
        this.lastStop = lastStop;
        this.firstScheme = firstScheme;
        this.secondScheme = secondScheme;
        this.price = price;
        this.rating = rating;
    }

    public Route(int idRoute, int number, Stop firstStop, Stop lastStop, int first, int second, int price, int rating) {
        this.idRoute = idRoute;
        this.number = number;
        this.firstStop = firstStop;
        this.lastStop = lastStop;
        this.first = first;
        this.second = second;
        this.price = price;
        this.rating = rating;
    }

    public Route(int idRoute, Circuit firstScheme, Circuit secondScheme) {
        this.idRoute = idRoute;
        this.firstScheme = firstScheme;
        this.secondScheme = secondScheme;
    }
    
    

    public Route() {

    }

    public Circuit getFirstScheme() {
        return firstScheme;
    }

    public void setFirstScheme(Circuit firstScheme) {
        this.firstScheme = firstScheme;
    }

    public Circuit getSecondScheme() {
        return secondScheme;
    }

    public void setSecondScheme(Circuit secondScheme) {
        this.secondScheme = secondScheme;
    }

    public int getIdRoute() {
        return idRoute;
    }

    public void setIdRoute(int idRoute) {
        this.idRoute = idRoute;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Stop getFirstStop() {
        return firstStop;
    }

    public void setFirstStop(Stop firstStop) {
        this.firstStop = firstStop;
    }

    public Stop getLastStop() {
        return lastStop;
    }

    public void setLastStop(Stop lastStop) {
        this.lastStop = lastStop;
    }

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
    

}
