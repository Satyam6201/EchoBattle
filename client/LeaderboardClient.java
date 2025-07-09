package EchoBattle.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class LeaderboardClient {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 7000);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line;
        System.out.println("===== Leaderboard =====");
        while ((line = in.readLine()) != null) {
            System.out.println(line);
        }
    }
}
