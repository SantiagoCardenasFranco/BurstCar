package com.uco.graduationproject.burstcar.domain.port.additinaldata;

import com.uco.graduationproject.burstcar.domain.dto.DtoAdditionalData;

import java.util.List;

public interface RepositoryDataAdditional {
    public List<DtoAdditionalData> listFindAll();
}
