package org.dzinevich.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "procedure")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Procedure {
    @Id
    @GeneratedValue
    private UUID procedureId;

    @NonNull
    private LocalDate date;

    private String description;
    private String result;

    @ManyToOne
    @JoinColumn(name="cat_id", nullable=false)
    private Cat cat;
}
