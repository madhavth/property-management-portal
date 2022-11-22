package edu.miu.propertymanagement.entity;

import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.INTEGER)
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "First Name cannot be blank")
    @NonNull
    @Column(nullable = false)
    private String firstName;

    @NotBlank(message = "Last Name cannot be blank")
    @NonNull
    @Column(nullable = false)
    private String lastName;

    @NotBlank(message = "Email Address cannot be blank")
    @NonNull
    @Column(nullable = false)
    private String email;

    @NotBlank(message = "Password cannot be blank")
    @NonNull
    @Column(nullable = false)
    private String password;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Address address;

    @NotBlank(message = "Phone Number cannot be blank")
    @NonNull
    private String phoneNumber;

    @Column(name="user_type", insertable = false, updatable = false)
    private int userType;

    @Column(columnDefinition = "boolean default false")
    private boolean IsEmailVerified;

    private String emailVerificationToken;

    private LocalDateTime emailVerificationTokenExpiry;

    private Integer emailVerificationAttempts;
}
