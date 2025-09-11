package com.sist.ex0910_ex1.store;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="category1_t")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Category1JPO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idx;
    private String cName;
    private String desc;
    private int status;

    @OneToMany
    @JoinColumn(name="category1")
    private List<ProductJPO> pList;
    
}
