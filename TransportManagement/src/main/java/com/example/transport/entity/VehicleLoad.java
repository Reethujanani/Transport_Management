package com.example.transport.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "vehicle_load_mapping")
public class VehicleLoad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vehicle_id_fk",referencedColumnName = "id")
    private Vehicles vehicle;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "load_id_fk",referencedColumnName = "id")
    private Load load;

}
