package com.jalr.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhanwenliang [routerhex@qq.com]
 * @description 用户个性签名实体类
 * @date 2020-10-23 14:17
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("tb_user_signature")
public class UserSignature {

    @TableId(type = IdType.AUTO)
    private Long id;

    private Long createUserId;

    private String signatureId;

    private String signature;

}
