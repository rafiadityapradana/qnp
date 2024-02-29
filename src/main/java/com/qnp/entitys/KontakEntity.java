package com.qnp.entitys;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import java.sql.Date;
import java.util.UUID;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "KONTAK")
public class KontakEntity {

     @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    private UUID id;

    @NotBlank(message = "Nama tidak boleh kosong")
    @Size(max = 70, message = "Nama tidak boleh lebih dari 70 karakter")
    @Column(name = "nama", nullable = false, length = 70)
    private String nama;

    @NotBlank(message = "Email tidak boleh kosong")
    @Email(message = "Format email tidak valid")
    @Size(max = 70, message = "Email tidak boleh lebih dari 70 karakter")
    @Column(name = "email", nullable = false, unique = true, length = 70)
    private String email;

    @NotBlank(message = "Password tidak boleh kosong")
    @Size(min = 6, message = "Password harus terdiri dari minimal 6 karakter")
    @Column(name = "password", nullable = false)
    private String password;

    @NotBlank(message = "Telepon tidak boleh kosong")
    @Pattern(regexp = "^\\d{10,13}$", message = "Nomor telepon harus terdiri dari 10 hingga 13 digit angka")
    @Column(name = "telepon", nullable = false, unique = true, length = 13)
    private String telepon;

    @NotBlank(message = "Alamat tidak boleh kosong")
    @Column(name = "alamat", nullable = false)
    private String alamat;

    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    private Date createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Date updatedAt;
     
}
