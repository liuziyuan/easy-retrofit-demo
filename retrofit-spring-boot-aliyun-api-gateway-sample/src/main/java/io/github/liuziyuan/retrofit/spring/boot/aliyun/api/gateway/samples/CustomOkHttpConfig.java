package io.github.liuziyuan.retrofit.spring.boot.aliyun.api.gateway.samples;

import io.github.liuziyuan.retrofit.extension.aliyun.api.gateway.spring.boot.OkHttpConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.net.ssl.*;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.concurrent.ExecutorService;

@Component
@Slf4j
public class CustomOkHttpConfig extends OkHttpConfig {
    @Override
    public X509TrustManager x509TrustManager() {
        return new X509TrustManager() {
            @Override
            public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
                log.debug("checkClientTrusted");
            }
            @Override
            public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
                log.debug("checkServerTrusted");
            }
            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }
        };
    }

    @Override
    public SSLSocketFactory sslSocketFactory() {
        try {
            //信任任何链接
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, new TrustManager[]{x509TrustManager()}, new SecureRandom());
            return sslContext.getSocketFactory();
        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            log.error("sslSocketFactory error.", e);
        }
        return null;
    }

    @Override
    public HostnameVerifier hostnameVerifier() {
        return null;
    }

    @Override
    public ExecutorService executorService() {
        return null;
    }

    @Override
    public Runnable idleCallback() {
        return null;
    }
}
