package org.junbin.spring.javaconfig.converter.jpa;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * @author : Chung Junbin
 * @email : <a href="mailto:rekadowney@163.com">发送邮件</a>
 * @createDate : 2016-09-01 21:52
 * @description :
 */
@Converter(autoApply = true)
public class JpaLocalDateConverter implements AttributeConverter<LocalDateTime, Timestamp> {

    @Override
    public Timestamp convertToDatabaseColumn(LocalDateTime attribute) {
        return null == attribute ? null : Timestamp.valueOf(attribute);
    }

    @Override
    public LocalDateTime convertToEntityAttribute(Timestamp dbData) {
        return null == dbData ? null : dbData.toLocalDateTime();
    }

}
