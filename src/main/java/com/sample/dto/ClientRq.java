package com.sample.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Request from Kafka.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientRq {
    private String name;

    /**
     * The highest score possible is 850, while the lowest is 300.
     */
    private Integer creditRating;
}
