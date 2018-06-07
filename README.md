![image](https://img.shields.io/badge/test-passing-green.svg)

# sample-zuul-swagger2
:palm_tree: A sample for zuul-swagger2 to test original service

sample-zuul-swagger2 是在Zuul中整合Swagger2，来动态生成源服务测试Dashboard的项目。

```
@Configuration
@EnableSwagger2
public class SwaggerConfig {

  //利用注入Zuul的配置文件，实现对路由源服务API的测试
	@Autowired
	ZuulProperties properties;

	@Primary
	@Bean
	public SwaggerResourcesProvider swaggerResourcesProvider() {
		return () -> {
			List<SwaggerResource> resources = new ArrayList<>();
			properties.getRoutes().values().stream()
					.forEach(route -> resources
					.add(createResource(route.getServiceId(), route.getServiceId(), "2.0")));
			return resources;
		};
	}

	private SwaggerResource createResource(String name, String location, String version) {
		SwaggerResource swaggerResource = new SwaggerResource();
		swaggerResource.setName(name);
		swaggerResource.setLocation("/" + location + "/v2/api-docs");
		swaggerResource.setSwaggerVersion(version);
		return swaggerResource;
	}
}
```

![image](https://github.com/SpringCloud/sample-zuul-swagger2/blob/master/img/1.png)

![image](https://github.com/SpringCloud/sample-zuul-swagger2/blob/master/img/2.png)
