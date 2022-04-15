package com.iroshan.library.lending.web;

import com.iroshan.library.lending.Lending;
import com.iroshan.library.lending.LendingServiceInf;
import com.iroshan.library.publisher.Publisher;
import com.iroshan.library.publisher.PublisherServiceInf;
import com.iroshan.library.publisher.web.PublisherBaseReq;
import com.iroshan.library.publisher.web.PublisherView;
import com.iroshan.library.returnbook.ReturnBook;
import com.iroshan.library.returnbook.web.ReturnBookBaseReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/lend")
public class LendingController {

    @Autowired
    LendingServiceInf lendingServiceInf;

    @GetMapping("/{id}")
    @ResponseBody
    public LendingView getLending(@PathVariable Long id){
        return lendingServiceInf.getLending(id);
    }

    @GetMapping("/all")
    @ResponseBody
    public Page<LendingView> getAllLending(@PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return lendingServiceInf.findAllLending(pageable);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public LendingView create(@Valid @RequestBody LendingBaseReq req) {
        return lendingServiceInf.create(req);
    }

    @PutMapping("/{id}")
    public LendingView updateLending(@PathVariable(name = "id") Long id,
                                      @Valid @RequestBody LendingBaseReq req) {
        Lending landing = lendingServiceInf.findLendingOrThrow(id);
        return lendingServiceInf.update(landing, req);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public LendingView deleteLending(@PathVariable Long id,@Valid @RequestBody LendingBaseReq req){
//        lendingServiceInf.delete(id);
        Lending lending = lendingServiceInf.findLendingOrThrow(id);
        return lendingServiceInf.delete(lending, req);
    }
}
