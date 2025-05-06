package graduation.datn.models;

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "certificates")
public class Certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "certificateId")
    private Integer certificateId;

    @Column(name = "createdate")
    @UpdateTimestamp
    private LocalDateTime createdate;

    @Column(name = "type")
    private String type;

    @Column(name = "tenchungchi")
    private String tenchungchi;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account accounts;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

}
