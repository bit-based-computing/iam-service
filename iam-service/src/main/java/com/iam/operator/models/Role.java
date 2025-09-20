package com.iam.operator.models;

import jakarta.persistence.*;
import java.util.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "roles")
public class Role extends Auditable {

  @Column(nullable = false, unique = true)
  private String name; // e.g. "ADMIN", "USER", "OPERATOR", "PRODUCT", "ORDER"

  @Builder.Default
  @ManyToMany(mappedBy = "roles")
  private Set<Operator> operators = new HashSet<>();

  @Builder.Default
  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
      name = "role_permissions",
      joinColumns = @JoinColumn(name = "role_id"),
      inverseJoinColumns = @JoinColumn(name = "permission_id"))
  private Set<Permission> permissions = new HashSet<>();
}
