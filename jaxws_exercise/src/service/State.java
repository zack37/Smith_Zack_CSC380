package service;

/**
 * User: Zack Smith
 * Date: 8/6/13
 * Time: 5:49 PM
 */
public class State {
    private String fullName;
    private String twoDigitCode;

    public State() {
    }

    public State(String fullName, String twoDigitCode) {
        this.fullName = fullName;
        this.twoDigitCode = twoDigitCode;
    }

    public String getFullName() {

        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getTwoDigitCode() {
        return twoDigitCode;
    }

    public void setTwoDigitCode(String twoDigitCode) {
        this.twoDigitCode = twoDigitCode;
    }
}
