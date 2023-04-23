//EmailDto
package com.lp.beans.pojo.dto;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailDto {
    @ApiModelProperty(value = "email")
    private String email;
}
