package spring.boot.persistance.layer.optimizy.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.domain.AuditorAware
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import spring.boot.persistance.layer.optimizy.support.auditing.AuditorAwareImpl

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
class AuditConfig {
    @Bean
    fun auditorProvider(): AuditorAware<String> {
        return AuditorAwareImpl()
    }
}
