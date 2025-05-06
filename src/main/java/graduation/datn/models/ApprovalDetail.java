package graduation.datn.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "approvaldetails")
public class ApprovalDetail implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kiemduyetId")
    private Integer kiemduyetId;

    @Column(name = "certificate")
    private String certificate;

    @Column(name = "experienceYears")
    private String experienceYears;

    @OneToOne
    @JoinColumn(name = "account_id")
    private Account accounts;

    @OneToMany(mappedBy = "approvalDetail", cascade = CascadeType.ALL)
    private List<Course> courses = new ArrayList<>();

}
