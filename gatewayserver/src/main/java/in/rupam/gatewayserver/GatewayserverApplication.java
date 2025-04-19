package in.rupam.gatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayserverApplication.class, args);
	}

	@Bean
	public RouteLocator myRouteConfig(RouteLocatorBuilder routeLocatorBuilder){
		return routeLocatorBuilder.routes()
				.route(p->p.path("/javams/accounts/**")
						.filters(f->f.rewritePath("/javams/accounts/(?<segment>.*)","/${segment}"))
						.uri("lb://Accounts"))
				.route(p->p.path("/javams/loans/**")
						.filters(f->f.rewritePath("/javams/loans/(?<segment>.*)","/${segment}"))
						.uri("lb://LOANS")
				)
				.route(p->p.path("/javams/creditcards/**")
						.filters(f->f.rewritePath("/javams/creditcards/(?<segment>.*)","/${segment}"))
				.uri("lb://CREDITCARDS"))
				.build();
	}
}
