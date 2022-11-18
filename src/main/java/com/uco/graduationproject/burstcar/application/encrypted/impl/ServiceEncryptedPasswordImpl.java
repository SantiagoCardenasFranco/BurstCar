package com.uco.graduationproject.burstcar.application.encrypted.impl;

import com.uco.graduationproject.burstcar.application.encrypted.ServiceEncryptedPassword;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

@Component
public class ServiceEncryptedPasswordImpl implements ServiceEncryptedPassword {

    @Override
    public String execute(String text) {
        return DigestUtils.sha256Hex(text);
    }
}
