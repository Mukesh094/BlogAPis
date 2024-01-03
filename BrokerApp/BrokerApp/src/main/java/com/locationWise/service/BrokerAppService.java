package com.locationWise.service;

import com.locationWise.controller.BrokerApp;
import com.locationWise.dto_or_Payload.BrokerAppDto;

public interface BrokerAppService {
    BrokerAppDto createBrokerApp(BrokerAppDto brokerappdto);

    void deleteBrokerApp(long id);
}
