package EchoBattle.client;

import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.TargetDataLine;

import EchoBattle.common.AudioUtils;

public class VoiceClient {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 6000);

        AudioFormat format = AudioUtils.getFormat();

        Scanner sc = new Scanner(System.in);
        System.out.print("Enable mic? (yes/no): ");
        String input = sc.nextLine();

        if ("yes".equalsIgnoreCase(input)) {
            // Sending voice
            new Thread(() -> {
                try {
                    TargetDataLine mic = AudioSystem.getTargetDataLine(format);
                    mic.open(format);
                    mic.start();
                    byte[] buffer = new byte[1024];
                    while (true) {
                        int count = mic.read(buffer, 0, buffer.length);
                        if (count > 0) {
                            socket.getOutputStream().write(buffer, 0, count);
                        }
                    }
                } catch (Exception e) {}
            }).start();
        }

        // Receiving voice
        SourceDataLine speaker = AudioSystem.getSourceDataLine(format);
        speaker.open(format);
        speaker.start();
        byte[] buffer = new byte[1024];
        InputStream in = socket.getInputStream();
        int count;
        while ((count = in.read(buffer)) > 0) {
            speaker.write(buffer, 0, count);
        }
    }
}
