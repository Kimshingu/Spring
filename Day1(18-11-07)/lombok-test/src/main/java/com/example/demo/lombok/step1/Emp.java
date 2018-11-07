package com.example.demo.lombok.step1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@Getter
//@Setter
//@ToString
//@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Emp {
	private int empno;
	private String ename;
	private String job;
	
//	@Override
//	public boolean equals(Object obj) {
//		if (!(obj instanceof Emp)) {
//			throw new RuntimeException("use Emp instance");
//		}
//		Emp that = (Emp) obj;
//		if(this.empno==that.empno || this.ename==that.ename || this.job==that.job) 
//		{
//			return true;
//		}
//		return false;
//	}
}
