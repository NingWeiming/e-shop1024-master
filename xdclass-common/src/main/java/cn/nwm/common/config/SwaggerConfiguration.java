package cn.nwm.common.config;

import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.*;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.schema.ScalarType;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import java.util.ArrayList;
import java.util.List;

@Component
@EnableOpenApi
@Data
public class SwaggerConfiguration {

    @Bean
    public Docket webApiDoc() {
        return new
                Docket(DocumentationType.OAS_30)
                .groupName("⽤户端接⼝⽂档")
                .pathMapping("/")
                // 定义是否开启swagger，false为关闭，可以通过变ᰁ控制，线上关闭
                .enable(true)
                //配置api⽂档元信息
                .apiInfo(apiInfo())
                // 选择哪些接⼝作为swagger的doc发布
                .select()
                .apis(RequestHandlerSelectors.basePackage("cn.nwm"))
                //正则匹配请求路径，并分配⾄当前分组
                .paths(PathSelectors.ant("/api/**"))
                .build();
    }

    @Bean
    public Docket adminApiDoc() {
        return new Docket(DocumentationType.OAS_30)
                .groupName("管理端接⼝⽂档")
                .pathMapping("/")
                // 定义是否开启swagger，false为关闭，可以通过变ᰁ控制，线上关闭
                .enable(true)
                //配置api⽂档元信息
                .apiInfo(apiInfo())
                // 选择哪些接⼝作为swagger的doc发布
                .select()
                .apis(RequestHandlerSelectors.basePackage("cn.nwm"))
                //正则匹配请求路径，并分配⾄当前分组
                .paths(PathSelectors.ant("/admin/**"))
                .build();
    }


    /**
     * ⽣成全局通⽤参数, ⽀持配置多个响应参数
     *
     * @return
     */
    private List<RequestParameter>
    getGlobalRequestParameters() {
        List<RequestParameter> parameters = new ArrayList<>();
        parameters.add(new RequestParameterBuilder()
                .name("token")
                .description("登录令牌")
                .in(ParameterType.HEADER)
                .query(q -> q.model(m ->
                        m.scalarModel(ScalarType.STRING)))
                .required(false)
                .build());
// parameters.add(new RequestParameterBuilder()
// .name("version")
// .description("版本号")
// .required(true)
// .in(ParameterType.HEADER)
// .query(q -> q.model(m ->m.scalarModel(ScalarType.STRING)))
// .required(false)
// .build());
        return parameters;
    }

    /**
     * ⽣成通⽤响应信息
     */
    private List<Response>
    getGlobalResponseMessage() {
        List<Response> responseList = new ArrayList<>();
        responseList.add(new ResponseBuilder().code("4xx").description("请求 错误，根据code和msg检查").build());
        return responseList;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("1024电商平台")
                .description("微服务接⼝⽂档")
                .contact(new Contact("⼩滴课堂-⼆ 当家⼩D", "https://xdclass.net", "794666918@qq.com")).version("12")
                .build();
    }
}