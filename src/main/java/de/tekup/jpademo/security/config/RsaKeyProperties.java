package de.tekup.jpademo.security.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

@Getter@Setter
@ConfigurationProperties(prefix = "rsa")
public class RsaKeyProperties {

    private RSAPrivateKey privateKey;
    private RSAPublicKey publicKey;

}
