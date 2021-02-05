package com.bofa.payment.scoreAPI.controller;

import com.bofa.payment.scoreAPI.pojo.Agent;
import com.bofa.payment.scoreAPI.Component.ResultJSONObj;
import com.bofa.payment.scoreAPI.service.AgentSerivce;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@ResponseBody
public class AgentController {

    private Log log = LogFactory.getLog(AgentController.class);
    @Autowired
    AgentSerivce agentService;

    @Autowired
    ResultJSONObj resultJson;

    @RequestMapping("/addAgent")
    public String add(@RequestParam("cname") String cname
            , @RequestParam("ename") String ename
            , @RequestParam("password") String password
            , @RequestParam("password2") String password2
            , @RequestParam("level") Integer level) {

        try {
            if(!password.equals(password2))
                throw new Exception("密碼比對不相同");
            agentService.addAgent(cname, ename, password, level);
            resultJson.setResult(true).setMsg("新增使用者成功");
        } catch (Exception e) {
            resultJson.setMsg(e.getMessage());
            log.info(e.toString());
        }
        return resultJson.toString();
    }

    @RequestMapping("/agent/query")
    public String query(@RequestParam String ename) {
        Agent agent = new Agent();
        agent.setEname(ename);
        resultJson.setResult(true).setMsg("查詢成功").addData("result",agentService.findAgents(agent));
        return resultJson.toString();
    }

    @RequestMapping("/agent/remove/{id}")
    public String remove(@PathVariable Integer id) throws IOException {
        agentService.deleteAgent(id);
        resultJson.setResult(true).setMsg("刪除成功");
        return resultJson.toString();
    }

    @RequestMapping("/agent/edit/{id}")
    public String edit(@PathVariable Integer id) {
        Agent agent = new Agent();
        agent.setId(id);
        resultJson.setResult(true).addData("agent",agentService.findAgents(agent).get(0));
        return resultJson.toString();

    }

    @RequestMapping("/agent/save")
    public String save(@RequestBody Agent agent) {
        resultJson.setResult(true).setMsg("儲存成功").addData("agent",agentService.saveAgent(agent));
        return resultJson.toString();
    }
}
