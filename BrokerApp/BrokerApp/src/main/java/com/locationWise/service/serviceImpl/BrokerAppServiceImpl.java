package com.locationWise.service.serviceImpl;

import com.locationWise.dto_or_Payload.BrokerAppDto;
import com.locationWise.entity.BrokerApp;
import com.locationWise.repository.BrokerAppRepository;
import com.locationWise.service.BrokerAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrokerAppServiceImpl implements BrokerAppService {
    @Autowired
    private BrokerAppRepository brokerAppRepo;
    @Override
    public BrokerAppDto createBrokerApp(BrokerAppDto brokerappdto) {
        BrokerApp app = new BrokerApp();
        app.setId(brokerappdto.getId());
        app.setLocation(brokerappdto.getLocation());
        app.setFlatDetails(brokerappdto.getFlatDetails());
        app.setFurnishing(brokerappdto.getFurnishing());
        //brokerAppRepo.save(app);
        BrokerApp save = brokerAppRepo.save(app);

        BrokerAppDto dto = new BrokerAppDto();
        dto.setId(save.getId());
        dto.setLocation(save.getLocation());
        dto.setFlatDetails(save.getFlatDetails());
        dto.setFurnishing(save.getFurnishing());
        dto.setMessage("BrokerApp created");
        return dto;
    }

    @Override
    public void deleteBrokerApp(long id) {
        brokerAppRepo.deleteById(id);
    }
}
