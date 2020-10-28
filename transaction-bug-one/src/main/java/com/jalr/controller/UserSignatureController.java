package com.jalr.controller;

import com.jalr.constant.ResponseObject;
import com.jalr.framework.util.SpringContextUtil;
import com.jalr.pojo.bo.UserCreateSignatureBo;
import com.jalr.pojo.condition.UserCreateSignatureCondition;
import com.jalr.pojo.condition.UserEditSignatureCondition;
import com.jalr.service.UserSignatureService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhanwenliang [routerhex@qq.com]
 * @description 用户模块的控制器
 * @date 2020-10-23 11:42
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/userSignature")
public class UserSignatureController {


    private final UserSignatureService userSignatureService;

    @PostMapping("/create/userSignature")
    public ResponseObject<UserCreateSignatureBo> createUserSignature(@RequestBody UserCreateSignatureCondition condition) {
        UserCreateSignatureBo bo = SpringContextUtil.getBean(UserSignatureService.class).createUserSignature(condition);
        return ResponseObject.success(bo);
    }


    @PostMapping("/edit/userSignature")
    public ResponseObject editUserSignature(@RequestBody UserEditSignatureCondition condition) {
        userSignatureService.editUserSignature(condition);
        return ResponseObject.success();
    }

}
