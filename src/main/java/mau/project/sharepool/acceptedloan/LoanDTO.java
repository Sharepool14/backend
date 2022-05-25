package mau.project.sharepool.acceptedloan;

public class LoanDTO {
    private Long id;
    private boolean accepted;
    private boolean returned;
    private String itemOwnerName;
    private String requesterName;
    private Long loan_post_id;

    public LoanDTO() {
    }

    public LoanDTO(Long id, boolean accepted, boolean returned, String itemOwnerName, String requesterName, Long loan_post_id) {
        this.id = id;
        this.accepted = accepted;
        this.returned = returned;
        this.itemOwnerName = itemOwnerName;
        this.requesterName = requesterName;
        this.loan_post_id = loan_post_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public boolean isReturned() {
        return returned;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }

    public String getItemOwnerName() {
        return itemOwnerName;
    }

    public void setItemOwnerName(String itemOwnerName) {
        this.itemOwnerName = itemOwnerName;
    }

    public String getRequesterName() {
        return requesterName;
    }

    public void setRequesterName(String requesterName) {
        this.requesterName = requesterName;
    }

    public Long getLoan_post_id() {
        return loan_post_id;
    }

    public void setLoan_post_id(Long loan_post_id) {
        this.loan_post_id = loan_post_id;
    }

    @Override
    public String toString() {
        return "LoanDTO{" +
                "id=" + id +
                ", accepted=" + accepted +
                ", returned=" + returned +
                ", itemOwnerName='" + itemOwnerName + '\'' +
                ", requesterName='" + requesterName + '\'' +
                ", loan_post_id=" + loan_post_id +
                '}';
    }
}
