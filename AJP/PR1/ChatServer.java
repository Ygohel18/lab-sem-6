import java.io.*;
import java.net.*;
import java.util.*;
import java.util.Scanner;

public class ChatServer {

  public static void main(String[] args) throws IOException {
    ServerSocket serverSocket = new ServerSocket(8000);
    Socket clientSocket;
    BufferedReader in;
    PrintWriter out;

    while (true) {
      clientSocket = serverSocket.accept();
      in =
        new BufferedReader(
          new InputStreamReader(clientSocket.getInputStream())
        );
      out = new PrintWriter(clientSocket.getOutputStream(), true);

      try {
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
          System.out.println("Client: " + inputLine);
          Scanner sc = new Scanner(System.in);
          String msg = sc.nextLine();
          out.println(msg);
        }
      } catch (IOException e) {
        e.printStackTrace();
      } finally {
        try {
          clientSocket.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
