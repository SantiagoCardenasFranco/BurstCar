package com.uco.graduationproject.burstcar.application.service.additionaldata.consult;

import com.uco.graduationproject.burstcar.domain.dto.DtoAdditionalData;
import com.uco.graduationproject.burstcar.domain.port.additinaldata.RepositoryDataAdditional;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServiceApplicationListAdditionalDataService {

    private final RepositoryDataAdditional repositoryDataAdditional;

    public ServiceApplicationListAdditionalDataService(RepositoryDataAdditional repositoryDataAdditional) {
        this.repositoryDataAdditional = repositoryDataAdditional;
    }

    public List<DtoAdditionalData> execute(){
        return this.repositoryDataAdditional.listFindAll();
    }
}
