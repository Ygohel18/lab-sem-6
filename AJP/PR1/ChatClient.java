import java.io.*;
import java.net.*;
import java.util.*;

public class ChatClient {

  public static void main(String[] args) throws IOException {
    Socket socket = new Socket("localhost", 8000);
    BufferedReader in = new BufferedReader(
      new InputStreamReader(socket.getInputStream())
    );
    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

    BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
    String userInput;
    while ((userInput = stdin.readLine()) != null) {
      out.println(userInput);
      System.out.println("Server says: " + in.readLine());
    }
  }
}
