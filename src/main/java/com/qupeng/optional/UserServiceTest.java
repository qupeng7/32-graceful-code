package com.qupeng.optional;

import java.util.Optional;

public class UserServiceTest {

    public static void main(String[] args) {
        UserService userService = new UserService();

        User user = userService.queryUserById(10);
        if (null != user) {
            System.out.println("匹配到该用户");
            //其他业务处理
        }else{
            System.out.println("用户不存在");
        }

        // TODO 新的实现方式
        Optional<User> userOptional = Optional.ofNullable(user);
        // 使用isPresent 方法进行判断
        if(userOptional.isPresent()){
            System.out.println("匹配到该用户");
            //其他业务处理
        } else {
            System.out.println("用户不存在");
        }

        //使用了Optional了，对于if else 的代码通常也是可以给省略掉
        userOptional.ifPresent((u)->{
            System.out.println("匹配到该用户");
            //其他业务处理
        });

        //使用map orElse方法同样也可以执行if else的逻辑判断
        userOptional.map((u) -> {
            System.out.println("匹配到该用户!");
            return u;
        }).orElse(null);


        //登录逻辑
        ResultObject resultInfo = null;
        String uname = null, upwd = null;
        user = userService.queryUserByUnameAndUpwd(uname, upwd);
        // 判断user对象是否为空
        if (user == null) { // 用户不存在
            resultInfo = new ResultObject(1,"登录失败,用户名或密码错误", null);
        } else {
            resultInfo = new ResultObject(0,"登录成功", user);
        }


        userOptional= Optional.ofNullable(userService.queryUserByUnameAndUpwd(uname,upwd));
        // 执行 map orElse 判断
        userOptional.map((u)->{
            //如果用户记录存在
            return new ResultObject(200,"登录成功",u);
        }).orElse(new ResultObject(300,"登录失败,用户名或密码错误",null));


        String action = "main";
        Optional<String> optional = Optional.ofNullable(action);
        String page = optional.filter(a -> a.trim().equals("") || a.equals("main"))
                .map((str) -> {
                    System.out.println("转发到主页面");
                    return "main";
                }).orElseGet(() -> {
                    System.out.println("抓发到登录页面");
                    return "login";
                });
        System.out.println(page);
        //controller跳转到 page 的字符串所代表的页面
    }
}