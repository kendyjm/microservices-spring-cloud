package com.in28minutes.microservices.limitsservice.bean;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class LimitConfiguration {

    private int maximum;
    private int minimum;

}
