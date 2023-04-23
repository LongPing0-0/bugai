//UserDto
package com.lp.beans.pojo.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Integer uid;
    private String username;
    private String password;
    private String email;
    private Timestamp accountCreated;
    private String avatar;
}
