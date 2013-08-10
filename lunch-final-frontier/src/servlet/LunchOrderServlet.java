package servlet;

import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.transport.servlet.CXFNonSpringServlet;
import service.LunchOrder;

import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebServlet;
import javax.xml.ws.Endpoint;

/**
 * User: Zack Smith
 * Date: 8/9/13
 * Time: 4:54 PM
 */
@WebServlet("/services/*")
public class LunchOrderServlet extends CXFNonSpringServlet {

    @Override
    protected void loadBus(ServletConfig sc) {
        super.loadBus(sc);
        Bus bus = getBus();
        BusFactory.setDefaultBus(bus);
        Endpoint.publish("LunchOrderService", new LunchOrder());
    }
}
