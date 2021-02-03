package com.bofa.payment.scoreAPI.controller;

import com.bofa.payment.scoreAPI.pojo.Agent;
import com.bofa.payment.scoreAPI.service.AgentSerivce;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class AgentController {

    private Log log = LogFactory.getLog(AgentController.class);

    @Autowired
    AgentSerivce agentService;

    @RequestMapping("/addAgent")
    public void add(@RequestParam("cname") String cname
            , @RequestParam("ename") String ename
            , @RequestParam("password") String password
            , @RequestParam("password2") String password2
            , @RequestParam("level") Integer level
            , HttpServletRequest req
            , HttpServletResponse res) {
        try {
            agentService.addAgent(cname, ename, password, level);
            res.sendRedirect(req.getContextPath() + "/login.html");
        } catch (Exception e) {
            log.info(e.toString());
        }
    }

    @RequestMapping("/agent")
    public String index() {
        return "query/agent";
    }

    @RequestMapping("/agent/query")
    public ModelAndView query(@RequestParam String ename) {
        Agent agent = new Agent();
        agent.setEname(ename);

        ModelAndView mv = new ModelAndView("query/agent");
        mv.addObject("display", true);
        mv.addObject("ename", ename);
        mv.addObject("dataList", agentService.findAgents(agent));

        return mv;
    }

    @RequestMapping("/agent/remove/{id}")
    public void remove(@PathVariable Integer id, @RequestParam String ename, HttpServletRequest request, HttpServletResponse response) throws IOException {

        agentService.deleteAgent(id);

        response.sendRedirect(String.format("%s%s?ename=%s", request.getContextPath(), "/agent/query", ename));
    }

    @RequestMapping("/agent/edit/{id}")
    public ModelAndView edit(@PathVariable Integer id) {
        Agent agent = new Agent();
        agent.setId(id);

        List<Agent> agents = agentService.findAgents(agent);

        ModelAndView mv = new ModelAndView("edit/agent");
        mv.addObject("agent", agents.get(0));

        return mv;

    }

    @RequestMapping("/agent/save")
    public void save(@ModelAttribute Agent agent, HttpServletRequest req, HttpServletResponse res) {

        agent = agentService.saveAgent(agent);

        try {
            res.sendRedirect(req.getContextPath() + "/agent/query?ename=" + agent.getEname());
        } catch (IOException e) {
            log.info(e.toString());
        }
    }
}
