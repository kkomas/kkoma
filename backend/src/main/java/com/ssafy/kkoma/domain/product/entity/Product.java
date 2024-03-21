package com.ssafy.kkoma.domain.product.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.kkoma.api.kid.dto.request.UpdateKidRequest;
import com.ssafy.kkoma.domain.common.entity.BaseTimeEntity;
import com.ssafy.kkoma.domain.deal.entity.Deal;
import com.ssafy.kkoma.domain.location.entity.Location;
import com.ssafy.kkoma.domain.member.entity.Member;
import com.ssafy.kkoma.domain.product.constant.ProductType;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Product extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "member_id")
	private Member member;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	private Category category;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "location_id")
	private Location location;
	private String thumbnailImage;

	@Column(length = 50)
	private String placeDetail;

	@Column(length = 100)
	private String title;

	@Column(columnDefinition = "text")
	private String description;
	private int price;

	@Builder.Default
	@Enumerated(EnumType.STRING)
	private ProductType status = ProductType.SALE;

	private Long viewCount;
	private Long wishCount;
	private Long offerCount;
	private LocalDateTime deletedAt;

	public void setMember(Member member) {
		this.member = member;
		member.getProducts().add(this);
	}

	public void updateStatus(ProductType productType) {
		this.status = productType;
	}
}
