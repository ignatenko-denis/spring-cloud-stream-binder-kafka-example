package com.sample.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Response to Kafka.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientRs {
    private String name;
    private boolean creditWorthy;
}
