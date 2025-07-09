package EchoBattle.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class VoiceServer {
    static List<Socket> voiceClients = new ArrayList<>();
    static final int MAX_VOICE_CLIENTS = 2;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6000);
        System.out.println("Voice Server started on port 6000");

        while (voiceClients.size() < MAX_VOICE_CLIENTS) {
            Socket client = serverSocket.accept();
            voiceClients.add(client);
            new Thread(() -> handleClient(client)).start();
        }
    }

    public static void handleClient(Socket client) {
        try {
            InputStream in = client.getInputStream();
            byte[] buffer = new byte[1024];
            int count;
            while ((count = in.read(buffer)) > 0) {
                for (Socket s : voiceClients) {
                    if (s != client) {
                        s.getOutputStream().write(buffer, 0, count);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Voice client disconnected");
        }
    }
}
