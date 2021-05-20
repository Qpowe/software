package com.demo.book.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.demo.book.repository")
public class MybatisConfig {
}
