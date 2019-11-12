package decorator;

/**
 * @author Jerry Salonen
 */
public class ReadWriteContext {

    private ReadWriteState current;

    public ReadWriteContext() {
        // default value
        current = new Read();
    }

    public void setState(ReadWriteState state) {
        this.current = state;
    }

    public String processFile() {
        return current.processFile();
    }

}
