package com.example.runsearcher;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {

    private static final ConfigLoader INSTANCE = new ConfigLoader();
    private final Properties properties;

    private ConfigLoader() {
        this.properties = new Properties();
        load();
    }

    private void load() {

        try {
            properties.load(new FileInputStream(ResourceSetup.propertiesFile));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static ConfigLoader getInstance() {
        return ConfigLoader.INSTANCE;
    }

    public boolean isDarkmodeEnabled() {
        String isDarkMode = properties.getProperty("darkmode");
        return isDarkMode.equals("true");
    }

    public void setDarkModePropertyFalse() {
        properties.setProperty("darkmode", "false");
        try (FileWriter writer = new FileWriter(ResourceSetup.propertiesFile)) {
            properties.store(writer, null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setDarkModePropertyTrue() {
        properties.setProperty("darkmode", "true");

        try (FileWriter writer = new FileWriter(ResourceSetup.propertiesFile)) {
            properties.store(writer, null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
