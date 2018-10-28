package logging;

public class DefaultLogger implements AmplitudeLogger{
    @Override
    public void info(String log) {
        System.out.println(log);
    }

    @Override
    public void error(String log) {
        System.out.println(log);
    }
}
