package ra.com.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Table(name = "Categories")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Categories {
    @Id
    @Column(name = "catalog_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "catalog_name",columnDefinition = "varchar(100)", nullable = false, unique = true)
    private String name;
    @Column(name = "catalog_priority")
    private int priority;
    @Column(name = "catalog_created")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @CreationTimestamp
    private LocalDate created;
    @Column(name = "catalog_description",columnDefinition = "text")
    private String description;
    @Column(name = "catalog_status")
    private boolean status;
}
