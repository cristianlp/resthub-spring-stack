package org.resthub.web.controller;

import javax.inject.Inject;

import org.resthub.web.model.Sample;
import org.resthub.web.repository.WebSampleResourceRepository;
import org.springframework.beans.TypeMismatchException;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/repository-based")
public class SampleRepositoryBasedRestController extends
        RepositoryBasedRestController<Sample, Long, WebSampleResourceRepository> {

    @Override
    @Inject
    public void setRepository(WebSampleResourceRepository repository) {
        this.repository = repository;
    }

    @Override
    public Long getIdFromResource(Sample resource) {
        return resource.getId();
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "test1")
    @ResponseBody
    public Sample throwDefaultHandledException() throws HttpMediaTypeNotAcceptableException {
        throw new HttpMediaTypeNotAcceptableException("test1");
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "test2")
    @ResponseBody
    public Sample throwIllegalArgumentException() throws IllegalArgumentException {
        throw new IllegalArgumentException();
    }
    
    

}
