package com.example.demo.user.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(fetch = FetchType.LAZY )
    private User user;
    @Getter
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Role role;

    @Override
    public String toString() {
        return role.toString();
    }

    public UserRole(User user, Role role) {
        this.user = user;
        this.role = role;
    }
}
