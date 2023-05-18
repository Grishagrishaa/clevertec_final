package ru.clevertec.clevertec_final.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

@Data
@Builder(setterPrefix = "set")
@FieldNameConstants
@AllArgsConstructor @NoArgsConstructor
public class CommentReadDto implements Serializable{

    @Serial
    private static final long serialVersionUID = 41L;

    private UUID uuid;
    private Instant createdDate;
    private String text;
    private String username;
    private String modifiedBy;
    private UUID newsUuid;

}
