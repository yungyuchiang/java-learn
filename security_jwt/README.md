# Spring security + jwt

### 数据流

#### 登录
1. login paramter中传入username, password
2. 到达JwtAuthenticationFilter.attemptAuthentication，包装为UsernamePasswordAuthenticationToken，交给AuthenticationManager.authenticate()鉴权
3. AuthenticationManager 从CachingUserDetailsService查找信息判断登录
4. 登录成功跳到JwtAuthenticationFilter的successfulAuthentication
5. 登录失败跳到JwtAuthenticationFilter的unsuccessfulAuthentication

#### 请求鉴权
- 请求鉴权的主要思路是我们会从请求中的 Authorization 字段拿取 token，如果不存在此字段的用户，Spring Security 会默认会用 AnonymousAuthenticationToken() 包装它，即代表匿名用户。
1. 请求发起
2. 到达JwtAuthorizationFilter.doFilterInternal() 鉴权
3. 鉴权成功生成 Authentication , 用 SecurityContextHolder.getContext().setAuthentication() 放入Security 即代表鉴权完成。

