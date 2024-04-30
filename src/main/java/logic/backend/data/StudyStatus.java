package logic.backend.data;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Entity
@Data
@Table(name = "study_status")
public class StudyStatus implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_status")
    private Long idStatus;
    
    @NotNull
    @JsonManagedReference 
    @JoinColumn(name = "name", referencedColumnName = "id_i18n")
    @ManyToOne
    private I18n name;
    
    @OneToMany(mappedBy = "status")
    @JsonBackReference
    private List<Study> studies;
}
