package com.vass.ecommerce.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PriceRequest {
	@JsonProperty("brand_id")
    private Long brandId;
	
	@JsonProperty("product_id")
    private Long productId;
	
	@JsonProperty("app_date")
    private LocalDateTime appDate;
}
