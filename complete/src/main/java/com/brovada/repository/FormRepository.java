package com.brovada.repository;

import com.brovada.document.QForm;
import com.brovada.document.config.FormConfig;
import com.google.common.collect.Lists;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import javax.annotation.Nullable;
import java.math.BigDecimal;
import java.util.List;

public interface FormRepository extends MongoRepository<FormConfig, String>, QueryDslPredicateExecutor<FormConfig> {

    public FormConfig findById(String id);

    default public @Nullable FormConfig findLatestById(String id) {
        QForm form= new QForm("qf");

        FormConfig latest = null;
        BigDecimal v = new BigDecimal(Integer.MIN_VALUE);

        Iterable<FormConfig> result = findAll(form.id.eq(id));
        for (FormConfig fc:result) {
            BigDecimal version = fc.getVersion();
            if (version.compareTo(v)>0) {
                latest = fc;
            }
        }
        return latest;
    }


    // note : for development, you don't want caching but in production you do.
    // use spring.cache.type=NONE in application-dev.properties to turn it off.
    @Cacheable(value="form", key = "#name")
    // example of a refactor safe, coded query (as opposed to automatically generated ones above).
    default public List<FormConfig> find(String name) {
        QForm form = new QForm("qf");

        Iterable<FormConfig> result = findAll(
                form.id.containsIgnoreCase(name).
                        or(form.label.containsIgnoreCase(name))
        );
        return Lists.newArrayList(result);
    }

}
