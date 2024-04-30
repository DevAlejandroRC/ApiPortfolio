package logic.backend.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Entity
@Data
@Table(name = "study")
public class Study implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_study")
    private Long idStudy;
    
    @NotBlank
    private String name;
    
    @NotNull
    @JoinColumn(name = "status", referencedColumnName = "id_status")
    @ManyToOne
    @JsonIgnoreProperties("idStatus")
    private StudyStatus status;
    
    @OneToMany(mappedBy = "study")
    @JsonIgnoreProperties("study")
    private List<Gallery> galleries;
    
}
