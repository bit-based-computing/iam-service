package com.iam.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "roles")
public class Role extends Auditable{

    @Column(nullable = false, unique = true)
    private String name;  // e.g. "ADMIN", "USER", "OPERATOR", "PRODUCT", "ORDER"

    @ManyToMany(mappedBy = "roles")
    private Set<Operator> operators = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "role_permissions",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id")
    )
    private Set<Permission> permissions = new HashSet<>();
}

