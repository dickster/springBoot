package com.brovada.repository;

import com.brovada.document.QForm;
import com.brovada.document.Form;
import com.google.common.collect.Lists;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import java.math.BigDecimal;
import java.util.List;

public interface FormRepository extends MongoRepository<Form, String>, QueryDslPredicateExecutor<Form> {

    public Form findById(String id);

    default public Form findLatestById(String id) {
        QForm form= new QForm("qf");

        Form latest = null;
        BigDecimal v = new BigDecimal(Integer.MIN_VALUE);

        Iterable<Form> result = findAll(form.id.eq(id));
        for (Form fc:result) {
            BigDecimal version = fc.getVersion();
            if (version.compareTo(v)>0) {
                latest = fc;
            }
        }
        return latest;
    }

    // example of a refactor safe, coded query (as opposed to automatically generated ones above).
    default public List<Form> find(String name) {
        QForm form = new QForm("qf");

        Iterable<Form> result = findAll(
                form.id.containsIgnoreCase(name).
                        or(form.label.containsIgnoreCase(name))
        );
        return Lists.newArrayList(result);
    }

}
