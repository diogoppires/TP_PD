package ClientRMI;

import ObserverRMI.ObserverRemoteInterface;
import ServerRMI.ServerRemoteInterface;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class ClientRemote extends UnicastRemoteObject implements ServerRemoteInterface, ObserverRemoteInterface {

    public ClientRemote() throws RemoteException {
    }

    @Override
    public void makeRegister(String name, String username, String password, String photo_path) throws RemoteException {

    }

    @Override
    public void sendMsgAll(String msg) throws RemoteException {

    }

    @Override
    public void addObserverUsers(ObserverRemoteInterface observer) throws RemoteException {

    }

    @Override
    public void addObserversMessages(ObserverRemoteInterface observer) throws RemoteException {

    }

    @Override
    public void removeObserverUsers(ObserverRemoteInterface observer) throws RemoteException {

    }

    @Override
    public void removeObserverMessages(ObserverRemoteInterface observer) throws RemoteException {

    }

    @Override
    public void notifyNewOperationConcluded(String description) throws RemoteException {
        System.out.println(description);
    }

    public static void main(String args[]) {
        String objectUrl;
        ClientRemote clientRemote;
        ServerRemoteInterface remObj;
        try{

            objectUrl = "rmi://127.0.0.1/ServerRemote";
            /*
             * Obtem a referencia remota para o servico com nome "GetRemoteFile"
             */
            remObj = (ServerRemoteInterface) Naming.lookup(objectUrl);
            /*
             * Lanca o servico local para acesso remoto por parte do servidor.
             */
            clientRemote = new ClientRemote();

            boolean over = false;
            Scanner sc = new Scanner(System.in);
            while (!over){
                System.out.println("Indique uma opção:");
                System.out.println("1 - Registar User   2 - Enviar Mensagem");
                System.out.println("3 - Notificar Users 4 - Notificar Mensagens");
                switch(sc.nextInt()){
                    case 1 -> remObj.makeRegister("Ola", "xau", "tau", "pau");
                    case 2 -> remObj.sendMsgAll("ola");
                    case 3 -> remObj.addObserverUsers(clientRemote);
                    case 4 ->  remObj.addObserversMessages(clientRemote);
                    case 6 -> over = true;
                }
            }





        } catch (RemoteException e) {
            System.out.println("Remote Error - " + e);
        } catch (NotBoundException e) {
            System.out.println("Unknown Remote Service - " + e);
        } catch (IOException e) {
            System.out.println("Error E/S - " + e);
        }
    }
}
