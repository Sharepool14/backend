package mau.project.sharepool.loanpost;

import java.util.Date;

public class LoanPostDTO {
    private Long id;
    private Date start_date;
    private Date return_date;
    private String communityName;
    private String itemName;
    private String borrowersName;
    private String description;

    public LoanPostDTO() {
    }

    public LoanPostDTO(Long id, Date start_date, Date return_date, String communityName, String itemName, String borrowersName, String description) {
        this.id = id;
        this.start_date = start_date;
        this.return_date = return_date;
        this.communityName = communityName;
        this.itemName = itemName;
        this.borrowersName = borrowersName;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getReturn_date() {
        return return_date;
    }

    public void setReturn_date(Date return_date) {
        this.return_date = return_date;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getBorrowersName() {
        return borrowersName;
    }

    public void setBorrowersName(String borrowersName) {
        this.borrowersName = borrowersName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "LoanPostDTO{" +
                "id=" + id +
                ", start_date=" + start_date +
                ", return_date=" + return_date +
                ", communityName='" + communityName + '\'' +
                ", itemName='" + itemName + '\'' +
                ", borrowersName='" + borrowersName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
