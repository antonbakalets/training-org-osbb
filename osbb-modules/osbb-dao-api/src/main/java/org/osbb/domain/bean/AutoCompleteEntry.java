package org.osbb.domain.bean;

/**
 *
 * @author Anton Bakalets
 */
public class AutoCompleteEntry<K> implements AutoComplete<K> {
    
    private K key;
    private String value;

    public AutoCompleteEntry() {
    }

    public AutoCompleteEntry(K key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public void setKey(K key) {
        this.key = key;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }
}
