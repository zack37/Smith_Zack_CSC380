
package generated;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import javax.xml.namespace.QName;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.7.6
 * 2013-08-09T19:19:33.534-06:00
 * Generated source version: 2.7.6
 */
public final class _002fLunchOrderService_LunchOrderPort_Client {

    private static final QName SERVICE_NAME = new QName("http://service/", "LunchOrderService");

    private _002fLunchOrderService_LunchOrderPort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = LunchOrderService.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) {
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }

        LunchOrderService ss = new LunchOrderService(wsdlURL, SERVICE_NAME);
        _002fLunchOrderService port = ss.getLunchOrderPort();

        {
            System.out.println("Invoking getRestaurants...");
            java.util.List<generated.Restaurant> _getRestaurants__return = port.getRestaurants();
            //System.out.println("getRestaurants.result=" + _getRestaurants__return);


            for (Restaurant rest : _getRestaurants__return)
                System.out.println(rest.getName());

            {
                System.out.println("Invoking order...");
                Scanner scan = new Scanner(System.in);
                System.out.print("What restaurant? ");
                String r = scan.nextLine();
                Restaurant chosen = null;
                for (int i = 0; i < _getRestaurants__return.size(); i++)
                    if (_getRestaurants__return.get(i).getName().equals(r))
                        chosen = _getRestaurants__return.get(i);
                generated.Restaurant _order_arg0 = chosen;
                _order_arg0.setName(r);
                for (Food f : chosen.getFoods())
                    System.out.println(f.getName());
                System.out.print("What do you want to order? ");
                String f = scan.nextLine();
                generated.Food _order_arg1 = new Food();
                _order_arg1.setName(f);
                _order_arg0.getFoods().add(_order_arg1);
                java.lang.String _order__return = port.order(_order_arg0, _order_arg1);
                System.out.println("order.result=" + _order__return);


            }
        }


        System.exit(0);
    }

}
