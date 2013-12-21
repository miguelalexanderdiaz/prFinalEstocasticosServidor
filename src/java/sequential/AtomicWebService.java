/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sequential;

import entity.ServiceRateWS;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author migueldiaz
 */
@WebService(serviceName = "AtomicWebService")
@Stateless()
public class AtomicWebService {

    @WebMethod(operationName = "atomicOperation")
    public Integer atomicOperation(
            @WebParam(name = "request") ServiceRateWS request,
            @WebParam(name = "arrivingRate") Double arrivingRate,
            @WebParam(name = "realTime") Boolean realTime) {

        Random ran = new Random();
        //to miliseconds
        Double reqInMilis = 1 / request.getServiceRate() * 1000;
        Double arrivInMilis = 1 / arrivingRate;
        Double deviation;


        deviation = ran.nextDouble() * request.getStandarDeviation();

        if (ran.nextInt() % 2 == 0) {
            deviation *= -1;
        }
        Double aux = reqInMilis + deviation;
        Integer sleep = aux.intValue() + arrivInMilis.intValue();
        System.out.println("sleep=" + sleep + " stdeviantion=" + deviation + " milis=" + reqInMilis);
        if (realTime) {
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException ex) {
                Logger.getLogger(AtomicWebService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return sleep;
    }
}
