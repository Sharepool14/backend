package mau.project.sharepool.itemrequester;

public class ItemRequesterDTO {
    private Long item_id;
    private String itemName;
    private String requesterName;

    public ItemRequesterDTO() {
    }

    public ItemRequesterDTO(Long item_id, String itemName, String requesterName) {
        this.item_id = item_id;
        this.itemName = itemName;
        this.requesterName = requesterName;
    }

    public Long getItem_id() {
        return item_id;
    }

    public void setItem_id(Long item_id) {
        this.item_id = item_id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getRequesterName() {
        return requesterName;
    }

    public void setRequesterName(String requesterName) {
        this.requesterName = requesterName;
    }

    @Override
    public String toString() {
        return "ItemRequesterDTO{" +
                "item_id=" + item_id +
                ", itemName='" + itemName + '\'' +
                ", requesterName='" + requesterName + '\'' +
                '}';
    }
}
