package com.iroshan.library.returnbook.web;

import com.iroshan.library.lending.Lending;
import com.iroshan.library.returnbook.ReturnBook;
import com.iroshan.library.returnbook.ReturnServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/return")
public class ReturnBookController {

    @Autowired
    ReturnServiceImpl returnServiceImpl;

    @GetMapping("/{id}")
    @ResponseBody
    public ReturnBookView getReturn(@PathVariable Long id){
        return returnServiceImpl.getLending(id);
    }

    @GetMapping("/all")
    @ResponseBody
    public Page<ReturnBookView> getAllReturn(@PageableDefault(sort = "id", direction = Sort.Direction.ASC)Pageable pageable){
        return returnServiceImpl.findAllLending(pageable);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ReturnBookView create(@Valid @RequestBody ReturnBookBaseReq req){
        return returnServiceImpl.create(req);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ReturnBookView update(@PathVariable(name = "id") Long id,
                                 @Valid @RequestBody ReturnBookBaseReq req){
        ReturnBook returnBook = returnServiceImpl.findLendingOrThrow(id);
        return returnServiceImpl.update(returnBook, req);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
//    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ReturnBookView deleteReturnBook(@PathVariable Long id,
                                 @Valid @RequestBody ReturnBookBaseReq req){
        ReturnBook returnBook = returnServiceImpl.findLendingOrThrow(id);
        return returnServiceImpl.delete(returnBook, req);
//        returnServiceImpl.delete(id);
    }
}
