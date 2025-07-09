package EchoBattle.common;

import javax.sound.sampled.AudioFormat;

public class AudioUtils {
    public static AudioFormat getFormat() {
        return new AudioFormat(8000.0f, 16, 1, true, true);
    }
}
