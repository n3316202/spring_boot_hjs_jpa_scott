package edu.hjs.scott.controller;

import edu.hjs.scott.dto.PageRequestDTO;
import edu.hjs.scott.service.DeptSevice;
import edu.hjs.scott.service.EmpSevice;
import groovy.util.logging.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/emp")
public class EmpController {

    @Autowired
    private EmpSevice empSevice;

    @GetMapping("/all")
    public String selectAll(Model model){
        model.addAttribute("empList", empSevice.selectAll());
        return "emp";
    }

    @GetMapping("/list")
    public String list(@ModelAttribute PageRequestDTO pageRequestDTO , Model model){
        // 실제로 model에 추가되는 데이터 : PageResultDTO
        // => Model을 이용해 GuestbookServiecImpl에서 반환하는 PageResultDTO를 result 라는 이름으로 전달
        model.addAttribute("result", empSevice.getList(pageRequestDTO));
        return "emp";
    }
}
