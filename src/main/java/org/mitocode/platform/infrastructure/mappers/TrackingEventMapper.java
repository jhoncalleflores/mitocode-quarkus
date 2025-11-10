package org.mitocode.platform.infrastructure.mappers;

import lombok.experimental.UtilityClass;
import org.mitocode.platform.domain.model.entities.Shipment;
import org.mitocode.platform.domain.model.entities.TrackingEvent;
import org.mitocode.platform.domain.model.valueobjects.Location;
import org.mitocode.platform.interfaces.resources.response.TrackingEventResponse;

import java.time.LocalDateTime;
import java.util.List;

@UtilityClass
public final class TrackingEventMapper {

    public static TrackingEvent createTrackingWithLocationAndShipment(Location location, Shipment shipment) {
        return TrackingEvent.builder()
                .status(shipment.getCurrentStatus())
                .associatedShipment(shipment)
                .createdAt(LocalDateTime.now())
                .location(location)
                .build();
    }

    public static TrackingEventResponse mapTrackingEventToTrackingEventResponse(TrackingEvent trackingEvent) {
        return TrackingEventResponse.builder()
                .code(trackingEvent.getCode())
                .status(trackingEvent.getStatus())
                .associatedShipment(trackingEvent.getAssociatedShipment())
                .createdAt(trackingEvent.getCreatedAt())
                .location(trackingEvent.getLocation())
                .lastModifiedAt(trackingEvent.getLastModifiedAt())
                .build();
    }

    public static List<TrackingEventResponse> mapTrackingEventsToResponses(List<TrackingEvent> trackingEvents) {
        return trackingEvents.stream().map(TrackingEventMapper::mapTrackingEventToTrackingEventResponse).toList();
    }

}
