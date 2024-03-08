package com.safee.devtask.services.domain.jpa;

import com.safee.devtask.models.PurchaseDTO;
import com.safee.devtask.repositories.PurchaseRepo;
import com.safee.devtask.services.domain.PurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PurchaseServiceJPAImpl implements PurchaseService {

    private final PurchaseRepo purchaseRepo;

    @Override
    public List<PurchaseDTO> getAllYesterday() {

        LocalDateTime yesterdayStart = LocalDateTime.of(LocalDate.now()
                                                                 .minusDays(1), LocalTime.MIN);

        LocalDateTime yesterdayEnd = LocalDateTime.of(LocalDate.now()
                                                               .minusDays(1), LocalTime.MAX);

        return purchaseRepo.findAllByCreatedDateGreaterThanEqualAndCreatedDateLessThanEqual(yesterdayStart,
                                                                                            yesterdayEnd)
                           .stream()
                           .map(getMapperObject()::objToDto)
                           .collect(Collectors.toList());
    }
}
