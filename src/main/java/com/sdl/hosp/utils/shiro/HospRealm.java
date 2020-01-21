package com.sdl.hosp.utils.shiro;
import com.sdl.hosp.model.entity.TPermission;
import com.sdl.hosp.model.entity.TRole;
import com.sdl.hosp.model.entity.TUser;
import com.sdl.hosp.service.TPermissionService;
import com.sdl.hosp.service.TRoleService;
import com.sdl.hosp.service.TUserService;
import com.sdl.hosp.utils.jwt.JWTUtil;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HospRealm extends AuthorizingRealm {
    @Autowired
    private TUserService tUserService;
    @Autowired
    private TRoleService tRoleService;
    @Autowired
    private TPermissionService tPermissionService;
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = JWTUtil.getUserName(principalCollection.toString());
        System.out.println(username+"获取授权信息...");
        TUser tUser = tUserService.findUserbyName(username);
        TRole tRole = tRoleService.queryById(tUser.getId());
        TPermission tPermission = tPermissionService.queryByRole(tRole.getUsertype());
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addRole(tRole.getUsertype());
        Set<String> permission = new HashSet<>(Arrays.asList(tPermission.getPermission().split(":")));
        System.out.println(permission);
        simpleAuthorizationInfo.addStringPermissions(permission);
        return simpleAuthorizationInfo;
    }

    /**
     * 认证用户登录
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
       String token = authenticationToken.getCredentials().toString();
       String username = JWTUtil.getUserName(token);
        System.out.println(username+"正在登录认证...");
       if (username == null){
           throw new AuthenticationException("token已过期");
       }
       TUser tUser = tUserService.findUserbyName(username);
       if (tUser == null){
           throw  new AuthenticationException("用户不存在");
       }
       if(!JWTUtil.verify(token,username,tUser.getPassword())){
           throw new AuthenticationException("密码错误");
       }
       return new SimpleAuthenticationInfo(token,token,"hosprealm");
    }
    @Bean
    public HospRealm shiroRealm(){
        HospRealm hospRealm = new HospRealm();
        hospRealm.setCachingEnabled(true);
        //启用身份验证缓存，即缓存AuthenticationInfo信息，默认false
        hospRealm.setAuthenticationCachingEnabled(true);
        //缓存AuthenticationInfo信息的缓存名称 在ehcache-shiro.xml中有对应缓存的配置
        hospRealm.setAuthenticationCacheName("authenticationCache");
        //启用授权缓存，即缓存AuthorizationInfo信息，默认false
        hospRealm.setAuthorizationCachingEnabled(true);
        //缓存AuthorizationInfo信息的缓存名称  在ehcache-shiro.xml中有对应缓存的配置
        hospRealm.setAuthorizationCacheName("authorizationCache");
        return hospRealm;
    }

    /**
     * 重写方法,清除当前用户的的 授权缓存
     * @param principals
     */
    @Override
    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }

    /**
     * 重写方法，清除当前用户的 认证缓存
     * @param principals
     */
    @Override
    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        super.clearCachedAuthenticationInfo(principals);
    }

    @Override
    public void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
    }

    /**
     * 自定义方法：清除所有 授权缓存
     */
    public void clearAllCachedAuthorizationInfo() {
        getAuthorizationCache().clear();
    }

    /**
     * 自定义方法：清除所有 认证缓存
     */
    public void clearAllCachedAuthenticationInfo() {
        getAuthenticationCache().clear();
    }

    /**
     * 自定义方法：清除所有的  认证缓存  和 授权缓存
     */
    public void clearAllCache() {
        clearAllCachedAuthenticationInfo();
        clearAllCachedAuthorizationInfo();
    }
}
