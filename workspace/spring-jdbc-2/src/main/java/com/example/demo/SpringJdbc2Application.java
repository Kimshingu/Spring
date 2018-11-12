package com.example.demo;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigurationExcludeFilter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.TypeExcludeFilter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ComponentScan.Filter;

/*
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited

스프링 부트 기술을 위한 환경을 구성한다.
@SpringBootConfiguration

디펜던시 및 application.propertis 파일의 설정에 따라 환경을 구성한다.
@EnableAutoConfiguration

베이스패키지가 생략되면 클래스의 패키지를 베이스패키지로 사용한다.
excludeFilters: 자동환경 설정에서 다음 클래스는 처리하지 않는다.
exclude={DataSourceAutoConfiguration.class} 설정을 추가하면
DataSource가 자동으로 처리되지 않아서 빈 컨테이너가 존재하지 않는다.
개발자가 직접 수동으로 하고자 할 떄 사용할 수 있다.
개발자가 다른 곳에서 설정을 한다면 스프림부트는 그 설정을 존중하여 자동환경 설정을 진행하지 않는다.
@ComponentScan(excludeFilters = {
		@Filter(type = FilterType.CUSTOM, classes = TypeExcludeFilter.class),
		@Filter(type = FilterType.CUSTOM, classes = AutoConfigurationExcludeFilter.class) })
 */

@SpringBootApplication
public class SpringJdbc2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbc2Application.class, args);
	}
}
