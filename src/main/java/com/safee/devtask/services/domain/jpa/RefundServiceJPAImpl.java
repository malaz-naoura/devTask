package com.safee.devtask.services.domain.jpa;

import com.safee.devtask.models.RefundDTO;
import com.safee.devtask.repositories.RefundRepo;
import com.safee.devtask.services.domain.RefundService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RefundServiceJPAImpl implements RefundService {

    private final RefundRepo refundRepo;

    @Override
    public List<RefundDTO> getAllYesterday() {
        LocalDateTime yesterdayStart = LocalDateTime.of(LocalDate.now()
                                                                 .minusDays(1), LocalTime.MIN);

        LocalDateTime yesterdayEnd = LocalDateTime.of(LocalDate.now()
                                                               .minusDays(1), LocalTime.MAX);

        return refundRepo.findAllByCreatedDateGreaterThanEqualAndCreatedDateLessThanEqual(yesterdayStart,
                                                                                            yesterdayEnd)
                           .stream()
                           .map(getMapperObject()::objToDto)
                           .collect(Collectors.toList());
    }
}
