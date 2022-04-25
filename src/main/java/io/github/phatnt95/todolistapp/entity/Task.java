package io.github.phatnt95.todolistapp.entity;

import lombok.*;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * @author phatnt
 * @discription
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Task extends MappedSuperEntity {
    @ManyToOne
    @JoinColumn(name = "parent_task_id")
    public Task parent_task;
    public String task_name;
    public String description;
//    @JsonSerialize(using = LocalDateSerializer.class)
//    @JsonDeserialize(using = LocalDateDeserializer.class)
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
public LocalDate start_date;
//    @JsonSerialize(using = LocalDateSerializer.class)
//    @JsonDeserialize(using = LocalDateDeserializer.class)
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
public LocalDate due_date;
    @OneToOne
    @JoinColumn(name = "task_owner_id")
    public User task_owner;
    @Enumerated(EnumType.STRING)
    public EIssueType type;
    @Enumerated(EnumType.STRING)
    public EStatus status;
    public Boolean isDone;
}
