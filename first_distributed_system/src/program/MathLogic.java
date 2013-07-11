package program;

/**
 * User: Zack Smith
 * Date: 7/9/13
 * Time: 12:59 PM
 */
public class MathLogic {

    public double add(Number... params) {
        double sum = 0;
        for (Number n : params)
            sum += n.doubleValue();

        return sum;
    }

    public double subtract(Number... params) {
        double difference = 0;
        for (Number n : params)
            difference -= n.doubleValue();

        return difference;
    }
}
