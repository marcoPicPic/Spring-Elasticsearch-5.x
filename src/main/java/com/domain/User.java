package com.domain;


import org.springframework.data.annotation.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(indexName = "users", type = "user")
public class User {


    @Id
    private String id;

    private String username;
    private String password;
    private boolean enabled;
}
