package com.hogwarts.orderservice.dto;

import java.util.List;

import lombok.Data;

@Data
public class BulkOrderRequestDto {

	private List<OrderRequestDto> orders;
}
