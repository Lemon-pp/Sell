package com.imooc.VO;


import lombok.Data;

/**
 * http请求返回的最外层对象
 * @param <T>
 */
@Data
public class ResultVO<T> {

    /**错误码*/
    private Integer code;

    /**提示*/
    private String message;

    /**具体内容*/
    private T data;
}
