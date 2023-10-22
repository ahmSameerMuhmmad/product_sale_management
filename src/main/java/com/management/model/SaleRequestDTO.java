package com.management.model;

import lombok.*;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SaleRequestDTO {
    private Long productId;
    private int quantity;
    private Date saleDate;
}