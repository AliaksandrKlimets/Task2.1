package com.epam.task2.manager;

import java.util.ResourceBundle;

/**
 * This class is used to create bundle
 */
public class ManagerBundle {
    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle("regex");

    public ManagerBundle() {
    }

    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }
}
