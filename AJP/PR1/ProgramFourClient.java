import java.io.*;
import java.net.*;
import java.util.*;
public class ProgramFourClient
{
public static void main(String args[]) throws Exception
{
Socket s=new Socket("localhost",777);
String str[]={"Hello ","I ","am ","a ","Student ","of ","an ","Engieering College. "};
BufferedReader br=new BufferedReader(new
InputStreamReader(s.getInputStream()));
PrintStream ps=new PrintStream(s.getOutputStream());
for(int i=0;i<str.length;i++)
{ ps.println(str[i]); }
String str_in;
while((str_in=br.readLine())!=null)
{
System.out.println(str_in);
}
ps.close();
s.close();
}
}