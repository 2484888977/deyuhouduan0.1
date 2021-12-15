package com.deyu.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.deyu.mapper.CollegeMapper;
import com.deyu.mapper.QxinfoMapper;
import com.deyu.mapper.UserclassMapper;
import com.deyu.pojo.Students;
import com.deyu.pojo.User;
import com.deyu.pojo.User_view;
import com.deyu.pojo.Userclass;
import com.deyu.service.UserServiceImpl;
import com.deyu.service.UserclassServiceImpl;
import com.deyu.util.ParseExcel;
import com.deyu.util.UtilTools;
import com.deyu.util.aLog;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Controller
@RequestMapping("/UserController")
@CrossOrigin
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private UserclassServiceImpl userclassService;
    @Autowired
    private CollegeMapper collegeMapper;
    @Autowired
    private QxinfoMapper qxinfoMapper;
    @Autowired
    private UserclassMapper userclassMapper;

    /**
     * 添加用户
     *
     * @param user 实体类
     * @return
     */
    @aLog("添加用户")
    @GetMapping("/addUser")
    @ResponseBody
    @CrossOrigin
    public JSON addUser(User user) {
        return userService.addUser(user);
    }

    /**
     * 个人信息查看
     *
     * @param u_id
     * @return
     */
    @GetMapping("/queryUserInfo")
    @ResponseBody
    @CrossOrigin
    public User_view queryUserInfo(int u_id) {
        User user = new User();
        User_view user_view = new User_view();
        user_view.setU_id(u_id);
        return userService.queryUserInfo(u_id);
    }


    /**
     * 保存个人信息
     * //     * @param user
     *
     * @return
     */
    @GetMapping("/saveUserInfo")
    @ResponseBody
    @CrossOrigin
    public JSON saveUserInfo(int u_id, String address, String u_mail, String qq, String vx) {
        User user = new User();
        user.setU_id(u_id);
        user.setAddress(address);
        user.setU_mail(u_mail);
        user.setQq(qq);
        user.setVx(vx);
        return userService.saveUserInfo(user);
    }

    /**
     * 验证密码
     *
     * @param user
     * @return
     */
    @GetMapping("/verifyUserPwd")
    @ResponseBody
    @CrossOrigin
    public JSON verifyUserPwd(User user) {
        return userService.verifyUserPwd(user);
    }

    /**
     * 修改密码
     * //     * @param user
     *
     * @return
     */
    @GetMapping("/updateUserPwd")
    @ResponseBody
    @CrossOrigin
    public JSON updateUserPwd(User user, String pwd1, String pwd2) {
        return userService.updateUserPwd(user, pwd1, pwd2);
    }

    //重置密码
    @GetMapping("/resetUserPwd")
    @ResponseBody
    @CrossOrigin
    public JSON resetUserPwd(int u_id) {
        return userService.resetUserPwd(u_id);
    }

    /**
     * 删除用户
     *
     * @param u_id
     * @return
     */
    @GetMapping("/deleteUser")
    @ResponseBody
    @CrossOrigin
    public JSON deleteUser(int u_id) {
        return userService.deleteUser(u_id);
    }

    /**
     * 查看用户
     * //     * @param page
     * //     * @param limit
     *
     * @return
     */
    @GetMapping("/queryUser")
    @ResponseBody
    @CrossOrigin
    public JSON queryUser(@RequestParam("page") int page, @RequestParam("limit") int limit, @Param("Keyword") String Keyword) {
        JSONObject json = new JSONObject();
        try {
            int page1 = page - 1;
            int page2 = page1 * limit;
            json.put("code", 0);
            json.put("msg", "查询信息成功");
            json.put("count", userService.queryUser(0, 100000, null).size());
            json.put("data", userService.queryUser(page2, limit, null));
        } catch (Exception e) {
            e.printStackTrace();
            json.put("code", -1);
            json.put("msg", "数据接口异常,请稍后再试");
        }
        return json;
    }

    //关键词查找——用户名，用户姓名，所属单位名称
    @GetMapping("/queryWhereUser")
    @ResponseBody
    @CrossOrigin
    public JSON queryWhereUser(@RequestParam("page") int page, @RequestParam("limit") int limit, @Param("Keyword") String Keyword) {
        JSONObject json = new JSONObject();
        try {
            int page1 = page - 1;
            int page2 = page1 * limit;
            json.put("code", 0);
            json.put("msg", "查询信息成功");
            json.put("count", userService.queryUser(0, 100000, Keyword).size());
            json.put("data", userService.queryUser(page2, limit, Keyword));
        } catch (Exception e) {
            e.printStackTrace();
            json.put("code", -1);
            json.put("msg", "数据接口异常,请稍后再试");
        }
        return json;
    }

    //操作——>查看/编辑——编辑
    @GetMapping("/updateUser")
    @ResponseBody
    @CrossOrigin
    public JSON updateUser(User user) {
        return userService.updateUser(user);
    }

    @GetMapping("/queryUserclass")
    @ResponseBody
    @CrossOrigin
    public List queryUserclass() {
        return userclassService.queryUserclass();
    }


    //批量添加用户信息
    @PostMapping("/addAllUser")
    @ResponseBody
    @CrossOrigin
    public JSON importAlumnis(MultipartFile file) {
        InputStream inputStream = null;
        //输入流
        try {
            inputStream = file.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //原始文件名
        String originalFilename = file.getOriginalFilename();
        //文件后缀
        String suffix = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        ParseExcel parser = new ParseExcel();
        //第二行开始读取
        int startRow = 1;
        List<String[]> result = null;
        try {
            result = parser.parseExcel(inputStream, suffix, startRow);
        } catch (IOException e) {
            e.printStackTrace();
        }
        User user = new User();
        JSON json = null;
        System.out.println(result);
        for (String[] ss : result) {
            System.out.println(ss);
            user.setUsername(ss[0]);//1
            user.setU_name(ss[1]);//1
            user.setU_sex(ss[2]);//1
            user.setAddress(ss[3]);//1
            user.setU_classinfo(collegeMapper.queryCollegeinfoid(ss[4]).get(0).getCollegeid());
            user.setJurisdiction(qxinfoMapper.queryQxinfoid(ss[5]).getJurisdiction());
            user.setUser_id(String.valueOf(ss[6]));
            user.setU_class(userclassMapper.queryUserclassinfoid(ss[7]).getUserid());
//            user.setU_id(0);
            user.setPassword(UtilTools.Encrypted_MD5("123456"));
            user.setStateCode("1");
            //导入信息进入数据库
            json = userService.addAllUser(user);
            System.out.println(json);
            //关闭流
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return json;
    }
}
