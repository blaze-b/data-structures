package learning;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URL;
import java.util.Objects;

public class Ping {

    public static boolean ping(String url) throws IOException {
        boolean result = false;
        HttpURLConnection con = null;
        try {
            URL urlObj = new URL(url);
            con = (HttpURLConnection) urlObj.openConnection();
            con.setRequestMethod("GET");
            con.setConnectTimeout(3000);
            con.connect();
            int code = con.getResponseCode();
            if (code == 401)
                result = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
           if(Objects.nonNull(con))
               con.disconnect();
        }
        return result;
    }

    public static boolean ping(String host, int port, int timeout) {
        try (Socket socket = new Socket()) {
            socket.connect(new InetSocketAddress(host, port), timeout);
            return true;
        } catch (IOException e) {
            return false; // Either timeout or unreachable or failed DNS lookup.
        }
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        int count = 0;
        while (true) {
            boolean reachable = Ping.ping("https://leni-stage-tech-data-ingestion-lpm-906-bf3mds3yyq-de.a.run.app");
            int j = count++;
            System.out.println("Reachable"+count+" = " + reachable);
            Thread.sleep(10000);
        }
    }
}
