package com.consignment.mapper;

/**
 * @author:Nguyen Anh Tuan
 *     <p>September 08,2020
 */
public interface CommonMapper<E, M> {

  E toEntity(M m);

  M toDTO(E e);
}
