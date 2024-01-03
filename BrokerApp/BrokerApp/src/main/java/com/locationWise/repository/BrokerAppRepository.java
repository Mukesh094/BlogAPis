package com.locationWise.repository;

import com.locationWise.dto_or_Payload.BrokerAppDto;
import com.locationWise.entity.BrokerApp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrokerAppRepository extends JpaRepository<BrokerApp,Long> {


}
