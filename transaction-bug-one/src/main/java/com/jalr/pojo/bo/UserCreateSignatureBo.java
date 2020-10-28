package com.jalr.pojo.bo;

import com.jalr.pojo.entity.UserSignature;
import lombok.Builder;
import lombok.Data;

/**
 * @author zhanwenliang [routerhex@qq.com]
 * @description 用户创建签名的业务响应数据类
 * @date 2020-10-23 14:47
 */
@Data
@Builder
public class UserCreateSignatureBo {

    /**
     * 创建成功，返回该记录的 id
     */
    private String signatureId;

    public UserCreateSignatureBo toBo(UserSignature userSignature) {
        return UserCreateSignatureBo.builder().signatureId(userSignature.getSignatureId()).build();
    }

}
