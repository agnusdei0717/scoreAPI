package com.bofa.payment.scoreAPI.controller;

import com.bofa.payment.scoreAPI.pojo.Agent;
import com.bofa.payment.scoreAPI.Component.ResultJSONObj;
import com.bofa.payment.scoreAPI.service.LoginService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;

@Controller
@ResponseBody
public class LoginController {
    private Log log = LogFactory.getLog(LoginController.class);

    @Autowired
    LoginService loginService;

    @Autowired
    ResultJSONObj resultJson;

    @RequestMapping("/login")
    public String login(@RequestParam("id") String loginID,
                              @RequestParam("password") String password, HttpServletRequest req){

        //获取当前用户
        Subject currentUser = SecurityUtils.getSubject();
        //用户是否已经登录，未登录则进行登录
        if (!currentUser.isAuthenticated()) {
            //封装用户输入的用户名和密码
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(loginID, password);
            try {
                //登录，进行密码比对，登录失败时将会抛出对应异常
                currentUser.login(usernamePasswordToken);
                resultJson.setResult(true).setMsg("登錄成功");
                resultJson.addData("agent",((Agent)currentUser.getSession().getAttribute("agent")).toString());
            } catch (UnknownAccountException uae) {
                resultJson.setMsg("用户名不存在");
            } catch (IncorrectCredentialsException ice) {
                resultJson.setMsg("密码错误");
            } catch (LockedAccountException lae) {
                resultJson.setMsg("用户状态异常");
            } catch (AuthenticationException ae) {
                resultJson.setMsg("登录失败，请与管理员联系");
            }
        } else {
            resultJson.setResult(true);
            resultJson.setMsg("您已经登录成功了");
        }

        return resultJson.toString();
    }

}
