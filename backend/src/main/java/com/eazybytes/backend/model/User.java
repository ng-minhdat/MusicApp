package com.eazybytes.backend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "`user`")
@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String username;
    private String password;
    @Enumerated(value = EnumType.ORDINAL)
    private UserStatus status;
    private String avatarPath;
}
