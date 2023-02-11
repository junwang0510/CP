# Ordering

Comparator.reverseOrder(): (Reverse Default Ordering)
```
Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

Map<String, Integer> map = new TreeMap<>(Comparator.reverseOrder());

...
```
<br>

Lambda: (Customized Ordering)
```
String[] plants = {"Mercury", "venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"};  
Arrays.sort(plants, (first, second) ->
{
    return first.length() - second.length();
});


List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());  
Collections.sort(list, (e1, e2) -> {return e1.getValue().compareTo(e2.getValue());} );

...
```
<br>

Comparable: (Customized Ordering)
```
class Person implements Comparable<Person> {  
    private String name, int age;

    // constructors, getters  

    @Override  
    public int compareTo(Person other) {  
        return this.age - other.age;
    }

    @Override
    public String toString() {  
        return name + "(" + age + ")";  
    }  
}
```
> Use Lambda expression when customizing an ordering for only one place in the code. Use Comparable otherwise.