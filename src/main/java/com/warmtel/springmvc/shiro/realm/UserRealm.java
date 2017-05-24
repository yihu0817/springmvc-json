package com.warmtel.springmvc.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.warmtel.springmvc.shiro.model.User;
import com.warmtel.springmvc.shiro.service.UserService;

public class UserRealm extends AuthorizingRealm {
    
    private UserService userService;
                      
    public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
    public String getName() {
        return "customRealm";
    }
    
    /**
     * 认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
    	// 获取用户名称
        String username = (String) token.getPrincipal();
        User user = userService.findByUsername(username);
        if (user == null) {
            // 用户名不存在抛出异常
            System.out.println("认证：当前登录的用户不存在");
            throw new UnknownAccountException();
        }
        String pwd = user.getPassWord();
        return new SimpleAuthenticationInfo(user, pwd, getName());
        
       
    }
    protected AuthenticationInfo testdoGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
    	 
        String username = (String)token.getPrincipal();  //得到用户名
        String password = new String((char[])token.getCredentials()); //得到密码
        
        System.out.println("AuthorizationInfo   认证 >>> password ："+username+ " password :"+password);
        
        if(!"admin".equals(username)) {
            throw new UnknownAccountException(); //如果用户名错误
        }
        if(!"123".equals(password)) {
            throw new IncorrectCredentialsException(); //如果密码错误
        }
        
        System.out.println("AuthorizationInfo   认证 >>> 完成 ");
        //如果身份认证验证成功，返回一个AuthenticationInfo实现；
        return new SimpleAuthenticationInfo(username, password, getName());
    }
    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection princ) {
    	System.out.println("AuthorizationInfo  授权 >>>>");
        return null;
    }
}