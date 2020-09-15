package com.consignment.mapper;

import com.consignment.dto.BorrowedLockersDTO;
import com.consignment.entity.BorrowedLockers;
import com.consignment.mapper.resolver.BorrowedLockersResolver;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-09-16T00:05:19+0700",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_221 (Oracle Corporation)"
)
@Component
public class BorrowedLockersMapperImpl implements BorrowedLockersMapper {

    @Autowired
    private BorrowedLockersResolver borrowedLockersResolver;

    @Override
    public BorrowedLockers toEntity(BorrowedLockersDTO borrowedLockersDTO) {
        if ( borrowedLockersDTO == null ) {
            return null;
        }

        BorrowedLockers borrowedLockers = new BorrowedLockers();

        borrowedLockers.setId( borrowedLockersDTO.getId() );
        borrowedLockers.setCreatedDate( borrowedLockersDTO.getCreatedDate() );
        borrowedLockers.setModifiedDate( borrowedLockersDTO.getModifiedDate() );
        borrowedLockers.setCreatedBy( borrowedLockersDTO.getCreatedBy() );
        borrowedLockers.setModifiedBy( borrowedLockersDTO.getModifiedBy() );
        borrowedLockers.setLockersId( borrowedLockersDTO.getLockersId() );
        borrowedLockers.setNote( borrowedLockersDTO.getNote() );
        borrowedLockers.setInsuranceCode( borrowedLockersDTO.getInsuranceCode() );
        borrowedLockers.setCustomerId( borrowedLockersDTO.getCustomerId() );

        return borrowedLockers;
    }

    @Override
    public BorrowedLockersDTO toDTO(BorrowedLockers borrowedLockers) {
        if ( borrowedLockers == null ) {
            return null;
        }

        BorrowedLockersDTO borrowedLockersDTO = borrowedLockersResolver.resolve( borrowedLockers, BorrowedLockersDTO.class );

        borrowedLockersDTO.setId( borrowedLockers.getId() );
        borrowedLockersDTO.setCreatedDate( borrowedLockers.getCreatedDate() );
        borrowedLockersDTO.setModifiedDate( borrowedLockers.getModifiedDate() );
        borrowedLockersDTO.setCreatedBy( borrowedLockers.getCreatedBy() );
        borrowedLockersDTO.setModifiedBy( borrowedLockers.getModifiedBy() );
        borrowedLockersDTO.setLockersId( borrowedLockers.getLockersId() );
        borrowedLockersDTO.setNote( borrowedLockers.getNote() );
        borrowedLockersDTO.setInsuranceCode( borrowedLockers.getInsuranceCode() );
        borrowedLockersDTO.setCustomerId( borrowedLockers.getCustomerId() );

        return borrowedLockersDTO;
    }
}
