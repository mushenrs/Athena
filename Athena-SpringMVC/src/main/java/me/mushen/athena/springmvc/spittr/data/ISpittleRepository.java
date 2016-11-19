package me.mushen.athena.springmvc.spittr.data;

import me.mushen.athena.springmvc.spittr.model.Spittle;

import java.util.List;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-10-30
 */
public interface ISpittleRepository {
    List<Spittle> findSpittles(long max, int count);

    Spittle findOne(long spittleId);
}
