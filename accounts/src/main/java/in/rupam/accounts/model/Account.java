package in.rupam.accounts.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Account extends BaseModel {

    private Long customerId;

    @Id
    private Long accountNumber;

    private String accountType;

    private String branchAddress;

    @Column(name = "communication_sw")
    private Boolean communicationSW;
}
