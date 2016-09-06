package org.junbin.spring.javaconfig.repository;

import org.junbin.spring.javaconfig.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : Chung Junbin
 * @email : <a href="mailto:rekadowney@163.com">发送邮件</a>
 * @createDate : 2016-09-01 21:40
 * @description :
 */
public interface UserRepository extends JpaRepository<User, Integer> {

}
