package org.example;

import java.util.Scanner;

public class MessageService {

    //Crear
    public static void createMessage(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Por favor escribe tu mensaje");
        String mensaje = sc.nextLine();

        System.out.println("Ingresa tu nombre");
        String nombre = sc.nextLine();

        System.out.println("Ingresa la fecha en formato dd/mm/yyyy");
        String fecha = sc.nextLine();

        Message message = new Message();
        message.setMessageText(mensaje);
        message.setAuthorMessage(nombre);
        message.setDateMessage(fecha);

        MessageDao.createMessage(message);
    }

    //Encontrar
    public static void findMessage(){
        MessageDao.readMessage();
    }

    //Eliminar
    public static void deleteMessage(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Por favor ingresa el id del mensaje a eliminar");
        int idMessage = sc.nextInt();
        MessageDao.deleteMessage(idMessage);
    }

    //Actualizar
    public static void updateMessages(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Por favor escribe el nuevo mensaje");
        String mensaje = sc.nextLine();

        System.out.println("Por favor ingresa el id del mensaje a actualizar");
        int idMessage = sc.nextInt();
        Message actualizacion = new Message();
        actualizacion.setIdMessage(idMessage);
        actualizacion.setMessageText(mensaje);
        MessageDao.updateMessage(actualizacion);
    }
}
