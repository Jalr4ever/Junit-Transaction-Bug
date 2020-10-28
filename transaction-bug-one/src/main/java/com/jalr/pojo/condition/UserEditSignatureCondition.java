package com.jalr.pojo.condition;

import com.jalr.framework.condition.BaseCondition;
import lombok.Builder;
import lombok.Data;

/**
 * @author zhanwenliang [routerhex@qq.com]
 * @description 用户编辑自己的个性签名的接口 condition
 * @date 2020-10-23 12:04
 */
@Data
@Builder
public class UserEditSignatureCondition implements BaseCondition {

    private Long userId;

    private String userSignatureId;

}
