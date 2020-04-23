import java.io.*;
import java.net.*;

public class webPageDownloader {
  public static void main(String[] args) {
    if (args.length > 0) {
      InputStream in = null;
      try {
        //Open URL
        URL u = new URL(args[0]);
        in = u.openStream();
        //buffer input to increase performance
        in = new BufferedInputStream(in);
        //chain the InputStream to a Reader
        Reader r = new InputStreamReader(in);
        FileOutputStream out = new FileOutputStream("page.html");
        int c;

        while ((c = r.read()) != -1) {
            out.write(c);
        }
      } catch(MalformedURLException ex) {
        System.err.println(args[0] + " is not parseable URL");
      } catch(IOException ex) {
        System.err.println("Unable to Read / Write file");
      }
    }
  }
}
