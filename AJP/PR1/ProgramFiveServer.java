import java.io.*;
import java.net.*;
import java.util.*;

public class ProgramFiveServer {

  public static void main(String args[]) throws IOException {
    ServerSocket ss = new ServerSocket(777);
    Socket s = ss.accept();
    int i, sum = 0;
    String str;
    InputStream is = s.getInputStream();
    PrintStream ps = new PrintStream(s.getOutputStream());
    BufferedReader br = new BufferedReader(new InputStreamReader(is));
    while ((str = br.readLine()) != null) {
      System.out.println("The Number Sends by Client is:" + str);
      i = Integer.parseInt(str);
      sum = sum + i;
      ps.println("" + sum);
    }
    ps.close();
    ss.close();
    s.close();
  }
}
