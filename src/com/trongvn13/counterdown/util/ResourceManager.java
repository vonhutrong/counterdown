package com.trongvn13.counterdown.util;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

public class ResourceManager {
    private ClassLoader classLoader = null;
    private static ResourceManager instance = new ResourceManager();
    
    private ResourceManager() {
        classLoader = getClass().getClassLoader();
    }
    
    public static ResourceManager getInstance() {
        return instance;
    }
    
    public Image getImageFromPath(String path) {
        URL url = classLoader.getResource(path);
        if (url == null)
            return null;
        return new ImageIcon(url).getImage();
    }
}
