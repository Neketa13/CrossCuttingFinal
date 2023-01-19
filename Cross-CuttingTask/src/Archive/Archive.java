package Archive;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Archive {
    void archiving(String fileName) throws IOException;
    void deArchiving(String input);

}
