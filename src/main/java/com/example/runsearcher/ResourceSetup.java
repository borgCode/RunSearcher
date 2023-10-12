package com.example.runsearcher;

import java.io.*;
import java.net.URISyntaxException;

public class ResourceSetup {

    private static final String APP_DIR_NAME = "RunSearcher";

    static File resourcesDirectory;

    public ResourceSetup() {

    }
    public void init() {


        String appData = System.getenv("APPDATA");
        if (appData == null || appData.isEmpty()) {
            appData = System.getProperty("user.home");
        }

        File appDir = new File(appData, APP_DIR_NAME);
        resourcesDirectory = new File(appDir, "resources");


        if (!resourcesDirectory.exists()) {
            resourcesDirectory.mkdirs();
            copyResources("/resources/membersAndDate.txt", new File(resourcesDirectory, "membersAndDate.txt"));
            copyResources("/resources/runs.csv", new File(resourcesDirectory, "runs.csv"));
        }


    }

    private void copyResources(String source, File destination) {

        if (destination.exists()) {
            return;
        }

        try (InputStream is = RunSearcher.class.getResourceAsStream(source);
            OutputStream os = new FileOutputStream(destination)) {
            if (is == null) {
                System.out.println("Hello");
                return;
            }
                byte[] data = new byte[1024];
                int bytesRead;
                while((bytesRead = is.read(data)) != -1) {
                    os.write(data, 0, bytesRead);
                }


        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }


    }

    public static File getCSV() {
        return new File(resourcesDirectory, "runs.csv");
    }

    public static File getTXT() {
        return new File(resourcesDirectory, "membersAndDate.txt");
    }
}
