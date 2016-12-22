package self.sunng.springmvc.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import self.sunng.springmvc.common.util.JsonUtil;

/**
 * Created by sunxiaodong on 16/7/30.
 */
@ApiModel(value = "响应信息")
public class Response {

    public static final Response OK = new Response(null);
    public static final Response SYSTEM_ERROR = new Response(-1, "系统错误");

    @ApiModelProperty(value = "响应代码")
    private int code;
    @ApiModelProperty(value = "响应信息")
    private String info;
    @ApiModelProperty(value = "响应数据")
    private Object data;

    public Response(Object data) {
        this.code = 0;
        this.info = "";
        this.data = data;
    }

    public Response(int code, String info) {
        this.code = code;
        this.info = info;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return JsonUtil.obj2Json(this);
    }
}
