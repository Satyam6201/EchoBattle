package EchoBattle.server;

import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import EchoBattle.common.GamePacket;

public class GameServer {
    static List<ObjectOutputStream> clients = new ArrayList<>();
    static final int MAX_PLAYERS = 2;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Game Server started on port 5000");

        while (clients.size() < MAX_PLAYERS) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket);
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            clients.add(out);
            new Thread(new MatchHandler(socket, out)).start();
        }
    }
}

class MatchHandler implements Runnable {
    private Socket socket;
    private ObjectOutputStream out;

    public MatchHandler(Socket socket, ObjectOutputStream out) {
        this.socket = socket;
        this.out = out;
    }

    public void run() {
        try {
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            while (true) {
                GamePacket packet = (GamePacket) in.readObject();
                if ("RESULT".equals(packet.type)) {
                    try (PrintWriter pw = new PrintWriter(new FileWriter("data/leaderboard.txt", true))) {
                        pw.println(packet.playerId + " - " + packet.message + " - " + new Date(packet.timestamp));
                    }
                }
                for (ObjectOutputStream client : GameServer.clients) {
                    if (client != out) client.writeObject(packet);
                }
            }
        } catch (Exception e) {
            System.out.println("Connection lost.");
        }
    }
}
