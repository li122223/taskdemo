package com.lzj.taskdemo.controller;

        import com.lzj.taskdemo.dao.UserRepository;
        import com.lzj.taskdemo.entity.Employee;
        import com.lzj.taskdemo.entity.User;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.*;

        import javax.persistence.criteria.CriteriaBuilder;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpSession;
        import java.util.Collection;
        import java.util.Map;

@Controller
public class UserController {
    @Autowired
    UserRepository userRepository;





    @RequestMapping("/user_list")
    public String findAllUser(Model model){
        Collection<User> users = userRepository.findAll();
        model.addAttribute("users",users);
        return  "user_list";

    }
     @RequestMapping("/to_user_add")
     public String AddUser(Map<String,Object> map){
         map.put("user",new User());
         return "user_add";

     }


     @PostMapping("/user_add")
     public String Add(User user){
        userRepository.save(user);
        return "redirect:/user_list";
     }

    @RequestMapping("/user/{id}")
    public String delete(@PathVariable("id") Integer id){
        userRepository.deleteById(id);
        return "redirect:/user_list";
    }

    @GetMapping("/user/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model){
        User user = userRepository.getOne(id);
        model.addAttribute("user",user);

        //页面要显示所有的部门列表


        return "user_list_edit";
    }

    //员工修改；需要提交员工id；
    @RequestMapping("/user_update")
    public String updateEmployee(User user){
        System.out.println("修改的员工数据："+user);
       userRepository.save(user);
        return "redirect:/user_list";
    }





    @RequestMapping("user_edit")
    public String UserEdit(HttpSession session){
        User user = (User) session.getAttribute("loginUser");
        if (user.getUsername().equals("admin"))
               return "admin_user_edit";
          else
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

    @PostMapping("/AdminUpdatePsw")
    public String updatepsw1(@RequestParam("old") String old,@RequestParam("password") String psw1, @RequestParam("password1") String psw2, Model model,HttpSession session) {
        User user = (User) session.getAttribute("loginUser");
        if (user.getPassword().equals(old)) {
            if (psw1.equals(psw2)) {
                user.setPassword(psw1);
                userRepository.save(user);
                return "admin_main";
            }
        }
        model.addAttribute("message","密码不一致");
        return "admin_user_edit";
    }


}
