package com.vass.ecommerce.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "prices")
public class Price {
    
    @Id
    @Column(name = "price_id")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;
    
    @Column(name = "start_date")
    private LocalDateTime startDate;
    
    @Column(name = "end_date")
    private LocalDateTime endDate;
    
    @Column(name = "price_list")
    private Long priceList;
    
    @Column(name = "product_id")
    private Long productId;
    
    @Column(name = "priority")
    private Integer priority;
    
    @Column(name = "price")
    private Double price;
    
    @Column(name = "curr")
    private String curr;

}
