package net.demo.myjava.microservices.addressservice.service;

import net.demo.myjava.microservices.addressservice.model.Address;
import net.demo.myjava.microservices.addressservice.model.AddressType;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class AddressService {

    public Flux<Address> getAddressByPersonId(String personId){
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
