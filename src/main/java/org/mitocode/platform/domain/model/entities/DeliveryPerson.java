package org.mitocode.platform.domain.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.UUID;

import static java.util.Objects.isNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class DeliveryPerson {
    private UUID id;
    private String code;
    private String firstName;
    private String lastName;
    private String licensePlate;
    private boolean isAvailable;

    public void persist(){
        if(isNull(id)){
            id = UUID.randomUUID();
        }

        if(isNull(code)){
            code = RandomStringUtils.randomAlphanumeric(12);
        }
    }

}
