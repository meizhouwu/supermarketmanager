package com.jxh.controller;

import com.jxh.domain.SystemLog;
import com.jxh.service.ISystemLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/systemLog")
public class SystemLogController {

    @Autowired
    private ISystemLogService systemLogService;

    @RequestMapping("/list")
    public String listSystemLog(Model model) {
        List<SystemLog> systemLogList = systemLogService.getSystemLogList();
        model.addAttribute("list",systemLogList);
        return "systemLogList";
    }

    @RequestMapping("/view")
    public String view(Model model,Long id) {
        SystemLog systemLog = systemLogService.getSystemLog(id);
        model.addAttribute("one",systemLog);
        return "systemLogView";
    }

    @RequestMapping("/delete")
    public String deleteSystemLog(Long id) {
        systemLogService.deleteSystemLog(id);
        return "redirect:/systemLog/list";
    }

}
