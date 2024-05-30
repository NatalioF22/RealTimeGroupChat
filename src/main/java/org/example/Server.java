package org.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;

    public Server(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }
    public void startServer(){
        try{
            System.out.println("The Server has initiated!");
            while(!serverSocket.isClosed()){
                Socket socket =  serverSocket.accept();

                System.out.println("A new user has connected!");
                ClientHandler clientHandler = new ClientHandler(socket);
                Thread thread = new Thread(clientHandler);
                thread.start();
            }
        }
        catch (IOException error){
            System.out.println();
        }
    }
    public void closeServerSocket(){
        try{
            if(serverSocket != null){
                closeServerSocket();
            }
            else {
                throw  new IOException();
            }
        }
        catch (IOException error){
            error.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9876);
        Server server = new Server(serverSocket);
        server.startServer();
    }
}
