package com.dzinevich.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
