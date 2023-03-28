package decorators;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileDatasource implements DataSource{
    private String name;

    public FileDatasource(String name) {
        this.name = name;
    }

    @Override
    public void writeData(String data) {
        var file = new File(name);
        try (var fos = new FileOutputStream(file)){
            fos.write(data.getBytes(), 0, data.length());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String readData() {
        char[] buffer = null;
        var file = new File(name);
        try(var reader = new FileReader(file)) {
            buffer = new char[(int) file.length()];
            reader.read(buffer);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return new String(buffer);
    }
}
