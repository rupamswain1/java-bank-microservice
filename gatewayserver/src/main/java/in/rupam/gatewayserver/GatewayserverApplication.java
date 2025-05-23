package in.rupam.gatewayserver;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.circuitbreaker.resilience4j.ReactiveResilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.gateway.filter.ratelimit.RedisRateLimiter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import reactor.core.publisher.Mono;

import java.beans.Customizer;
import java.util.function.Consumer;

import java.time.Duration;

@SpringBootApplication
public class GatewayserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayserverApplication.class, args);
	}

	@Bean
	public RouteLocator myRouteConfig(RouteLocatorBuilder routeLocatorBuilder){
		return routeLocatorBuilder.routes()
				.route(p->p.path("/javams/accounts/**")
						.filters(f->f.rewritePath("/javams/accounts/(?<segment>.*)","/${segment}")
								.circuitBreaker(config->config.setName("accountsCircuitBreaker")
										.setFallbackUri("forward:/contactSupport")
								))
						.uri("lb://Accounts"))
				.route(p->p.path("/javams/loans/**")
						.filters(f->f.rewritePath("/javams/loans/(?<segment>.*)","/${segment}")
								.retry(retryConfig -> retryConfig.setRetries(3)
										.setMethods(HttpMethod.GET)
										.setBackoff(Duration.ofMillis(100), Duration.ofMillis(1000),2,true))
						)
						.uri("lb://LOANS")
				)
				.route(p->p.path("/javams/creditcards/**")
						.filters(f->f.rewritePath("/javams/creditcards/(?<segment>.*)","/${segment}")
								.requestRateLimiter(config->config.setRateLimiter(redisRateLimiter())
										.setKeyResolver(userKeyResolver())
								)
						)
				.uri("lb://CREDITCARDS"))
				.build();
	}

	@Bean
	public RedisRateLimiter redisRateLimiter(){
		return new RedisRateLimiter(1,1,1);
	}

	@Bean
	KeyResolver userKeyResolver(){
		return exchange-> Mono.justOrEmpty(exchange.getRequest().getHeaders().getFirst("user")).defaultIfEmpty("anonymous");
	}
}
