package com.example.demo.spel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import lombok.Data;

//<context:property-placeholder location="my.properties"/>
@PropertySource(value = { "my.properties" })
@Component
@Data
public class Person {
	@Value("#{member.name}")
	private String name;
	@Value("#{member.age}")
	private int age;
	
//	:null 설정  : car.default.name 키로 찾았는데 없으면 대신 null을 할당한다.
	@Value("${car.default.name:null}")
	private String carName;
	@Value("${car.default.doors:0}")
	private int carDoors;
// Run As > Run Configuration > VM arguments > -Duser.region=KR
	// java -jar 빌드결과.jar  -Duser.region=KR
	@Value("#{systemProperties['user.region'] == null ? 'US' : systemProperties['user.region']}")
	private String defaultLocale;
}
