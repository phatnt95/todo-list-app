package io.github.phatnt95.todolistapp.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author phatnt
 * @discription
 */

@Entity
@Table(name="roles")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Role extends MappedSuperEntity{
    private String name;
}
