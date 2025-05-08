package com.nttdata.employee_management_ntt_data.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "office")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Office {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @ManyToMany(mappedBy = "offices")
    @ToString.Exclude
    @JsonIgnore
    private Set<Employee> employees = new HashSet<>();
}
