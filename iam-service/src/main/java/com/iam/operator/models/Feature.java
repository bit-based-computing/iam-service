package com.iam.operator.models;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "features")
public class Feature {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  // 'key' can be a reserved keyword in SQL, so we quote it.
  @Column(name = "`key`", unique = true, nullable = false, length = 100)
  private String key; // e.g., "enable-beta-dashboard"

  @Column(name = "description")
  private String description;

  // Constructors, Getters, and Setters

  public Feature() {}

  // hashCode and equals for proper Set functionality
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Feature feature = (Feature) o;
    return Objects.equals(id, feature.id) && Objects.equals(key, feature.key);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, key);
  }
}
