package decorators;

public class DataSourceDecorator implements DataSource{
    private DataSource wrapper;

    public DataSourceDecorator(DataSource dataSource) {
        this.wrapper = dataSource;
    }

    @Override
    public void writeData(String data) {
        wrapper.writeData(data);
    }

    @Override
    public String readData() {
        return wrapper.readData();
    }
}
