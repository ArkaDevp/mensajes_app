package com.arka.mensajes_app.services;

import com.arka.mensajes_app.DAO.MensajesDAO;
import com.arka.mensajes_app.model.Mensajes;

import java.util.Scanner;

public class MensajesService {
    static Scanner sc = new Scanner(System.in);
    public static void createMensaje(){
        System.out.println("Write your message:");
        String message = sc.nextLine();

        System.out.println("Your name:");
        String name = sc.nextLine();

        Mensajes registro = new Mensajes();
        registro.setMensaje(message);
        registro.setAutor_mensaje(name);

        MensajesDAO.createMensajeDB(registro);
    }

    public static void listMensajes(){
        MensajesDAO.readMensajesDB();
    }

    public static void deleteMensaje(){
        System.out.println("Write the id of the message you want to delete:");
        int id = sc.nextInt();
        MensajesDAO.deleteMensajesDB(id);

    }

    public static void editMensaje(){
        System.out.println("Write the id of the message you want edit: ");
        int id = sc.nextInt();
        System.out.println("Write your message");
        sc.nextLine();
        String message = sc.nextLine();
        System.out.println("Your name");
        String author = sc.nextLine();

        Mensajes registro = new Mensajes();
        registro.setMensaje(message);
        registro.setAutor_mensaje(author);

        MensajesDAO.actualizarMensajeDB(registro,id);
    }
}
