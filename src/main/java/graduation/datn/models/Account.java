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
@Table(name = "accounts")
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accountId")
    private Integer accountId;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "password")
    private String password;

    @Column(name = "is_active", nullable = false, columnDefinition = "BIT DEFAULT 1")
    @Builder.Default
    private boolean isActive = true;

    @OneToOne
    @JoinColumn(name = "roleId", referencedColumnName = "roleId")
    private Role role;

    @OneToMany(mappedBy = "accounts", cascade = CascadeType.ALL)
    private List<Order> orders = new ArrayList<>();

    @OneToOne(mappedBy = "accounts", cascade = CascadeType.ALL)
    private ApprovalDetail approvalDetail;

    @OneToOne(mappedBy = "accounts", cascade = CascadeType.ALL)
    private InstructorDetail instructorDetail;

    @OneToMany(mappedBy = "accounts", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "accounts", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "accounts", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Certificate> certificates = new ArrayList<>();

    @OneToMany(mappedBy = "accounts", cascade = CascadeType.ALL)
    private List<CourseAccountDetail> courseAccountDetails = new ArrayList<>();

    @OneToMany(mappedBy = "accounts", cascade = CascadeType.ALL)
    private List<Share> shares = new ArrayList<>();

}
