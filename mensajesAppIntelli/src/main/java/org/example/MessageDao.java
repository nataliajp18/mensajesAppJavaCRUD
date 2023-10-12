package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MessageDao {

    public static void createMessage (Message message){
        Conection dbConnect = new Conection();
        try (Connection conection = dbConnect.get_connection()){
            PreparedStatement preparedStatement = null;
            try {
                String query = "INSERT INTO message (messageText, authorMessage, dateMessage) VALUES (?,?,?)";
                preparedStatement = conection.prepareStatement(query);
                preparedStatement.setString(1,message.getMessageText());
                preparedStatement.setString(2, message.getAuthorMessage());
                preparedStatement.setString(3, message.getDateMessage());

                preparedStatement.executeUpdate();

                System.out.println("Mensaje creado");

            }catch (SQLException ex){
                System.out.println(ex);
            }

        }catch (SQLException e){
            System.out.println("No se puede conectar" + e);
        }
    }

    public static void readMessage(){

        Conection dbConnect = new Conection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;//Traer datos en filas para poderlos procesar

        try (Connection connection = dbConnect.get_connection()){

            String query = "SELECT * FROM message";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                System.out.println("ID: " + resultSet.getInt("idmessage"));
                System.out.println("Mensaje: " + resultSet.getString("messageText"));
                System.out.println("Autor: " + resultSet.getString("authorMessage"));
                System.out.println("Fecha: " + resultSet.getString("dateMessage"));
            }

        }catch (SQLException e){
            System.out.println("No se pueden leer los mensajes");
            System.out.println(e);
        }

    }

    public static void deleteMessage(int idMessage){
        Conection dbConnect = new Conection();

        try (Connection connection = dbConnect.get_connection()){
            PreparedStatement preparedStatement = null;

            try {

                String query = "DELETE FROM message WHERE idmessage = ?";
                preparedStatement=connection.prepareStatement(query);
                preparedStatement.setInt(1, idMessage);
                preparedStatement.executeUpdate();
                System.out.println("El mensaje ha sido borrado correctamente");
            }catch (SQLException ex){
                System.out.println(ex);
                System.out.println("No se puede eliminar el resgitro, comprobar numero de id");
            }
        }catch (SQLException e){
            System.out.println(e);
        }
    }

    public static void updateMessage(Message message){
        Conection dbConnect = new Conection();

        try (Connection connection = dbConnect.get_connection()){

            PreparedStatement preparedStatement = null;

            try {
                String query = "UPDATE message SET messageText = ? WHERE idmessage = ?";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, message.getMessageText());
                preparedStatement.setInt(2, message.getIdMessage());
                preparedStatement.executeUpdate();
                System.out.println("El mensaje se actualizo correctamente");
            }catch (SQLException ex){
                System.out.println(ex);
                System.out.println("No se pudo actualziar el mensaje.");
            }
        }catch (SQLException e){
            System.out.println(e);
        }
    }
}
