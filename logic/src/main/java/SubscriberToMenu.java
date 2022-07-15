import java.util.Objects;

public class SubscriberToMenu {
    private Integer userId;
    private Integer menuId;

    public SubscriberToMenu(Integer userId, Integer menuId) {
        this.userId = userId;
        this.menuId = menuId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubscriberToMenu that = (SubscriberToMenu) o;
        return userId.equals(that.userId) && menuId.equals(that.menuId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, menuId);
    }
}
