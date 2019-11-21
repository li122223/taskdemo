package com.lzj.taskdemo.controller;

        import com.lzj.taskdemo.dao.UserRepository;
        import com.lzj.taskdemo.entity.User;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.PostMapping;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestParam;

        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    UserRepository userRepository;





    @RequestMapping("user_edit")
    public String UserEdit(){
        return "user_edit";
    }

    @PostMapping("/UpdatePsw")
    public String updatepsw(@RequestParam("old") String old,@RequestParam("password") String psw1, @RequestParam("password1") String psw2, Model model,HttpSession session) {
        User user = (User) session.getAttribute("loginUser");
        if (user.getPassword().equals(old)) {
            if (psw1.equals(psw2)) {
                user.setPassword(psw1);
                userRepository.save(user);
                return "main";
            }
            }
        model.addAttribute("message","密码不一致");
        return "user_edit";


    }

}
