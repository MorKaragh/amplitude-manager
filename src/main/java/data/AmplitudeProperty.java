package data;

public class AmplitudeProperty {
    private String name;
    private Double doubleVal;
    private Integer integerVal;
    private String stringVal;

    public AmplitudeProperty(String name, Double doubleVal) {
        this.name = name;
        this.doubleVal = doubleVal;
    }

    public AmplitudeProperty(String name, String stringVal) {
        this.name = name;
        this.stringVal = stringVal;
    }

    public AmplitudeProperty(String name, Integer integerVal) {
        this.name = name;
        this.integerVal = integerVal;
    }

    @Override
    public String toString() {
        return "AmplitudeProperty{" +
                "name='" + name + '\'' +
                ", doubleVal=" + doubleVal +
                ", integerVal=" + integerVal +
                ", stringVal='" + stringVal + '\'' +
                '}';
    }
}
