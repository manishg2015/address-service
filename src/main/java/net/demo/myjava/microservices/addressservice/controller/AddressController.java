package net.demo.myjava.microservices.addressservice.controller;



import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.demo.myjava.microservices.addressservice.model.Address;
import net.demo.myjava.microservices.addressservice.service.AddressService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/address")
@Slf4j
@RequiredArgsConstructor
public class AddressController {

    final AddressService addressService;
    @GetMapping(value = "/person/{personId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<Address> addressByPersonId(@PathVariable("personId")String personId){
        log.info("**addressByPersonId:" + personId);
        return addressService.getAddressByPersonId(personId);

    }
}
