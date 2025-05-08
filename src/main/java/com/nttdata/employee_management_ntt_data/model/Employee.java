package com.nttdata.employee_management_ntt_data.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "employee")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String phoneNumber;

    @Column(nullable = false, unique = true)
    private String dni;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private Date birthDate;

    @ManyToMany
    @JoinTable(
        name = "employee_office",
        joinColumns = @JoinColumn(name = "employee_id"),
        inverseJoinColumns = @JoinColumn(name = "office_id")
    )
    @ToString.Exclude
    @JsonIgnore
    private Set<Office> offices = new HashSet<>();
}
