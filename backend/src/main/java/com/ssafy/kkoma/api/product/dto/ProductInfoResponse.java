package com.ssafy.kkoma.api.product.dto;

import java.time.Duration;
import java.time.LocalDateTime;

import com.ssafy.kkoma.domain.deal.entity.Deal;
import com.ssafy.kkoma.domain.product.constant.MyProductType;
import com.ssafy.kkoma.domain.product.constant.ProductType;
import com.ssafy.kkoma.domain.product.entity.Product;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class ProductInfoResponse {

	private Long id;
	private String thumbnailImage;
	private String title;
	private String dealPlace;
	private ProductType status;
	private int price;
	private Long elapsedMinutes;
	private Long wishCount;
	private Long viewCount;
	private Long offerCount;
	private MyProductType type;

	// 거래 관련
	private Long dealId;
	private LocalDateTime selectedTime;

	public static ProductInfoResponse fromEntity(
		Product product, MyProductType type, Long dealId, LocalDateTime dealTime
	) {
		LocalDateTime createdAt = product.getCreatedAt();
		Duration elapsedDuration = (createdAt != null) ? Duration.between(createdAt, LocalDateTime.now()) : null;

		return ProductInfoResponse.builder()
			.id(product.getId())
			.thumbnailImage(product.getThumbnailImage())
			.title(product.getTitle())
			.dealPlace(product.getPlaceDetail())
			.status(product.getStatus())
			.price(product.getPrice())
			.elapsedMinutes((elapsedDuration != null) ? elapsedDuration.toMinutes() : null)
			.wishCount(product.getWishCount())
			.viewCount(product.getViewCount())
			.offerCount(product.getOfferCount())
			.type(type)
			.dealId(dealId)
			.selectedTime(dealTime)
			.build();
	}

}
