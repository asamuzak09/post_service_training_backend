package com.example.post_service_training_backend

import org.jetbrains.exposed.sql.Database
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component
import org.jetbrains.exposed.spring.SpringTransactionManager
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.annotation.EnableTransactionManagement
import org.springframework.transaction.annotation.TransactionManagementConfigurer
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import javax.sql.DataSource


@SpringBootApplication
class PostServiceTrainingBackendApplication

fun main(args: Array<String>) {
    val context: ApplicationContext = SpringApplication.run(PostServiceTrainingBackendApplication::class.java, *args)
    val exposed: ExposedConfig = context.getBean(ExposedConfig::class.java)

    exposed.config()
}

@Configuration
class WebMvcConfig : WebMvcConfigurer {
    override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/**")
            .allowedOrigins("http://localhost:3000")
            .allowedMethods("GET", "POST", "PUT", "DELETE")
    }
}

@Component
class ExposedConfig {
    @Value("\${spring.datasource.url}")
    val url = ""

    @Value("\${spring.datasource.driver-class-name}")
    val driver = ""

    fun config(){
        Database.connect(url, driver)
    }
}

@Configuration
@EnableTransactionManagement
class TxConfig(val dataSource: DataSource): TransactionManagementConfigurer {
    @Bean
    override fun annotationDrivenTransactionManager(): PlatformTransactionManager =
        SpringTransactionManager(dataSource)
}