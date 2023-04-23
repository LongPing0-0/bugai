//Result
package com.lp.beans.pojo;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    @ApiModelProperty(value = "状态码")
    private Integer code; //状态码
    @ApiModelProperty(value = "信息")
    private String msg;   //信息
    @ApiModelProperty(value = "数据")
    private Object data; //数据
    public static Result success(String msg){
        return new Result(200,msg,"");
    }
    public static Result success(String msg,Object data){
        return new Result(200,msg,data);
    }
    public static Result error(String msg){
        return new Result(500,msg,"");
    }
    public static Result error(String msg,Object data){
        return new Result(500,msg,data);
    }
}
