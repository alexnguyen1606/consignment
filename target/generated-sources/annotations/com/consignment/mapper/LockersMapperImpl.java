package com.consignment.mapper;

import com.consignment.dto.LockersDTO;
import com.consignment.entity.Lockers;
import com.consignment.mapper.resolver.LockersResolve;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-09-17T13:39:29+0700",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_221 (Oracle Corporation)"
)
@Component
public class LockersMapperImpl implements LockersMapper {

    @Autowired
    private LockersResolve lockersResolve;

    @Override
    public Lockers toEntity(LockersDTO m) {
        if ( m == null ) {
            return null;
        }

        Lockers lockers = new Lockers();

        lockers.setId( m.getId() );
        lockers.setCreatedDate( m.getCreatedDate() );
        lockers.setModifiedDate( m.getModifiedDate() );
        lockers.setCreatedBy( m.getCreatedBy() );
        lockers.setModifiedBy( m.getModifiedBy() );
        lockers.setName( m.getName() );
        lockers.setCode( m.getCode() );
        lockers.setDescription( m.getDescription() );
        lockers.setIsActive( m.getIsActive() );

        return lockers;
    }

    @Override
    public LockersDTO toDTO(Lockers e) {
        if ( e == null ) {
            return null;
        }

        LockersDTO lockersDTO = lockersResolve.resolve( e, LockersDTO.class );

        lockersDTO.setId( e.getId() );
        lockersDTO.setCreatedDate( e.getCreatedDate() );
        lockersDTO.setModifiedDate( e.getModifiedDate() );
        lockersDTO.setCreatedBy( e.getCreatedBy() );
        lockersDTO.setModifiedBy( e.getModifiedBy() );
        lockersDTO.setName( e.getName() );
        lockersDTO.setCode( e.getCode() );
        lockersDTO.setDescription( e.getDescription() );
        lockersDTO.setIsActive( e.getIsActive() );

        return lockersDTO;
    }
}
