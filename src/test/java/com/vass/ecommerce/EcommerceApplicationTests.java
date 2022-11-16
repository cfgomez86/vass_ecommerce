package com.vass.ecommerce;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.vass.ecommerce.controller.PriceController;
import com.vass.ecommerce.entity.PriceRequest;
import com.vass.ecommerce.entity.PriceResponse;

@SpringBootTest
class EcommerceApplicationTests {

	@Autowired
	private PriceController priceController;

	@ParameterizedTest
	@CsvFileSource(resources = "/test_data.csv", numLinesToSkip = 1)
	void restIntegrationTest(ArgumentsAccessor argumentsAccessor) {
		LocalDateTime appDate = LocalDateTime.parse(argumentsAccessor.getString(2));

		PriceRequest priceRequest = PriceRequest.builder()
				.brandId(argumentsAccessor.getLong(0))
				.productId(argumentsAccessor.getLong(1))
				.appDate(appDate)
				.build();

		ResponseEntity<PriceResponse> priceResponse = priceController.getPrice(priceRequest);
		if (HttpStatus.OK == priceResponse.getStatusCode()) {
			PriceResponse price = priceResponse.getBody();
			if (price != null) {
				assertEquals(price.getBrandId(), argumentsAccessor.getLong(0));
				assertEquals(price.getProductId(), argumentsAccessor.getLong(1));
				assertEquals(price.getAppDate(), appDate);
				assertEquals(price.getFinalPrice(), argumentsAccessor.getDouble(3));
				assertEquals(price.getPrice(), argumentsAccessor.getLong(4));
			}
		} else {
			System.err.println(priceResponse.getStatusCode());
		}
	}

}
