package servlet;

import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebServlet;
import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.transport.servlet.CXFNonSpringServlet;
import service.ZipCodeServiceImpl;

/**
 * User: Zack Smith
 * Date: 8/6/13
 * Time: 6:27 PM
 */
@WebServlet("/services/*")
public class ZipCodeServlet extends CXFNonSpringServlet {

    @Override
    protected void loadBus(ServletConfig sc) {
        super.loadBus(sc);
        Bus bus = getBus();
        BusFactory.setDefaultBus(bus);
        Endpoint.publish("/ZipCodeService", new ZipCodeServiceImpl());
    }
}