package com.web.shiro;

import javax.annotation.Resource;
import com.web.po.User;
import com.web.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class AuthRealm extends AuthorizingRealm{
	
	@Resource
	private UserService userService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
		// TODO Auto-generated method stub
		
		System.out.println("shiro框架要进行授权了----------------");
		//到数据库根据用户id查询该用户的所有权限,  进行授权
		//如何获取用户id
		User user = (User) principal.getPrimaryPrincipal();
		
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.addStringPermission(user.getRolename());

		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		System.out.println("shiro框架要进行认证了");
		
		//查询数据库判断用户是存在
		//根据用户名查询
		
		//获取用户名
		UsernamePasswordToken	 t =  (UsernamePasswordToken) token;
		String username = t.getUsername();
		
		User user = userService.findUserByName(username);
		if(user != null){
			//user  根据用户名查询出的user对象
			//user.getPassword() 查询到的user对象密码 ,框架会自动用用户登录时传递的密码和该密码进行比较;
			//第三个参数无所谓
			return new SimpleAuthenticationInfo(user,user.getPassword(),getName());
		}
		return null;
	}

}
