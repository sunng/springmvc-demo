package self.sunng.springmvc.common;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import self.sunng.springmvc.common.util.JsonUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Created by sunxiaodong on 16/7/30.
 */
public class ExceptionHandler implements HandlerExceptionResolver {
    private static final String ERROR_RESP = JsonUtil.obj2Json(Response.SYSTEM_ERROR);
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        try {
            PrintWriter writer = httpServletResponse.getWriter();
            writer.write(ERROR_RESP);
            writer.flush();
        } catch (Exception ex) {

        }

        return new ModelAndView();
    }
}
