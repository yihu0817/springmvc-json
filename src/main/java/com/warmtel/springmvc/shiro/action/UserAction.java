package com.warmtel.springmvc.shiro.action;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.warmtel.springmvc.shiro.model.User;
import com.warmtel.springmvc.shiro.utils.StringUtil;

@Controller
public class UserAction {
	@RequestMapping(value="/login/form")
	public String loginIndex(){
		System.out.println("login_from userActin >>>>>>> ");
		return "login";
	}
	
	/**
     * shiro框架登录
     * User user = (User) SecurityUtils.getSubject().getPrincipal(); 
     * 这句代码在任何地方任何时候都能获取当前登录成功的用户信息。
     * @param user
     */
    @RequestMapping(value = "/login",method=RequestMethod.POST)
    public ModelAndView login(User user){
    	System.out.println("login userActin >>>>>>> "+user.getUserName()+ "  "+user.getPassWord());
        // 表面校验
        if(StringUtil.isNullOrBlank(user.getUserName()) || StringUtil.isNullOrBlank(user.getPassWord())){
             return new ModelAndView("login")
                     .addObject("message", "账号或密码不能为空")
                     .addObject("failuser", user);
        }
        // 获取主体
        Subject subject = SecurityUtils.getSubject();
        try{
            // 调用安全认证框架的登录方法
            subject.login(new UsernamePasswordToken(user.getUserName(), user.getPassWord()));
        }catch(AuthenticationException ex){
            System.out.println("登陆失败: " + ex.getMessage());
            return new ModelAndView("login")
                    .addObject("message", "用户不存在")
                    .addObject("failuser", user);
        }
        // 登录成功后重定向到首页
        return new ModelAndView("redirect:/index");
    }
    
    @RequestMapping(value="/index")
    public String main(){
    	return "main";
    }
}
