package com.vass.ecommerce.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class PriceResponse {
	@JsonProperty("price")
	private Long price;
	
	@JsonProperty("brand_id")
	private Long brandId;
	
	@JsonProperty("product_id")
	private Long productId;
	
	@JsonProperty("app_date")
	private LocalDateTime appDate;
	
	@JsonProperty("final_price")
	private Double finalPrice;
}
