package com.june.notebook.util;

import java.io.FileWriter;
import java.io.IOException;

public class resetConfig {
    public static void reset() {
        try {
            FileWriter fileOverwriter = new FileWriter("config/vanilla-notebook/config.cfg");
            fileOverwriter.write("# You need to reload for these to take affect!\n# Directory for the pages to be stored in (e.g .minecraft/CoordinateBook)\npagedirectory=Notebook/Default\n# Set page limits, negative numbers mean no limit\npagelimit=-1\n# Page to start on after opening the book\nstartpage=0\n# Presets enabled?\npresets=false");
            fileOverwriter.close();
        } catch (IOException e) { e.printStackTrace(); }

        try {
            FileWriter fileOverwriter = new FileWriter("config/vanilla-notebook/bookmark.cfg");
            fileOverwriter.write("# This file stores the bookmark data; DO NOT EDIT THIS FILE as it can cause issues, bugs and crashing!\n0");
            fileOverwriter.close();
        } catch (IOException e) { e.printStackTrace(); }
    }
}