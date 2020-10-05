package com.example.demo.Controller;


import com.example.demo.Model.Driver;
import com.example.demo.Model.Rider;
import com.example.demo.Repository.RecordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class CabController {


    @Autowired
    private RecordsRepository recordsRepository;

    @Autowired
    private Rider rider;

    @Autowired
  private Driver driver;

    @RequestMapping(value="/drivers",method= RequestMethod.GET)
    public List<Driver> getAllDrivers()
    {
        return (List<Driver>) recordsRepository.findAll();
    }

     @RequestMapping(value="/details/{id}",method=RequestMethod.GET)
    public List<Driver> shareDetails(@PathVariable String id , String name)
    {
        List<Driver> details = new ArrayList<>();
        return (List<Driver>) details.stream().filter(t->t.getLicense_id().equals(id)).findFirst().get();

    }


    @PostMapping("/driver")
    public ResponseEntity<Driver> createOrUpdateDriver(Driver driver1)
            throws Exception {
        driver = recordsRepository.save(driver1);
        return new ResponseEntity<Driver>(driver, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping(value="/rider")
      public Rider addRider(@RequestBody Rider rider)
      {

           rider.setId("101");
           rider.setName("Prashant");
           rider.setAddress("36, Brooklane , Bangalore");
           return rider;
      }

      @GetMapping("/rider/{id}")
    public String getRiderDetails(@PathVariable String id) throws Exception
    {
        boolean rider1 = rider.getId().equals(id);

        if(rider1) {
            return rider.getAddress();
        } else {
            System.out.println("No rider record exist for given id");
        }
        return id;
    }
    public void bookCab(String id )
    {
        recordsRepository.findAll();
    }

    @GetMapping("/booking/drivers/{id}")
    public void bookRide(@PathVariable String id)
    {
        Optional<Driver> driver2 = recordsRepository.findById(id);

        if(driver2.isPresent()) {

            rider.setBookingDetails(driver2);
        } else {
   System.out.println("No Driver Available");

        }
    }

}
