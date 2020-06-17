package org.rest.webservice.controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.rest.webservice.model.SomeBean;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

  @GetMapping("/filtering")
  public SomeBean retrieveSomeBean(){
//    SimpleBeanPropertyFilter filter = new SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");

//    FilterProvider filters = new SimpleFilterProvider().addFilter("someBeanFilter", filter);
    SomeBean someBean = new SomeBean("value1", "value2", "value3", "value4");
//    MappingJacksonValue mapping = new MappingJacksonValue(someBean);
//    mapping.setFilters(filters);
    return someBean;
  }

  @GetMapping("/filtering-list")
  public List<SomeBean> retrieveAllSomeBean(){
    return Arrays.asList(
        new SomeBean("value1", "value2", "value3", "value4"),
        new SomeBean("value1", "value2", "value3", "value4")
      );
  }
}
