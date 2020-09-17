package com.consignment.mapper;

import com.consignment.dto.LoggingDTO;
import com.consignment.entity.Logging;
import com.consignment.mapper.resolver.LoggingResolver;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-09-17T13:39:30+0700",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_221 (Oracle Corporation)"
)
@Component
public class LoggingMapperImpl implements LoggingMapper {

    @Autowired
    private LoggingResolver loggingResolver;

    @Override
    public Logging toEntity(LoggingDTO m) {
        if ( m == null ) {
            return null;
        }

        Logging logging = new Logging();

        logging.setId( m.getId() );
        logging.setCreatedDate( m.getCreatedDate() );
        logging.setModifiedDate( m.getModifiedDate() );
        logging.setCreatedBy( m.getCreatedBy() );
        logging.setModifiedBy( m.getModifiedBy() );
        logging.setType( m.getType() );
        logging.setCustomerId( m.getCustomerId() );
        logging.setLockerId( m.getLockerId() );

        return logging;
    }

    @Override
    public LoggingDTO toDTO(Logging e) {
        if ( e == null ) {
            return null;
        }

        LoggingDTO loggingDTO = loggingResolver.resolve( e, LoggingDTO.class );

        loggingDTO.setId( e.getId() );
        loggingDTO.setCreatedDate( e.getCreatedDate() );
        loggingDTO.setModifiedDate( e.getModifiedDate() );
        loggingDTO.setCreatedBy( e.getCreatedBy() );
        loggingDTO.setModifiedBy( e.getModifiedBy() );
        loggingDTO.setCustomerId( e.getCustomerId() );
        loggingDTO.setType( e.getType() );
        loggingDTO.setLockerId( e.getLockerId() );

        return loggingDTO;
    }
}
