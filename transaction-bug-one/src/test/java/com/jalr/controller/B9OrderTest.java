package com.jalr.controller;

import cn.hutool.core.util.RandomUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jalr.common.BaseControllerTest;
import com.jalr.constant.ResponseEnum;
import com.jalr.dao.UserSignatureMapper;
import com.jalr.framework.condition.BaseCondition;
import com.jalr.framework.config.ApplicationContextInitConfig;
import com.jalr.framework.util.SpringContextUtil;
import com.jalr.pojo.condition.UserCreateSignatureCondition;
import com.jalr.pojo.condition.UserEditSignatureCondition;
import com.jalr.pojo.entity.User;
import com.jalr.pojo.entity.UserSignature;
import com.jalr.service.UserService;
import com.jalr.service.UserSignatureService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.transaction.annotation.Transactional;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@Transactional
@SpringBootTest
@AutoConfigureMockMvc
class B9OrderTest extends BaseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserService userService;

    private UserSignatureService userSignatureService;

    private final String BASE_URL = "/userSignature";

    @Test
    void editUserSignature() throws Exception {

        // mock 添加一个用户
        User user = mockAddOneUser();

        // mock 用户创建一个个性签名
        String createResult = post(BASE_URL + "/create/userSignature", mockUserCreateSignatureCondition(user), ResponseEnum.SUCCESS).andReturn().getResponse().getContentAsString();
        String signatureId = JSON.parseObject(createResult).getJSONObject("data").getString("signatureId");

        // mock 用户编辑自己的个人签名
        post(BASE_URL + "/edit/userSignature", mockUserEditSignatureCondition(user, signatureId), ResponseEnum.SUCCESS);

    }

    private BaseCondition mockUserEditSignatureCondition(User user, String signatureId) {
        return UserEditSignatureCondition.builder().userId(user.getId()).userSignatureId(signatureId).build();
    }

    private BaseCondition mockUserCreateSignatureCondition(User user) {
        return UserCreateSignatureCondition.builder()
                .userId(user.getId())
                .signature("hello world, it's me")
                .build();
    }

    private User mockAddOneUser() {
        String userName = "UName_" + RandomUtil.randomString(10);
        userService.save(User.builder().userName(userName).build());
        return userService.getOne(new QueryWrapper<>(User.builder().userName(userName).build()));
    }


    /**
     * 发送一个 post 请求
     *
     * @param url          请求 url
     * @param condition    请求参数
     * @param responseEnum 请求 expected 的响应 code enum
     * @return
     * @throws Exception
     */
    private ResultActions post(String url, BaseCondition condition, ResponseEnum responseEnum) throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post(url);
        builder.contentType(MediaType.APPLICATION_JSON_VALUE).content(JSONObject.toJSONString(condition));
        return mockMvc
                .perform(builder)
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(jsonPath("$.code").value(responseEnum.getCode()));
    }

}