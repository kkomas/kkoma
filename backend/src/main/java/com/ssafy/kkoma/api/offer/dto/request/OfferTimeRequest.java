package com.ssafy.kkoma.api.offer.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OfferTimeRequest {

    @Schema(example = "2024-03-28", type = "string")
    private LocalDate offerDate;

    @Schema(example = "11:30", type = "string")
    private LocalTime startTime;

    @Schema(example = "14:20", type = "string")
    private LocalTime endTime;

    public OfferTimeRequest(LocalDate offerDate, LocalTime startTime, LocalTime endTime){
        this.offerDate = offerDate;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
