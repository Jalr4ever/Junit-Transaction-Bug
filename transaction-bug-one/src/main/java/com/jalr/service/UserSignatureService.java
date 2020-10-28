package com.jalr.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jalr.pojo.bo.UserCreateSignatureBo;
import com.jalr.pojo.condition.UserCreateSignatureCondition;
import com.jalr.pojo.condition.UserEditSignatureCondition;
import com.jalr.pojo.entity.UserSignature;

/**
 * @author zhanwenliang [routerhex@qq.com]
 * @description 用户个人签名服务类
 * @date 2020-10-23 14:24
 */
public interface UserSignatureService extends IService<UserSignature> {

    /**
     * 创建一条用户的个性签名
     *
     * @param condition
     */
    UserCreateSignatureBo createUserSignature(UserCreateSignatureCondition condition);

    /**
     * 编辑用户的个性签名
     *
     * @param condition
     */
    void editUserSignature(UserEditSignatureCondition condition);

}
