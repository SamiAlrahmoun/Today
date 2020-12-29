package fr.alma.today;

import com.mongodb.*;

import com.mongodb.ConnectionString;
//
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import com.mongodb.client.MongoDatabase;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import fr.alma.today.shopMethods.ShopMethods;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

public class Server   {
    private static Logger logger = Logger.getLogger(String.valueOf(Server.class));

    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        Logger.getLogger("org.mongodb.driver").setLevel(Level.WARNING);


        ConnectionString connectionString = new ConnectionString("mongodb+srv://today:today123@cluster0.ny1qh.mongodb.net/today?retryWrites=true&w=majority");
        CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
        CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
        MongoClientSettings clientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)

                .codecRegistry(codecRegistry)
                .build();
        try{
            MongoClient mongoClient = MongoClients.create(clientSettings);
           mongoClient.watch();

            MongoDatabase database = mongoClient.getDatabase("today");
            Registry registry = LocateRegistry.createRegistry(1099);

             registry.bind("today", new ShopMethods(database));
            System.out.println("Server is connected and waiting for the client");

        }catch (Exception e){
            logger.info("Exceptioon @ " + e);
        }

    }

    }

