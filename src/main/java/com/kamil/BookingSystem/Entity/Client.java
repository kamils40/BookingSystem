package com.kamil.BookingSystem.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Builder
@Table(name = "Client")
public class Client {
    @Id
    @SequenceGenerator(
            name = "clientId_Sequence",
            sequenceName = "client_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "client_sequence"
    )
    private long Id;
    private String name;
    private String surname;
    @Column(unique = true)
    private String email;
    @JsonIgnore
    @OneToMany
    private List<Booking> bookings;

    public Client(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }
}
