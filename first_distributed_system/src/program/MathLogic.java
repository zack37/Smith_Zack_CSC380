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
        double difference = params[0].doubleValue();

        Number[] copy = new Number[params.length - 1];
        System.arraycopy(params, 1, copy, 0, params.length - 1);

        for (Number n : copy)
            difference -= n.doubleValue();

        return difference;
    }

    public double multiply(Number... params) {
        int product = 1;

        for (Number n : params) {
            product *= n.doubleValue();
        }

        return product;
    }
}
