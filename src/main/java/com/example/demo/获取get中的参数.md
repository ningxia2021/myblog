# SpringBoot Controller层如何获取Get请求中的参数

## 参数跟在 ? 号后面
+ http://localhost:8080/hello?name=hangge
```java
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(@RequestParam("name") String name) {
        return "获取到的name是：" + name;
    }
}
```
### 参数没有传递的情况
+ 如果没有传递参数 Controller 将会报错，我们可以使用 required = false 标注参数是非必须的。
```java
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(@RequestParam(name = "name", required = false) String name) {
        return "获取到的name是：" + name;
    }
}
```
+ 或者可以指定个默认值，当没有传递参数时自动使用默认值：
```java
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(@RequestParam(name = "name", defaultValue = "xxx") String name) {
        return "获取到的name是：" + name;
    }
}
```

## 使用 map 来接收参数
+ Controller 还可以直接使用 map 来接收所有的请求参数：
```java
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(@RequestParam Map<String, Object> params) {
        return "name：" + params.get("name") + "<br>age：" + params.get("age");
    }
}
```


## 使用对象来接收参数
+ 如果一个 get 请求的参数太多，我们构造一个对象来简化参数的接收方式：
```java
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(User user) {
        return "name：" + user.getName() + "<br> age：" + user.getAge();
    }
}
```

## 参数直接在路径中 
+ 形如http://localhost:8080/hello/hangge，      hangge 这个参数值直接放在路径里面
```java
@RestController
public class HelloController {
    @GetMapping("/hello/{name}")
    public String hello(@PathVariable("name") String name) {
        return "获取到的name是：" + name;
    }
}
```
