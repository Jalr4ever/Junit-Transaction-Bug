package com.jalr.pojo.condition;

import com.jalr.framework.condition.BaseCondition;
import lombok.Builder;
import lombok.Data;

/**
 * @author zhanwenliang [routerhex@qq.com]
 * @description 用户创建一条个性签名的接口 condition
 * @date 2020-10-23 12:02
 */
@Data
@Builder
public class UserCreateSignatureCondition implements BaseCondition {

    private Long userId;

    private String signature;

}
