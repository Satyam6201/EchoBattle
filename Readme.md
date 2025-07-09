# 🎮 EchoBattle: Multiplayer Java Game with Voice & Emoji Chat

> A real-time multiplayer Java game that blends classic turn-based gameplay with voice chat, emoji messaging, and persistent leaderboard support — all powered by Java Sockets and Java Sound API.

---

## 🛠 Built With
- **Java 8+** (supports newer versions with `--enable-preview`)
- **Java Sockets** for networking between players
- **Java Sound API** for microphone input and speaker output
- **Multithreading** for concurrent clients and audio streams
- **Serializable GamePacket** class to send/receive structured data
- **File I/O** for logging and retrieving leaderboard scores

---

## 📦 Features

✅ 2-Player Multiplayer Gameplay  
✅ 🎤 Real-Time Voice Chat (Peer-to-Peer Streaming)  
✅ 💬 Text Chat System (Command: `/chat Hello`)  
✅ 😄 Emoji Reaction Support (Command: `/emoji 😀`)  
✅ 🏆 Leaderboard Tracking (Command: `/result win/lose`)  
✅ 📡 Socket-Based Low-Latency Communication  
✅ 🧩 Clean Modular Structure (Client / Server / Common)  
✅ 💻 Console-Based Game With Easy Extension for GUI  
✅ 🔁 Timestamped Moves and Messages  
✅ 🔒 Separate Ports for Game, Voice, and Leaderboard Services  
✅ 🎯 Easily Extendable to Add New Games (Chess, Snake, etc.)

---

## 📁 Folder Structure
```
MultiplayerGame/
├── common/
│   ├── GamePacket.java           # Serializable game data wrapper
│   └── AudioUtils.java           # Audio format used in voice streaming
│
├── client/
│   ├── GameClient.java           # Handles gameplay, moves, chat, emoji, and result submission
│   ├── VoiceClient.java          # Sends/receives audio using mic and speakers
│   └── LeaderboardClient.java    # Reads leaderboard from server
│
├── server/
│   ├── GameServer.java           # Relays moves/chat/emoji between players
│   ├── VoiceServer.java          # Relays voice data streams
│   └── LeaderboardServer.java    # Reads leaderboard.txt and sends to clients
│
├── data/
│   └── leaderboard.txt           # Stores game result logs (e.g., "PlayerX - win - Date")
```

---

## 🚀 How to Run

### ✅ 1. Compile Everything
```bash
javac common/*.java server/*.java client/*.java
```

### ✅ 2. Start Servers in Separate Terminals
```bash
java server.GameServer         # Starts on port 5000
java server.VoiceServer        # Starts on port 6000
java server.LeaderboardServer  # Starts on port 7000
```

### ✅ 3. Start Clients
```bash
java client.GameClient         # For each player
java client.VoiceClient        # For each player (optional)
java client.LeaderboardClient  # To view game results
```

You need **two terminals for each player** (Game + Voice client).

---

## 🎮 Game Client Commands
| Command          | Action                              |
|------------------|-------------------------------------|
| `1 2`            | Send move (x=1, y=2)                 |
| `/chat Hello`    | Send a chat message to opponent     |
| `/emoji 😀`       | Send an emoji reaction              |
| `/result win`    | Submit your match result to server  |


---

## 🌐 Network Notes
- Default IP is `localhost`. To play over LAN, replace `localhost` with the host's IP address.
- Each server binds to a specific port:
  - `GameServer`: `5000`
  - `VoiceServer`: `6000`
  - `LeaderboardServer`: `7000`

Use different ports if you get `Address already in use` error.

---

## 🧪 Troubleshooting

❌ `java.net.BindException: Address already in use`  
➡ Another app is using the port. Run:
```bash
netstat -ano | findstr :5000   # Then kill the PID using task manager
```

❌ `Voice not working`  
➡ Ensure microphone access is enabled. Check Java permissions or test in another voice app.

---

## 📌 Future Enhancements
- ⏱ Turn Timers for Moves
- 🎨 GUI using JavaFX or Swing
- 🧠 AI Opponent Option for Practice
- 🔐 Login System and Player Profiles
- 🗃 Match Replay System

---

## 🙋 FAQ
**Q: Can this be used for games other than Tic Tac Toe?**  
Yes! The packet system supports custom data — you can plug in any 2-player turn-based game logic.

**Q: Is this multiplayer over internet or LAN?**  
It's LAN by default. Use public IP & port forwarding for internet play.

**Q: Can I use it as a class project?**  
Yes! It's perfect for networking, audio, and Java projects.

---

## 📧 Author
**Satyam Kumar Mishra**  
> Passionate about building real-time multiplayer systems and creative Java-based projects.

📍 India  
🌐 [Satyam Kumar Mishra](https://www.linkedin.com/in/satyam-kumar-mishra-9bb980291/)  
💻 GitHub: [Satyam6201](https://github.com/Satyam6201)

---

> 💡 *Star this project if you find it helpful or use it in your own games!*
