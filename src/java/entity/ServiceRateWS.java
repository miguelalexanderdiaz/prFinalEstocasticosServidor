/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author migueldiaz
 */
public class ServiceRateWS {
    
    private int number;
    private double serviceRate;
    private double standarDeviation;

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setServiceRate(double serviceRate) {
        this.serviceRate = serviceRate;
    }

    public double getServiceRate() {
        return serviceRate;
    }

    public double getStandarDeviation() {
        return standarDeviation;
    }

    public void setStandarDeviation(double standarDeviation) {
        this.standarDeviation = standarDeviation;
    }
    
}
