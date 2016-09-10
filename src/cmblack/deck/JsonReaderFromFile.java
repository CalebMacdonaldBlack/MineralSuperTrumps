package cmblack.deck;

import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by calebmacdonaldblack on 10/09/2016.
 */
public class JsonReaderFromFile implements IJsonReaderWrapper {

    private final String fileName;

    public JsonReaderFromFile(String fileName) {
        this.fileName = fileName;
    }


    @Override
    public JsonReader getReader() throws FileNotFoundException {
        return new JsonReader(new FileReader(this.fileName));
    }
}
