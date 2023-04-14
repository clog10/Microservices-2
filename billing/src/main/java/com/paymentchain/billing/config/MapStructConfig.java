package com.paymentchain.billing.config;

import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.paymentchain.billing.common.InvoiceRequestMapper;
import com.paymentchain.billing.common.InvoiceResponseMapper;

@Configuration
public class MapStructConfig {

    @Bean
    public InvoiceRequestMapper invoiceRequestMapper() {
        return Mappers.getMapper(InvoiceRequestMapper.class);
    }

    @Bean
    public InvoiceResponseMapper invoiceResponseMapper() {
        return Mappers.getMapper(InvoiceResponseMapper.class);
    }

}
