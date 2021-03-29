package net.demo.myjava.microservices.addressservice.service;

import lombok.extern.slf4j.Slf4j;
import net.demo.myjava.microservices.addressservice.model.Address;
import net.demo.myjava.microservices.addressservice.model.AddressType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.Arrays;

@Service
@Slf4j

public class AddressService {

    private final String key1;
    private final String key2;

    @Autowired
    public AddressService(

            @Value("${app.secret.key1}") String key1,
            @Value("${app.secret.key2}") String key2
    ) {
        this.key1 = key1;
        this.key2 = key2;
        log.info("*****Secret key1 is :" + key1);
        log.info("*****Secret key2 is :" + key2);
    }

    public Flux<Address> getAddressByPersonId(String personId){

        log.info("*****In Address service Secret key1 is :" + key1);
        log.info("*****In Address service Secret key2 is :" + key2);
        ArrayList<Address> addressList = new ArrayList<>(Arrays.asList(new Address[]{
                Address.builder().city("Bangalore").personId(personId).country("IND").state("KA").
                        type(AddressType.HOME).postalCode("560075").street("New Thiipasandara").id("12345").build(),

                Address.builder().city("Bhopal").personId(personId).country("IND").state("MP").
                        type(AddressType.OFFICE).postalCode("660075").street("New Bhopal").id("12346").build(),

                Address.builder().city("Raipur").personId(personId).country("IND").state("UP").
                        type(AddressType.OFFICE).postalCode("770075").street("New Raipur").id("12347").build()
        }));
        return Flux.fromIterable(addressList);
    }
}
