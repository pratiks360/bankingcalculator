package com.yesbank.bankingcalculator.repos;

import org.springframework.data.repository.CrudRepository;

import com.yesbank.bankingcalculator.model.ProductMaster;

public interface ProductRepo extends CrudRepository<ProductMaster, Long> {

}
