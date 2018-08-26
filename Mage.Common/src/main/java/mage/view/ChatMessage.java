

package mage.view;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author BetaSteward_at_googlemail.com
 */
public class ChatMessage implements Serializable {
    private static final long serialVersionUID = 1L;

    private String username;
    private Date time;
    private String message;
    private MessageColor color;
    private SoundToPlay soundToPlay;
    private MessageType messageType;

    public enum MessageColor {
        BLACK, RED, GREEN, BLUE, ORANGE, YELLOW
    }

    public enum MessageType {
        USER_INFO, STATUS, GAME, TALK, WHISPER_FROM, WHISPER_TO
    }

    public enum SoundToPlay {
        PlayerLeft, PlayerQuitTournament, PlayerSubmittedDeck, PlayerWhispered
    }

    public ChatMessage(String username, String message, Date time, MessageColor color) {
        this(username, message, time, color, null);
    }

    public ChatMessage(String username, String message, Date time, MessageColor color, SoundToPlay soundToPlay) {
        this(username, message, time, color, MessageType.TALK, soundToPlay);
    }
    
    public ChatMessage(String username, String message, Date time, MessageColor color, MessageType messageType, SoundToPlay soundToPlay) {
        this.username = username;
        this.message = message;
        this.time = time;
        this.color = color;
        this.messageType = messageType;
        this.soundToPlay = soundToPlay;
    }

    public String getMessage() {
        return message;
    }

    public MessageColor getColor() {
        return color;
    }

    public boolean isUserMessage() {
        return color != null && (color==MessageColor.BLUE || color==MessageColor.YELLOW);
    }

    public boolean isStatusMessage() {
        return color != null && color== MessageColor.ORANGE;
    }

    public String getUsername() {
        return username;
    }

    public Date getTime() {
        return time;
    }

    public SoundToPlay getSoundToPlay() {
        return soundToPlay;
    }

    public MessageType getMessageType() {
        return messageType;
    }

}
