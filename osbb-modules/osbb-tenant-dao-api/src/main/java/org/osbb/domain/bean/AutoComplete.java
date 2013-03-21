package org.osbb.domain.bean;

/**
 *
 * @author Anton Bakalets
 */
public interface AutoComplete<K> {

    K getKey();

    String getValue();

    void setKey(K key);

    void setValue(String value);
    
}
