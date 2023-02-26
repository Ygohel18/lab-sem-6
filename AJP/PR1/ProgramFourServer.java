import java.io.*;
import java.net.*;
import java.util.*;

public class ProgramFourServer {

  public static void main(String args[]) throws IOException {
    ServerSocket ss = new ServerSocket(1811);
    Socket s = ss.accept();
    String str, str_out, stro = "";
    BufferedReader br = new BufferedReader(
      new InputStreamReader(s.getInputStream())
    );
    PrintStream ps = new PrintStream(s.getOutputStream());
    while ((str = br.readLine()) != null) {
      str_out = str;
      stro = stro + str_out;
      ps.println(stro);
    }
    ps.close();
    ss.close();
    s.close();
  }
}
