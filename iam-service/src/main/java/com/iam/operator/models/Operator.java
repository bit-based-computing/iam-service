package com.iam.operator.models;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import lombok.*;

@Entity
@Table(name = "operators")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Operator extends Auditable {

  @Column(nullable = false)
  private String firstName;

  private String middleName;

  @Column(nullable = false)
  private String lastName;

  @Column(unique = true, nullable = false)
  private String email;

  @Column(nullable = false)
  private boolean active;

  @Column(unique = true)
  private String phoneNumber;

  @Column(nullable = false)
  private String passwordHash;

  // --- RBAC Relationship ---
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(
      name = "operator_roles",
      joinColumns = @JoinColumn(name = "operator_id"),
      inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Role> roles = new HashSet<>();

  // --- Feature Entitlement Relationship ---
  @ManyToMany(fetch = FetchType.LAZY) // Lazy load features, as they might not always be needed
  @JoinTable(
      name = "operator_features",
      joinColumns = @JoinColumn(name = "operator_id"),
      inverseJoinColumns = @JoinColumn(name = "feature_id"))
  private Set<Feature> features = new HashSet<>();

  // hashCode and equals
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Operator operator = (Operator) o;
    return Objects.equals(email, operator.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(email);
  }
}
