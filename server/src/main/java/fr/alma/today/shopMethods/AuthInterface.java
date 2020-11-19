package fr.alma.today.shopMethods;

import fr.alma.today.models.User;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AuthInterface extends Remote {

    public User register(String username, String email, String password) throws RemoteException;;

    public User login(String username, String password) throws RemoteException;

}
