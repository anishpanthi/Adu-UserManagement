package com.app.adu.usermanagement.domain.error;

import lombok.*;

/**
 * @author Anish Panthi
 * <p>
 * 10/8/2017
 */

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Error {

    private String errorCode;
    private String field;
    private String message;
}
