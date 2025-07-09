package EchoBattle.client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

import EchoBattle.common.GamePacket;

public class GameClient {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 5000);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your player ID: ");
        String playerId = sc.nextLine();

        new Thread(() -> {
            try {
                while (true) {
                    GamePacket packet = (GamePacket) in.readObject();
                    if ("MOVE".equals(packet.type)) {
                        System.out.println("Opponent move: (" + packet.x + "," + packet.y + ")");
                    } else if ("CHAT".equals(packet.type)) {
                        System.out.println("[Chat from " + packet.playerId + "]: " + packet.message);
                    } else if ("EMOJI".equals(packet.type)) {
                        System.out.println("[Emoji from " + packet.playerId + "]: " + packet.emoji);
                    }
                }
            } catch (Exception e) {}
        }).start();

        while (true) {
            System.out.print("Enter move (x y), chat (/chat <msg>), result (/result win/lose), emoji (/emoji 😀): ");
            String input = sc.nextLine();
            GamePacket packet = new GamePacket();
            packet.playerId = playerId;
            if (input.startsWith("/chat ")) {
                packet.type = "CHAT";
                packet.message = input.substring(6);
            } else if (input.startsWith("/result ")) {
                packet.type = "RESULT";
                packet.message = input.substring(8);
            } else if (input.startsWith("/emoji ")) {
                packet.type = "EMOJI";
                packet.emoji = input.substring(7);
            } else {
                String[] parts = input.split(" ");
                packet.x = Integer.parseInt(parts[0]);
                packet.y = Integer.parseInt(parts[1]);
                packet.type = "MOVE";
            }
            out.writeObject(packet);
        }
    }
}
