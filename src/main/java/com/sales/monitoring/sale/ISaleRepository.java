package com.sales.monitoring.sale;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ISaleRepository extends JpaRepository<SaleModel, Long> {}