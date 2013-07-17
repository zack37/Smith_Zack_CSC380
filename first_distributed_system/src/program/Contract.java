package program;

import java.io.Serializable;

/**
 * User: Zack Smith
 * Date: 7/14/13
 * Time: 4:58 PM
 */
public class Contract implements Serializable {

    private String classPath;
    private String methodName;
    private Object parameters;

    public Contract(String classPath, String methodName, Object parameters) {
        this.classPath = classPath;
        this.methodName = methodName;
        this.parameters = parameters;
    }

    public Object getParameters() {
        return parameters;
    }

    public String getMethodName() {
        return methodName;
    }

    public String getClassPath() {
        return classPath;
    }
}
