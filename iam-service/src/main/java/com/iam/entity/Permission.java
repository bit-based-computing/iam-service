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
@Table(name = "permissions")
public class Permission extends Auditable{

    @Column(nullable = false, unique = true)
    private String name;  // e.g. "CREATE", "READ", "UPDATE", "DELETE", "VIEW_LIST", "ALL"

    @ManyToMany(mappedBy = "permissions")
    private Set<Role> roles = new HashSet<>();
}

