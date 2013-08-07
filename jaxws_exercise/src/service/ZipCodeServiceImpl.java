package service;

import javax.jws.WebService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: Zack Smith
 * Date: 8/6/13
 * Time: 5:50 PM
 */
@WebService(endpointInterface ="service.ZipCodeService", serviceName = "ZipCodeService")
public class ZipCodeServiceImpl implements ZipCodeService {

    private static final Map<Integer, State> States;

    static {
        States = new HashMap<>();
        State initialState = new State();
        States.put(84111, new State("Utah", "UT"));
    }

    @Override
    public State getState(Integer zipCode) {
        return States.get(zipCode);
    }

    @Override
    public void addZipCode(State state, List<Integer> zipCodes) {
        for (Integer zipCode : zipCodes)
            if (!States.containsKey(zipCode))
                States.put(zipCode, state);
    }
}
