package com.ssafy.kkoma.api.product.dto;

import com.ssafy.kkoma.domain.area.entity.Area;
import com.ssafy.kkoma.domain.area.repository.AreaRepository;
import com.ssafy.kkoma.domain.product.constant.ProductType;

import com.ssafy.kkoma.domain.product.entity.Product;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Duration;
import java.time.LocalDateTime;

@Builder
@Getter
@ToString
public class ProductSummary {

	private Long id;
	private String thumbnailImage;
	private String title;

	@Setter
	private String dealPlace;
	private ProductType status;
	private int price;
	private Long elapsedMinutes;
	private Long wishCount;
	private Long viewCount;
	private Long offerCount;

	public static ProductSummary fromEntity(Product product){
		LocalDateTime createdAt = product.getCreatedAt();
		Duration elapsedDuration = (createdAt != null) ? Duration.between(createdAt, LocalDateTime.now()) : null;

		return ProductSummary.builder()
				.id(product.getId())
				.thumbnailImage(product.getThumbnailImage())
				.title(product.getTitle())
				.status(product.getStatus())
				.price(product.getPrice())
				.elapsedMinutes((elapsedDuration != null) ? elapsedDuration.toMinutes() : null)
				.wishCount(product.getWishCount())
				.viewCount(product.getViewCount())
				.offerCount(product.getOfferCount())
				.build();
	}

	public static ProductSummary fromEntity(Product product, Area area){
		LocalDateTime createdAt = product.getCreatedAt();
		Duration elapsedDuration = (createdAt != null) ? Duration.between(createdAt, LocalDateTime.now()) : null;

		return ProductSummary.builder()
				.id(product.getId())
				.thumbnailImage(product.getThumbnailImage())
				.title(product.getTitle())
				.status(product.getStatus())
				.price(product.getPrice())
				.elapsedMinutes((elapsedDuration != null) ? elapsedDuration.toMinutes() : null)
				.wishCount(product.getWishCount())
				.viewCount(product.getViewCount())
				.offerCount(product.getOfferCount())
				.dealPlace(area.getFullArea())
				.build();
	}

}
