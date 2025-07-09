package EchoBattle.server;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class LeaderboardServer {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(7000);
        System.out.println("Leaderboard Server started on port 7000");

        while (true) {
            Socket client = serverSocket.accept();
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            BufferedReader fileIn = new BufferedReader(new FileReader("data/leaderboard.txt"));
            String line;
            while ((line = fileIn.readLine()) != null) {
                out.println(line);
            }
            fileIn.close();
        }
    }
}
