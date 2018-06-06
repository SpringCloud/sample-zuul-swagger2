package cn.springcloud.sample.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "测试源服务API接口")
@RestController
public class TestController {

	@ApiOperation(value = "加法", notes = "加法")
	@GetMapping("/add")
	public Integer add(Integer a, Integer b){
		return a + b;
	}
	@ApiOperation(value = "减法", notes = "减法")
	@GetMapping("/sub")
	public Integer sub(Integer a, Integer b){
		return a - b;
	}
	@ApiOperation(value = "乘法", notes = "乘法")
	@GetMapping("/mul")
	public Integer mul(Integer a, Integer b){
		return a * b;
	}
	@ApiOperation(value = "除法", notes = "除法")
	@GetMapping("/div")
	public Integer div(Integer a, Integer b){
		return a / b;
	}
}
