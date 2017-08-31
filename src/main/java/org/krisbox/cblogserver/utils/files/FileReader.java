package org.krisbox.cblogserver.utils.files;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.krisbox.cblogserver.App;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReader {
    public FileReader() {

    }

    public String readFile(String filename) {
        ClassLoader classLoader = this.getClass().getClassLoader();
        InputStream stream = classLoader.getResourceAsStream(filename);

        String theString = null;
        try {
            theString = IOUtils.toString(stream, "UTF8");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return theString;
    }
}
