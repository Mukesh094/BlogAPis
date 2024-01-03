package com.locationWise.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="brokerapp")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BrokerApp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String location;
    private String flatDetails;
    private String furnishing;
}
