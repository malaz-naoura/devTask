package com.safee.devtask.repositories;

import com.safee.devtask.annotation.ExcludeFromScanning;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

@ExcludeFromScanning
public interface RootRepo<T,ID> extends JpaRepository<T, ID> {

    Page<T> findAll(Pageable pageable);

}
