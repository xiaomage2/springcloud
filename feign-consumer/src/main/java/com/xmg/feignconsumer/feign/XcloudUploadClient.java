package com.xmg.feignconsumer.feign;

import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.feign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * @author f00lish
 * @version 2018/1/25
 * Created By IntelliJ IDEA.
 * Qun:530350843
 */
@FeignClient(value = "${security.upload.server.serverId:xcloud-upload}",configuration = XcloudUploadClient.MultipartSupportConfig.class )
public interface XcloudUploadClient {

    @RequestMapping(value = "/sysUpload/add",method = RequestMethod.POST,consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    Map  add(@RequestPart(value = "file") MultipartFile file);

    @RequestMapping(value = "/sysUpload/get",method = RequestMethod.GET)
    Map get(@RequestParam("id") Long id);

    @Configuration
    class MultipartSupportConfig {
        @Bean
        public Encoder feignFormEncoder() {

            return new SpringFormEncoder(new SpringEncoder(new ObjectFactory<HttpMessageConverters>() {
                @Override
                public HttpMessageConverters getObject() throws BeansException {
                    return new HttpMessageConverters(new RestTemplate().getMessageConverters());
                }
            }));
        }
    }
}
