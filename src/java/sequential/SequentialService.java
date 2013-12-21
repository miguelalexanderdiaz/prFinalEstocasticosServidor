/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sequential;


import atomic.AtomicWebService_Service;
import atomic.ServiceRateWS;

import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author migueldiaz
 */
@WebService(serviceName = "SequentialService")
@Stateless()
public class SequentialService {
    @WebServiceRef(wsdlLocation = "META-INF/wsdl/localhost_8080/AtomicWebService/AtomicWebService.wsdl")
    private AtomicWebService_Service service;
    


    @WebMethod(operationName = "fullSimulation")
    public ArrayList<Integer> fullSimulation(
            @WebParam(name = "queue") ArrayList<ServiceRateWS> queue,
            @WebParam(name = "arrivingRate") Double arrivingRate) {
        ArrayList<Integer> resultQueue = new ArrayList<Integer>();
        int lengthQueue = queue.size();
        for (int i = 0; i < lengthQueue; i++) {
            
           resultQueue.add(atomicOperation(queue.get(i),arrivingRate, false));
        }
        return resultQueue;
    }

    @WebMethod(operationName = "byIndexSimulation")
    public Integer byIndexSimulation(@WebParam(name = "request") ServiceRateWS request,
    @WebParam(name = "arrivingRate") Double arrivingRate) {
        return atomicOperation(request, arrivingRate ,true);

    }

    /*
     * implementacion cliente de la operación atómica
     */

    private Integer atomicOperation(atomic.ServiceRateWS request, java.lang.Double arrivingRate, java.lang.Boolean realTime) {
        atomic.AtomicWebService port = service.getAtomicWebServicePort();
        return port.atomicOperation(request, arrivingRate, realTime);
    }
    



    
    
}
