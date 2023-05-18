package ru.clevertec.clevertec_final.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldNameConstants;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

@Data
@FieldNameConstants
@Builder(setterPrefix = "set")
@RequiredArgsConstructor @AllArgsConstructor
public class NewsReadDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 42L;

    private UUID uuid;
    private Instant createdDate;
    private String title;
    private String text;
    private String username;
    private String modifiedBy;

}
