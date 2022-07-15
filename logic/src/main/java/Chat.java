import java.sql.Timestamp;
import java.util.Objects;

public class Chat {
    private Integer userId;
    private Integer createdBy;
    private boolean isAnswered;
    private Integer to;
    private String title;
    private Timestamp timestamp;
    private String content;

    public Chat(Integer userId, Integer createdBy, boolean isAnswered, Integer to, String title, Timestamp timestamp, String content) {
        this.userId = userId;
        this.createdBy = createdBy;
        this.isAnswered = isAnswered;
        this.to = to;
        this.title = title;
        this.timestamp = timestamp;
        this.content = content;
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

    public Integer getTo() {
        return to;
    }

    public void setTo(Integer to) {
        this.to = to;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
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
        return isAnswered == chat.isAnswered && userId.equals(chat.userId) && createdBy.equals(chat.createdBy) && to.equals(chat.to) && title.equals(chat.title) && timestamp.equals(chat.timestamp) && content.equals(chat.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, createdBy, isAnswered, to, title, timestamp, content);
    }
}
