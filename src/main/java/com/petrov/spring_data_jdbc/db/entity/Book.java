package com.petrov.spring_data_jdbc.db.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("books")
public class Book {

    @Id

    private Long id;
    private String title;
    private String author;

    @Column("publication_year")
    private int publicationYear;

}
