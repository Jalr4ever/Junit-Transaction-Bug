package com.jalr.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jalr.dao.UserSignatureMapper;
import com.jalr.pojo.bo.UserCreateSignatureBo;
import com.jalr.pojo.condition.UserCreateSignatureCondition;
import com.jalr.pojo.condition.UserEditSignatureCondition;
import com.jalr.pojo.entity.User;
import com.jalr.pojo.entity.UserSignature;
import com.jalr.service.UserService;
import com.jalr.service.UserSignatureService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author zhanwenliang [routerhex@qq.com]
 * @description
 * @date 2020-10-23 14:25
 */
@Service
@RequiredArgsConstructor
public class UserSignatureServiceImpl extends ServiceImpl<UserSignatureMapper, UserSignature> implements UserSignatureService {

    private final UserSignatureMapper userSignatureMapper;

    private final UserService userService;

    @Override
    public UserCreateSignatureBo createUserSignature(UserCreateSignatureCondition condition) {
        String signatureId = RandomUtil.randomString(12);
        UserSignature userSignature = UserSignature.builder()
                .signature(condition.getSignature())
                .createUserId(condition.getUserId())
                .signatureId(signatureId)
                .build();
        userSignatureMapper.insert(userSignature);
        return UserCreateSignatureBo.builder().signatureId(signatureId).build();
    }

    @Override
    public void editUserSignature(UserEditSignatureCondition condition) {
        UserSignature userSignature = userSignatureMapper.selectOne(new QueryWrapper<>(
                UserSignature.builder()
                        .signatureId(condition.getUserSignatureId())
                        .build()
        ));
        User user = userService.getById(condition.getUserId());

        if (Objects.isNull(userSignature)) {
            throw new RuntimeException("更新用户签名错误 - 用户签名不存在");
        }

        if (!userSignature.getCreateUserId().equals(condition.getUserId())) {
            throw new RuntimeException("更新用户签名错误 - 不是该用户创建");
        }

        if (Objects.isNull(user)) {
            throw new RuntimeException("用户不存在");
        }

        user.setSignatureId(userSignature.getSignatureId());
        userService.updateById(user);
    }

}
