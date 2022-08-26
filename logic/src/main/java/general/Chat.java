package general;

import java.sql.Timestamp;
import java.util.Objects;

public class Chat {
    private Integer userId;
    private Integer createdBy;
    private boolean isAnswered;
    private Integer chatId;
    private String title;
    private String content;
    private String username;
    private long time;

    private int messageNum;

    public Chat(){}

    public Chat(int from, int to){
        userId = from;
        this.chatId = to;
    }
    public Chat(String chatString, int from, int to, int messageNum) {
        this.content = chatString;
        userId = from;
        this.chatId = to;
        this.time = System.currentTimeMillis();
        this.messageNum = messageNum;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public boolean isAnswered() {
        return isAnswered;
    }

    public void setAnswered(boolean answered) {
        isAnswered = answered;
    }

    public Integer getChatId() {
        return chatId;
    }

    public void setChatId(Integer chatId) {
        this.chatId = chatId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chat chat = (Chat) o;
        return isAnswered == chat.isAnswered && userId.equals(chat.userId) && createdBy.equals(chat.createdBy) && chatId.equals(chat.chatId) && title.equals(chat.title) &&  content.equals(chat.content);
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getMessageNum() {
        return messageNum;
    }

    public void setMessageNum(int messageNum) {
        this.messageNum = messageNum;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, createdBy, isAnswered, chatId, title, content);
    }
}
