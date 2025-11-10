package org.mitocode.platform.domain.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.mitocode.platform.domain.model.enums.ShipmentStatus;
import org.mitocode.platform.domain.model.valueobjects.Location;

import java.time.LocalDateTime;
import java.util.UUID;

import static java.util.Objects.isNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TrackingEvent {
    private UUID id;
    private String code;
    private ShipmentStatus status;
    private Shipment associatedShipment;
    private Location location;
    private LocalDateTime createdAt;
    private LocalDateTime lastModifiedAt;

    public void persist(){
        if(isNull(id)){
            id = UUID.randomUUID();
        }

        if(isNull(code)){
            code = RandomStringUtils.randomAlphanumeric(12);
        }
    }

}
