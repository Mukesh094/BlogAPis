package com.locationWise.dto_or_Payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BrokerAppDto {
    private long id;
    private String location;
    private String flatDetails;
    private String furnishing;
    private String message;
}
