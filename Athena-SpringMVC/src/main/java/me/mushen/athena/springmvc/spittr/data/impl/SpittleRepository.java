package me.mushen.athena.springmvc.spittr.data.impl;

import me.mushen.athena.springmvc.spittr.data.ISpittleRepository;
import me.mushen.athena.springmvc.spittr.model.Spittle;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-10-30
 */
@Repository
public class SpittleRepository implements ISpittleRepository {

    @Override
    public List<Spittle> findSpittles(long max, int count) {
        List<Spittle> spittleList = new ArrayList<>();
        for(int i=0; i<count; i++){
            Spittle spittle = new Spittle(Long.parseLong((max - i) + ""), "Spittle_" + (max - i), new Date());
            spittleList.add(spittle);
        }
        return spittleList;
    }

    @Override
    public Spittle findOne(long spittleId) {

        return new Spittle(spittleId, "Spittle_" + spittleId, new Date());
    }
}
