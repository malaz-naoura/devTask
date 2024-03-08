package com.safee.devtask.jobs;

import com.safee.devtask.models.PurchaseDTO;
import com.safee.devtask.models.RefundDTO;
import com.safee.devtask.services.domain.PurchaseService;
import com.safee.devtask.services.domain.RefundService;
import com.safee.devtask.services.mail.EmailService;
import com.safee.devtask.models.OrderItemEmailDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ReportingJob {

    @Value("${my.email.to}")
    private String toEmail;

    @Value("${my.email.subject}")
    private String subject;

    private final EmailService emailService;

    private final TemplateEngine templateEngine;

    private final PurchaseService purchaseService;

    private final RefundService refundService;

    @Scheduled(cron = "0 0 1 * * *")
    public void runEveryMinute() {
        Context context = new Context();

        context.setVariable("purchases", getPurchases());
        context.setVariable("refunds", getRefunds());
        String htmlText = templateEngine.process("email", context);

        emailService.sendEmail(toEmail, subject, htmlText);
    }


    List<OrderItemEmailDTO> getPurchases() {

        List<PurchaseDTO> purchasesDto = purchaseService.getAllYesterday();
        List<OrderItemEmailDTO> purchases = purchasesDto.stream()
                                                        .map(purchaseDTO -> OrderItemEmailDTO.builder()
                                                                                             .id(purchaseDTO.getId())
                                                                                             .amount(purchaseDTO.getAmount())
                                                                                             .productName(
                                                                                                     purchaseDTO.getProduct()
                                                                                                                .getName())
                                                                                             .customerName(
                                                                                                     purchaseDTO.getCustomer()
                                                                                                                .getName())
                                                                                             .build())
                                                        .collect(Collectors.toList());

        return purchases;
    }

    List<OrderItemEmailDTO> getRefunds() {
        List<RefundDTO> refundsDtos = refundService.getAllYesterday();

        List<OrderItemEmailDTO> refunds = refundsDtos.stream()
                                                     .map(refundsDTO -> OrderItemEmailDTO.builder()
                                                                                         .id(refundsDTO.getId())
                                                                                         .amount(refundsDTO.getAmount())
                                                                                         .customerName(
                                                                                                 refundsDTO.getPurchase()
                                                                                                           .getCustomer()
                                                                                                           .getName())
                                                                                         .productName(
                                                                                                 refundsDTO.getPurchase()
                                                                                                           .getProduct()
                                                                                                           .getName())
                                                                                         .build())
                                                     .collect(Collectors.toList());

        return refunds;
    }


}
