package com.wizzstudio.smartlab.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.RequestParameterBuilder;
import springfox.documentation.service.Contact;
import springfox.documentation.service.RequestParameter;
import springfox.documentation.service.Server;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.List;

@Import(SpringDataRestConfiguration.class)
@Configuration
public class SwaggerConfig {
    @Value("${swaggerhost}")
    private String swaggerHost;
    /**
     * 当前版本
     */
    @Value("${app.version}")
    private String version;
    /**
     * 打包时间
     */
    @Value("${app.build.time}")
    private String buildTime;
    @Bean
    public Docket createRestApi() {

        RequestParameter requestParameter = new RequestParameterBuilder().name("Authorization").description("JWT Authorization").required(false).build();
        List<RequestParameter> globalRequestParameters = new ArrayList<>();
        globalRequestParameters.add(requestParameter);
//        ParameterBuilder tokenPar = new ParameterBuilder();
//        List<RequestParameter> pars = new ArrayList<>();
//        tokenPar.name("Authorization").description("JWT Authorization").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
//        pars.add(tokenPar.build());
        //todo update to spring fox 3.0.1
        //https://github.com/springfox/springfox/issues/3483
        Server s = new Server("server",swaggerHost,"d", new ArrayList<>(),new ArrayList<>());
        return new Docket(DocumentationType.OAS_30).servers(s)
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build().globalRequestParameters(globalRequestParameters).apiInfo(new ApiInfoBuilder()
                        .title("SmartLab")
                        .description("XDU 物理实验计算器 后端")
                        .version(String.format("%s %s UTC+0", version, buildTime))
                        .contact(new Contact("Qht", "https://www.117503445.top", "t117503445@gmail.com"))
                        .build());
    }
}