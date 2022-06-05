package mau.project.sharepool.loanpost;

import java.util.Date;
import java.util.Set;

/**
 * The purpose of a DTO class is to pass data with multiple attributes in one shot to frontend
 * Which enables you to costumize which attributes you want to send
 * DTO can be a alternative to more complicates joins between tables
 */
public class CreatePostDTO {
    private Long community_id;
    private Long item_id;
    private Date start_date;
    private Date end_date;

    public Long getCommunity_id() {
        return community_id;
    }

    public void setCommunity_id(Long community_id) {
        this.community_id = community_id;
    }

    public Long getItem_id() {
        return item_id;
    }

    public void setItem_id(Long item_id) {
        this.item_id = item_id;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }
}
