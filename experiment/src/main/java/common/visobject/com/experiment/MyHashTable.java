package common.visobject.com.experiment;

import java.util.ArrayList;

class MyHashTable {
	class KV {
		private Object key;
		private Object value;
	}
	private int size = 0;
	private ArrayList<KV>[] data = null;
	
	public MyHashTable() {
		new MyHashTable(50);
	}
	
	public MyHashTable(int size) {
		data = new ArrayList[size];
	}
	
	private int hash(String key) {
		int hash = 0;
		for (int i = 0; i < key.length(); i++) {
			hash = (hash + key.charAt(i) * i) % data.length;
		}
		return hash;
	}
	
	//O(1)
	public Object get(Object key) {
		int hashValue = hash((String)key);
		if (data[hashValue] != null) {
			ArrayList<KV> kvList = data[hashValue];
			for (KV kv: kvList) {
				if (kv.key.equals(key)) {
					return kv.value;
				}
			}
			return null;
		} else { 
			return null;
		}
	}
	
	//O(1)
	public void set(Object key, Object value) {
		if (key == null || value == null) {
			throw new IllegalArgumentException("null key or value is not allowed");
		}
		int hashValue = hash((String)key);
		System.out.println("hashValue=" + hashValue);
		if (data[hashValue] == null) {
			data[hashValue] = new ArrayList<KV>();
		}
		KV item = new KV();
		item.key = key;
		item.value = value;
		
		//allow duplicate keys
		data[hashValue].add(item);
		size++;

	}
	
	public Object[] getKeys() {
		Object[] keys = new Object[size];
		int k = 0;
		for (int i = 0; i< data.length; i++) {
			ArrayList<KV> kvList = data[i];
			if (kvList != null) {
				for (KV kv : kvList) {
					keys[k] = kv.key;
					k++;
				}
			}
		}
		return keys;
	}
	
	public Object[] getValues() {
		Object[] values = new Object[size];
		int k = 0;
		for (int i = 0; i< data.length; i++) {
			ArrayList<KV> kvList = data[i];
			if (kvList != null) {
				for (KV kv : kvList) {
					values[k] = kv.value;
					k++;
				}
			}
		}
		return values;
	}
	
	public int size() {
		return size;
	}
}
