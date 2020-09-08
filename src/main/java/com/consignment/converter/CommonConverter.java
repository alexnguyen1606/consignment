package com.consignment.converter;

/**
 * @author:Nguyen Anh Tuan
 *     <p>September 08,2020
 */
public interface CommonConverter<E, M> {

  E toEntity(M m);

  M toDTO(E e);
}
