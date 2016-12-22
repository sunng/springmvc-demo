package self.sunng.springmvc.ctr;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import self.sunng.springmvc.common.Response;
import self.sunng.springmvc.common.RestfulParam;
import self.sunng.springmvc.common.annotation.Authorization;
import self.sunng.springmvc.ent.User;
import self.sunng.springmvc.srv.UserSrv;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * Created by sunxiaodong on 16/7/27.
 */
@Api(value = "用户")
@Authorization
@RestController
@RequestMapping("/users")
public class UserCtr {

    @Resource
    private UserSrv userSrv;

    @ApiOperation(value = "查询用户", response = Response.class, notes = "查询用户", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiParam(name = "pageNum", value = "页数", required = true)
    @Authorization
    @RequestMapping(method = RequestMethod.GET)
    public Response doGet(@RequestParam Map<String, String> paramMap,
                        HttpServletRequest request, HttpServletResponse response) {
        RestfulParam param = new RestfulParam(request, response, paramMap);
        List<User> users = userSrv.queryByPage(param);
        return new Response(users);
    }

    @ApiOperation(value = "创建用户", response = Response.class, notes = "创建用户", produces = MediaType.APPLICATION_JSON_VALUE)
    @Authorization
    @RequestMapping(method = RequestMethod.POST)
    public Response doPost(@RequestBody User user, HttpServletResponse response) {
        user = userSrv.create(user);
        return new Response(user);
    }

    @ApiOperation(value = "更新用户信息", response = Response.class, notes = "更新用户信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @Authorization
    @RequestMapping(method = RequestMethod.PUT)
    public Response doPut(@RequestBody User user) {
        user = userSrv.updateById(user);
        return new Response(user);
    }

    @ApiOperation(value = "删除用户", response = Response.class, notes = "删除用户", produces = MediaType.APPLICATION_JSON_VALUE)
    @Authorization
    @RequestMapping(method = RequestMethod.DELETE)
    public Response doDelete(@RequestBody User user) {
        userSrv.deleteById(user.getId());
        return Response.OK;
    }
}
