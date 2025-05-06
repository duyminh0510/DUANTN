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
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "questionId")
    private Integer questionId;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "luaChonA")
    private String luaChonA;

    @Column(name = "luaChonB")
    private String luaChonB;

    @Column(name = "luaChonC")
    private String luaChonC;

    @Column(name = "luaChonD")
    private String luaChonD;

    @Column(name = "dapAnDung")
    private String dapAnDung;

    @Column(name = "createdate")
    @UpdateTimestamp
    private LocalDateTime createdate;

    @ManyToOne
    @JoinColumn(name = "exercise_id", nullable = false)
    private Exercise exercise;

}
