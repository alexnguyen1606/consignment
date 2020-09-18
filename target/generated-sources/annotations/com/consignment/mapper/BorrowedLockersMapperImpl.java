package com.consignment.mapper;

import com.consignment.dto.BorrowedLockersDTO;
import com.consignment.entity.BorrowedLockers;
import com.consignment.mapper.resolver.BorrowedLockersResolver;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-09-17T19:19:28+0700",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_221 (Oracle Corporation)"
)
@Component
public class BorrowedLockersMapperImpl implements BorrowedLockersMapper {

    @Autowired
    private BorrowedLockersResolver borrowedLockersResolver;

    @Override
    public BorrowedLockers toEntity(BorrowedLockersDTO m) {
        if ( m == null ) {
            return null;
        }

        BorrowedLockers borrowedLockers = new BorrowedLockers();

        borrowedLockers.setId( m.getId() );
        borrowedLockers.setCreatedDate( m.getCreatedDate() );
        borrowedLockers.setModifiedDate( m.getModifiedDate() );
        borrowedLockers.setCreatedBy( m.getCreatedBy() );
        borrowedLockers.setModifiedBy( m.getModifiedBy() );
        borrowedLockers.setLockersId( m.getLockersId() );
        borrowedLockers.setNote( m.getNote() );
        borrowedLockers.setInsuranceCode( m.getInsuranceCode() );
        borrowedLockers.setCustomerId( m.getCustomerId() );

        return borrowedLockers;
    }

    @Override
    public BorrowedLockersDTO toDTO(BorrowedLockers e) {
        if ( e == null ) {
            return null;
        }

        BorrowedLockersDTO borrowedLockersDTO = borrowedLockersResolver.resolve( e, BorrowedLockersDTO.class );

        borrowedLockersDTO.setId( e.getId() );
        borrowedLockersDTO.setCreatedDate( e.getCreatedDate() );
        borrowedLockersDTO.setModifiedDate( e.getModifiedDate() );
        borrowedLockersDTO.setCreatedBy( e.getCreatedBy() );
        borrowedLockersDTO.setModifiedBy( e.getModifiedBy() );
        borrowedLockersDTO.setLockersId( e.getLockersId() );
        borrowedLockersDTO.setNote( e.getNote() );
        borrowedLockersDTO.setInsuranceCode( e.getInsuranceCode() );
        borrowedLockersDTO.setCustomerId( e.getCustomerId() );

        return borrowedLockersDTO;
    }
}
