import java.sql.Timestamp;
import java.util.Objects;

public class Menu {
    private Integer menuId;
    private String name;
    private Integer createdBy;
    private Timestamp timestamp;
    private String description;
    private enum type{};
    private Float popularity;
    private Float fatPercentage;
    private Integer calories;
    private Integer protein;

    public Menu(Integer menuId, String name, Integer createdBy, Timestamp timestamp, String description, Float popularity, Float fatPercentage, Integer calories, Integer protein) {
        this.menuId = menuId;
        this.name = name;
        this.createdBy = createdBy;
        this.timestamp = timestamp;
        this.description = description;
        this.popularity = popularity;
        this.fatPercentage = fatPercentage;
        this.calories = calories;
        this.protein = protein;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPopularity() {
        return popularity;
    }

    public void setPopularity(Float popularity) {
        this.popularity = popularity;
    }

    public Float getFatPercentage() {
        return fatPercentage;
    }

    public void setFatPercentage(Float fatPercentage) {
        this.fatPercentage = fatPercentage;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public Integer getProtein() {
        return protein;
    }

    public void setProtein(Integer protein) {
        this.protein = protein;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menu menu = (Menu) o;
        return menuId.equals(menu.menuId) && name.equals(menu.name) && createdBy.equals(menu.createdBy) && timestamp.equals(menu.timestamp) && description.equals(menu.description) && popularity.equals(menu.popularity) && fatPercentage.equals(menu.fatPercentage) && calories.equals(menu.calories) && protein.equals(menu.protein);
    }

    @Override
    public int hashCode() {
        return Objects.hash(menuId, name, createdBy, timestamp, description, popularity, fatPercentage, calories, protein);
    }
}
