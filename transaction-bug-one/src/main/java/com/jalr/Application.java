/*
 * @Copyright 2014-2020 云安宝 (www.yunanbao.com.cn).
 *
 * 注意：本内容仅限于深圳云安宝科技有限公司内部传阅，禁止外泄以及用于其他商业目的
 *
 */

package com.jalr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: zhanwenliang [routerhex@qq.com]
 * @description: 启动类
 * @date: 2020-10-10 14:43
 */
@SpringBootApplication
@MapperScan(basePackages = "com.jalr.dao")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
