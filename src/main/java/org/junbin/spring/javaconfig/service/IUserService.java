package org.junbin.spring.javaconfig.service;

import org.junbin.spring.javaconfig.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author : Chung Junbin
 * @email : <a href="mailto:rekadowney@163.com">发送邮件</a>
 * @createDate : 2016-09-01 21:42
 * @description :
 */
public interface IUserService {

    User findOne(Integer id);

    void delete(Integer id);

    User save(User user);

    Page<User> find(Pageable pageable);

    //List<User> findAll();
    //
    //List<User> findAll(Sort sort);
    //
    //List<User> findAll(Iterable<Integer> integers);
    //
    //List<User> save(Iterable<User> entities);
    //
    //void flush();
    //
    //User saveAndFlush(User entity);
    //
    //void deleteInBatch(Iterable<User> entities);
    //
    //void deleteAllInBatch();

    User getOne(Integer integer);

}
