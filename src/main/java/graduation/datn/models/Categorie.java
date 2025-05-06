package graduation.datn.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table(name = "categories")
public class Categorie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "danhmucId")
    private Integer danhmucId;

    @Column(name = "tieude")
    private String tieude;

    @Column(name = "description")
    private String description;

    @Column(name = "createdate")
    @UpdateTimestamp
    private LocalDateTime createdate;

    @OneToMany(mappedBy = "categorie", cascade = CascadeType.ALL)
    private List<Course> courses = new ArrayList<>();
}
