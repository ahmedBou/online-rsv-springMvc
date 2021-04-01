package online.reservation.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "userId", unique = true, nullable = false, length = 255)
    private Long user_id;
    @Column(name = "firstname", unique = false, nullable = false, length = 255)
    private String firstname;
    @Column(name = "lastname", unique = false, nullable = false, length = 255)
    private String lastname;
    @Column(name = "username", unique = false, nullable = false, length = 255)
    private String username;
    @Column(name = "email", unique = true, nullable = false, length = 255)
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "role", columnDefinition = "varchar(255) default 'user'")
    private String role;

    @Column(name = "isAuthenticated", columnDefinition = "boolean default false")
    private boolean isAuthenticated;

    @OneToMany(mappedBy = "user")
    private List<Reservation> reservationList;

    public User() {
    }

    public User(String firstname, String lastname, String username, String email, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.email = email;
        this.password = password;

    }

    public User(String firstname, String lastname, String username, String email, String password, String role, boolean isAuthenticated, List<Reservation> reservationList) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.isAuthenticated = isAuthenticated;
        this.reservationList = reservationList;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAuthenticated() {
        return isAuthenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        isAuthenticated = authenticated;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", isAuthenticated=" + isAuthenticated +
                ", reservationList=" + reservationList +
                '}';
    }
}
