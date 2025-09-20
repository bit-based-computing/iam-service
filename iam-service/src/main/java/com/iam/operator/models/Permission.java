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
@Table(name = "permissions")
public class Permission extends Auditable {

  @Column(nullable = false, unique = true)
  private String name; // e.g. "CREATE", "READ", "UPDATE", "DELETE", "VIEW_LIST", "ALL"

  @Builder.Default
  @ManyToMany(mappedBy = "permissions")
  private Set<Role> roles = new HashSet<>();
}
