package tp2_act_2_2;

import java.io.*;
import java.net.*;

public class Client2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		try {
            Socket socket = new Socket("localhost", 12345);
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            
            // Créer l'objet sérialisable de Calcul
            calcul calcul = new calcul(5, 3, "+");

            // Envoyer l'objet sérialisé au serveur
            outputStream.writeObject(calcul);
            outputStream.flush();

            // Recevoir la réponse du serveur
            Object response = inputStream.readObject();

            if (response instanceof Double) {
                double resultat = (Double) response;
                System.out.println("Résultat : " + resultat);
            } else if (response instanceof String) {
                String message = (String) response;
                System.out.println("Message du serveur : " + message);
            }

           
            outputStream.close();
            inputStream.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	

}
