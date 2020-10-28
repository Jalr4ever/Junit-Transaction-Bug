package com.jalr.dao;

import com.jalr.common.BaseControllerTest;
import com.jalr.common.BaseMapperTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.AfterTestClass;
import org.springframework.transaction.annotation.Transactional;


@Slf4j
@SpringBootTest
@Transactional
//@AutoConfigureMockMvc
class C0OrderTest extends BaseMapperTest {

    @Autowired
    private UserSignatureMapper userSignatureMapper;

    @Test
    void testUserSignatureMapperSelect() {
        userSignatureMapper.selectById(9L);
    }

}