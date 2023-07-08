package com.example.anonchat;

import android.content.Context;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class FileUtility {

    // final because it never will change
    // static because we need access from isUserLoggedIn to the Strings
    static public final String nicknameFile = "nickname.txt";

    static public String readFromFile(String filename, Context context) throws IOException {
        FileInputStream fis = context.openFileInput(filename);
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(fis, StandardCharsets.UTF_8));

        return reader.readLine();
    }

    static public void writeToFile(String filename, String fileContent, Context context) throws IOException {
        try (FileOutputStream fos = context.openFileOutput(filename, Context.MODE_PRIVATE)) {
            fos.write(fileContent.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

