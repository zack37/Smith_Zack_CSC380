package program;

/**
 * User: Zack Smith
 * Date: 7/16/13
 * Time: 5:34 PM
 */
public class ObjectTester {

    public String printObjects(Object... params) {
        StringBuilder sb = new StringBuilder();

        String delim = "";

        for (Object o : params) {
            sb.append(delim).append(o.toString());
            delim = ",";
        }

        System.out.print(sb.toString());

        return sb.toString();
    }
}
