package org.dzinevich.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name = "cat")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Cat {

    @Id
    @GeneratedValue
    private UUID catId;

    @NonNull
    private String name;

    @NonNull
    private int age;

    @OneToMany(mappedBy = "cat", cascade = ALL)
    private List<Procedure> procedureList = new ArrayList<>();

}
