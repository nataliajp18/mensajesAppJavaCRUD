package org.example;

public class Message {

    int idMessage;
    String messageText;
    String authorMessage;
    String dateMessage;

    public Message() {
    }

    public Message(int idMessage, String messageText, String authorMessage, String dateMessage) {
        this.idMessage = idMessage;
        this.messageText = messageText;
        this.authorMessage = authorMessage;
        this.dateMessage = dateMessage;
    }

    public int getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(int idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public String getAuthorMessage() {
        return authorMessage;
    }

    public void setAuthorMessage(String authorMessage) {
        this.authorMessage = authorMessage;
    }

    public String getDateMessage() {
        return dateMessage;
    }

    public void setDateMessage(String dateMessage) {
        this.dateMessage = dateMessage;
    }
}
