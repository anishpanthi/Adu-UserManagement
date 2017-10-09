package com.app.adu.usermanagement.domain.response;

import com.app.adu.usermanagement.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author Anish Panthi
 * <p>
 * 10/8/2017
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse implements Serializable{

    private User user;
}
