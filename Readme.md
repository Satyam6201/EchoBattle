# 🎮 EchoBattle: Multiplayer Java Game with Voice & Emoji Chat

> A real-time multiplayer Java game that blends classic turn-based gameplay with voice chat, emoji messaging, and persistent leaderboard support — all powered by Java Sockets and Java Sound API.

---

## 🛠 Built With
- **Java Sockets** for networking
- **Java Sound API** for real-time voice communication
- **Serializable GamePacket** for all game data exchange
- **Multithreading** for concurrent players
- **Plaintext file storage** for leaderboard

---

## 📦 Features

✅ 2-Player Multiplayer (Tic-Tac-Toe-style or turn-based)  
✅ 🎤 Real-time Voice Chat (via mic)  
✅ 💬 Text Chat (`/chat Hello`)  
✅ 😄 Emoji Reactions (`/emoji 😀`)  
✅ 🏆 Leaderboard Logging (`/result win/lose`)  
✅ 📁 Modular Code Structure  
✅ 🧩 Easily Extendable to Add AI, Timer, etc.

---

## 📁 Folder Structure
```
MultiplayerGame/
├── common/
│   ├── GamePacket.java        # Serializable object for data exchange
│   └── AudioUtils.java        # Audio format utility
├── client/
│   ├── GameClient.java        # Input/output logic for gameplay
│   ├── VoiceClient.java       # Real-time voice streamer
│   └── LeaderboardClient.java# Reads & prints leaderboard
├── server/
│   ├── GameServer.java        # Handles move/chat packets
│   ├── VoiceServer.java       # Relays voice data
│   └── LeaderboardServer.java# Serves leaderboard file
├── data/
│   └── leaderboard.txt        # Auto-created; logs game results
```

---

## 🚀 How to Run

### ✅ 1. Compile Everything:
```bash
javac common/*.java server/*.java client/*.java
```

### ✅ 2. Start Servers (each in a new terminal):
```bash
java server.GameServer         # Port 5000
java server.VoiceServer        # Port 6000
java server.LeaderboardServer  # Port 7000
```

### ✅ 3. Start Clients (on same/different machines):
```bash
java client.GameClient         # For each player
java client.VoiceClient        # Optional voice client
java client.LeaderboardClient  # To view leaderboard
```

---

## 🕹 Game Commands (GameClient)
- `x y` → Make move (e.g. `1 2`)
- `/chat Hello` → Send chat message
- `/emoji 😀` → Send emoji reaction
- `/result win` → Submit match result

---

## 🌐 Notes
- Default communication is via `localhost`. Use IP for LAN play.
- Ensure `data/leaderboard.txt` exists or is created by the app.
- Requires mic/speakers for voice to work.

---

## 📌 Future Ideas
- GUI using JavaFX
- Match timer or countdown system
- Player login/authentication
- Match history and replay

---

## 💡 Ideal For
- Java Networking Mini Projects
- Final Year BTech Demonstrations
- Internship Showcases (Full Java Only)
- College Game Jams & Experiments

---

## 📧 Author
**Satyam Kumar Mishra**  
Built with ❤️ using pure Java.
