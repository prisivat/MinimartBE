//package com.example.EShop;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//import org.springframework.web.filter.CorsFilter;
//
//
//import java.util.Arrays;
//
//@Configuration
//public class CorsConfig {
//    @Bean
//    public CorsFilter corsFilter() {
//        CorsConfiguration corsConfiguration = new CorsConfiguration();
//
//        // Set allowed origins explicitly
//        corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:3000", "https://minimart-50025724243.development.catalystappsail.in"));
//        corsConfiguration.setAllowCredentials(true); // Enable credentials
//
//        // Other CORS settings
//        corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
//        corsConfiguration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));
//
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", corsConfiguration);
//
//        return new CorsFilter(source);
//    }
//}
