package com.vass.ecommerce.service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vass.ecommerce.entity.Price;
import com.vass.ecommerce.entity.PriceRequest;
import com.vass.ecommerce.entity.PriceResponse;
import com.vass.ecommerce.repository.PriceRepository;

@Service
public class PriceService {

	@Autowired
	private PriceRepository priceRepository;

	public PriceResponse getPrice(PriceRequest priceRequest) {
		List<Price> prices = priceRepository.find(
				priceRequest.getBrandId(),
				priceRequest.getProductId(), 
				priceRequest.getAppDate());
		PriceResponse priceResponse = null;
		if (!prices.isEmpty()) {
			Price price = prices.stream().max(Comparator.comparing(var -> var.getPriority())).get();
			priceResponse = getResponse(priceRequest.getAppDate(), price);
		}
		return priceResponse;
	}

	private PriceResponse getResponse(LocalDateTime appDate, Price price) {
		PriceResponse priceResponse = new PriceResponse();
		priceResponse.setAppDate(appDate);
		priceResponse.setBrandId(price.getBrand().getId());
		priceResponse.setFinalPrice(price.getPrice());
		priceResponse.setPrice(price.getPriceList());
		priceResponse.setProductId(price.getProductId());
		return priceResponse;
	}

}
