package com.casi_td4;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import com.casi_td4.modele.Banque;
import com.google.gson.Gson;

public class JsonManager {

    private static JsonManager instance;

    private JsonManager() {
        super();
    }

    public static synchronized JsonManager getInstance() {
        if (instance == null) {
            instance = new JsonManager();
        }

        return instance;
    }

    public void SaveBanque(Banque obj, String path) {
        String json = new Gson().toJson(obj);

        Path filepath = Paths.get(path);

        if (filepath.toFile().exists()) {
            filepath.toFile().delete();
        }

        try {
            Files.write(filepath, json.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE_NEW);
        } catch (IOException ioex) {
            ioex.printStackTrace();
        }

    }

    public Banque ReadObject(String path) {
        Path filepath = Paths.get(path);

        if (!filepath.toFile().exists()) {
            return null;
        } else {
            try {
                byte[] json = Files.readAllBytes(filepath);

                Banque banque = new Gson().fromJson(new String(json, StandardCharsets.UTF_8), Banque.class);

                return banque;
            } catch (IOException ioex) {
                ioex.printStackTrace();
                return null;
            }
        }
    }

}
