package com.example.runsearcher;

import javafx.scene.control.Alert;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class FileDownloader {

    File file;
    String listVersion;


    public FileDownloader() {
        file = new File("src/main/resources/membersAndDate.txt");

    }

    public void init() {

        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            br.readLine();
            listVersion = br.readLine();
            fr.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        downloadTxt();
        
        if (versionCheck(listVersion)) {
            downloadCSV();
            Alert success = new Alert(Alert.AlertType.INFORMATION);
            success.setTitle("List update");
            success.setHeaderText("List successfully updated!");
            success.show();
        } else {
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setTitle("List update");
            error.setHeaderText("Your list is already updated with the latest version!");
            error.show();
        }

    }

    private void downloadTxt() {
        try {
            URL url = new URL("https://drive.google.com/uc?id=1_lLys2JtffjNO9FggtBnpKCEWVqyZwJw&export=download");
            URLConnection connection = url.openConnection();
            InputStream is = connection.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            FileOutputStream fos = new FileOutputStream(file);

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            fos.close();
            bis.close();
            is.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private boolean versionCheck(String listVersion) {
        String line;

        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            br.readLine();
            line = br.readLine();
            fr.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return (!line.equals(listVersion));

    }

    private void downloadCSV() {

        try {

            URL url = new URL("https://drive.google.com/uc?id=1RiNkN6kCuO9eY1gY9u844vEThfvfX2IQ&export=download");
            URLConnection connection = url.openConnection();
            InputStream is = connection.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            FileOutputStream fos = new FileOutputStream("src/main/resources/runs.csv");

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            fos.close();
            bis.close();
            is.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
