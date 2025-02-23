package com.hidiscuss.backend.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "User")
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "username", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "access_token", nullable = false)
    private String accessToken;

    @Column(name = "refresh_token", nullable = false)
    private String refreshToken;

    @Column(name = "point", nullable = false)
    private Long point;

    @Builder
    public User(Long id, String name, String email, String accessToken, String refreshToken, Long point) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.point = point;
    }
}
