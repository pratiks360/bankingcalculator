package com.yesbank.bankingcalculator.repos;

import org.springframework.data.repository.CrudRepository;

import com.yesbank.bankingcalculator.model.ComputeRules;

public interface ProductRepo  extends CrudRepository<ComputeRules,Long> {

}
