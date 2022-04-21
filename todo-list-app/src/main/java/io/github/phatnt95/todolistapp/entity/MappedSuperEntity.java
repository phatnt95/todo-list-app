package io.github.phatnt95.todolistapp.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

/**
 * @author phatnt
 * @discription
 */

@MappedSuperclass
@Getter
@Setter
public class MappedSuperEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private LocalDate creationTime;
    private LocalDate lastModifiedTime;
}
