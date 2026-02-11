package com.arka.mensajes_app;

import com.arka.dbconnection.ConnectionDB;
import com.arka.mensajes_app.services.MensajesService;

import java.sql.Connection;
import java.util.Scanner;

public class Main { 
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int option = 0;

        do {
            System.out.println("------------------------");
            System.out.println("Messaages App");
            System.out.println("1. Create message");
            System.out.println("2. List message");
            System.out.println("3. Edit message");
            System.out.println("4. Delete message");
            System.out.println("5. Exit");

            option = sc.nextInt();

            switch (option){
                case 1 ->{
                    MensajesService.createMensaje();
                }
                case 2 -> {
                    MensajesService.listMensajes();
                }
                case 3 -> {
                    MensajesService.editMensaje();
                }
                case 4 -> {
                    MensajesService.deleteMensaje();
                }
                default -> System.out.println("Invalid option");
            }
        }while(option != 5);




//        ConnectionDB connectionDB = new ConnectionDB();
//
//        try(Connection connection = connectionDB.get_connection()){
//
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }
    }
}
