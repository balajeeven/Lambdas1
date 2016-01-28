package LambdaCompositionOverMap;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

/**
 * Created by Aniruddha Sinha on 25-01-2016.
 */
interface MapOperations{
    public void sortNaturallyByKey();
    public void reverseSortByKey();
    public void sortNaturallyByValue();
    public void reverseSortByValue();
}
class MapComposer<K,V> implements Map<K,V> {
    private final Map<K, V> mapObject;

    public MapComposer(Map<K, V> mapObject) {
        this.mapObject = mapObject;//constructor injection}

    }

    /**
     * in the above code segement the composition actually occurs by means of Code injection
     * @param key
     * @param value
     * @return
     */

    @Override
    public V put(K key, V value) {
        return this.mapObject.put(key, value);
    }

    @Override
    public V get(Object key) {
        return this.mapObject.get(key);
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        this.mapObject.putAll(m);
    }

    @Override
    public V remove(Object key) {
        return this.mapObject.remove(key);
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return this.mapObject.entrySet();
    }

    @Override
    public Collection<V> values() {
        return this.mapObject.values();
    }

    @Override
    public Set<K> keySet() {
        return this.mapObject.keySet();
    }

    @Override
    public void clear() {
        this.mapObject.clear();
    }

    @Override
    public void forEach(BiConsumer<? super K, ? super V> action) {
        this.mapObject.forEach(action);
    }

    @Override
    public void replaceAll(BiFunction<? super K, ? super V, ? extends V> function) {
        this.mapObject.replaceAll(function);
    }

    @Override
    public V putIfAbsent(K key, V value) {
        return this.mapObject.putIfAbsent(key, value);
    }

    @Override
    public boolean remove(Object key, Object value) {
        return this.mapObject.remove(key, value);
    }

    @Override
    public boolean replace(K key, V oldValue, V newValue) {
        return this.mapObject.replace(key, oldValue, newValue);
    }

    @Override
    public V replace(K key, V value) {
        return this.mapObject.replace(key, value);
    }

    @Override
    public V computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        return this.mapObject.computeIfPresent(key, remappingFunction);
    }

    @Override
    public int size() {
        return this.mapObject.size();
    }

    @Override
    public boolean isEmpty() {
        return this.mapObject.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return this.mapObject.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return this.mapObject.containsValue(value);
    }
}

class CustomMapWrapper<K,V> extends MapComposer<K,V>{

    public CustomMapWrapper(Map<K, V> mapObject) {
        super(mapObject);
    }
}

class Person implements MapOperations{
    private CustomMapWrapper<String,Integer> person;
    private CustomMapWrapper<String,Integer> naturalOrderByKeyMap;
    private CustomMapWrapper<String,Integer> reverseOrderByKeyMap;
    private CustomMapWrapper<String,Integer> naturalOrderByValueMap;
    private CustomMapWrapper<String,Integer> reverseOrderByValueMap;
            public Person(){
                person=new CustomMapWrapper<String,Integer>(new LinkedHashMap<String,Integer>(){{
                put("Aniruddha",23);
                put("Amol",24);
                put("Balajee",23);
                put("Akanksha",23);
                put("Ashok",25);
            }});
                naturalOrderByKeyMap=new CustomMapWrapper<String,Integer>(new LinkedHashMap<String,Integer>());
                reverseOrderByKeyMap=new CustomMapWrapper<String,Integer>(new LinkedHashMap<String,Integer>());
                naturalOrderByValueMap=new CustomMapWrapper<String, Integer>(new LinkedHashMap<String,Integer>());
                reverseOrderByValueMap=new CustomMapWrapper<String, Integer>(new LinkedHashMap<String,Integer>());
            }



    private void sortByKeyInNaturalOrder() {
       this.person.entrySet().stream().sorted(Comparator.comparing(e->e.getKey().toString()))
       .forEachOrdered(e->{
           naturalOrderByKeyMap.put(e.getKey(),e.getValue());
       });
    }
    private void sortByKeyInReverseOrder() {
        this.person.entrySet().stream()
                .sorted(Collections.reverseOrder(Comparator.comparing(e->e.getKey().toString())))
                .forEachOrdered(e->{
                    reverseOrderByKeyMap.put(e.getKey(),e.getValue());
                });
    }
    private void sortByValueInNaturalOrder() {
        this.person.entrySet().stream().sorted(Comparator.comparing(e->e.getValue().intValue()))
                .forEachOrdered(e->{
                    naturalOrderByValueMap.put(e.getKey(),e.getValue());
                });
    }
    private void sortByValueInReverseOrder() {
        this.person.entrySet().stream()
                .sorted(Collections.reverseOrder(Comparator.comparing(e->e.getValue().intValue())))
                .forEachOrdered(e->{
                    reverseOrderByValueMap.put(e.getKey(),e.getValue());
                });
    }


    @Override
    public void sortNaturallyByKey() {
        sortByKeyInNaturalOrder();
        naturalOrderByKeyMap.entrySet().stream().forEachOrdered(e->{
            System.out.println(e.getKey()+" => "+e.getValue());
        });
    }

    @Override
    public void reverseSortByKey() {
        sortByKeyInReverseOrder();
        reverseOrderByKeyMap.entrySet().stream().forEachOrdered(e->{
            System.out.println(e.getKey()+" => "+e.getValue());
        });
    }

    @Override
    public void sortNaturallyByValue() {
        sortByValueInNaturalOrder();
        naturalOrderByValueMap.entrySet().stream()
                .forEachOrdered(e->{
                    System.out.println(e.getKey()+" => "+e.getValue());
                });
    }

    @Override
    public void reverseSortByValue() {
        sortByValueInReverseOrder();
        reverseOrderByValueMap.entrySet().stream()
                .forEachOrdered(e->{
                    System.out.println(e.getKey()+" => "+e.getValue());
                });
    }
}
    public class LambdaCompositionOverMap {
        public static void main(String args[]){
            Person p=new Person();
            System.out.println("Sorting naturally by key");
            p.sortNaturallyByKey();
            System.out.println("==================================");
            System.out.println("Reverse sort by Key");
            p.reverseSortByKey();
            System.out.println("==================================");
            System.out.println("Natural sort by Value");
            p.sortNaturallyByValue();
            System.out.println("==================================");
            System.out.println("Reverse sort by Value");
            p.reverseSortByValue();
        }
    }
