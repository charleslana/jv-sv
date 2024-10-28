package com.example.jv_sv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.example.jv_sv.model.entity.Counter;

@Service
public class CounterService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public Long generateId(String counterName) {
        Query query = new Query(Criteria.where("name").is(counterName));
        Counter counter = mongoTemplate.findAndModify(
                query,
                new Update().inc("seq", 1),
                FindAndModifyOptions.options().returnNew(true).upsert(true),
                Counter.class);
        return counter.getSeq();
    }
}
