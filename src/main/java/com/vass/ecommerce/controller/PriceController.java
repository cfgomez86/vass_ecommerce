package com.vass.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vass.ecommerce.entity.PriceRequest;
import com.vass.ecommerce.entity.PriceResponse;
import com.vass.ecommerce.service.PriceService;

@Controller
public class PriceController {

	@Autowired
	private PriceService priceService;

	@RequestMapping(value = "/price", method = RequestMethod.POST)
	public ResponseEntity<PriceResponse> getPrice(@RequestBody PriceRequest priceRequest) {
		PriceResponse priceResponse = priceService.getPrice(priceRequest);
		
		return priceResponse != null ? ResponseEntity.ok(priceResponse) 
				: new ResponseEntity<PriceResponse>(HttpStatus.NO_CONTENT);
	}
}
