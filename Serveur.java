package tp2_act_2_2;

import java.io.*;
import java.net.*;
public class Serveur {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		 try {
	            ServerSocket serverSocket = new ServerSocket(12345);
	            System.out.println("Serveur en attente de connexions...");

	            while (true) {
	                Socket clientSocket = serverSocket.accept();
	                ObjectInputStream inputStream = new ObjectInputStream(clientSocket.getInputStream());
	                ObjectOutputStream outputStream = new ObjectOutputStream(clientSocket.getOutputStream());

	                // Recevoir l'objet de calcul du client
	                calcul calcul = (calcul) inputStream.readObject();

	                // Effectuer le calcul
	                double resultat = effectuerCalcul(calcul);

	                // Envoyer le résultat au client
	                outputStream.writeDouble(resultat);
	                outputStream.flush();

	                // Fermer les flux et la connexion avec le client
	                inputStream.close();
	                outputStream.close();
	                clientSocket.close();
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    private static double effectuerCalcul(calcul calcul) {
	        double operande1 = calcul.getOperande1();
	        double operande2 = calcul.getOperande2();
	        String operateur = calcul.getOperateur();

	        switch (operateur) {
	            case "+":
	                return operande1 + operande2;
	            case "-":
	                return operande1 - operande2;
	            case "*":
	                return operande1 * operande2;
	            case "/":
	                return operande1 / operande2;
	            default:
	                return 0.0;
	        }
	    }
	

}
