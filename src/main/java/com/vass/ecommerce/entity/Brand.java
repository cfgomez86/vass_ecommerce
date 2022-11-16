package com.vass.ecommerce.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "brands")
public class Brand {

    @Id
    @Column(name = "brand_id")
    private Long id;
    
    @Column(name = "name")
    private String name;
}
