/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cat_app;

import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author sebas
 */
public class GatosService {

    public static void vergatos() throws IOException {
        //traer datos de la api
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url("https://api.thecatapi.com/v1/images/search").method("GET", null).build();
        Response response = client.newCall(request).execute();
        String jsons = response.body().string();
        //cortar corchetes
        jsons = jsons.substring(1, jsons.length());
        jsons = jsons.substring(0, jsons.length() - 1);
        //creat objeto de la clase gson
        Gson gson = new Gson();
        Gato gatos = gson.fromJson(jsons, Gato.class);

        //redimencionar
        Image image = null;

        try {
            URL url = new URL(gatos.getUrl());
            image = ImageIO.read(url);
            ImageIcon fondoGato = new ImageIcon(image);

            if (fondoGato.getIconWidth() > 800) {
                Image fondo = fondoGato.getImage();
                Image modificada = fondo.getScaledInstance(800, 600, java.awt.Image.SCALE_SMOOTH);
                fondoGato = new ImageIcon(modificada);
            }
            String menu = "opciones\n"
                    + "1ver otra imagen\n"
                    + "favorito"
                    + "volver\n";
            String[] botones = {"ver otra imagen", "favorito", "volver"};
            String id_gato = String.valueOf(gatos.getId());
            String opcion = (String) JOptionPane.showInputDialog(null, menu, id_gato, JOptionPane.INFORMATION_MESSAGE, fondoGato, botones, botones[0]);
            int seleccion= -1;
            
                        for (int i = 0; i < botones.length; i++) {
                if (opcion.equals(botones[i])) {
                    seleccion = i;

                }
            }
                        switch(seleccion){
                            case 0:{
                                vergatos();
                                break;
                            }
                            case 1:{
                                favoritoGato(gatos);
                                break;
                               
                            }
                            default:
                                break;
                        }

        } catch (Exception e) {
            System.out.println(e);
        }

    }
public static void favoritoGato (Gato gato){
}
}
