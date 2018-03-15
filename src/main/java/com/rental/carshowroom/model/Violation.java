package com.rental.carshowroom.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rental.carshowroom.model.enums.ViolationType;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity(name = "violations")
@Builder
public class Violation extends AbstractEntity {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @NotNull
    private User violatingUser;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Patterns.DATETIME)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime violationStart;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Patterns.DATETIME)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime violationEnd;

    @NotNull
    @Enumerated(EnumType.STRING)
    private ViolationType violationType;

}
