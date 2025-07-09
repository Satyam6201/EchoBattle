package EchoBattle.common;

import java.io.Serializable;

public class GamePacket implements Serializable {
    public int x, y;
    public String playerId;
    public String type; // "MOVE", "RESULT", "CHAT", "PING", "EMOJI"
    public String message;
    public long timestamp;
    public String emoji; // new field for emojis

    public GamePacket() {}

    public GamePacket(int x, int y, String playerId, String type, String message) {
        this.x = x;
        this.y = y;
        this.playerId = playerId;
        this.type = type;
        this.message = message;
        this.timestamp = System.currentTimeMillis();
    }
}
